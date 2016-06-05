package com.fmy.dao;

import java.util.List;
import com.fmy.entity.MhydChapter;

public interface MhydChapterMapper {
    int deleteByPrimaryKey(String id);

    int insert(MhydChapter record);

    int insertSelective(MhydChapter record);

    MhydChapter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MhydChapter record);

    int updateByPrimaryKeyWithBLOBs(MhydChapter record);

    int updateByPrimaryKey(MhydChapter record);
    
    /**
     * 获取漫画最新更新章节
     * @param comicsIds 漫画id
     * @return
     */
    List<MhydChapter> getUpdateChapterByIds(List<String> comicsIdsList);
    
    /**
     * 获取漫画上次阅读章节
     * @param chapterIds 章节id
     * @return
     */
    List<MhydChapter> getRecentChapterByIds(List<String> chapterIdsList);
}