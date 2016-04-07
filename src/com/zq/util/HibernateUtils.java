package com.zq.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class HibernateUtils {

	private static SessionFactory sf = null;
	static {
		try {
			Configuration cfg = new Configuration().configure();

			sf = cfg.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		return sf.openSession();
	}

	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
