package com.zq.test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private String uname;
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(uname);
		uname = new String("小明");
		return super.execute();
	}
}
