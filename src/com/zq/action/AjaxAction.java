package com.zq.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.service.AdminService;

public class AjaxAction extends ActionSupport {

	public AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String ajaxLoadAdmin() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();

		// 设置返回参数
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();

		// 得到request
		HttpServletRequest req = ServletActionContext.getRequest();

		// 加载所有的管理员信息
		List<Admin> adminlist = adminService.queryAllAdmin();

		// System.out.println(adminlist.get(0).getAUsername());

		// 通过json输出
		JSONArray jsonArray = JSONArray.fromObject(adminlist);
		System.out.println(jsonArray.toString());
		out.println(jsonArray.toString());

		return null;
	}

}
