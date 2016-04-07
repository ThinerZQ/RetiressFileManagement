package com.zq.beans;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String realname;
	private String sex;
	private Date birthday;
	private String landscape;
	private String nation;
	private String birthplace;
	private String workdepartment;
	private String worked;
	private String professionaltile;
	private String address;
	private String phone;
	private String department;
	private String experience;
	private String health;
	private String education;
	private String degress;
	private String idnumber;
	
	private Set filetables = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String realname, String sex, Date birthday, String landscape,
			String nation, String birthplace) {
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.landscape = landscape;
		this.nation = nation;
		this.birthplace = birthplace;
	}

	/** full constructor */
	public User(String realname, String sex, Date birthday, String landscape,
			String nation, String birthplace, String workdepartment,
			String worked, String professionaltile, String address,
			String phone, String department, String experience, String health,
			String education, String degress, String idnumber, 
			Set filetables) {
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.landscape = landscape;
		this.nation = nation;
		this.birthplace = birthplace;
		this.workdepartment = workdepartment;
		this.worked = worked;
		this.professionaltile = professionaltile;
		this.address = address;
		this.phone = phone;
		this.department = department;
		this.experience = experience;
		this.health = health;
		this.education = education;
		this.degress = degress;
		this.idnumber = idnumber;
		
		this.filetables = filetables;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getLandscape() {
		return this.landscape;
	}

	public void setLandscape(String landscape) {
		this.landscape = landscape;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getWorkdepartment() {
		return this.workdepartment;
	}

	public void setWorkdepartment(String workdepartment) {
		this.workdepartment = workdepartment;
	}

	public String getWorked() {
		return this.worked;
	}

	public void setWorked(String worked) {
		this.worked = worked;
	}

	public String getProfessionaltile() {
		return this.professionaltile;
	}

	public void setProfessionaltile(String professionaltile) {
		this.professionaltile = professionaltile;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getHealth() {
		return this.health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegress() {
		return this.degress;
	}

	public void setDegress(String degress) {
		this.degress = degress;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	

	public Set getFiletables() {
		return this.filetables;
	}

	public void setFiletables(Set filetables) {
		this.filetables = filetables;
	}

	@Override
	public String toString() {
		
		
		
		
		String s = "姓名："+realname+" 身份证号： "+idnumber+" 性别："+sex+" 出生日期："+getBirthday().toString()+
				" 政治面貌："+landscape+" 民族："+nation+" 籍贯："+birthplace+" 工作部门："+workdepartment;
		return s;
	}
	
}