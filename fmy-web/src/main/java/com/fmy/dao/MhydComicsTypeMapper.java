package com.fmy.dao;

import com.fmy.entity.MhydComicsType;

public interface MhydComicsTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(MhydComicsType record);

    int insertSelective(MhydComicsType record);

    MhydComicsType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MhydComicsType record);

    int updateByPrimaryKey(MhydComicsType record);
}