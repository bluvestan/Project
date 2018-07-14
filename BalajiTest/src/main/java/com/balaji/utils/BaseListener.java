package com.balaji.utils;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class BaseListener extends TestListenerAdapter{
	@Override
	public void onTestStart(ITestResult tr){
		log("Test Started....");
	}
	@Override
	public void onTestSuccess(ITestResult tr){
		log("Test '"+ tr.getName()+ "' PASSED");
		log(tr.getTestClass());
		log("Priority of this method is "+ tr.getMethod().getPriority());
	}
	@Override
	public void onTestFailure(ITestResult tr){
		log("Test '"+ tr.getName()+ "' FAILED");
		log(tr.getTestClass());
		log("Priority of this method is "+ tr.getMethod().getPriority());
		CommonTestUtils.takeScreenShot(CommonTestUtils.wd);
	}
	@Override
	public void onTestSkipped(ITestResult tr){
		log("Test '"+ tr.getName()+ "' SKIPPED");
		System.out.println(".....");
	}
	private void log(String methodName){
		System.out.println(methodName);
	}
	private void log(IClass testClass){
		System.out.println(testClass);
	}
}
