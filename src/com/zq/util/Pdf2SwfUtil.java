package com.zq.util;

import java.io.File;
import java.io.IOException;

public class Pdf2SwfUtil {

	private static String PDF2SWF_PATH = "C:/Program Files/SWFTools/pdf2swf.exe";

	public static boolean convert2SWF(String inputFile, String swfFile) {
		File pdfFile = new File(inputFile);
		File outFile = new File(swfFile);
		if (!inputFile.endsWith(".pdf")) {
			System.out.println("文件格式非PDF！");
			return false;
		}
		if (!pdfFile.exists()) {
			System.out.println("PDF文件不存在！");
			return false;
		}
		if (outFile.exists()) {
			System.out.println("SWF文件已存在！");
			return false;
		}
		//组装将PDF转化为SWF格式的CMD命令
		String command = PDF2SWF_PATH + " \"" + inputFile + "\" -o " + swfFile
				+ " -T 9 -f";
		try {
			System.out.println("开始转换文档: " + inputFile);
			Runtime.getRuntime().exec(command);
			System.out.println("成功转换为SWF文件！");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("转换文档为swf文件失败！");
			return false;
		}

	}

	// 将pdf转化成为swf
	public static boolean convert2SWF(File pdfFile, File swfFile) {
		// 文件非pdf
		if (!pdfFile.getName().endsWith(".pdf")) {
			System.out.println("文件格式非PDF！");
			return false;
		}
		if (!pdfFile.exists()) {
			System.out.println("PDF文件不存在！");
			return false;
		}
		if (swfFile.exists()) {
			System.out.println("SWF文件已存在！,更新SWF文件");

		}
		//组装将PDF转化为SWF格式的CMD命令
		String command = PDF2SWF_PATH + " \"" + pdfFile.getAbsolutePath()
				+ "\" -o " + swfFile.getAbsolutePath() + " -T 9 -f";
		try {
			// 开始转换
			System.out.println("开始转换文档: " + pdfFile.getName());
			Runtime.getRuntime().exec(command);
			System.out.println("成功转换为SWF文件！");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("转换文档为swf文件失败！");
			return false;
		}
	}

}
