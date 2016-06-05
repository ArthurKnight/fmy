package com.fmy.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Update;

import com.fmy.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    
    @Update("update production set browse_num = #{browse_num} where id = #{pro_id}")
	public int BrowseCount(Map<String , Object> map) ;
}