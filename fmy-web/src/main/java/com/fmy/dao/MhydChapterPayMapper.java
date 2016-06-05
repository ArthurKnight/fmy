package com.fmy.dao;

import com.fmy.entity.MhydChapterPay;

public interface MhydChapterPayMapper {
    int deleteByPrimaryKey(String id);

    int insert(MhydChapterPay record);

    int insertSelective(MhydChapterPay record);

    MhydChapterPay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MhydChapterPay record);

    int updateByPrimaryKey(MhydChapterPay record);
}