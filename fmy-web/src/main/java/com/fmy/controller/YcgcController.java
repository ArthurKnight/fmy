package com.fmy.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fmy.service.UserService;
import com.fmy.util.Result;

@Controller
@RequestMapping("/ycgc")
public class YcgcController {

	@Autowired
	private UserService userService;

	@Value("${picturePath}")
	private String picturePath;
	
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	/**
	 * 进入原创广场
	 * 
	 * @param id
	 * @param name
	 * @param friendIds
	 * @param drawRank
	 * @return
	 */
	@RequestMapping("/index")
	@ResponseBody
	public Result ycgc(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "friendIds", defaultValue = "") String friendIds,
			@RequestParam(value = "drawRank", defaultValue = "") Integer drawRank) {
		Result a = userService.inYcgc(id, name, friendIds, drawRank);
		return a;
	}

	/**
	 * 获取优秀作品
	 * 
	 * @return
	 */
	@RequestMapping("/excellentPro")
	@ResponseBody
	public Result excellentPro(
			@RequestParam(value = "page", defaultValue = "") Integer page) {
		return userService.findExcellentPros(page);
	}

	/**
	 * 获取最新作品
	 * 
	 * @return
	 */
	@RequestMapping("/latestPro")
	@ResponseBody
	public Result latestPro(
			@RequestParam(value = "page", defaultValue = "") Integer page) {
		return userService.findLatestPros(page);
	}

	/**
	 * 获取我的作品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/myPro")
	@ResponseBody
	public Result myPro(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "page", defaultValue = "") Integer page) {
		return userService.findMyPros(userId, page);
	}

	/**
	 * 删除作品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delPro")
	@ResponseBody
	public Result delPro(
			@RequestParam(value = "proId", defaultValue = "") String proId) {
		return userService.deletePro(proId);
	}

	/**
	 * 好友作品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/friendsPro")
	@ResponseBody
	public Result friendsPro(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "page", defaultValue = "") Integer page) {
		return userService.findFriendPros(userId, page);
	}

	/**
	 * 图片上传
	 * 
	 * @param userId
	 * @param proName
	 * @param fileStream
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/uploadFile")
	@ResponseBody
	public Result uploadFile(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "proName", defaultValue = "") String proName,
			@RequestParam(value = "fileStream", defaultValue = "") String fileStream,
			 HttpSession session) throws Exception {
		//fileStream=ImageUtil.getImageFromServer("Korla.jpg", "C:/Users/Public/Pictures/Sample Pictures/");
		picturePath=session.getServletContext().getRealPath("/")+"/images/uploadPic/";
		return userService.addPro(userId, proName, fileStream,picturePath);  
	}
	
	/**
	 * 作品详情
	 * 
	 * @param proId
	 * @return
	 */
	@RequestMapping("/proInfo")
	@ResponseBody
	public Result proInfo(
			@RequestParam(value = "proId", defaultValue = "") String proId,
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "proPage", defaultValue = "1") Integer proPage,
			@RequestParam(value = "commentPage", defaultValue = "1") Integer commentPage,
			@RequestParam(value = "commentPageSize", defaultValue = "10") Integer commentPageSize,
			@RequestParam(value = "flag", defaultValue = "true") Boolean flag) {
		Result result = userService.getProductInfo(proId, userId, proPage,commentPage,commentPageSize,flag);
		return result;
	}

	/**
	 * 赠送鲜花
	 * 
	 * @param userId
	 * @param proId
	 * @return
	 */
	@RequestMapping("/proInfo/sendFlower")
	@ResponseBody
	public Result sendFlower(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "proId", defaultValue = "") String proId) {
		Result result = userService.sendFlower(proId, userId);
		return result;
	}

	/**
	 * 发表评论
	 * 
	 * @param userId
	 * @param userName
	 * @param comment
	 * @param proId
	 * @return
	 */
	@RequestMapping("/proInfo/comment")
	@ResponseBody
	public Result comment(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "userName", defaultValue = "") String userName,
			@RequestParam(value = "comment", defaultValue = "") String comment,
			@RequestParam(value = "proId", defaultValue = "") String proId) {
		Result result = userService.sendComment(userId, userName, comment,
				proId);
		return result;
	}

	/**
	 * 点赞
	 * 
	 * @param commentId
	 * @param userId
	 * @return
	 */
	@RequestMapping("/proInfo/favour")
	@ResponseBody
	public Result favour(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "commentId", defaultValue = "") String commentId) {
		Result result = userService.clickLike(commentId, userId);
		return result;
	}

}
