package com.sat2credit.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryMethod implements IRetryAnalyzer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 * 
	 * This method decides how many times a test needs to be rerun. TestNg will
	 * call this method every time a test fails. So we can put some code in here
	 * to decide when to rerun the test.
	 * 
	 * Note: This method will return true if a tests needs to be retried and
	 * false it not.
	 *
	 */
	
	 private int count = 0;
	    private static int maxTry = 2;

	    @Override
	    public boolean retry(ITestResult iTestResult) {
	        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
	            if (count < maxTry) {                            //Check if maxtry count is reached
	                count++;                                     //Increase the maxTry count by 1
	                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
	                return true;                                 //Tells TestNG to re-run the test
	            } else {
	                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
	            }
	        } 
	        else {
	            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
	        }
	        return false;
	    }
}
