package com.zq.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Logtable;
import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.service.UserService;
import com.zq.util.MyUtils;

public class FenYeAction extends ActionSupport {

	public UserService userService;
	public AdminService adminService;

	public String execute() throws Exception {

		String s = "error";
		try {
			List<User> allUser = new ArrayList<User>();

			String pageNum = ServletActionContext.getRequest().getParameter(
					"pageNum");

			int pageNums = Integer.parseInt(pageNum);

			allUser = userService.findAllUser();

			int pcount = allUser.size();

			int pageSize = 10;
			int lastpage;
			if (pcount % pageSize == 0) {
				lastpage = pcount / pageSize;
			} else {
				lastpage = (pcount / pageSize) + 1;
			}

			List<User> fenyeUser = null;
			if (pageNums > lastpage) {
				fenyeUser = userService.fenYe(lastpage, pageSize);
			} else {
				fenyeUser = userService.fenYe(pageNums, pageSize);
			}

			ServletActionContext.getRequest().setAttribute("alluserlist",
					fenyeUser);
			ServletActionContext.getRequest().setAttribute("pcount", pcount);

			if (pageNums > lastpage) {
				ServletActionContext.getRequest().setAttribute("pageNow",
						lastpage);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						lastpage - 1);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						lastpage);
			} else if (pageNums == 1) {
				ServletActionContext.getRequest().setAttribute("pageNow",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						pageNums + 1);
			} else {
				ServletActionContext.getRequest().setAttribute("pageNow",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						pageNums - 1);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						pageNums + 1);
			}

			ServletActionContext.getRequest()
					.setAttribute("lastPage", lastpage);

			s = "success";
		} catch (Exception e) {
			e.printStackTrace();

		}
		return s;
	}

	public String fenYeQuery() throws Exception {

		String s = "error";
		try {
			List<User> allUser = new ArrayList<User>();

			String pageNum = ServletActionContext.getRequest().getParameter(
					"pageNum");

			int pageNums = Integer.parseInt(pageNum);

			allUser = userService.queryUser(MyUtils.getUser());

			int pcount = allUser.size();

			int pageSize = 10;
			int lastpage;
			if (pcount % pageSize == 0) {
				lastpage = pcount / pageSize;
			} else {
				lastpage = (pcount / pageSize) + 1;
			}

			List<User> fenyeUser = null;
			if (pageNums > lastpage) {
				fenyeUser = userService.fenYeQuery(MyUtils.getUser(), lastpage,
						pageSize);
			} else {
				fenyeUser = userService.fenYeQuery(MyUtils.getUser(), pageNums,
						pageSize);
			}

			ServletActionContext.getRequest().setAttribute("queryuserlist",
					fenyeUser);
			ServletActionContext.getRequest().setAttribute("pcount", pcount);

			if (pageNums > lastpage) {
				ServletActionContext.getRequest().setAttribute("pageNow",
						lastpage);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						lastpage - 1);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						lastpage);
			} else if (pageNums == 1) {
				ServletActionContext.getRequest().setAttribute("pageNow",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						pageNums + 1);
			} else {
				ServletActionContext.getRequest().setAttribute("pageNow",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						pageNums - 1);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						pageNums + 1);
			}

			ServletActionContext.getRequest()
					.setAttribute("lastPage", lastpage);

			s = "success";
		} catch (Exception e) {
			e.printStackTrace();

		}
		return s;
	}

	public String fenYeQueryLog() throws Exception {

		String s = "error";
		int pageSize = 10;
		try {
			List<List> list = new ArrayList<List>();
			List<Logtable> loglist = new ArrayList<Logtable>();
			List<User> operlist = new ArrayList<User>();

			String pageNum = ServletActionContext.getRequest().getParameter(
					"pageNum");

			int pageNums = Integer.parseInt(pageNum);

			list = adminService.checkLog();

			loglist = list.get(0);

			int pcount = loglist.size();

			System.out.println("pcount====" + pcount);
			int lastpage;
			if (pcount % pageSize == 0) {
				lastpage = pcount / pageSize;
			} else {
				lastpage = (pcount / pageSize) + 1;
			}

			System.out.println("页面传过来的是：pageNum=" + pageNums);
			System.out.println("lastpage===" + lastpage);
			if (pageNums > lastpage) {
				list = adminService.fenYeQueryLog(MyUtils.getLog(), lastpage,
						pageSize);
			} else {
				list = adminService.fenYeQueryLog(MyUtils.getLog(), pageNums,
						pageSize);
			}

			loglist = list.get(0);
			operlist = list.get(1);

			ServletActionContext.getRequest().setAttribute("loglist", loglist);
			ServletActionContext.getRequest()
					.setAttribute("operlist", operlist);
			ServletActionContext.getRequest().setAttribute("pcount", pcount);

			if (pageNums > lastpage) {
				ServletActionContext.getRequest().setAttribute("pageNow",
						lastpage);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						lastpage - 1);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						lastpage);
			} else if (pageNums == 1) {
				ServletActionContext.getRequest().setAttribute("pageNow",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						pageNums + 1);
			} else {
				ServletActionContext.getRequest().setAttribute("pageNow",
						pageNums);
				ServletActionContext.getRequest().setAttribute("pageNowq",
						pageNums - 1);
				ServletActionContext.getRequest().setAttribute("pageNowh",
						pageNums + 1);
			}

			ServletActionContext.getRequest()
					.setAttribute("lastPage", lastpage);

			s = "success";
		} catch (Exception e) {
			e.printStackTrace();

		}
		return s;

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
