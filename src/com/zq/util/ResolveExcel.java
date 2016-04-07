package com.zq.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zq.beans.User;

public class ResolveExcel {

	public static List<User> resolveExcelWorkBook(String path) {
		List<User> userlist = new ArrayList<User>();
		try {
			// 获取文件
			File file = new File(path);
			FileInputStream fin = new FileInputStream(file);
			// 获取工作对象
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fin);
			// 循环工作表Sheet
			for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
				if (xssfSheet == null) {
					continue;
				}
				int firstNum = 0;
				// find out fisrt row
				XSSFRow firstRow = xssfSheet.getRow(firstNum);
				List<String> typeRow = new ArrayList<String>();
				if (firstRow != null) {
					// 循环列Cell
					for (int cellNum = 0; cellNum <= firstRow.getLastCellNum(); cellNum++) {
						XSSFCell xssfCell = firstRow.getCell(cellNum);
						if (xssfCell == null) {
							continue;
						}
						System.out.print("   " + getValue(xssfCell));
						typeRow.add(getValue(xssfCell));
					}
				}

				System.out.println();
				// make Row except for first row recycle
				for (int rowNum = 0; rowNum < xssfSheet.getLastRowNum(); rowNum++) {
					XSSFRow xssfRow = xssfSheet.getRow(rowNum + 1);

					if (xssfRow == null) {
						continue;
					}

					User user = new User();
					// 循环列Cell
					for (int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++) {
						XSSFCell xssfCell = xssfRow.getCell(cellNum);

						if (xssfCell == null) {
							continue;
						}

						if (typeRow.get(cellNum).equals("姓名")) {
							user.setRealname(getValue(xssfCell));
						} else if (typeRow.get(cellNum).equals("身份证号")) {
							user.setIdnumber(getValue(xssfCell));
						} else if (typeRow.get(cellNum).equals("性别")) {
							user.setSex(getValue(xssfCell));
						} else if (typeRow.get(cellNum).equals("出生日期")) {

							String s[] = getValue(xssfCell).split("-");
							String sdate = s[0] + "-" + s[1] + "-" + s[2];
							Date date = Date.valueOf(sdate);
							user.setBirthday(date);
						} else if (typeRow.get(cellNum).equals("政治面貌")) {
							user.setLandscape(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("民族")) {
							user.setNation(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("籍贯")) {
							user.setBirthplace(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("学历")) {
							user.setEducation(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("学位")) {
							user.setDegress(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("健康状况")) {
							user.setHealth(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("工作单位")) {
							user.setWorkdepartment(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("所属部门")) {
							user.setDepartment(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("任何职")) {
							user.setWorked(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("职称")) {
							user.setProfessionaltile(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("联系电话")) {
							user.setPhone(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("家庭住址")) {
							user.setAddress(getValue(xssfCell));

						} else if (typeRow.get(cellNum).equals("工作经历")) {
							user.setExperience(getValue(xssfCell));
						}
						System.out.print("   " + getValue(xssfCell));
					}
					System.out.println();
					userlist.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userlist;
	}

	@SuppressWarnings("static-access")
	// 得到某个cell的值
	private static String getValue(XSSFCell xssfCell) {
		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_STRING) {
			return String.valueOf(xssfCell.getStringCellValue());
		} else {
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}

}
