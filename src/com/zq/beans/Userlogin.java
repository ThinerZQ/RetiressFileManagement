package com.zq.beans;

/**
 * Userlogin entity. @author MyEclipse Persistence Tools
 */

public class Userlogin implements java.io.Serializable {

	// Fields

	private Long id;
	
	private String password;
	private Long u_id;

	// Constructors

	/** default constructor */
	public Userlogin() {
	}

	/** full constructor */
	public Userlogin(Long u_id, String password) {
		this.u_id = u_id;
		this.password = password;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getU_id() {
		return u_id;
	}

	public void setU_id(Long uId) {
		u_id = uId;
	}
	

}