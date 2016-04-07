package com.zq.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestXlsx {

	 public static void main( String[] args) throws IOException {  
		 TestXlsx xlsxMain = new TestXlsx();  
		      
		    xlsxMain.readXlsx();  
		  }  
	
		  private void readXlsx() throws IOException{  
		    String fileName = "D:\\Study\\tomcat-6.0.39\\webapps\\RetiressFileManagement\\excel\\数据导入文件2014-05-15-21-42-11.xlsx";  
		     
		    File file = new File(fileName);  
	        FileInputStream fin = new FileInputStream(file);  
		    
	        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fin);
		      
		    // 循环工作表Sheet  
		    for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++){  
		      XSSFSheet xssfSheet = xssfWorkbook.getSheetAt( numSheet);  
		      if(xssfSheet == null){  
		        continue;  
		      }  
		        
		      // 循环行Row   
		      for(int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ){  
		        XSSFRow xssfRow = xssfSheet.getRow( rowNum);  
		        if(xssfRow == null){  
		          continue;  
		        }  
		          
		        // 循环列Cell     
		        for(int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++){  
		          XSSFCell xssfCell = xssfRow.getCell( cellNum);  
		          if(xssfCell == null){  
		            continue;  
		          }  
		          System.out.print("   "+getValue(xssfCell));  
		        }  
		        System.out.println();  
		      }  
		    }  
		  }  
		    
		  @SuppressWarnings("static-access")  
		  private String getValue(XSSFCell xssfCell){  
		    if(xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN){  
		      return String.valueOf( xssfCell.getBooleanCellValue());  
		    }else if(xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC){  
		      return String.valueOf( xssfCell.getNumericCellValue());  
		    }else{  
		      return String.valueOf( xssfCell.getStringCellValue());  
		    }  
		  }  

}
