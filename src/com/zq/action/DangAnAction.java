package com.zq.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.User;
import com.zq.service.UserService;

public class DangAnAction extends ActionSupport {

	private UserService userService;

	public String goAddFile() throws Exception {

		String s = "error";

		// 档案action
		String uid = ServletActionContext.getRequest().getParameter("uid");
		// 获取用户
		User user = userService.findUserById(Long.parseLong(uid));
		// 设置用户
		ServletActionContext.getRequest().setAttribute("user", user);
		s = "success";
		return s;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
