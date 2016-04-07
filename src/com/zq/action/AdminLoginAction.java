package com.zq.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.beans.User;
import com.zq.beans.Userlogin;
import com.zq.service.AdminService;
import com.zq.service.UserService;

public class AdminLoginAction extends ActionSupport {

	public AdminService adminService;
	public UserService userService;
	public String username;
	public String password;
	public String type;
	public int pageSize;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		String re = "error";
		pageSize = 10;

		// 判断用户类型
		if (this.getType().equals("管理员")) {

			// 实例化管理员
			Admin admin = new Admin();
			admin.setAUsername(username);
			admin.setAPwd(password);
			List<User> allUser = new ArrayList<User>();

			// 检查管理员是否合法
			List<Admin> list = adminService.checkUser(admin);

			// 管理员合法
			if (list.size() == 1) {
				Admin loadAdmin = list.get(0);

				// 获取分页显示的数据
				List<User> fenyelist = userService.fenYe(1, pageSize);

				// 保存日志
				adminService.saveLog(loadAdmin.getARealname(), "登录", null,
						"登录成功");

				// 将当前登录的管理员写入session中
				ActionContext.getContext().getSession().put("admin_login",
						loadAdmin);

				// 获取所有的用户，得到总的用户数量
				allUser = userService.findAllUser();
				int pcount = allUser.size();

				// 将需要分页显示的数据放入request
				ServletActionContext.getRequest().setAttribute("alluserlist",
						fenyelist);
				// 将分页信息放入request
				ServletActionContext.getRequest()
						.setAttribute("pcount", pcount);
				ServletActionContext.getRequest().setAttribute("pageNow", 1);
				ServletActionContext.getRequest().setAttribute("pageNowq", 1);
				ServletActionContext.getRequest().setAttribute("pageNowh", 2);

				// 判断最后一页是多少
				int lastpage;
				if (pcount % pageSize == 0) {
					lastpage = pcount / pageSize;
				} else {
					lastpage = (pcount / pageSize) + 1;
				}
				ServletActionContext.getRequest().setAttribute("lastPage",
						lastpage);
				re = "successadmin";
			} else {

			}
		} else {

			// 普通用户登录

			// 新建用户
			User user = new User();
			// 根据身份证号查找用户
			user = userService.findUserByIdNumber(username);
			// 查找密码
			String pwd = userService.findPasswordByIdUid(user.getId());
			// 检查密码
			if (pwd.equals(password)) {
				// 将当前登录的用户放入session
				ActionContext.getContext().getSession().put("user_now", user);
				// 如果密码为888888默认，跳转去改密码
				if (password.equals("888888")) {
					re = "changepwd";
				} else {
					re = "successuser";
				}

			} else {
				re = "error";
			}
		}
		return re;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
