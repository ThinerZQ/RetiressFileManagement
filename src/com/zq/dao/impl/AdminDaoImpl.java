package com.zq.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zq.beans.Admin;
import com.zq.beans.Logtable;
import com.zq.beans.User;
import com.zq.dao.AdminDao;
import com.zq.service.UserService;
import com.zq.util.MyUtils;

public class AdminDaoImpl implements AdminDao {

	private SessionFactory sessionFactory;
	private UserService userService;
	private Transaction ts;
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Admin> checkUser(Admin admin) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		List<Admin> list = null;

		try {

			String s = "from Admin a where a.AUsername =? and a.APwd=?";
			System.out.println(s);
			System.out.println(admin.getAUsername());
			Query query = session.createQuery(s);
			query.setString(0, admin.getAUsername());
			query.setString(1, admin.getAPwd());
			list = (List<Admin>) query.list();

			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return list;
	}

	public List<List> checkLog() {
		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		List<Logtable> loglist = null;
		List<User> operlist = new ArrayList<User>();
		List<List> list = new ArrayList<List>();
		;

		try {

			String s = "from Logtable ";
			System.out.println("查找所有日志");

			Query query = session.createQuery(s);

			loglist = (List<Logtable>) query.list();
			//			
			for (Logtable log : loglist) {
				Long uid = log.getUid();
				if (uid != null) {
					User operatorobject = userService
							.findUserById(log.getUid());

					operlist.add(operatorobject);
				} else {
					operlist.add(new User());
				}

			}

			list.add(loglist);
			list.add(operlist);
			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return list;
	}

	public User findUserById(Long id) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		User user = null;
		System.out.println("jasfnalsj");
		try {
			user = (User) session.get(User.class, id);

			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return user;
	}

	public void saveLog(String operator, String type, Long operobj,
			String remark) {

		Logtable log = new Logtable();
		log.setOperator(operator);
		log.setRemark(remark);
		log.setType(type);
		log.setUid(operobj);

		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		try {
			session.save(log);

			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
	}

	public List<Admin> queryAllAdmin() {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		List<Admin> adminlist = null;

		try {

			String s = "from Admin ";
			Query query = session.createQuery(s);

			adminlist = (List<Admin>) query.list();
			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return adminlist;
	}

	public Admin findAdminById(int id) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		Admin admin = null;
		try {
			admin = (Admin) session.get(Admin.class, id);

			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return admin;
	}

	public List<List> checkLog(Logtable log) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		List<Logtable> loglist = null;
		List<User> operlist = new ArrayList<User>();
		List<List> list = new ArrayList<List>();
		;

		try {

			String s = MyUtils.pingJieLogQuery(log);
			System.out.println(s);

			Query query = session.createSQLQuery(s).addEntity(Logtable.class);

			loglist = (List<Logtable>) query.list();
			//			
			for (Logtable log1 : loglist) {
				Long uid = log1.getUid();
				if (uid != null) {
					User operatorobject = userService.findUserById(log1
							.getUid());
					System.out.println(operatorobject.getRealname() + "ddd");
					operlist.add(operatorobject);
				} else {
					operlist.add(new User());
				}
			}

			list.add(loglist);
			list.add(operlist);
			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return list;

	}

	public List<List> fenYeQueryLog(Logtable logtable, int pageNum, int pageSize) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		List<Logtable> loglist = new ArrayList<Logtable>();
		List<User> operlist = new ArrayList<User>();
		List<List> list = new ArrayList<List>();
		;

		try {

			String s = MyUtils.pingJieLogQuery(logtable);

			System.out.println("分页查看日志：当前第 " + pageNum + "页");

			Query query = session.createSQLQuery(s).addEntity(Logtable.class);
			query.setFirstResult((pageNum - 1) * pageSize);
			query.setMaxResults(pageSize);

			loglist = query.list();
			//			
			for (Logtable log : loglist) {
				System.out.println("第 " + pageNum + " 页的日志记录 ID : "
						+ log.getId());
				Long uid = log.getUid();
				if (uid != null) {
					User operatorobject = userService
							.findUserById(log.getUid());

					operlist.add(operatorobject);
				} else {
					operlist.add(new User());
				}

			}

			list.add(loglist);
			list.add(operlist);
			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return list;

	}
}
