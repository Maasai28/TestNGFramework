package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFuntionsTest {
	
	@Test
	 public void ExcelTest() {
	     ExcelUtility obj=new ExcelUtility();//to access our methods we have to create an object, cause our methods are not static
	     obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");
	     System.out.println(obj.getCellData(2, 3));
	     //kSystem.out.println(value);
	     
	     //retrieve all values from xcell and store into DataProvider(2D object array)
	     
	     int row = obj.getRowNum();
	     int cell = obj.getColNum(0);
	     
	     Object [][] data = new Object[row][cell];
	     
	     for (int i = 1; i<row; i++) {
	    	 for ( int y = 0; y<cell; y++) {
	    		 //retrieve value from excel
	    		 String value = obj.getCellData(i, y);
	    		 //store value inside 2D array
	    		 data[i][y] = value;
	    	 }
	     }
	     
	     System.out.println(data.length);
	}
}
