package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {

	@Test
	public void readLocations() throws IOException {
		
		  String xlPath="src/test/resources/TestData/OrangeHrmData.xlsx";
	        
	        FileInputStream fis =new FileInputStream(xlPath);
	        
	        XSSFWorkbook wbook=new XSSFWorkbook(fis);
	        XSSFSheet sheet = wbook.getSheet("EmployeeDetails");
	        //write to excel
	        sheet.getRow(0).createCell(4).setCellValue("Result");
	        
	        sheet.getRow(0).createCell(4).setCellValue("Pass");
	        sheet.getRow(1).createCell(4).setCellValue("Fail");
	        sheet.getRow(2).createCell(4).setCellValue("Fail");
	        sheet.getRow(3).createCell(4).setCellValue("Fail");
	        sheet.getRow(4).createCell(4).setCellValue("Fail");
	        sheet.getRow(5).createCell(4).setCellValue("Pass");
	        sheet.getRow(6).createCell(4).setCellValue("Pass");
	        sheet.getRow(7).createCell(4).setCellValue("Pass");
	        sheet.getRow(8).createCell(4).setCellValue("Pass");
	        sheet.getRow(9).createCell(4).setCellValue("Pass");
	        sheet.getRow(10).createCell(4).setCellValue("Pass");
	        
	        
	        //sheet.createRow(11).createCell(0).setCellValue("Mehmet");
	        
	        //writing to excel
	        FileOutputStream fos = new FileOutputStream(xlPath);
	        wbook.write(fos);
	        //close file and stream 
	        fos.close();
	        wbook.close();
	        fis.close();
	        
	        
	        
}
}
