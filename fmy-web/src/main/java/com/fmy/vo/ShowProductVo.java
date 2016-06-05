package com.fmy.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2016-5-31
 * 
 * @author luliang_yu
 * @version 1.0
 * 显示作品详情Vo
 */
public class ShowProductVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5844064954612607037L;

	/**
	 * 作者名字
	 */
	private String userName;
	
	/**
	 * 作者画力
	 */
	private int drawRank;
	
	/**
	 * 作品总数
	 */
	private int proCounts;
	
	/**
	 * 作品列表
	 */
	private List<ProductVo> pros;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getDrawRank() {
		return drawRank;
	}

	public void setDrawRank(int drawRank) {
		this.drawRank = drawRank;
	}

	public int getProCounts() {
		return proCounts;
	}

	public void setProCounts(int proCounts) {
		this.proCounts = proCounts;
	}

	public List<ProductVo> getPros() {
		return pros;
	}

	public void setPros(List<ProductVo> pros) {
		this.pros = pros;
	}
	
}