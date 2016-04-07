package com.zq.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zq.beans.Admin;
import com.zq.beans.User;



public class PermissionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -4431977378844348269L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if(!isLogin()) {
			return "login";
		}
		return invocation.invoke();
	}
	/**
	 * 判断用户是否登录
	 * @return
	 */
	private boolean isLogin() {
		
		boolean b=false;
		String uri = ServletActionContext.getRequest().getRequestURI();
		
		
		System.out.println(uri);
		//如果用户未登录，重定向到用户登陆界面
		Admin admin  = (Admin) ActionContext.getContext().getSession().get("admin_login");
		
		//System.out.println(admin.getARealname());
		//System.out.println("inteceptor   + ");
		User user = (User) ActionContext.getContext().getSession().get("user_now");
		if(null!=admin || user!=null){
			
			b= true;
		}
		
		if(uri.equals("/RetiressFileManagement/adminLoginAction")){
			
			System.out.println(uri);
			b=true;
		}
		return b;
			
	}
}
