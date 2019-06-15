package com.syntax.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLocationsTest {
	
	@Test
	public void readLocations() throws IOException {
		
		  String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
	        
	        FileInputStream fis =new FileInputStream(xlPath);
	        
	        XSSFWorkbook workbook=new XSSFWorkbook(fis);
	        
	        XSSFSheet sheet=workbook.getSheet("LocationDetails");
	        
	        int rowNum = sheet.getPhysicalNumberOfRows();
	        int colNum = sheet.getRow(0).getLastCellNum();
	        
	        for (int i=0; i<rowNum; i++) {
	            for (int j=0; j<colNum; j++) {
	                String cellValue=sheet.getRow(i).getCell(j).toString();
	                System.out.print(cellValue+"  ");
	            }
	            System.out.println();
	        }
	        workbook.close();
	        fis.close();
		
	}

}
