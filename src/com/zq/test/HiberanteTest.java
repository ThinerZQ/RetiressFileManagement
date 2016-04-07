package com.zq.test;


import org.hibernate.Session;

import com.zq.beans.User;
import com.zq.util.HibernateUtils;

public class HiberanteTest {

	
	public static void main(String[] args) {
		
		Session s = HibernateUtils.getSession();
		s.beginTransaction();
		
		User user = new User();
		s.load(user, 1);
		
		System.out.println(user.getRealname());
		
		

	}

}
