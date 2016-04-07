package com.zq.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class AddUserAction extends ActionSupport {

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
	private String department;
	private String worked;
	private String professionaltile;
	private String health;
	private String phone;
	private String address;
	private String experience;
	private String year;
	private String month;
	private String day;

	public String execute() throws Exception {

		// 创建需要添加的用户
		User user = new User();
		user.setRealname(realname);
		// System.out.println(this.getRealname());
		// System.out.println(this.getSex());
		user.setSex(sex);
		user.setIdnumber(idnumber);
		user.setAddress(address);
		user.setEducation(education);
		user.setPhone(phone);
		user.setProfessionaltile(professionaltile);
		user.setDegress(degree);
		user.setWorked(worked);
		user.setDepartment(department);
		user.setWorkdepartment(workdepartment);
		user.setNation(nation);
		user.setExperience(experience);
		user.setLandscape(landscape);
		user.setHealth(health);
		String birthplace = this.getBirthplace_province()
				+ this.getBirthplace_city();
		user.setBirthplace(birthplace);
		String s = year + "-" + month + "-" + day;
		Date date = Date.valueOf(s);

		// 添加日期
		user.setBirthday(date);
		List<User> list = new ArrayList<User>();
		list.add(user);
		// 保存用户
		List<Long> idlist = userService.saveUserInfo(list);
		Long id = idlist.get(0);
		if (id != 0l) {
			user = userService.findUserById(id);
			// 获取当前登录的管理员对象
			Admin currentAdmin = (Admin) ActionContext.getContext()
					.getSession().get("admin_login");
			// 增加添加用户日志
			adminService.saveLog(currentAdmin.getARealname(), "添加用户", id,
					"添加成功");
			// 将添加的用户放入request中
			ServletActionContext.getRequest().setAttribute("user", user);
			return "success";
		} else {
			return "error";
		}
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
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
