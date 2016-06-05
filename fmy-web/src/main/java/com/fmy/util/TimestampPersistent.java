package com.fmy.util;

import java.util.Date;


/**
 * 通用的持久化基类 <br/>
 * id默认为32位的UUID<br/>
 * Date: 2016-5-30
 * 
 * @author luliang_yu
 * @version 3.0.0
 * 
 */
public class TimestampPersistent  {

	/**
	 * 创建时间
	 */
	private Date createTimeStamp;

	/**
	 * 更新时间
	 */
	private Date lastChangeTimeStamp;

	public Date getCreateTimeStamp() {
		return createTimeStamp;
	}

	public void setCreateTimeStamp(Date createTimeStamp) {
		this.createTimeStamp = createTimeStamp;
	}

	public Date getLastChangeTimeStamp() {
		return lastChangeTimeStamp;
	}

	public void setLastChangeTimeStamp(Date lastChangeTimeStamp) {
		this.lastChangeTimeStamp = lastChangeTimeStamp;
	}

}
