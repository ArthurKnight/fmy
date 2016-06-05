package com.fmy.dao;

import java.util.List;
import java.util.Map;
import com.fmy.entity.Production;

public interface ProductionMapper {
	int deleteByPrimaryKey(String id);

	int insert(Production record);

	int insertSelective(Production record);

	Production selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Production record);

	int updateByPrimaryKeyWithBLOBs(Production record);

	int updateByPrimaryKey(Production record);

	List<Production> findExcellentPros(int start_num);

	List<Production> findProsByUserId(Map<String, Object> map);

	List<Production> findLatestPros(int start_num);

	/**
	 * 根据作者id获取所有作品
	 * 
	 * @param id
	 * @return
	 */
	List<Production> getProsByUserId(String id);

	/**
	 * 分页显示用户作品
	 * 
	 * @param map
	 * @return
	 */
	Production findByUserIdPage(Map<String, Object> map);

	/**
	 * 根据作者ID统计该作者作品数目
	 * 
	 * @param id
	 * @return
	 */
	int countProNums(String id);

}