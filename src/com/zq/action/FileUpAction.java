package com.zq.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Admin;
import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.service.UserService;
import com.zq.util.ResolveExcel;

public class FileUpAction extends ActionSupport {

	private File excel;
	private String excelName;
	private String excelContentType;
	private String savePath;
	private UserService userService;
	private AdminService adminService;

	public String execute() throws Exception {

		FileOutputStream fos = null;
		FileInputStream fis = null;
		String filename = "数据导入文件";
		String s = "error";

		try {
			// 建立文件输出流
			System.out.println(getSavePath());

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");// 定义格式
			String sdate = df.format(new Date());
			filename = filename + "" + sdate + ".xlsx";

			fos = new FileOutputStream(getSavePath() + "\\" + filename);

			// 建立文件上传流
			fis = new FileInputStream(getExcel());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			s = "success";
		} catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
		} finally {
			close(fos, fis);
			// 上传成功
			if ("success".equals(s)) {
				s = "error";
				try {
					// 从Excel中获取用户列表
					List<User> userlist = ResolveExcel
							.resolveExcelWorkBook(getSavePath() + "\\"
									+ filename);

					System.out.println(userlist.size());
					// 保存用户信息
					List<Long> idlist = userService.saveUserInfo(userlist);
					Admin currentAdmin = (Admin) ActionContext.getContext()
							.getSession().get("admin_login");
					// 保存日志
					adminService.saveLog(currentAdmin.getARealname(), "导入Exel",
							null, filename);
					s = "success";
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("上传成功，保存数据失败");
					;
				}
			}
		}
		return s;
	}

	public File getExcel() {
		return excel;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

	public String getExcelContentType() {
		return excelContentType;
	}

	public void setExcelContentType(String excelContentType) {
		this.excelContentType = excelContentType;
	}

	// 关闭流
	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("FileInputStream关闭失败");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("FileOutputStream关闭失败");
				e.printStackTrace();
			}
		}
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
