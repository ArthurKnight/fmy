package com.fmy.dao;

import com.fmy.entity.MhydComment;

public interface MhydCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(MhydComment record);

    int insertSelective(MhydComment record);

    MhydComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MhydComment record);

    int updateByPrimaryKeyWithBLOBs(MhydComment record);

    int updateByPrimaryKey(MhydComment record);
}