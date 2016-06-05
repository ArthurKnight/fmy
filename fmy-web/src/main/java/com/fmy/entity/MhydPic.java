package com.fmy.entity;

import java.util.Date;

public class MhydPic {
    private String id;

    private String fkChapterId;

    private String picPath;

    private Integer picOrder;

    private Date createTimestamp;

    private Date lastChangeTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFkChapterId() {
        return fkChapterId;
    }

    public void setFkChapterId(String fkChapterId) {
        this.fkChapterId = fkChapterId == null ? null : fkChapterId.trim();
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public Integer getPicOrder() {
        return picOrder;
    }

    public void setPicOrder(Integer picOrder) {
        this.picOrder = picOrder;
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
}