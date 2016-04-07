package com.zq.beans;

import java.sql.Timestamp;



/**
 * Logtable entity. @author MyEclipse Persistence Tools
 */

public class Logtable implements java.io.Serializable {

	private Long id;
	private Long uid;
	private String operator;
	private String type;
	private String remark;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Logtable() {
	}

	/** minimal constructor */
	public Logtable(String operator, Timestamp time) {
		this.operator = operator;
		this.time = time;
	}

	/** full constructor */
	public Logtable(Long uid, String operator, String type, Timestamp time,String remark) {
		this.uid = uid;
		this.operator = operator;
		this.type = type;
		this.time = time;
		this.remark = remark;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}