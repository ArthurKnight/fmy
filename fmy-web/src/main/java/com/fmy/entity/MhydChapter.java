package com.fmy.entity;

import java.util.Date;

public class MhydChapter {
    private String id;

    private String fkComicsId;

    private String chapterName;

    private Integer chapterOrder;

    private Date createTimestamp;

    private Date lastChangeTimestamp;

    private String contentIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFkComicsId() {
        return fkComicsId;
    }

    public void setFkComicsId(String fkComicsId) {
        this.fkComicsId = fkComicsId == null ? null : fkComicsId.trim();
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public Integer getChapterOrder() {
        return chapterOrder;
    }

    public void setChapterOrder(Integer chapterOrder) {
        this.chapterOrder = chapterOrder;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getLastChangeTimestamp() {
        return lastChangeTimestamp;
    }

    public void setLastChangeTimestamp(Date lastChangeTimestamp) {
        this.lastChangeTimestamp = lastChangeTimestamp;
    }

    public String getContentIds() {
        return contentIds;
    }

    public void setContentIds(String contentIds) {
        this.contentIds = contentIds == null ? null : contentIds.trim();
    }
}