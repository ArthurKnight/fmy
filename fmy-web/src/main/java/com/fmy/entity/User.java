package com.fmy.entity;

import java.util.Date;

public class User {
    private String id;

    private String name;

    private Integer drawRank;

    private Date createTimestamp;

    private Date lastChangeTimestamp;

    private String frendIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDrawRank() {
        return drawRank;
    }

    public void setDrawRank(Integer drawRank) {
        this.drawRank = drawRank;
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

    public String getFrendIds() {
        return frendIds;
    }

    public void setFrendIds(String frendIds) {
        this.frendIds = frendIds == null ? null : frendIds.trim();
    }
}