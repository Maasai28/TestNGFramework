package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReview {

	@Test
	public void readExcel() throws Exception {
		String xlPath = "src/test/resources/testdata/OrangeHrmData.xlsx";

		FileInputStream fis = new FileInputStream(xlPath);
		// open wookbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// open specific sheet
		XSSFSheet sheet = workbook.getSheet("EmployeeDetails");
		// access value of specific cell
		String value = sheet.getRow(6).getCell(0).toString();
		System.out.println(value);
		// get number of rows and cols
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of rows and cols:" + rows + " " + cols);
		// get value from cell 1 by 1
		for (int a = 0; a < rows; a++) {
			for (int b = 0; b < cols; b++) {

				String cellVal = sheet.getRow(a).getCell(b).toString();
				System.out.print(cellVal + " ");
			}
			System.out.println();
		}

		// close workbook and stream
		workbook.close();
		fis.close();

	}
}
