package com.zq.beans;

import java.sql.Timestamp;

/**
 * Filetable entity. @author MyEclipse Persistence Tools
 */

public class Filetable implements java.io.Serializable {

	// Fields

	private Long id;
	private User users;
	private String url;
	private Timestamp time;
	private String categories;

	// Constructors

	/** default constructor */
	public Filetable() {
	}

	/** minimal constructor */
	public Filetable(User users, String url, Timestamp time) {
		this.users = users;
		this.url = url;
		this.time = time;
	}

	/** full constructor */
	public Filetable(User users, String url, Timestamp time, String categories) {
		this.users = users;
		this.url = url;
		this.time = time;
		this.categories = categories;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUsers() {
		return this.users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getCategories() {
		return this.categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

}