package com.zq.util;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.CreationHelper;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zq.beans.User;

public class ExcelBean {

	private XSSFWorkbook wb = null;

	public ExcelBean() {
		wb = new XSSFWorkbook();
	}

	public XSSFWorkbook createExcel(List list, String box[]) throws IOException {
		// 需要创建总的行数：
		List<Row> rows = new ArrayList<Row>();
		// 创建sheet
		XSSFSheet sheet = wb.createSheet("退休人员信息");
		wb.setSheetName(0, "退休人员信息");
		// 创建第一行
		Row row = sheet.createRow((short) 0);
		// 设置冻结窗口
		sheet.createFreezePane(0, 2);
		// 调用自定义函数，生成头部信息
		this.createUrl(wb, row, box.length, "查询到的退休员工信息共    " + list.size()
				+ "  人");
		// 创建第二行
		row = sheet.createRow((short) 1);
		for (int i = 0; i < box.length; i++) {
			createCell(wb, row, (short) i, box[i]);

		}
		// 创建第所有行
		for (int j = 0; j < list.size(); j++) {
			Row rowr = sheet.createRow((short) (j + 2));
			rows.add(rowr);
		}
		// 根据box内容往创建出来的行里面填写内容
		for (int i = 0; i < box.length; i++) {
			Iterator<User> it = list.iterator();
			int j = 0;
			// 判断box[i]
			if (box[i].equals("姓名")) {
				//判断数据库里面是否有内容
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getRealname());
					sheet.setColumnWidth(i,
							user.getRealname().getBytes().length * 2 * 256);
					j++;
				}

			} else if (box[i].equals("身份证号")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getIdnumber());
					sheet.setColumnWidth(i,
							user.getIdnumber().getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("性别")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user.getSex());
					sheet.setColumnWidth(i,
							user.getIdnumber().getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("出生日期")) {
				while (it.hasNext()) {
					User user = it.next();

					this.createCell(wb, rows.get(j), (short) i, user
							.getBirthday().toString());
					sheet.setColumnWidth(i, user.getBirthday().toString()
							.getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("政治面貌")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getLandscape());
					sheet.setColumnWidth(i,
							user.getLandscape().getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("民族")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getNation());
					sheet.setColumnWidth(i,
							user.getNation().getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("籍贯")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getBirthplace());
					sheet.setColumnWidth(i,
							user.getBirthplace().getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("学历")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getEducation());
					sheet.setColumnWidth(i,
							user.getEducation().getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("学位")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getDegress());
					sheet.setColumnWidth(i,
							user.getDegress().getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("健康状况")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getHealth());
					sheet.setColumnWidth(i,
							user.getHealth().getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("工作单位")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getWorkdepartment());
					String s = user.getWorkdepartment();
					if (user.getWorkdepartment() == null)
						s = "工作单位";

					sheet.setColumnWidth(i, s.getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("所属部门")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getDepartment());
					String s = user.getDepartment();
					if (s == null)
						s = "所属部门";

					sheet.setColumnWidth(i, s.getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("任何职")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getWorked());
					String s = user.getWorked();
					if (s == null)
						s = "任何职";

					sheet.setColumnWidth(i, s.getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("职称")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getProfessionaltile());
					String s = user.getProfessionaltile();
					if (s == null)
						s = "职称";

					sheet.setColumnWidth(i, s.getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("家庭住址")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getAddress());
					String s = user.getAddress();
					if (s == null)
						s = "家庭住址";

					sheet.setColumnWidth(i, s.getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("联系电话")) {
				while (it.hasNext()) {
					User user = it.next();
					this
							.createCell(wb, rows.get(j), (short) i, user
									.getPhone());
					String s = user.getPhone();
					if (s == null)
						s = "联系电话";
					sheet.setColumnWidth(i, s.getBytes().length * 2 * 256);
					j++;
				}
			} else if (box[i].equals("工作经历")) {
				while (it.hasNext()) {
					User user = it.next();
					this.createCell(wb, rows.get(j), (short) i, user
							.getExperience());
					j++;
				}
			}
			// sheet.autoSizeColumn(i,true);
		}

		return wb;
	}

	// 创建普通cell
	private void createCell(XSSFWorkbook wb, Row row, short col, String val) {
		Cell cell = row.createCell(col);
		if (val == null) {
			cell.setCellValue("无");
		} else {
			cell.setCellValue(val);
		}
		// 设置cell格式
		CellStyle cellstyle = wb.createCellStyle();
		cellstyle.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		cell.setCellStyle(cellstyle);
	}

	// // 创建头部cell
	// private void createCellHeader(XSSFWorkbook wb, Row row, short col,
	// String val) {
	//
	// Cell cell = row.createCell(col);
	// cell.setCellValue(val);
	// CellStyle cellstyle = wb.createCellStyle();
	// Font font = wb.createFont();
	// font.setFontHeightInPoints((short) 24);
	// font.setFontName("Courier New");
	// font.setItalic(true);
	// // font.setStrikeout(true);
	// cellstyle.setFont(font);
	// cellstyle.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
	// cell.setCellStyle(cellstyle);
	//
	// }

	// // 创建图片
	// private void createPicture(XSSFWorkbook wb, XSSFSheet sheet,
	// String fileString, int row1, int row2, int col1, int col2) {
	// int pictureIdx = 0;
	//
	// try {
	// InputStream is = new FileInputStream(fileString);
	// byte[] bytes = IOUtils.toByteArray(is);
	// pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
	// is.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// CreationHelper helper = wb.getCreationHelper();
	//
	// Drawing drawing = sheet.createDrawingPatriarch();
	// // 添加一个图片图形
	// ClientAnchor anchor = helper.createClientAnchor();
	// // 设置图像左上角的位置
	// // 然后调用picture的resize方法，自动关联到uzobiao
	// anchor.setCol1(col1);
	// anchor.setRow1(row1);
	// anchor.setCol2(col2);
	// anchor.setRow2(row2);
	// Picture pict = drawing.createPicture(anchor, pictureIdx);
	//
	// // 自动关联到新坐标
	// // pict.resize();
	// }
	//
	// 创建头部
	private void createUrl(XSSFWorkbook wb, Row row, int length, String val) {

		XSSFSheet sheet = wb.getSheet("退休人员信息");
		// int region = sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,
		// 18));
		CreationHelper createHelper = wb.getCreationHelper();

		// 默认，下划线，蓝色字体
		CellStyle hlink_style = wb.createCellStyle();
		Font hlink_font = wb.createFont();
		hlink_font.setUnderline(Font.U_SINGLE);
		hlink_font.setColor(IndexedColors.BLUE.index);
		hlink_font.setFontHeightInPoints((short) 16);
		hlink_font.setFontName("Courier New");

		hlink_style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		hlink_style.setFont(hlink_font);
		Cell cell = null;
		if (length % 2 == 0) {
			cell = row.createCell(length / 2 - 1);
		} else {
			cell = row.createCell(length / 2);
		}
		cell.setCellValue(val);
		cell.setCellStyle(hlink_style);

	}
	//
	// // 设置邮件格式
	// private void createEmail(XSSFWorkbook wb, Row row, short col, String val)
	// {
	// // 得到创建助手
	// CreationHelper createHelper = wb.getCreationHelper();
	// // 设置cell样式
	// CellStyle hlink_style = wb.createCellStyle();
	// // 设置字体
	// Font hlink_font = wb.createFont();
	// hlink_font.setUnderline(Font.U_SINGLE);
	// hlink_font.setColor(IndexedColors.BLUE.getIndex());
	// hlink_style.setFont(hlink_font);
	// // 创建单元格，并且复制
	// Cell cell = row.createCell(col);
	// cell.setCellValue(val);
	// // 创建邮件样式
	// Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_EMAIL);
	//
	// link.setAddress("mailto:" + val);
	// cell.setHyperlink(link);
	// cell.setCellStyle(hlink_style);
	//
	// }
}
