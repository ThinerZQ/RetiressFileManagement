package com.zq.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.zq.beans.Admin;
import com.zq.beans.User;
import com.zq.service.AdminService;
import com.zq.service.UserService;
import com.zq.util.ExcelBean;
import com.zq.util.MyUtils;

public class DealExcelAction extends ActionSupport {

	public UserService userService;
	private AdminService adminService;

	private InputStream excelStream; // 输出流变量
	private String excelFileName; // 下载文件名
	private String checkbox;
	private String flag;

	public String execute() throws Exception {

		String r = "error";
		// 实例化Excel对象
		XSSFWorkbook wb;
		// 得到需要输出的字段名
		String box[] = this.getCheckbox().split(", ");
		List<User> list = new ArrayList<User>();

		if (flag.equals("all")) {
			list = userService.findAllUser();
		} else {
			list = userService.queryUser(MyUtils.getUser());
		}
		// System.out.println("list=====" + list.size());

		// 实例化生成Excel的类
		ExcelBean excelbean = new ExcelBean();
		// 调用对象方法，获取生成的Excel

		try {
			// 得到WB对象
			wb = excelbean.createExcel(list, box);

			excelFileName = "retireesInfo.xlsx"; // 设置下载的文件名
			// 获取输出流
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			wb.write(output);

			byte[] ba = output.toByteArray();
			excelStream = new ByteArrayInputStream(ba);
			output.flush();
			output.close();

			Admin currentAdmin = (Admin) ActionContext.getContext()
					.getSession().get("admin_login");
			// 保存日志
			adminService.saveLog(currentAdmin.getARealname(), "Excel下载", null,
					"下载查询到的Excel");

			r = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
