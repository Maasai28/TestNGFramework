package com.syntax.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) { //
		System.out.println("Test case started:" +result.getName());
		test=report.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed:" +result.getName());
		test.pass("Test Passed Successfully:"+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed:"+result.getName());
		test.fail("Test failed:"+result.getName());
		
		String imagePath=CommonMethods.takeScreenshot(result.getName());
		try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
			test.info("Not able to attach screenshot");
		}
	}
	
		
	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped:" +result.getName());
		test.skip("Test case skipped:" +result.getName());
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case failed:" +result.getName());
		test.fail("Test failed within success percentage:"+result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test case started:" +context.getName());
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test case finished:" +context.getName());
		
	}

}
