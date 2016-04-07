package com.zq.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.zq.beans.Admin;
import com.zq.beans.Logtable;
import com.zq.beans.User;

public class MyUtils {

	// 查询中保存的用户
	public static User user;
	// 查询中保存的irzhi
	public static Logtable log = null;

	// 拼接查询用户用到的sql语句
	public static String pingJie(User user) {

		StringBuilder sb = new StringBuilder();
		sb.append("select * from users where 1=1");
		if (!"".equals(user.getRealname())) {
			sb.append(" and realname like '%" + user.getRealname() + "%'");
		}
		if (!"".equals(user.getIdnumber())) {
			sb.append(" and idnumber='" + user.getIdnumber() + "'");
		}
		if (user.getSex() != null) {
			sb.append(" and sex='" + user.getSex() + "'");
		}
		if (!"00".equals(user.getBirthplace())) {
			sb.append(" and birthplace='" + user.getBirthplace() + "'");
		}
		if (!"0".equals(user.getLandscape())) {
			sb.append(" and landscape='" + user.getLandscape() + "'");
		}
		if (!"0".equals(user.getNation())) {
			sb.append(" and nation='" + user.getNation() + "'");
		}
		if (!"0".equals(user.getEducation())) {
			sb.append(" and education='" + user.getEducation() + "'");
		}
		if (!"0".equals(user.getDegress())) {
			sb.append(" and degress='" + user.getDegress() + "'");
		}
		if ((!"".equals(user.getWorkdepartment()))
				&& (user.getWorkdepartment() != null)) {
			sb.append(" and workdepartment like '%" + user.getWorkdepartment()
					+ "%'");
		}
		if ((!"".equals(user.getWorked())) && (user.getWorked() != null)) {
			sb.append(" and worked like '%" + user.getWorked() + "%'");
		}
		if (!"".equals(user.getProfessionaltile())) {
			sb.append(" and professionaltile like '%"
					+ user.getProfessionaltile() + "%'");
		}
		if (!"".equals(user.getPhone())) {
			sb.append(" and phone='" + user.getPhone() + "'");
		}
		if (!Date.valueOf("1111-11-11").toString().equals(
				user.getBirthday().toString())) {
			sb.append(" and birthday='" + user.getBirthday() + "'");
		}
		System.out.println("dddddd" + user.getBirthday());

		System.out.println(sb.toString());
		return sb.toString();
	}

	// 凭借查询日志用到的sql语句
	public static String pingJieLogQuery(Logtable log) {

		StringBuilder sb = new StringBuilder();
		sb.append("select * from logtable where 1=1");

		if (log != null) {

			if (!"0".equals(log.getOperator())) {
				sb.append(" and operator='" + log.getOperator() + "'");
			}
			if (!"0".equals(log.getType())) {
				sb.append(" and type='" + log.getType() + "'");
			}

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s1 = "1111-11-11 00:00:00";
			if (!s1.equals(df.format(log.getTime()))) {
				sb.append(" and time >='" + df.format(log.getTime()) + "'");
			}
		}
		System.out.println("当前日志查询添加为：" + sb.toString());

		return sb.toString();
	}

	// 返回查询条件
	public static String returnQueryCondition(User user) {

		StringBuilder sb = new StringBuilder();

		if (!"".equals(user.getRealname())) {
			sb.append(" 姓名=" + user.getRealname());
		}
		if (!"".equals(user.getIdnumber())) {
			sb.append(" 身份证号=" + user.getIdnumber());
		}
		if (user.getSex() != null) {
			sb.append(" 性别=" + user.getSex());
		}
		if (!"00".equals(user.getBirthplace())) {
			sb.append(" 籍贯=" + user.getBirthplace());
		}
		if (!"0".equals(user.getLandscape())) {
			sb.append(" 政治面貌=" + user.getLandscape());
		}
		if (!"0".equals(user.getNation())) {
			sb.append(" 民族=" + user.getNation());
		}
		if (!"0".equals(user.getEducation())) {
			sb.append(" 学历=" + user.getEducation());
		}
		if (!"0".equals(user.getDegress())) {
			sb.append(" 学位=" + user.getDegress());
		}
		if ((!"".equals(user.getWorkdepartment()))
				&& (user.getWorkdepartment() != null)) {
			sb.append(" 工作单位 =" + user.getWorkdepartment());
		}
		if ((!"".equals(user.getWorked())) && (user.getWorked() != null)) {
			sb.append(" 任何职=" + user.getWorked());
		}
		if (!"".equals(user.getProfessionaltile())) {
			sb.append(" 职称=" + user.getProfessionaltile());
		}
		if (!"".equals(user.getPhone())) {
			sb.append(" 电话='" + user.getPhone());
		}
		if (!Date.valueOf("1111-11-11").toString().equals(
				user.getBirthday().toString())) {
			sb.append(" 出生日期='" + user.getBirthday());
		}
		System.out.println(sb.toString());
		if (sb.toString() == null || sb.toString().equals("")) {
			return "查询全体人员信息";
		} else {
			return sb.toString();
		}

	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		MyUtils.user = user;
	}

	public static Logtable getLog() {
		return log;
	}

	public static void setLog(Logtable log) {
		MyUtils.log = log;
	}

}
