package com.zq.test;

import java.io.IOException;

public class Testbackup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String cmd=null;
		cmd="D:\\Program Files\\Tencent\\QQ\\Bin\\QQ.exe";
		String k="C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump.exe ";
		String s = "cmd /k start/ mysqldump -uroot -pzhengqiang retiressfilemanagement > D:\\Study\\tomcat-6.0.39\\webapps\\RetiressFileManagement\\backup\\backup11111.sql";
		
		System.out.println(s);
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			p.destroy();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
