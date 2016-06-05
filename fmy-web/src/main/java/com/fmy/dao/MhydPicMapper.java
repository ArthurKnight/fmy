package com.fmy.dao;

import com.fmy.entity.MhydPic;

public interface MhydPicMapper {
    int deleteByPrimaryKey(String id);

    int insert(MhydPic record);

    int insertSelective(MhydPic record);

    MhydPic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MhydPic record);

    int updateByPrimaryKey(MhydPic record);
}