package com.fmy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fmy.entity.MhydBookMark;

public interface MhydBookMarkMapper {
	int deleteByPrimaryKey(String id);

	int insert(MhydBookMark record);

	int insertSelective(MhydBookMark record);

	MhydBookMark selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(MhydBookMark record);

	int updateByPrimaryKey(MhydBookMark record);

	/**
	 * 获取该读者最近阅读的五条记录
	 * 
	 * @param id
	 * @return
	 */
	List<MhydBookMark> getRecentBooksByUserId(String id);

	/**
	 * 获取该读者收藏的漫画
	 * 
	 * @param id
	 *            读者id
	 * @param startNum
	 *            游标
	 * @param pageSize
	 *            每页显示漫画数
	 * @return
	 */
	List<MhydBookMark> getMarkBooksByUserId(@Param("id") String id,@Param("startNum") int startNum, @Param("pageSize") int pageSize);
	
	/**
	 * 统计该读者收藏漫画数
	 * @param id
	 * @return
	 */
	@Select("select count(1) from mhyd_bookmark where fk_user_id=#{id}")
	int countMark(String id);

}
