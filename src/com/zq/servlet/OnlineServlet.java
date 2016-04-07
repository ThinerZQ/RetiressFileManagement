package com.zq.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zq.beans.Filetable;
import com.zq.beans.User;
import com.zq.service.UserService;
import com.zq.service.impl.UserServiceImpl;
import com.zq.util.Doc2PdfUtil;
import com.zq.util.PathUtil;
import com.zq.util.Pdf2SwfUtil;

@SuppressWarnings("serial")
public class OnlineServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OnlineServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	/**
	 * 转换doc文件并显示到页面上
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
			String uid = request.getParameter("uid").trim();
			String file_type = request.getParameter("file_type").trim();
			
			
			System.out.println(uid+"  "+ file_type);
			
			UserService userService = new UserServiceImpl();
			User user = userService.findUserById(Long.parseLong(uid));
			
			Iterator<Filetable> it = user.getFiletables().iterator();
			
			String filename="nothisfile.pdf";
			String filename2 = "nothisfile.swf";
			while(it.hasNext()){
				Filetable ft = it.next();
				String file_type_db = ft.getCategories();
				if(file_type_db.equals(file_type)){
					filename=user.getIdnumber()+"_"+file_type+".pdf";
					filename2=user.getIdnumber()+"_"+file_type+".swf";
				}
			}
			
			System.out.println("filename=="+filename);
			
			//1.装换为pdf文件
			String pdfPath = PathUtil.getWebRootDirFilePath("pdf") + "/"+filename;
			
			File pdfFile = new File(pdfPath);


			if(pdfFile.exists()){
				
				String swfPath = PathUtil.getWebRootDirFilePath("swf") + "/"+filename2;

				File swfFile = new File(swfPath);
				boolean  bl= false;
				if(!swfFile.exists())
					Pdf2SwfUtil.convert2SWF(pdfFile, swfFile);	
				
				
		
					response.setContentType("text/json;charset=utf-8");
					response.setContentType("application/json-rpc");
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					
					
					
					
					String s = "{\"path\":"+filename2+"}";//把要浏览的文件地址返回到前台
					System.out.println(s);
					out.print(s);
					out.flush();
					out.close();
				
			}else{
				Logger.getLogger(OnlineServlet.class).warn("要转换的pdf文件不存在");
		}
	}
}
