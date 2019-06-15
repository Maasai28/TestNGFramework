package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class LocationPage extends BaseClass{
	   @FindBy(xpath = "//a[@ng-click='locationCtrl.addLocation()']")
	   public WebElement add;
	    
	    @FindBy(id = "name")
	   public WebElement name;
	    
	    @FindBy(id = "city")
	   public WebElement city;
	    
	    @FindBy(id = "zipCode")
	   public WebElement zipCode;

	    @FindBy(xpath = "//div[@id='countryCode_inputfileddiv']//input")
	   public WebElement country;
	    

	    @FindBy(xpath = "//div[@id='countryCode_inputfileddiv']//ul")
	   public WebElement selectCountry;
	    
	    @FindBy(xpath="//h4[text()='Add Location']/../form/div/a[text()='Save']")
	    public WebElement saveBtn;
	    
	    public LocationPage() {
	        PageFactory.initElements(driver, this);
	    }
	}