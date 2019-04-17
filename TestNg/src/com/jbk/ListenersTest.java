package com.jbk;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest implements ITestListener{

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test cases finished >>::" +context.getName());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test cases startrd time>>: :" + context.getName());
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("i am onTestFailedButWithinSuccessPercentage");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("i am onTestFailture");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("i am onTestSkipped");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("I am onTestSTart");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("i am onTestSuccess");
		// TODO Auto-generated method stub
		
	}

}
