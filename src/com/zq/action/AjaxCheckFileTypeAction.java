package com.zq.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zq.beans.Filetable;
import com.zq.beans.User;
import com.zq.service.UserService;
import com.zq.servlet.OnlineServlet;
import com.zq.util.PathUtil;
import com.zq.util.Pdf2SwfUtil;

public class AjaxCheckFileTypeAction extends ActionSupport {

	private UserService userService;
	private String uid;
	private String file_type;

	public String execute() throws Exception {

		System.out.println(uid + "  " + file_type);
		// 得到当前用户对象
		User user = userService.findUserById(Long.parseLong(uid));

		// 得到当前用户的档案信息
		Iterator<Filetable> it = user.getFiletables().iterator();

		// 设置出错的加载文件
		String filename = "nothisfile.pdf";
		String filename2 = "nothisfile.swf";

		// 迭代档案信息
		while (it.hasNext()) {
			Filetable ft = it.next();
			String file_type_db = ft.getCategories();
			// 判断数据库里面是否有用户需要查看的档案
			if (file_type_db.equals(file_type)) {
				filename = user.getIdnumber() + "_" + file_type + ".pdf";
				filename2 = user.getIdnumber() + "_" + file_type + ".swf";
			}
		}

		System.out.println("filename==" + filename);

		// 1.装换为pdf文件
		String pdfPath = PathUtil.getWebRootDirFilePath("pdf") + "/" + filename;

		File pdfFile = new File(pdfPath);

		// pdf存在
		if (pdfFile.exists()) {

			String swfPath = PathUtil.getWebRootDirFilePath("swf") + "/"
					+ filename2;

			File swfFile = new File(swfPath);

			// 将pdf转化成swf
			boolean b = Pdf2SwfUtil.convert2SWF(pdfFile, swfFile);

			// 获取response
			HttpServletResponse response = ServletActionContext.getResponse();

			// 设置参数
			response.setContentType("text/json;charset=utf-8");
			response.setContentType("application/json-rpc");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();

			filename2 = "\"" + filename2 + "\"";
			String s = "{\"path\":" + filename2 + "}";// 把要浏览的文件地址返回到前台
			System.out.println(s);
			out.print(s);
			out.flush();
			out.close();

		} else {
			Logger.getLogger(OnlineServlet.class).warn("要转换的pdf文件不存在");
		}

		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String fileType) {
		file_type = fileType;
	}

}
