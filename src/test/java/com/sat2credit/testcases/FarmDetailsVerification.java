package com.sat2credit.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat2credit.pages.HomePage;
import com.sat2credit.pages.LoginPage;
import com.sat2credit.utilities.BaseClass;

public class FarmDetailsVerification extends BaseClass {
	
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
	}
	
	@Test(priority=1)
	public void verifyUser_TC01() throws InterruptedException {
		
		home=new HomePage(driver);
		home.userNameText().isDisplayed();
		logger.info("user number is displayed.");
		Thread.sleep(6000);
	}
	
	@Test(priority=2)
	public void clickOnFarm_TC02() throws InterruptedException {
		
		home.mouseMoveTOFarms();
		logger.info("mouse is moved to farms.");
		
		home.selectFarmFromList(readConfig.getFarmName());
		logger.info("clicked on farm.");
	}
	
	@Test(priority=3)
	public void verifyFarmName_TC03() throws InterruptedException {
		
		Thread.sleep(2000);
		Assert.assertEquals(home.farmNameText().getText(), readConfig.getFarmName());
		logger.info("farm name is displayed.");
	}
	
	@Test(priority=4)
	public void verifyFarmDetails_TC04() throws Exception {
		
		home.farmDetailsLink().click();
		logger.info("clicked on farm details link.");
		Thread.sleep(2000);
		
		getScreenShot("verifyFarmDetails_TC04", driver);
		logger.info("screenshot is taken for farm details verification.");
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void verifyZoomInButton_TC05() {
		
		Assert.assertEquals(home.zoomInButton().isDisplayed(), true);
		logger.info("zoom-in button is displayed.");
	}
	
	@Test(priority=6)
	public void clickOnZoomInButton_TC06() {
		
		home.zoomInButton().click();
		logger.info("clicked on zoom-in button and working.");
	}
	
	@Test(priority=7)
	public void verifyZoomOutButton_TC07() {
		
		Assert.assertEquals(home.zoomOutButton().isDisplayed(), true);
		logger.info("zoom-out button is displayed.");
	}
	
	@Test(priority=8)
	public void clickONZoomOutButton_TC08() {
		
		home.zoomOutButton().click();
		logger.info("clicked on zoom-out button and working.");
	}
	
	@Test(priority=9)
	public void verifyCreditScoreDetails_TC09() throws Exception {
		
		home.scrollingToUp();
		logger.info("page is scrolled to up for credit score link.");
		Thread.sleep(3000);
		
		home.creditScoreLink().click();
		logger.info("clicked on credit score link.");
		Thread.sleep(3000);
		
		getScreenShot("verifyCreditScoreDetails_TC09", driver);
		logger.info("screenshot is taken for credit score details verification.");
	}
	
	@Test(priority=10)
	public void verifyRisksDetails_TC10() throws Exception {
		
		home.scrollingToUp();
		logger.info("page is scrolled to up for risks link.");
		Thread.sleep(3000);
		
		home.risksLink().click();
		logger.info("clicked on risks link.");
		Thread.sleep(3000);
		
		getScreenShot("verifyRisksDetails_TC10", driver);
		logger.info("screenshot is taken for risks details verification.");
	}
	
	@Test(priority=11)
	public void verifyVerificationDetails_TC11() throws Exception {
		
		home.scrollingToUp();
		logger.info("page is scrolled to up for verification link.");
		Thread.sleep(3000);
		
		home.verificationLink().click();
		logger.info("clicked on verification link.");
		Thread.sleep(3000);
		
		getScreenShot("verifyVerificationDetails_TC11", driver);
		logger.info("screenshot is taken for verification details verification.");
	}
	
	@Test(priority=12)
	public void verifyIncomeDetails_TC12() throws Exception {
		
		home.scrollingToUp();
		logger.info("page is scrolled to up for income link.");
		Thread.sleep(3000);
		
		home.incomeStatementLink().click();
		logger.info("clicked on income statement link.");
		Thread.sleep(3000);
		
		getScreenShot("verifyIncomeDetails_TC12", driver);
		logger.info("screenshot is taken for income details verification.");
	}
	
	@Test(priority=13)
	public void verifySMDetails_TC13() throws Exception {
		
		home.scrollingToUp();
		logger.info("page is scrolled to up for SM link.");
		Thread.sleep(3000);
		
		home.smMonitoringLink().click();
		logger.info("clicked on SM monitoring link.");
		Thread.sleep(3000);
		
		getScreenShot("verifySMDetails_TC13", driver);
		logger.info("screenshot is taken for SM details verification.");
	}
	
	@Test(priority=14)
	public void verifyVHIDetails_TC14() throws Exception {
		
		home.scrollingToUp();
		logger.info("page is scrolled to up for VHI link.");
		Thread.sleep(3000);
		
		home.vhiMonitoringLink().click();
		logger.info("clicked on VHI monitoring link.");
		Thread.sleep(3000);
		
		getScreenShot("verifyVHIDetails_TC14", driver);
		logger.info("screenshot is taken for VHI details verification.");
	}
	
}
