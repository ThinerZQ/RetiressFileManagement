package com.zq.beans;

/**
 * Admintable entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String AUsername;
	private String ARealname;
	private String APwd;
	private String AState;
	private String APhone;
	private String ASex;
	private String AEmail;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String AUsername, String ARealname, String APwd,
			String AState, String APhone, String ASex, String AEmail) {
		this.AUsername = AUsername;
		this.ARealname = ARealname;
		this.APwd = APwd;
		this.AState = AState;
		this.APhone = APhone;
		this.ASex = ASex;
		this.AEmail = AEmail;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAUsername() {
		return this.AUsername;
	}

	public void setAUsername(String AUsername) {
		this.AUsername = AUsername;
	}

	public String getARealname() {
		return this.ARealname;
	}

	public void setARealname(String ARealname) {
		this.ARealname = ARealname;
	}

	public String getAPwd() {
		return this.APwd;
	}

	public void setAPwd(String APwd) {
		this.APwd = APwd;
	}

	public String getAState() {
		return this.AState;
	}

	public void setAState(String AState) {
		this.AState = AState;
	}

	public String getAPhone() {
		return this.APhone;
	}

	public void setAPhone(String APhone) {
		this.APhone = APhone;
	}

	public String getASex() {
		return this.ASex;
	}

	public void setASex(String ASex) {
		this.ASex = ASex;
	}

	public String getAEmail() {
		return this.AEmail;
	}

	public void setAEmail(String AEmail) {
		this.AEmail = AEmail;
	}

}