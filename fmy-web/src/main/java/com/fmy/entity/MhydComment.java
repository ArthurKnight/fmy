package com.fmy.entity;

import java.util.Date;

public class MhydComment {
    private String id;

    private String fkUserId;

    private String fkComicsId;

    private String userName;

    private Date commenttime;

    private Integer favournum;

    private Date createtimestamp;

    private Date lastchangetimestamp;

    private String content;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public Integer getFavournum() {
        return favournum;
    }

    public void setFavournum(Integer favournum) {
        this.favournum = favournum;
    }

    public Date getCreatetimestamp() {
        return createtimestamp;
    }

    public void setCreatetimestamp(Date createtimestamp) {
        this.createtimestamp = createtimestamp;
    }

    public Date getLastchangetimestamp() {
        return lastchangetimestamp;
    }

    public void setLastchangetimestamp(Date lastchangetimestamp) {
        this.lastchangetimestamp = lastchangetimestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}