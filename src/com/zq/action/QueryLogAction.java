package com.zq.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.beans.Logtable;
import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.util.MyUtils;

public class QueryLogAction extends ActionSupport {

	private AdminService adminService;
	private String operator;
	private String year;
	private String month;
	private String day;
	private String type;
	List<Logtable> loglist;
	List<User> operlist;

	public String execute() throws Exception {

		String r = "error";
		int pageSize = 10;
		// 日志类
		Logtable log = new Logtable();
		log.setType(type);

		String s = year + "-" + month + "-" + day;
		// 判断时间
		if (s.equals("00-00-00")) {
			s = "1111-11-11 00:00:00";
		} else {
			s = s + " 00:00:00";
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定义格式

		System.out.println(s);
		Timestamp ts = Timestamp.valueOf(s);
		log.setTime(ts);

		Admin admin = null;
		// 判断操作者
		if (!operator.equals("0")) {
			admin = adminService.findAdminById(Integer.parseInt(operator));
			log.setOperator(admin.getARealname());
		} else {
			log.setOperator("0");
		}
		// System.out.println("222222222222222222222222222222222");
		try {
			// System.out.println("333333333333333333333333333");
			List<List> list = null;
			// System.out.println("4444444444444444444444444444");
			// 查找所有日志
			list = adminService.checkLog();
			int pcount = list.size();
			// 设置日志
			MyUtils.setLog(log);
			// 分页得到日志
			List<List> fenyelist = adminService.fenYeQueryLog(MyUtils.getLog(),
					1, pageSize);
			loglist = fenyelist.get(0);
			operlist = fenyelist.get(1);

			// 设置分页信息
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
			r = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;

	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
