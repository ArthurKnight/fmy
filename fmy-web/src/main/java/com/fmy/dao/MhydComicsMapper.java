package com.fmy.dao;

import java.util.List;
import com.fmy.entity.MhydComics;

public interface MhydComicsMapper {
    int deleteByPrimaryKey(String id);

    int insert(MhydComics record);

    int insertSelective(MhydComics record);

    MhydComics selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MhydComics record);

    int updateByPrimaryKeyWithBLOBs(MhydComics record);

    int updateByPrimaryKey(MhydComics record);
    
    /**
     * 根据漫画ids获取漫画列表
     * @param ids
     * @return
     */
    List<MhydComics> getComicsListByIds(List<String> idsList);
    
}