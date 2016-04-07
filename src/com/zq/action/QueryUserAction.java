package com.zq.action;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.service.UserService;
import com.zq.util.MyUtils;

public class QueryUserAction extends ActionSupport {

	private UserService userService;
	private AdminService adminService;

	private String realname;
	private String idnumber;
	private String sex;
	private String birthplace_province;
	private String birthplace_city;
	private String landscape;
	private String nation;
	private String education;
	private String degree;
	private String workdepartment;
	private String worked;
	private String professionaltile;
	private String phone;
	private String year;
	private String month;
	private String day;

	public String execute() throws Exception {

		String s = "error";
		System.out.println("realname" + realname);
		System.out.println("idnumber" + idnumber);
		System.out.println("sex" + sex);
		System.out.println("birthplace_province" + birthplace_province);
		System.out.println("birthplace_city" + birthplace_city);
		System.out.println("landscape" + landscape);
		System.out.println("nation" + nation);
		System.out.println("education" + education);
		System.out.println("degree" + degree);
		System.out.println("workdepartment" + workdepartment);
		System.out.println("worked" + worked);
		System.out.println("professionaltile" + professionaltile);
		System.out.println("phone" + phone);
		System.out.println("year" + year);
		System.out.println("month" + month);
		System.out.println("day" + day);

		if (realname.equals("")) {
			System.out.println(12345);
		} else if (realname == null) {
			System.out.println("nimei");
		}

		User user = new User();
		// 新建用户
		user.setRealname(realname);
		user.setSex(sex);
		user.setIdnumber(idnumber);
		user.setEducation(education);
		user.setPhone(phone);
		user.setProfessionaltile(professionaltile);
		user.setDegress(degree);
		user.setWorked(worked);
		user.setNation(nation);
		user.setLandscape(landscape);
		try {
			String birthplace = this.getBirthplace_province()
					+ this.getBirthplace_city();
			user.setBirthplace(birthplace);

			int pageSize = 10;

			String sdate = year + "-" + month + "-" + day;
			Date date = null;
			if (sdate.equals("--")) {
				sdate = "1111-11-11";
			}

			date = Date.valueOf(sdate);

			System.out.println(date);
			user.setBirthday(date);
			System.out.println(user.getBirthday());

			List<User> list = new ArrayList<User>();
			// 得到需要查询的用户信息
			list = userService.queryUser(user);
			// 设置查询的用户信息
			MyUtils.setUser(user);

			// 设置共查找到多少记录
			ActionContext.getContext().getSession().put("querycount",
					list.size());

			List<User> fenyelist = new ArrayList<User>();
			// 分页获取需要显示的信息
			fenyelist = userService.fenYeQuery(user, 1, pageSize);

			// 设置分页参数
			int pcount = list.size();
			ServletActionContext.getRequest().setAttribute("queryuserlist",
					fenyelist);
			ServletActionContext.getRequest().setAttribute("pcount", pcount);
			ServletActionContext.getRequest().setAttribute("pageNow", 1);
			ServletActionContext.getRequest().setAttribute("pageNowq", 1);
			ServletActionContext.getRequest().setAttribute("pageNowh", 2);

			int lastpage;
			if (pcount % pageSize == 0) {
				lastpage = pcount / pageSize;
			} else {
				lastpage = (pcount / pageSize) + 1;
			}

			ServletActionContext.getRequest()
					.setAttribute("lastPage", lastpage);

			Admin currentAdmin = (Admin) ActionContext.getContext()
					.getSession().get("admin_login");
			// 保存日志
			adminService.saveLog(currentAdmin.getARealname(), "查询", null,
					MyUtils.returnQueryCondition(user));

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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthplace_province() {
		return birthplace_province;
	}

	public void setBirthplace_province(String birthplaceProvince) {
		birthplace_province = birthplaceProvince;
	}

	public String getBirthplace_city() {
		return birthplace_city;
	}

	public void setBirthplace_city(String birthplaceCity) {
		birthplace_city = birthplaceCity;
	}

	public String getLandscape() {
		return landscape;
	}

	public void setLandscape(String landscape) {
		this.landscape = landscape;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getWorkdepartment() {
		return workdepartment;
	}

	public void setWorkdepartment(String workdepartment) {
		this.workdepartment = workdepartment;
	}

	public String getWorked() {
		return worked;
	}

	public void setWorked(String worked) {
		this.worked = worked;
	}

	public String getProfessionaltile() {
		return professionaltile;
	}

	public void setProfessionaltile(String professionaltile) {
		this.professionaltile = professionaltile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
