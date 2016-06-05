package com.fmy.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Date: 2016-5-31
 * 
 * @author luliang_yu
 * @version 1.0
 * 
 */
public class ProductVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7396754988228144722L;

	private String proId;

	private String proName;

	private String picturePath;

	private String commentId;

	private String userName;

	private Date commentTime;

	private int favourNum;

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public int getFavourNum() {
		return favourNum;
	}

	public void setFavourNum(int favourNum) {
		this.favourNum = favourNum;
	}

}
