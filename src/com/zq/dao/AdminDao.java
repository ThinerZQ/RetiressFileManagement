package com.zq.dao;

import java.util.List;

import com.zq.beans.Admin;
import com.zq.beans.Logtable;

public interface AdminDao {

	// 检查管理员登陆是否合法
	public List<Admin> checkUser(Admin admin);

	// 查找所有日志记录
	public List<List> checkLog();

	// 保存日志
	public void saveLog(String operator, String type, Long operobj,
			String remark);

	// 查找所有管理员
	public List<Admin> queryAllAdmin();

	// 根据Id查找管理员
	public Admin findAdminById(int id);

	// 查看所有日志
	public List<List> checkLog(Logtable log);

	// 分页获取日志
	public List<List> fenYeQueryLog(Logtable log, int pageNum,
			final int pageSize);

}
