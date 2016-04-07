package com.zq.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testTimestamp {

	public static void main(String[] args) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定义格式

		String s1 = "1993-01-19 00:00:00";
		String s2 = "1994-01-19 00:00:00";

		Timestamp t1 = Timestamp.valueOf(s1);
		Timestamp t2 = Timestamp.valueOf(s2);

		System.out.println(df.format(t1));
		System.out.println(df.format(t2));
		
		
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");// 定义格式

		
		System.out.println(df1.format(new Date()));
		
		
		

	}

}
