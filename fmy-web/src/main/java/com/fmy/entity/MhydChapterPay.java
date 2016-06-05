package com.fmy.entity;

import java.util.Date;

public class MhydChapterPay {
    private String id;

    private String fkChapterId;

    private Byte payType;

    private String readPay;

    private String readCard;

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

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public String getReadPay() {
        return readPay;
    }

    public void setReadPay(String readPay) {
        this.readPay = readPay == null ? null : readPay.trim();
    }

    public String getReadCard() {
        return readCard;
    }

    public void setReadCard(String readCard) {
        this.readCard = readCard == null ? null : readCard.trim();
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