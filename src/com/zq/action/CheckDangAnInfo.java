package com.zq.action;

import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.User;
import com.zq.service.UserService;

public class CheckDangAnInfo extends ActionSupport {

	private String uid;
	private UserService userService;

	public String execute() throws Exception {

		String r = "error";
		User user = new User();
		try {
			// 查找需要查看的用户
			user = userService.findUserById(Long.parseLong(uid));
			// 得到档案材料
			Set ss = user.getFiletables();
			// 将得到的用户放入request
			ServletActionContext.getRequest().setAttribute("user", user);
			r = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("当前用户的档案多少："+ss.size());

		return r;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
