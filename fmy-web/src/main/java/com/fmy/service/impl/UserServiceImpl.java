package com.fmy.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fmy.dao.CommentMapper;
import com.fmy.dao.ProductionMapper;
import com.fmy.dao.UserMapper;
import com.fmy.entity.Comment;
import com.fmy.entity.CommentWithBLOBs;
import com.fmy.entity.Production;
import com.fmy.entity.User;
import com.fmy.service.UserService;
import com.fmy.util.ImageUtil;
import com.fmy.util.Result;
import com.fmy.util.UUIDUtils;
import com.fmy.vo.ProductVo;
import com.fmy.vo.ShowProductVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProductionMapper proMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	/**
	 * 作品上传功能
	 */
	public Result addPro(String user_id, String pro_name, String picture,String picturePath) {
		Result r = new Result();
		Production w = proMapper.selectByPrimaryKey(user_id);
		if(w!=null){
			r.setStatus(1);
			r.setMsg("作品名已经存在");
			return r ;
		}
		w = new Production();
		w.setFkAuthorId(user_id);
		w.setId(UUIDUtils.getUUID());
		w.setProName(pro_name);
		w.setBrowseNum(0L);
		w.setFlowerNum(0L);
		w.setCreateTimestamp(new Date());
		w.setLastChangeTimestamp(w.getCreateTimestamp());
		w.setUploadTime(w.getCreateTimestamp());
		String path=ImageUtil.base64ToImage(picture,picturePath);
		w.setPicturePath(path);
		int f = proMapper.insert(w);
		if(f==1){
			r.setStatus(0);
			r.setMsg("添加作品成功");
		}else{
			r.setStatus(1);
			r.setMsg("添加作品失败");
		}
		return r;
	}
	
	
	/**
	 * 根据ID查找作品相关信息
	 */
	public Result findProduction(String pro_id) {
		Result r = new Result();
		Production p = proMapper.selectByPrimaryKey(pro_id);
		if(p==null){
			r.setStatus(1);
			r.setMsg("没有找到该作品");
		}else{
			r.setStatus(0);
			r.setData(p);
		}
		return r;
	}
	
	/**
	 * 进入原创广场，保存用户信息
	 */
	public Result inYcgc(String id , String name , String friendIds , Integer drawRank) {
		Result r = new Result();
		User entity=userMapper.selectByPrimaryKey(id);
		int f=0;
		if(entity!=null){
			entity.setLastChangeTimestamp(new Date());
			entity.setDrawRank(drawRank);
			entity.setFrendIds(friendIds);
			entity.setName(name);
			f=userMapper.updateByPrimaryKey(entity);
			if(f==1){
				r.setMsg("用户已存在，信息更新成功");
				r.setStatus(0);
				r.setData(entity);
			}else{
				r.setMsg("用户信息更新失败");
				r.setStatus(1);
			}
		}else{
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setDrawRank(drawRank);
			user.setFrendIds(friendIds);
			user.setCreateTimestamp(new Date());
			user.setLastChangeTimestamp(new Date());
			 f = userMapper.insert(user);
			if(f==1){
				r.setMsg("保存用户信息成功");
				r.setStatus(0);
				r.setData(user);
			}else{
				r.setMsg("保存用户信息失败");
				r.setStatus(1);
			}
		}
		return r;
	}
	/**
	 * 根据页码找优秀作品
	 * @param page
	 * @return
	 */
	@Override
	public Result findExcellentPros(Integer page) {
		Result r = new Result();
		if(page==null){
			r.setStatus(1);
			r.setMsg("页码输入有误");
			return r ;
		}
		int start_num = 10 * (page-1);
		List<Production> pros = proMapper.findExcellentPros(start_num);
		if(pros.size()>0){
			r.setStatus(0);
			r.setData(pros);
			return r ;
		}
		r.setStatus(0);
		r.setMsg("暂无更多作品了");
		return r;
	}
	
	/**
	 * 根据id和页码找好友作品
	 */
	@Override
	public Result findFriendPros(String user_id, Integer page) {
		Result r = new Result();
		if(page==null){
			r.setStatus(1);
			r.setMsg("页码输入有误");
			return r ;
		}
		Map<String , Object> map = new HashMap<String , Object>();
		List<Production> pros = new ArrayList<Production>();
		User user = userMapper.selectByPrimaryKey(user_id);
		List<String> friend_ids = Arrays.asList(user.getFrendIds().split(",")); 
		for(String s : friend_ids){
			map.put("user_id", s);
			map.put("start_num", 10 * (page-1));
			pros.addAll(proMapper.findProsByUserId(map));
		}
		r.setStatus(0);
		r.setData(pros);
		return r;
	}
	
	/**
	 * 查找最近的作品
	 * @param page
	 * @return
	 */
	public Result findLatestPros(Integer page) {
		Result r = new Result();
		if(page==null){
			r.setStatus(1);
			r.setMsg("页码输入有误");
			return r ;
		}
		int start_num = 10 * (page-1);
		List<Production> pros =  proMapper.findLatestPros(start_num);
		r.setData(pros);
		r.setStatus(0);
		return r;
	}
	
	/**
	 * 根据id和页码找我的作品
	 * @param user_id
	 * @param page
	 * @return
	 */
	@Override
	public Result findMyPros(String user_id, Integer page) {
		Result r = new Result();
		if(page==null){
			r.setStatus(1);
			r.setMsg("页码输入有误");
			return r ;
		}
		Map<String , Object> map = new HashMap<String , Object>();
		map.put("user_id", user_id);
		map.put("start_num", 10 * (page-1));
		List<Production> pros = proMapper.findProsByUserId(map);
		r.setStatus(0);
		r.setData(pros);
		return r;
	}
	
	/**
	 * 根据ID删除作品
	 */
	@Override
	public Result deletePro(String pro_id) {
		Result r = new Result();
		//删除所有作品ID为pro_id的评论
		int flag=commentMapper.deleteByProIds(pro_id);
		int f = proMapper.deleteByPrimaryKey(pro_id);
		if(f==1&&flag>0){
			r.setStatus(0);
			r.setMsg("删除成功");
			return r ;
		}
		r.setStatus(1);
		r.setMsg("删除失败");
		return r ;
	}
	
	
	/**
	 * 作品详情分页展示
	 */
	@Override
	public Result getProductInfo(String proId , String userId , Integer proPage , Integer commentPage,Integer commentPageSize ,Boolean flag) {
		Result result=new Result();
		int f = -1 ;
		Map<String , Object> ma = new HashMap<String , Object>();
		if(flag){
			Production pro = proMapper.selectByPrimaryKey(proId);
			if(pro!=null){
				long browse_num = pro.getBrowseNum()+1 ;
				ma.put("pro_id", proId);
				ma.put("browse_num", browse_num);
				f = userMapper.BrowseCount(ma);
			}else{
				result.setStatus(1);
				result.setMsg("没有该作品");
				return result ;
			}
		}
		Map<String , Object> map = new HashMap<String , Object>();
		map.put("id", proId);
		map.put("start_num", proPage-2);
		map.put("user_id", userId);
		Production p = null ;
		if(proPage==1){
			p = proMapper.selectByPrimaryKey(proId);
		}else{
			p = proMapper.findByUserIdPage(map);
		}
		if(p==null){
			result.setStatus(1);
			result.setMsg("该用户已经没有更多的作品了");
			return result ;
		}
		Map<String , Object> m = new HashMap<String , Object>();
		m.put("id", p.getId());
		m.put("start_num", commentPageSize*(commentPage-1));
		m.put("commentPageSize", commentPageSize);
		List<Comment> comments = commentMapper.getProCommentsByPage(m);
		Map<String , Object> dataMap = new HashMap<String , Object>();
		dataMap.put("product", p);
		dataMap.put("comments",comments);
		result.setStatus(0);
		result.setMsg("作品及评论的相关信息");
		result.setData(dataMap);
		return result;
	}

	@Override
	public Result sendFlower(String proId, String userId) {
		Result result=new Result();
		Production pro=proMapper.selectByPrimaryKey(proId);
		String flowerUserIds="";
		//若flowerUserIds不为null，则查找该字符串有没包含该userId,
		//若包含userId表示该玩家已经对该作品送过鲜花，鲜花数不变；
		//若不包含该userId则拼接flowerUserIds,并且鲜花数+1。
		if(StringUtils.isNotBlank(pro.getFlowerUserIds())){
			flowerUserIds=pro.getFlowerUserIds();
			List<String> userIds=Arrays.asList(flowerUserIds.split(","));
			if(!userIds.contains(userId)){
				flowerUserIds=flowerUserIds+","+userId;
				long num=pro.getFlowerNum();
				pro.setFlowerNum(++num);
				pro.setFlowerUserIds(flowerUserIds);
				proMapper.updateByPrimaryKeySelective(pro);
				result.setData(pro);
				result.setMsg("赠送成功，鲜花数+1");
				result.setStatus(0);//state:0表示成功，state:1表示失败
			}else{
				result.setMsg("赠送失败，该玩家(id:"+userId+")已对该作品(id:"+proId+")送过鲜花");
				result.setStatus(1);
				return result;
			}
		}else{//flowerUserIds为null表示该作品没人送过鲜花
			pro.setFlowerUserIds(userId);
			long num=pro.getFlowerNum();
			pro.setFlowerNum(++num);
			proMapper.updateByPrimaryKeySelective(pro);
			result.setData(pro);
			result.setMsg("赠送成功，鲜花数加+1");
			result.setStatus(0);
		}
		return result;
	}

	@Override
	public Result sendComment(String userId, String userName, String comment,
			String proId) {
		Result result=new Result();
		CommentWithBLOBs entity=new CommentWithBLOBs();
		entity.setId(UUIDUtils.getUUID());
		entity.setFkProId(proId);
		entity.setUserId(userId);
		entity.setUserName(userName);
		entity.setCommentTime(new Date());
		entity.setContent(comment);
		if(entity.getFavourNum()==null){
			entity.setFavourNum(0);
		}
		int state=commentMapper.insert(entity);
		if(state==1){
			result.setMsg("提交成功");
			result.setStatus(0);
			result.setData(entity);
			return result;
		}
		result.setMsg("提交失败");
		result.setStatus(1);
		result.setData(entity);
		return result;
	}

	@Override
	public Result clickLike(String commentId, String userId) {
		Result result=new Result();
		CommentWithBLOBs comment=commentMapper.selectByPrimaryKey(commentId);
		String favourIds="";
		//若favourIds不为null，则查找该字符串有没包含该userId,
		//若包含userId表示该玩家已经对该评论赞过，赞数不变；
		//若不包含该userId则拼接favourIds,并且赞数+1。
		if(StringUtils.isNotBlank(comment.getFavourIds())){
			favourIds=comment.getFavourIds();
			List<String> userIds=Arrays.asList(favourIds.split(","));
			if(!userIds.contains(userId)){
				favourIds=favourIds+","+userId;
				Integer num=comment.getFavourNum();
				comment.setFavourNum(++num);
				comment.setFavourIds(favourIds);
				commentMapper.updateByPrimaryKeyWithBLOBs(comment);
				result.setData(comment);
				result.setMsg("点赞成功，赞数+1");
				result.setStatus(0);
			}else{
				result.setMsg("点赞失败，该玩家(id:"+userId+")已对该评论(id:"+commentId+")赞过");
				result.setStatus(1);
				return result;
			}
		}else{//favourIds为null表示该作品没人送过鲜花
			comment.setFavourIds(userId);
			Integer num=comment.getFavourNum();
			comment.setFavourNum(++num);
			commentMapper.updateByPrimaryKeySelective(comment);
			result.setData(comment);
			result.setMsg("点赞成功，赞数+1");
			result.setStatus(0);
		}
		return result;
	}


}
