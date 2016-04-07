package com.zq.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.User;
import com.zq.service.UserService;

public class DetailInfoAction extends ActionSupport {

	private UserService userService;

	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {

		String s = null;
		try {
			// 得到ID
			String uid = ServletActionContext.getRequest().getParameter("uid");
			// 查找用户给
			User user = userService.findUserById(Long.parseLong(uid));
			// System.out.println(user.getRealname());

			// 将当前用户放入request
			ServletActionContext.getRequest().setAttribute("user", user);
			s = "success";

		} catch (Exception e) {
			e.printStackTrace();
			s = "error";
		}
		System.out.println(s);

		return s;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
