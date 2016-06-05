package com.fmy.dao;

import com.fmy.entity.MhydUser;

public interface MhydUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(MhydUser record);

    int insertSelective(MhydUser record);

    MhydUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MhydUser record);

    int updateByPrimaryKey(MhydUser record);
}