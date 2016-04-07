package com.zq.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.beans.Filetable;
import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.service.UserService;

public class DangAnAddAction extends ActionSupport {

	private UserService userService;
	private AdminService adminService;
	private String user_id;
	private String file_type;

	public String execute() throws Exception {

		String r = "error";

		User user = new User();
		// 查找用户
		user = userService.findUserById(Long.parseLong(getUser_id()));
		// 获取档案路径
		String path = "D:\\Study\\tomcat-6.0.39\\webapps\\RetiressFileManagement\\pdf\\";
		String fpath = path + "_" + user.getIdnumber() + file_type + ".pdf";

		// System.out.println(fpath);

		// 实例化档案信息
		Filetable ftable = new Filetable();
		ftable.setCategories(file_type);
		ftable.setUrl(fpath);
		ftable.setUsers(user);

		// 添加档案
		String s = userService.addFiles(ftable);
		String file_type_zn = null;

		// 判断材料类型
		if (file_type.equals("record_file")) {
			file_type_zn = "履历材料";
		} else if (file_type.equals("autobio_file")) {
			file_type_zn = "自传材料";
		} else if (file_type.equals("identify_file")) {
			file_type_zn = "鉴定考核考察材料";
		} else if (file_type.equals("degree_file")) {
			file_type_zn = "学历职称培训材料";
		} else if (file_type.equals("politicalexam_file")) {
			file_type_zn = "政审材料";
		} else if (file_type.equals("party_file")) {
			file_type_zn = "党团材料";
		} else if (file_type.equals("advanceper_file")) {
			file_type_zn = "先进个人，模范事迹材料";
		} else if (file_type.equals("punish_file")) {
			file_type_zn = "处分材料";
		} else if (file_type.equals("workaboard_file")) {
			file_type_zn = "工资任免，出国材料";
		} else if (file_type.equals("other_file")) {
			file_type_zn = "其他材料";
		}
		// 判断是否添加成功
		if (s.equals("success")) {
			// System.out.println("档案添加成功");
			Admin currentAdmin = (Admin) ActionContext.getContext()
					.getSession().get("admin_login");
			// 保存日志
			adminService.saveLog(currentAdmin.getARealname(), "添加档案", user
					.getId(), "添加档案+" + file_type_zn + "+成功");
			// 将当前用户放入request
			ServletActionContext.getRequest().setAttribute("user", user);
			r = "success";
		} else {
			System.out.println("档案添加失败 ");
		}
		return r;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String fileType) {
		file_type = fileType;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
