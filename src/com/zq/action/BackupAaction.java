package com.zq.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.service.AdminService;

public class BackupAaction extends ActionSupport {

	private AdminService adminService;

	public String execute() throws Exception {

		// 设置备份语句
		String s = "cmd /k start/ mysqldump -uroot -pzhengqiang retiressfilemanagement > D:\\Study\\tomcat-6.0.39\\webapps\\RetiressFileManagement\\backup\\backup11111.sql";

		try {
			Process p = Runtime.getRuntime().exec(s);

			// 获取当前管理员
			Admin currentAdmin = (Admin) ActionContext.getContext()
					.getSession().get("admin_login");
			// 保存日志
			adminService.saveLog(currentAdmin.getARealname(), "数据备份", null,
					"备份成功");
			p.destroy();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return "success";
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
