package com.zq.dao;

import java.text.ParseException;
import java.util.List;

import com.zq.beans.Filetable;
import com.zq.beans.User;

public interface UserDao {

	// 保存用户信息
	public List<Long> saveUserInfo(List<User> list);

	// 根据id查找用户
	public User findUserById(Long id);

	// 查询用户
	public List<User> queryUser(User user) throws ParseException;

	// 查找所有用户
	public List<User> findAllUser();

	// 分页获取用户
	public List<User> fenYe(int pageNum, final int pageSize);

	// 分页查询用户
	public List<User> fenYeQuery(User user, int pageNum, final int pageSize);

	// update user info
	public Long updateUser(User user);

	// find user by idnumber
	public User findUserByIdNumber(String idnumber);

	// find out password by user id
	public String findPasswordByIdUid(Long id);

	// update password
	public String updatePassword(String uid, String pwd);

	// add files
	public String addFiles(Filetable ftable);
}
