package com.fmy.entity;

import java.util.Date;

public class MhydBookMark {
    private String id;

    private String fkUserId;

    private String fkComicsId;

    private String fkReadChapterId;

    private Byte markflag;

    private Date createTimestamp;

    private Date lastChangeTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(String fkUserId) {
        this.fkUserId = fkUserId == null ? null : fkUserId.trim();
    }

    public String getFkComicsId() {
        return fkComicsId;
    }

    public void setFkComicsId(String fkComicsId) {
        this.fkComicsId = fkComicsId == null ? null : fkComicsId.trim();
    }

    public String getFkReadChapterId() {
        return fkReadChapterId;
    }

    public void setFkReadChapterId(String fkReadChapterId) {
        this.fkReadChapterId = fkReadChapterId == null ? null : fkReadChapterId.trim();
    }

    public Byte getMarkflag() {
        return markflag;
    }

    public void setMarkflag(Byte markflag) {
        this.markflag = markflag;
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