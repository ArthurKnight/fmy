package com.fmy.service;

import com.fmy.util.Result;

/**
 * Date: 2016-6-2
 * 
 * @author luliang_yu
 * @version 1.0
 * 
 */

public interface MhydService {
	
	/**
	 * 读者最近阅读（最近五条记录）
	 * @param id	读者id
	 * @return
	 */
	Result getRecentRead(String id);
	
	/**
	 * 读者收藏漫画
	 * @param id	读者id
	 * @return
	 */
	Result getMarkBooks(String id,int pageNum,int pageSize);
	
}
