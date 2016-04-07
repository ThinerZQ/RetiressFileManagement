package com.zq.action;

import java.sql.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.service.UserService;

public class UpdateUserAction extends ActionSupport {

	private UserService userService;
	private AdminService adminService;

	private String id;
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

		String r = "error";

		// 获取标识符
		String flag = ServletActionContext.getRequest().getParameter("flag");
		try {

			// 新建用户
			User user = new User();
			user.setId(Long.parseLong(this.getId()));

			user.setRealname(realname);
			System.out.println(this.getRealname());
			System.out.println(this.getSex());
			user.setSex(sex);
			user.setIdnumber(idnumber);
			user.setAddress(address);
			user.setEducation(education);
			user.setPhone(phone);
			user.setProfessionaltile(professionaltile);
			user.setDegress(degree);
			user.setWorked(worked);
			user.setWorkdepartment(workdepartment);
			user.setDepartment(department);
			user.setNation(nation);
			user.setExperience(experience);
			user.setLandscape(landscape);
			user.setHealth(health);
			String birthplace = this.getBirthplace_province()
					+ this.getBirthplace_city();
			user.setBirthplace(birthplace);
			String s = year + "-" + month + "-" + day;
			Date date = Date.valueOf(s);
			user.setBirthday(date);

			// 获取原来用户信息
			User olduser = userService.findUserById(Long
					.parseLong(this.getId()));

			// 获取被修改的类型
			StringBuilder sb = new StringBuilder();
			sb.append("修改部分为：");
			if (!olduser.getRealname().equals(realname)) {
				sb.append("原姓名：" + olduser.getRealname());

			}
			if (!olduser.getSex().equals(sex)) {
				sb.append("原性别：" + olduser.getSex());

			}
			if (!olduser.getIdnumber().equals(idnumber)) {
				sb.append("原身份证号：" + olduser.getIdnumber());

			}
			if (!olduser.getAddress().equals(address)) {
				sb.append("原地址：" + olduser.getAddress());

			}
			if (!olduser.getBirthday().toString().equals(date.toString())) {
				sb.append("原出生日期：" + olduser.getBirthday().toString());

			}
			if (!olduser.getBirthplace().equals(birthplace)) {
				sb.append("原出生地：" + olduser.getBirthplace());

			}
			if (!olduser.getDegress().equals(degree)) {
				sb.append("原学位：" + olduser.getDegress());

			}
			if (!olduser.getDepartment().equals(department)) {
				sb.append("原工作单位：" + olduser.getDepartment());

			}
			if (!olduser.getEducation().equals(education)) {
				sb.append("原学历：" + olduser.getEducation());

			}
			if (!olduser.getExperience().equals(experience)) {
				sb.append("原工作经历：" + olduser.getExperience());

			}
			if (!olduser.getHealth().equals(health)) {
				sb.append("原健康状况：" + olduser.getHealth());

			}
			if (!olduser.getWorked().equals(worked)) {
				sb.append("原任何职务：" + olduser.getWorked());

			}
			if (!olduser.getWorkdepartment().equals(workdepartment)) {
				sb.append("原在何部门：" + olduser.getWorkdepartment());

			}
			if (!olduser.getProfessionaltile().equals(professionaltile)) {
				sb.append("原职称：" + olduser.getProfessionaltile());

			}
			if (!olduser.getPhone().equals(phone)) {
				sb.append("原电话：" + olduser.getPhone());
				;
			}
			if (!olduser.getNation().equals(nation)) {
				sb.append("原姓名：" + olduser.getNation());

			}
			if (!olduser.getLandscape().equals(landscape)) {
				sb.append("原政治面貌：" + olduser.getLandscape());

			}

			// 更新用户信息
			Long i = userService.updateUser(user);
			if (i == 1) {
				// 管理员更新
				if (flag.equals("admin")) {

					Admin currentAdmin = (Admin) ActionContext.getContext()
							.getSession().get("admin_login");
					// 保存日志
					adminService.saveLog(currentAdmin.getARealname(), "修改",
							user.getId(), sb.toString());

					r = "successadmin";
				} else if (flag.equals("user")) {

					// 根性session里面的当前用户
					ActionContext.getContext().getSession().put("user_now",
							user);

					r = "successuser";
				}
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
