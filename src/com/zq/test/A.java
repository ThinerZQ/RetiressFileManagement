package com.zq.test;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "ddd";
		String f ="\""+a.toString()+"\"";
		String s = "{\"path\":"+f+"}";//把要浏览的文件地址返回到前台
System.out.println(s);
	}

}
