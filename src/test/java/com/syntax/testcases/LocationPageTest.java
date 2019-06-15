package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LocationPage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LocationPageTest extends BaseClass	{
	
	 @Test (dataProvider = "locationData")
	    public void addLocation(String nameData, String countryData, String cityData, String zipData) {
	        //login
	        LoginPage login = new LoginPage();    

	        CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
	        CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
	        CommonMethods.click(login.loginBtn);

	        HomePage home = new HomePage();
	        //Admin tab
	        CommonMethods.click(home.Admin);
	        //Organization
	        CommonMethods.click(home.Organization);
	        //Location
	        CommonMethods.click(home.Locations);
	        //click add button
	        
	        LocationPage locations = new LocationPage();    
	        CommonMethods.click(locations.add);
	        
	        //fillout the addlocation form
	        CommonMethods.sendText(locations.name, nameData);
	        
	        CommonMethods.click(locations.country);
	        
	        CommonMethods.waitForElementBeClickable(locations.selectCountry, 20);
	        CommonMethods.selectList(locations.selectCountry, countryData);
	        //CommonMethods.sendText(locations.country, countryData);
	        CommonMethods.sendText(locations.city , cityData);
	        CommonMethods.sendText(locations.zipCode, zipData);
	        
	        CommonMethods.click(locations.saveBtn);
	        CommonMethods.takeScreenshot("06132019", nameData+"_location_data");
	        
//	        CommonMethods.waitForElementBeClickable(locations.name, 20);
//			String verifText=location..getText();
//			System.out.println(verifText);
//			Assert.assertEquals(verifText, fName+" "+lName);
	    }
	    
	    @DataProvider (name="locationData")
	    public Object[][] locationData(){
	        Object[][] data = new Object[5][4];
	            data[0][0] = "Liza";
	            data[0][1] = "Ukraine";
	            data[0][2] = "Kiev";
	            data[0][3] = "20005";
	            
	            data[1][0] = "Valeria";
	            data[1][1] = "Ukraine";
	            data[1][2] = "Kiev";
	            data[1][3] = "20005";
	            
	            data[2][0] = "Kasu";
	            data[2][1] = "Ethiopia";
	            data[2][2] = "Addis";
	            data[2][3] = "4561";
	            
	            data[3][0] = "Doug";
	            data[3][1] = "Kenya";
	            data[3][2] = "Nairobi";
	            data[3][3] = "25436";
	            
	            data[4][0] = "Ryan";
	            data[4][1] = "Korea";
	            data[4][2] = "Seoul";
	            data[4][3] = "15478";
	        
	        return data;
	    }
	}


