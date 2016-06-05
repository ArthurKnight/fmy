package com.fmy.entity;

import java.util.Date;

public class MhydUser {
    private String id;

    private String name;

    private Integer diamondNum;

    private Date createTimestamp;

    private Date lastChangeTimestamp;
    
    private Integer markNum;

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

    public Integer getDiamondNum() {
        return diamondNum;
    }

    public void setDiamondNum(Integer diamondNum) {
        this.diamondNum = diamondNum;
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

	public Integer getMarkNum() {
		return markNum;
	}

	public void setMarkNum(Integer markNum) {
		this.markNum = markNum;
	}
    
}