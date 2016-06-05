package com.fmy.entity;

public class CommentWithBLOBs extends Comment {
    private String content;

    private String favourIds;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFavourIds() {
        return favourIds;
    }

    public void setFavourIds(String favourIds) {
        this.favourIds = favourIds == null ? null : favourIds.trim();
    }
}