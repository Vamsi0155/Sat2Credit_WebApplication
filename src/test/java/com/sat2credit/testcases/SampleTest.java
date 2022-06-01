package com.sat2credit.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat2credit.pages.HomePage;
import com.sat2credit.pages.LoginPage;
import com.sat2credit.utilities.BaseClass;

public class SampleTest extends BaseClass {
	
	LoginPage login;
	HomePage home;
	
	@Test(priority=0)
	public void moveTOHomePage() {
		
		login=new LoginPage(driver);
		
		login.phoneNumberInput().sendKeys(phoneNumber);
		logger.info("phone number is entered.");
		
		login.passwordInput().sendKeys(password);
		logger.info("passowrd is entered.");
		
		login.loginButton().click();
		logger.info("clicked on login button.");
		
		home=new HomePage(driver);
		home.userNameText().isDisplayed();
		logger.info("home page is displayed.");
	}
	
	
	@Test(priority=1, enabled=false)
	public void verifyTheAddedFarm_TC28() {
		
		home.mouseMoveTOFarms();
		logger.info("mouse is moved to farms.");
		
		Assert.assertEquals(home.verifyFarmAfterAdding(readConfig.getKMLFarmName()).isDisplayed(), true);
		logger.info("The added farm is displayed.");
	}
}
