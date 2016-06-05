package com.fmy.entity;

import java.util.Date;

public class MhydComics {
    private String id;

    private String name;

    private String author;

    private String tagIds;

    private String homePic;

    private String onewordDesc;

    private Long likeNum;

    private Long markNum;

    private String state;

    private Date launchDate;

    private Byte propflag;

    private Byte bookstateflag;

    private Long pays;

    private Date createTimestamp;

    private Date lastChangeTimestamp;

    private String plotDesc;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds == null ? null : tagIds.trim();
    }

    public String getHomePic() {
        return homePic;
    }

    public void setHomePic(String homePic) {
        this.homePic = homePic == null ? null : homePic.trim();
    }

    public String getOnewordDesc() {
        return onewordDesc;
    }

    public void setOnewordDesc(String onewordDesc) {
        this.onewordDesc = onewordDesc == null ? null : onewordDesc.trim();
    }

    public Long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Long likeNum) {
        this.likeNum = likeNum;
    }

    public Long getMarkNum() {
        return markNum;
    }

    public void setMarkNum(Long markNum) {
        this.markNum = markNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Byte getPropflag() {
        return propflag;
    }

    public void setPropflag(Byte propflag) {
        this.propflag = propflag;
    }

    public Byte getBookstateflag() {
        return bookstateflag;
    }

    public void setBookstateflag(Byte bookstateflag) {
        this.bookstateflag = bookstateflag;
    }

    public Long getPays() {
        return pays;
    }

    public void setPays(Long pays) {
        this.pays = pays;
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

	public String getPlotDesc() {
		return plotDesc;
	}

	public void setPlotDesc(String plotDesc) {
		this.plotDesc = plotDesc;
	}

    
}