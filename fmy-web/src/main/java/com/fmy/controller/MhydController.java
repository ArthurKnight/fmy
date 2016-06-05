package com.fmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fmy.service.MhydService;
import com.fmy.util.Result;

/**
 * Date: 2016-6-2
 * 
 * @author luliang_yu
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/mhyd")
public class MhydController {

	@Autowired
	private MhydService mhydService;

	/**
	 * 我的书架-最近阅读
	 * @param id 读者id
	 * @return
	 */
	@RequestMapping("/bookShelf/recentRead")
	@ResponseBody
	public Result recentRead(
			@RequestParam(value = "id", defaultValue = "") String id) {
		Result a = mhydService.getRecentRead(id);
		return a;
	}

	/**
	 * 我的书架-我的收藏
	 * @param id 读者id
	 * @param pageNum 页码
	 * @param pageSize 每页显示条数
	 * @return
	 */
	@RequestMapping("/bookShelf/markBook")
	@ResponseBody
	public Result markBook(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		Result a = mhydService.getMarkBooks(id,pageNum,pageSize);
		return a;
	}
	
	/**
	 * 查看漫画详情
	 * @param userId
	 * @param comicsId
	 * @return
	 */
	@RequestMapping("/comicsInfo/index")
	@ResponseBody
	public Result infoIndex(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "comicsId", defaultValue = "") Integer comicsId){
		return null;
	}
	
	/**
	 * 获取漫画章节
	 * @param comicsId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/comicsInfo/chapter")
	@ResponseBody
	public Result chapter(
			@RequestParam(value = "comicsId", defaultValue = "") String comicsId,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "40") Integer pageSize){
		
		return null;
	}
	
	
	/**
	 * 猜你喜欢
	 * @param comicsId
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/comicsInfo/likeComics")
	@ResponseBody
	public Result likeComics(
			@RequestParam(value = "comicsId", defaultValue = "") String comicsId,
			@RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize){
		
		return null;
	}
	
	
	/**
	 * 获取该漫画的所有评论
	 * @param comicsId
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/comicsInfo/commentList")
	@ResponseBody
	public Result commentList(
			@RequestParam(value = "comicsId", defaultValue = "") String comicsId,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
		
		return null;
	}
	
	/**
	 * 提交漫画评论
	 * @param comicsId
	 * @param userId
	 * @param userName
	 * @param content
	 * @return
	 */
	@RequestMapping("/comicsInfo/submitComment")
	@ResponseBody
	public Result commentList(
			@RequestParam(value = "comicsId", defaultValue = "") String comicsId,
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "userName", defaultValue = "") String userName,
			@RequestParam(value = "content", defaultValue = "") String content){
		
		return null;
	}
	
	
	
	
	
	
	
}
