package com.fmy.entity;

import java.util.Date;

public class Production {
    private String id;

    private String proName;

    private Long flowerNum;

    private Long browseNum;

    private String fkAuthorId;

    private Date uploadTime;

    private Date createTimestamp;

    private Date lastChangeTimestamp;

    private String picturePath;

    private String flowerUserIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Long getFlowerNum() {
        return flowerNum;
    }

    public void setFlowerNum(Long flowerNum) {
        this.flowerNum = flowerNum;
    }

    public Long getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Long browseNum) {
        this.browseNum = browseNum;
    }

    public String getFkAuthorId() {
        return fkAuthorId;
    }

    public void setFkAuthorId(String fkAuthorId) {
        this.fkAuthorId = fkAuthorId == null ? null : fkAuthorId.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
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

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public String getFlowerUserIds() {
        return flowerUserIds;
    }

    public void setFlowerUserIds(String flowerUserIds) {
        this.flowerUserIds = flowerUserIds == null ? null : flowerUserIds.trim();
    }
}