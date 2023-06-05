package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utils {
	public static final int IMPLICIT_WAIT_TIME=60;
	public static final int PAGELOAD_WAIT_TIME=60;
	public static String generatetimestamp() 
	{
		Date date=new Date();
		String timestamp= date.toString().replace(":", "_").replace(" ", "_");
		return "practiseone"+timestamp+"@gmail.com";
	}
	public static Object[][] gettestdatafromexcel(String sheetname) {
		
		File excelfile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\1TestData.xlsx");
		XSSFWorkbook workbook=null;
		try {
		FileInputStream fis=new FileInputStream(excelfile);
		 workbook=new XSSFWorkbook(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("login");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[rows][cols];
		
		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				default:
					break;
				}
			}
			
			
			
		}
		return data;
		
		
		
		
	}

}
