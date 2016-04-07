package com.zq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zq.beans.Admin;
import com.zq.beans.Logtable;
import com.zq.dao.AdminDao;
import com.zq.dao.impl.AdminDaoImpl;

import com.zq.service.AdminService;

public class AdminServiceImpl implements AdminService {

	public AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public List<Admin> checkUser(Admin admin) {

		return adminDao.checkUser(admin);
	}

	public List<List> checkLog() {

		return adminDao.checkLog();
	}

	public void saveLog(String operator, String type, Long operobj,
			String remark) {

		adminDao.saveLog(operator, type, operobj, remark);

	}

	public List<Admin> queryAllAdmin() {

		return adminDao.queryAllAdmin();
	}

	public Admin findAdminById(int id) {

		return adminDao.findAdminById(id);
	}

	public List<List> checkLog(Logtable log) {

		return adminDao.checkLog(log);
	}

	public List<List> fenYeQueryLog(Logtable log, int pageNum, int pageSize) {

		return adminDao.fenYeQueryLog(log, pageNum, pageSize);
	}

}
