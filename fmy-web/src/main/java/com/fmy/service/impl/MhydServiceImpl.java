package com.fmy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmy.dao.MhydBookMarkMapper;
import com.fmy.dao.MhydChapterMapper;
import com.fmy.dao.MhydComicsMapper;
import com.fmy.dao.MhydUserMapper;
import com.fmy.entity.MhydBookMark;
import com.fmy.entity.MhydChapter;
import com.fmy.entity.MhydComics;
import com.fmy.entity.MhydUser;
import com.fmy.service.MhydService;
import com.fmy.util.Result;
import com.fmy.vo.MhydMarkBookVo;
import com.fmy.vo.MhydMarkRecentBookVo;

@Service
public class MhydServiceImpl implements MhydService {

	@Autowired
	MhydBookMarkMapper bookMarkMapper;
	
	@Autowired
	MhydComicsMapper comicsMapper;
	
	@Autowired
	MhydChapterMapper chapterMapper;
	
	@Autowired
	MhydUserMapper userMapper;
	
	@Override
	public Result getRecentRead(String id) {
		Result result=new Result();
		List<MhydMarkRecentBookVo>recentList=new ArrayList<MhydMarkRecentBookVo>();
		List<MhydBookMark> markList=bookMarkMapper.getRecentBooksByUserId(id);
		//最近阅读漫画ids
		List<String>comicsIds=new ArrayList<String>();
		//上次阅读到章节ids
		List<String>readChapterIds=new ArrayList<String>();
		for(MhydBookMark mark :markList){
			String comicsId=mark.getFkComicsId();
			String readChapterId=mark.getFkReadChapterId();
			comicsIds.add(comicsId);
			readChapterIds.add(readChapterId);
		}
		//获取漫画最新章节
		List<MhydChapter>maxChapterList=chapterMapper.getUpdateChapterByIds(comicsIds);
		//获取上次阅读章节
		List<MhydChapter>lastReadChapterList=chapterMapper.getRecentChapterByIds(readChapterIds);
		//获取最近阅读的五本漫画
		List<MhydComics>comicsList=comicsMapper.getComicsListByIds(comicsIds);
		for (MhydComics comics : comicsList) {
			MhydMarkRecentBookVo vo=new MhydMarkRecentBookVo();
			vo.setComicsId(comics.getId());
			vo.setComicsName(comics.getName());
			vo.setHomePic(comics.getHomePic());
			vo.setOnewordDesc(comics.getOnewordDesc());
			for(MhydChapter chap:maxChapterList){
				if(chap.getFkComicsId().equals(vo.getComicsId())){
					vo.setUpdateChapter(chap.getChapterName());
					vo.setUpdateChapterOrder(chap.getChapterOrder());
				}
			}
			for(MhydChapter chap:lastReadChapterList){
				if(chap.getFkComicsId().equals(vo.getComicsId())){
					vo.setReadChapter(chap.getChapterName());
					vo.setReadChapterOrder(chap.getChapterOrder());
				}
			}
			if(vo.getReadChapterOrder()<vo.getUpdateChapterOrder()){
				vo.setIsRead(0);
			}else{
				vo.setIsRead(1);
			}
			recentList.add(vo);
		}
		result.setStatus(0);
		result.setMsg("最近阅读漫画信息");
		result.setData(recentList);
		return result;
	}
	
	@Override
	public Result getMarkBooks(String id,int pageNum,int pageSize) {
		Result result=new Result();
		Map<String, Object>map=new HashMap<String, Object>();
		List<MhydMarkBookVo>markBookList=new ArrayList<MhydMarkBookVo>();
		//相关分页信息
		int totalMark=getMarkNums(id);
		int haveMarkNum=bookMarkMapper.countMark(id);
		map.put("haveMarkNum", haveMarkNum);
		map.put("canMarkNum", totalMark-haveMarkNum);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		int totalPage=haveMarkNum/pageSize+1;
		map.put("totalPage", totalPage);
		int startNum=pageSize*(pageNum-1);
		if(pageNum>totalPage||pageNum<1){
			result.setStatus(1);
			result.setMsg("pageNum超出最大页数或pageNum<1");
			return result;
		}
		//获取读者收藏列表
		List<MhydBookMark> markList=bookMarkMapper.getMarkBooksByUserId(id, startNum, pageSize);
		//收藏阅读漫画ids
		List<String>comicsIds=new ArrayList<String>();
		//上次阅读到章节ids
		List<String>readChapterIds=new ArrayList<String>();
		for(MhydBookMark mark :markList){
			String comicsId=mark.getFkComicsId();
			String readChapterId=mark.getFkReadChapterId();
			comicsIds.add(comicsId);
			readChapterIds.add(readChapterId);
		}
		//获取漫画最新章节
		List<MhydChapter>maxChapterList=chapterMapper.getUpdateChapterByIds(comicsIds);
		//获取上次阅读章节
		List<MhydChapter>lastReadChapterList=chapterMapper.getRecentChapterByIds(readChapterIds);
		//获取收藏的漫画
		List<MhydComics>comicsList=comicsMapper.getComicsListByIds(comicsIds);
		for (MhydComics comics : comicsList) {
			MhydMarkBookVo vo=new MhydMarkBookVo();
			vo.setComicsId(comics.getId());
			vo.setComicsName(comics.getName());
			vo.setHomePic(comics.getHomePic());
			vo.setOnewordDesc(comics.getOnewordDesc());
			for(MhydChapter chap:maxChapterList){
				if(chap.getFkComicsId().equals(vo.getComicsId())){
					vo.setUpdateChapter(chap.getChapterName());
					vo.setUpdateChapterOrder(chap.getChapterOrder());
				}
			}
			for(MhydChapter chap:lastReadChapterList){
				if(chap.getFkComicsId().equals(vo.getComicsId())){
					vo.setReadChapter(chap.getChapterName());
					vo.setReadChapterOrder(chap.getChapterOrder());
				}
			}
			for(MhydBookMark mark :markList){
				if(mark.getFkComicsId().equals(vo.getComicsId())){
					vo.setIsMark(mark.getMarkflag());
				}
			}
			if(vo.getReadChapterOrder()<vo.getUpdateChapterOrder()){
				vo.setIsRead(0);
			}else{
				vo.setIsRead(1);
			}
			markBookList.add(vo);
		}
		map.put("markBooks", markBookList);
		result.setStatus(0);
		result.setMsg("收藏漫画信息");
		result.setData(map);
		return result;
	}
	
	/**
	 * 获取读者默认总可收藏数
	 * @param id
	 * @return
	 */
	private int getMarkNums(String id){
		MhydUser user=userMapper.selectByPrimaryKey(id);
		int totalMark=user.getMarkNum();
		return totalMark;
	}

}
