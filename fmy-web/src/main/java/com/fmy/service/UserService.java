package com.fmy.service;

import com.fmy.util.Result;

/**
 * Date: 2016-5-30
 * 
 * @author luliang_yu
 * @version 1.0
 * 
 */

public interface UserService {
	
	/**
	 * 作品删除功能
	 */
	Result deletePro(String pro_id);
	
	/**
	 * 作品上传功能
	 * @param user_id
	 * @param pro_name
	 * @param picture
	 * @return
	 */
	Result addPro(String user_id , String pro_name ,String picture,String picturePath) ;
	
	/**
	 * 根据作品ID查找作品的相关信息
	 * @param pro_id
	 * @return
	 */
	Result findProduction(String pro_id);
	
	/**
	 * 玩家进入原创广场界面（显示玩家画力值）
	 * @param user_id
	 * @return
	 */
	Result inYcgc(String id , String name , String friendIds , Integer drawRank) ;
	/**
	 * 分页展示优秀作品（前端传入页码）
	 * @param page
	 * @return
	 */
	Result findExcellentPros(Integer page);
	
	/**
	 * 好友作品列表
	 * @param user_id
	 * @param page
	 * @return
	 */
	Result findFriendPros(String user_id , Integer page) ;
	
	/**
	 * 我的作品
	 * @param user_id
	 * @param page
	 * @return
	 */
	Result findMyPros(String user_id , Integer page) ;
	
	/**
	 * 最近作品
	 * @param page
	 * @return
	 */
	Result findLatestPros(Integer page);
	

	/**
	 * 作品详情
	 */
	Result getProductInfo(String proId , String userId , Integer proPage , Integer commentPage,Integer commentPageSize ,Boolean flag);

	/**
	 * 赠送鲜花
	 * 
	 * @param proId
	 * @param userId
	 * @return
	 */
	Result sendFlower(String proId, String userId);

	/**
	 * 提交评论
	 * 
	 * @param proId
	 * @param userId
	 * @return
	 */
	Result sendComment(String userId, String userName, String comment,
			String proId);

	/**
	 * 玩家点赞
	 * 
	 * @param commentId
	 * @param userId
	 * @return
	 */
	Result clickLike(String commentId, String userId);

}
