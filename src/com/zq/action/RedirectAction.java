package com.zq.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.service.AdminService;
import com.zq.service.UserService;

public class RedirectAction extends ActionSupport {

	private UserService userService;
	private AdminService adminService;

	// 去添加用户
	public String addUser() throws Exception {

		return "success";

	}

	// 去查询用户
	public String queryUser() throws Exception {

		return "success";

	}

	// 去执行Exel
	public String goExcel() throws Exception {

		return "success";

	}

	// 去退出
	public String goExit() throws Exception {

		// 清空session
		Admin curradmin = (Admin) ActionContext.getContext().getSession().get(
				"admin_login");
		ActionContext.getContext().getSession().put("admin_login", null);
		// 保存日志
		adminService.saveLog(curradmin.getARealname(), "注销", null, "退出成功");

		return "success";

	}

	// 去欢迎界面
	public String welcome() throws Exception {
		return "success";
	}

	// 去选择需要输出的信息
	public String goChoiceOutputCols() throws Exception {
		return "success";
	}

	// 去文件上传页面
	public String goFileUp() throws Exception {
		return "success";
	}

	// 去查看我的信息
	public String checkMyInfo() throws Exception {
		return "success";
	}

	// 去查看我的档案信息学
	public String checkMyDangAnInfo() throws Exception {
		return "success";
	}

	// 输出所有的Excel
	public String outAllExcel() throws Exception {

		// userService.findAllUser();

		return "success";
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

}
