package com.sat2credit.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat2credit.pages.HomePage;
import com.sat2credit.pages.LoginPage;
import com.sat2credit.utilities.BaseClass;

public class HomeScreen extends BaseClass {

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
	public void verifyUser_TC01() {
		
		home=new HomePage(driver);
		home.userNameText().isDisplayed();
		logger.info("user number is displayed.");
	}
	
	@Test(priority=2)
	public void verifyPortfolioLink_TC02() {
		
		Assert.assertEquals(home.portFolioLink().isDisplayed(), true);
		logger.info("portfolio link is displayed.");
	}
	
	@Test(priority=3)
	public void verifyFarmNameText_TC03() {
		
		Assert.assertEquals(home.farmNameText().isDisplayed(), true);
		logger.info("farm name text is displayed.");
	}
	
	@Test(priority=4)
	public void verifyFarmDetailsLink_TC04() {
		
		Assert.assertEquals(home.farmDetailsLink().isDisplayed(), true);
		logger.info("farm details link is displayed.");
	}
	
	@Test(priority=5)
	public void verifyCreditScoreLink_TC05() {
		
		Assert.assertEquals(home.creditScoreLink().isDisplayed(), true);
		logger.info("credit score link is displayed.");
	}
	
	@Test(priority=6)
	public void verifyRisksLink_TC06() {
		
		Assert.assertEquals(home.risksLink().isDisplayed(), true);
		logger.info("risks link is displayed.");
	}
	
	@Test(priority=7)
	public void verifyVerificationLink_TC07() {
		
		Assert.assertEquals(home.verificationLink().isDisplayed(), true);
		logger.info("verification link is displayed.");
	}
	
	@Test(priority=8)
	public void verifyIncomeStatementLink_TC08() {
		
		Assert.assertEquals(home.incomeStatementLink().isDisplayed(), true);
		logger.info("income statement link is displayed.");
	}
	
	@Test(priority=9)
	public void verifySMMonitoringLink_TC09() {
		
		Assert.assertEquals(home.smMonitoringLink().isDisplayed(), true);
		logger.info("SM monitoring link is displayed.");
	}
	
	@Test(priority=10)
	public void verifyVHIMonitoringLink_TC10() {
		
		Assert.assertEquals(home.vhiMonitoringLink().isDisplayed(), true);
		logger.info("VHI monitoring link is displayed.");
	}
	
	@Test(priority=11)
	public void clickOnFarmDetailsLink_TC11() {
		
		home.farmDetailsLink().click();
		logger.info("clicked on farm details link.");
		
		home.scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=12)
	public void clickOnCreditScoreLink_TC12() {
		
		home.creditScoreLink().click();
		logger.info("clicked on credit score link.");
		
		home.scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=13)
	public void clickOnVerificationLink_TC13() {
		
		home.verificationLink().click();
		logger.info("clicked on verification link.");
		
		home.scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=14)
	public void clickOnRisksLink_TC14() {
		
		home.risksLink().click();
		logger.info("clicked on risks link.");
		
		home.scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=15)
	public void clickeOnIncoomeStatementLink_TC15() {
		
		home.incomeStatementLink().click();
		logger.info("clicked on income statement link");
		
		home.scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=16)
	public void clickOnSMMonitoringLink_TC16() {
		
		home.smMonitoringLink().click();
		logger.info("clicked on SM monitoring link.");
		
		home.scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=17)
	public void clickONVHIStatementLink_TC17() {
		
		home.vhiMonitoringLink().click();
		logger.info("clicked on VHI monitoring link.");
		
		driver.navigate().refresh();
		logger.info("page is refreshed.");
		
		home.scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=18)
	public void verifyFarmsListScroll_TC18() throws InterruptedException {
		
		home.mouseMoveTOFarms();
		logger.info("mouse is moved to farms list.");
		
		home.scrollingToDown();
		logger.info("farms list scrolled is verified.");
	}
	
	@Test(priority=19)
	public void verifyFarmDetailsScroll_TC019() throws InterruptedException {
		
		driver.navigate().refresh();
		logger.info("page is refreshed.");
		
		home.mouseMoveToFarmDetails();
		logger.info("mouse is moved to farm details.");
		
		home.scrollingToDown();
		logger.info("farm details scrolling is verified.");
		Thread.sleep(2000);
		
		home.scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=20)
	public void verifyLogOutButton_TC20() {
		
		Assert.assertEquals(home.logOutButton().isDisplayed(), true);
		logger.info("log-out button is displayed.");
	}
	
	@Test(priority=21)
	public void clickOnLogOutButton_TC21() {
		
		home.logOutButton().click();
		logger.info("clicked on log-out button.");
	}
	
	
}
