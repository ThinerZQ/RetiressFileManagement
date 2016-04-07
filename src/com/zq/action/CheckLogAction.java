package com.zq.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Logtable;
import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.service.UserService;
import com.zq.util.MyUtils;

public class CheckLogAction extends ActionSupport {

	private UserService userService;
	private AdminService adminService;
	List<Logtable> loglist;
	List<User> operlist;

	@Override
	public String execute() throws Exception {

		List<List> list = null;
		String s = "error";
		// 页面大小
		int pageSize = 10;

		try {
			// 设置查询的日志为空
			MyUtils.setLog(null);
			// 查找所有日志
			list = adminService.checkLog();
			// 得到日志记录
			loglist = list.get(0);
			// 得到一共有多少条日志记录
			int pcount = loglist.size();
			// 分页获取日志记录
			List<List> fenyelist = adminService.fenYeQueryLog(MyUtils.getLog(),
					1, pageSize);
			// 日志
			loglist = fenyelist.get(0);
			// 操作者
			operlist = fenyelist.get(1);

			// 设置分页参数
			ServletActionContext.getRequest().setAttribute("pcount", pcount);
			ServletActionContext.getRequest().setAttribute("pageNow", 1);
			ServletActionContext.getRequest().setAttribute("pageNowq", 1);
			ServletActionContext.getRequest().setAttribute("pageNowh", 2);

			// 判断最后一页
			int lastpage;
			if (pcount % pageSize == 0) {
				lastpage = pcount / pageSize;
			} else {
				lastpage = (pcount / pageSize) + 1;
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

	public List<Logtable> getLoglist() {
		return loglist;
	}

	public void setLoglist(List<Logtable> loglist) {
		this.loglist = loglist;
	}

	public List<User> getOperlist() {
		return operlist;
	}

	public void setOperlist(List<User> operlist) {
		this.operlist = operlist;
	}

}
