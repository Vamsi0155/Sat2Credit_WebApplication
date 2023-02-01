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
	public void verifyRiskLink_TC06() {
		
		Assert.assertEquals(home.riskLink().isDisplayed(), true);
		logger.info("risks link is displayed.");
	}
	
	@Test(priority=7)
	public void verifyRepayementCapacity_TC07() {
		
		Assert.assertEquals(home.repaymentCapacity().isDisplayed(), true);
		logger.info("repayment capacity link is displayed.");
	}
	
	@Test(priority=8)
	public void clickOnFarmDetailsLink_TC08() {
		
		home.farmDetailsLink().click();
		logger.info("clicked on farm details link.");
		
		scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=9)
	public void clickOnCreditScoreLink_TC09() {
		
		home.creditScoreLink().click();
		logger.info("clicked on credit score link.");
		
		scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=10)
	public void clickOnRiskLink_TC10() {
		
		home.riskLink().click();
		logger.info("clicked on risks link.");
		
		scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=11)
	public void clickRepaymentCapacityLink_TC11() {
		
		home.repaymentCapacity().click();
		logger.info("clicked on repayment capacity link.");
		
		scrollingToUp();
		logger.info("scrolled to up.");
	}
		
	@Test(priority=12)
	public void verifyFarmsListDownScroll_TC12() throws InterruptedException {
		
		home.mouseMoveTOFarms();
		logger.info("mouse is moved to farms list.");
		
		scrollingToDown();
		logger.info("farms list scrolled is verified.");
	}
	
	@Test(priority=13)
	public void verifyFarmDetailsUpScroll_TC013() throws InterruptedException {
		
		driver.navigate().refresh();
		logger.info("page is refreshed.");
		
		mouseMoveTo(home.farmID());
		logger.info("mouse is moved to farm details.");
		
		scrollingToDown();
		logger.info("farm details scrolling is verified.");
		Thread.sleep(2000);
		
		scrollingToUp();
		logger.info("scrolled to up.");
	}
	
	@Test(priority=14)
	public void verifyLogOutButton_TC14() {
		
		Assert.assertEquals(home.logOutButton().isDisplayed(), true);
		logger.info("log-out button is displayed.");
	}
	
	@Test(priority=15)
	public void clickOnLogOutButton_TC15() {
		
		home.logOutButton().click();
		logger.info("clicked on log-out button.");
	}
	
	
}
