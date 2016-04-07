package com.zq.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.zq.beans.Filetable;
import com.zq.beans.User;
import com.zq.beans.Userlogin;
import com.zq.dao.UserDao;
import com.zq.util.MyUtils;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	private Transaction ts;
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Long> saveUserInfo(List<User> list) {

		List<Long> idlist = new ArrayList<Long>();

		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		try {

			Iterator<User> it = list.iterator();
			while (it.hasNext()) {
				User user = it.next();
				Long id = (Long) session.save(user);
				idlist.add(id);
			}
			Long uid = idlist.get(0).longValue();
			Userlogin ul = new Userlogin();
			ul.setPassword("888888");
			ul.setU_id(uid);
			savePassword(ul);
			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return idlist;
	}

	public User findUserById(Long id) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		User user = null;
		System.out.println("111111111111111");
		try {
			user = (User) session.get(User.class, id);

			ts.commit();
			System.out.println(user.getFiletables().size());

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return user;
	}

	public List<User> queryUser(User user) throws ParseException {

		List<User> list = new ArrayList<User>();
		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		String sql = MyUtils.pingJie(user);
		try {
			Query query = session.createSQLQuery(sql).addEntity(User.class);

			list = query.list();

			System.out.println(list.size());

			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}

		return list;
	}

	public List<User> findAllUser() {

		List<User> allUser = new ArrayList<User>();
		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("select * from users ");
			Query query = session.createSQLQuery(sb.toString()).addEntity(
					User.class);
			allUser = query.list();
			System.out.println(allUser.size());
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return allUser;
	}

	public List<User> fenYe(int pageNum, int pageSize) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		List<User> list = null;

		try {

			String hql = "from User";
			Query query = session.createQuery(hql);
			query.setFirstResult((pageNum - 1) * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
			ts.commit();

		} catch (Exception e) {

			ts.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}

	public List<User> fenYeQuery(User user, int pageNum, int pageSize) {

		List<User> list = new ArrayList<User>();
		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		String sql = MyUtils.pingJie(user);
		try {
			Query query = session.createSQLQuery(sql).addEntity(User.class);
			query.setFirstResult((pageNum - 1) * pageSize);
			query.setMaxResults(pageSize);

			list = query.list();

			System.out.println(list.size());

			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}

		return list;
	}

	public Long updateUser(User user) {

		int i = 0;
		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			ts.commit();
			i = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return Long.parseLong(i + "");
	}

	public User findUserByIdNumber(String idnumber) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();
		User user = null;
		try {

			String hql = "from User where idnumber='" + idnumber + "'";
			user = (User) session.createQuery(hql).list().get(0);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return user;
	}

	public String findPasswordByIdUid(Long id) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		String pwd = "";
		try {

			String hql = "from Userlogin where u_id='" + id + "'";
			Userlogin userlogin = (Userlogin) session.createQuery(hql).list()
					.get(0);
			pwd = userlogin.getPassword();
			ts.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return pwd;
	}

	public String updatePassword(String uid, String pwd) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		String r = "error";

		try {

			String sql = "UPDATE userlogin SET PASSWORD='" + pwd
					+ "' WHERE u_id='" + uid + "'";
			System.out.println(sql);
			session.createSQLQuery(sql).executeUpdate();
			ts.commit();
			r = "success";

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return r;
	}

	public String addFiles(Filetable ftable) {

		session = sessionFactory.openSession();
		ts = session.beginTransaction();

		String r = "error";
		try {
			session.save(ftable);

			ts.commit();
			r = "success";

		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
		return r;
	}

	public void savePassword(Userlogin ul) {
		session.save(ul);
	}

}
