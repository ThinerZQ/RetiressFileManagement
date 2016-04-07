package com.zq.service.impl;

import java.text.ParseException;
import java.util.List;

import com.zq.beans.Filetable;
import com.zq.beans.User;
import com.zq.dao.AdminDao;
import com.zq.dao.UserDao;
import com.zq.service.UserService;

public class UserServiceImpl implements UserService {

	public UserDao userDao;

	public List<Long> saveUserInfo(List<User> list) {

		return userDao.saveUserInfo(list);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findUserById(Long id) {

		return userDao.findUserById(id);
	}

	public List<User> queryUser(User user) throws ParseException {

		return userDao.queryUser(user);
	}

	public List<User> findAllUser() {

		return userDao.findAllUser();
	}

	public List<User> fenYe(int pageNum, int pageSize) {

		return userDao.fenYe(pageNum, pageSize);
	}

	public List<User> fenYeQuery(User user, int pageNum, int pageSize) {
		return userDao.fenYeQuery(user, pageNum, pageSize);
	}

	public Long updateUser(User user) {

		return userDao.updateUser(user);
	}

	public User findUserByIdNumber(String idnumber) {
		return userDao.findUserByIdNumber(idnumber);
	}

	public String findPasswordByIdUid(Long id) {

		return userDao.findPasswordByIdUid(id);
	}

	public String updatePassword(String uid, String pwd) {
		return userDao.updatePassword(uid, pwd);
	}

	public String addFiles(Filetable ftable) {

		return userDao.addFiles(ftable);
	}

}
