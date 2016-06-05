package com.fmy.vo;

import java.util.Date;

public class CommentVo {
    private String id;

    private String commentName;
    
    private String content;

    private Date commentTime;

    private Integer favourNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getFavourNum() {
		return favourNum;
	}

	public void setFavourNum(Integer favourNum) {
		this.favourNum = favourNum;
	}
    
}