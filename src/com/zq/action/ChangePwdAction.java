package com.zq.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.service.UserService;

public class ChangePwdAction extends ActionSupport {

	private UserService userService;
	private AdminService adminService;
	private String password_f;

	public String execute() throws Exception {

		String r = "error";
		try {
			// 获取当前用户
			User user = (User) ActionContext.getContext().getSession().get(
					"user_now");
			// 更新密码
			String res = userService.updatePassword(user.getId().toString(),
					getPassword_f());
			// 判断是否更改成功
			if (res.equals("success")) {
				r = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getPassword_f() {
		return password_f;
	}

	public void setPassword_f(String passwordF) {
		password_f = passwordF;
	}

}
