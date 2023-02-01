package com.sat2credit.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat2credit.pages.HomePage;
import com.sat2credit.pages.LoginPage;
import com.sat2credit.utilities.BaseClass;

public class MyFarmListVerification extends BaseClass{

	LoginPage login;
	HomePage home;
	
	@Test(priority=1)
	public void moveTOHomePage() {
		
		login=new LoginPage(driver);
		
		login.phoneNumberInput().sendKeys(phoneNumber);
		logger.info("phone number is entered.");
		
		login.passwordInput().sendKeys(password);
		logger.info("passowrd is entered.");
		
		login.loginButton().click();
		logger.info("clicked on login button.");
	}
	
	@Test(priority=2)
	public void verifyFarmsList_TC01() {
		
		home=new HomePage(driver);
		home.userNameText().isDisplayed();
		logger.info("user number is displayed.");
		
		home.getFarmsList();
		logger.info("List of farms are displayed.");
	}
	
	@Test(priority=3)
	public void verifyAllFarmsDetails_TC02() {
		
		for(int i=1; i<=home.getFarmsList(); i++) {
			
			logger.info(i+" farm verification:- ");
			
			home.farmImage(i).isDisplayed();
			logger.info("farm image is displayed.");
			
			home.farmName(i).isDisplayed();
			logger.info("farm name is displayed.");
			
			home.cropName(i).isDisplayed();
			logger.info("crop name is displayed.");
			
			home.cropAge(i).isDisplayed();
			logger.info("crop age is displayed.");
			
			home.farmUploadDate(i).isDisplayed();
			logger.info("farm uploaded date is displayed.");
			
			home.deleteButton(i).isDisplayed();
			logger.info("farm delete button is displayed.");
		}
	}
	
	@Test(priority=4)
	public void clickOnDeleteButton_TC03() {
		
		driver.navigate().refresh();
		home.deleteButton(home.getFarmIndex(readConfig.deleteFarmName(), home.getFarmsList())).click();
		logger.info("click on delete button of farm");
	}
	
	@Test(priority=5)
	public void verifySuccessAler_TC04() {
		
		home.deleteAlertMsg().isDisplayed();
		logger.info("Alert is displayed.");
	}
	
	@Test(priority=6)
	public void verifyAlertMessage_TC05() throws Exception {
		
		String message =home.deleteAlertMsg().getText();
		
		if(message.equals("Farm deleted successfully")) {
			logger.info("Success Alert message is displayed.");
			getScreenShot("verifyAlertMessage_TC05", driver);
		}
		else if(message.equals("Farm could not be deleted")) {
			logger.info("Error Alert message is displayed.");
			getScreenShot("verifyAlertMessage_TC05", driver);
			Assert.assertTrue(false);
		}
		else {
			logger.info("Deleting Alert message is displayed.");
			Thread.sleep(15);
			
			if(home.deleteAlertMsg().getText().equals("Farm deleted successfully")) {
				logger.info("Success Alert message is displayed.");
				getScreenShot("verifyAlertMessage_TC05", driver);
			}
			else if(home.deleteAlertMsg().getText().equals("Deleting farm...")) {
				logger.info("Still deleting alert message is displayed.");
				getScreenShot("verifyAlertMessage_TC05", driver);
				Assert.assertTrue(false);
			}
		}
	}
	
}
