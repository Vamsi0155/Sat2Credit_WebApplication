package com.sat2credit.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
		
		//home.selectFarmFromList(readConfig.getFarmName());
		int inde =home.getFarmIndex(readConfig.getFarmName(), home.getFarmsList());
		home.farmImage(inde).click();
		logger.info("clicked on farm.");
	}
	
	@Test(priority=3)
	public void verifyFarmName_TC03() throws InterruptedException {
		
		Thread.sleep(2000);
		Assert.assertEquals(home.farmNameText().getText(), readConfig.getFarmName());
		logger.info("farm name is displayed.");
	}
	
	@Test(priority=4)
	public void verifyZoomInButton_TC04() {
		
		Assert.assertEquals(home.zoomInButton().isDisplayed(), true);
		logger.info("zoom-in button is displayed.");
	}
	
	@Test(priority=5)
	public void clickOnZoomInButton_TC05() {
		
		home.zoomInButton().click();
		logger.info("clicked on zoom-in button and working.");
	}
	
	@Test(priority=6)
	public void verifyZoomOutButton_TC06() {
		
		Assert.assertEquals(home.zoomOutButton().isDisplayed(), true);
		logger.info("zoom-out button is displayed.");
	}
	
	@Test(priority=7)
	public void clickONZoomOutButton_TC07() {
		
		home.zoomOutButton().click();
		logger.info("clicked on zoom-out button and working.");
	}
	

	
	@Test(priority=8)
	public void validateTheFarmName_TC09() {
		
		home.farmName().isDisplayed();
		logger.info("farm name is displayed.");
	}
	
	@Test(priority=9)
	public void validateCropName_TC10() {
		
		home.cropName().isDisplayed();
		logger.info("crop name is displayed.");
	}
	
	@Test(priority=10)
	public void validateCropAge_TC13() {
		
		home.cropAge().isDisplayed();
		logger.info("crop age is displayed.");
	}
	
	@Test(priority=11)
	public void validateLatitudeAndLongitude_TC12() {
		
		home.latitude().isDisplayed();
		home.longitude().isDisplayed();
		logger.info("latitude and longitude is displayed.");
	}
	
	@Test(priority=12)
	public void validateTheFarmID_TC08() {
		
		home.farmID().isDisplayed();
		logger.info("farm id is displayed.");
	}
	
	
	@Test(dependsOnMethods= {"validateTheFarmID_TC08"})
	public void verifyTheRiskEstimation_TC13() {
		
		home.riskEstimationText().isDisplayed();
		logger.info("risk estimation text is displayed.");
		
		scrollingToUp();
		home.riskLink().click();
		logger.info("clicked on risk estimation link");
	}
	
	
	@Test(dependsOnMethods= {"verifyTheRiskEstimation_TC13"})
	public void validateDroughtRiskText_TC14() {
		
		try {
			
			scrollUntilToView(home.droughtRiskText());
			home.droughtRiskText().isDisplayed();
			logger.info("drought risk text is displayed.");
		}
		catch(NoSuchElementException | TimeoutException e) {
			
			home.drErrorMsg().isDisplayed();
			logger.info("farm does n't have drought risk data.");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(dependsOnMethods={"validateDroughtRiskText_TC14"})
	public void validateDroughtRiskGraph_TC15() {
		
		home.droughtRiskGraph().isDisplayed();
		logger.info("drought risk graph is displayed.");
	}
	
	
	@Test(dependsOnMethods= {"verifyTheRiskEstimation_TC13"})
	public void validateFloodRiskText_TC16() {
		
		try {
			
			scrollUntilToView(home.floodRiskText());
			home.floodRiskText().isDisplayed();
			logger.info("flood risk text is displayed.");
		}
		catch(NoSuchElementException | TimeoutException e) {
			
			home.frErrorMsg().isDisplayed();
			logger.info("farm does n't have flood risk data.");
			Assert.assertTrue(false);
		}
	}
	
	@Test(dependsOnMethods= {"validateFloodRiskText_TC16"})
	public void validateFloodRiskGraph_TC17() {
		
		home.floodRiskGraph().isDisplayed();
		logger.info("flood risk graph is displayed.");
	}
	
	
	@Test(dependsOnMethods= {"verifyTheRiskEstimation_TC13"})
	public void validateAnnualRainFallText_TC18() {
		
		try {
			
			scrollUntilToView(home.annualRainFallText());
			home.annualRainFallText().isDisplayed();
			logger.info("Annual rainfall text displayed.");
		} catch(NoSuchElementException | TimeoutException e) {
			
			home.arfErrorMsg().isDisplayed();
			logger.info("farm does n't has annual rainfall data.");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(dependsOnMethods= {"validateAnnualRainFallText_TC18"})
	public void validateAnnualRainfallGraph_TC19() {
		
		home.annualRainFallGraph().isDisplayed();
		logger.info("Annual rainfall graph is displayed.");
	}
	
	
	@Test(dependsOnMethods= {"verifyTheRiskEstimation_TC13"})
	public void validateSMMonitoringDetails_TC20() {
		
		try {
			
			scrollUntilToView(home.smMonitoringText());
			home.smMonitoringText().isDisplayed();
			logger.info("SM monitoring monthly avg text is displayed.");
		} catch (NoSuchElementException | TimeoutException e) {
			
			home.smErrorMsg().isDisplayed();
			logger.info("farm doesn't has SM data.");
			Assert.assertTrue(false);
		}
	}
	
	@Test(dependsOnMethods= {"validateSMMonitoringDetails_TC20"})
	public void validateSMmonitoringGraph_TC21() {
		
		home.smMonitoringGraph().isDisplayed();
		logger.info("SM monitoring monthly avg graph is displayed");
	}
	
	
	@Test(dependsOnMethods= {"verifyTheRiskEstimation_TC13"})
	public void validateVHIMonitoringDetails_TC22() {
		
		try {
			
			scrollUntilToView(home.vhiMonitoringText());
			home.vhiMonitoringText().isDisplayed();
			logger.info("VHI monitoring monthly avg text is displayed.");
		} catch(NoSuchElementException | TimeoutException e) {
			
			home.vhiErrorMsg().isDisplayed();
			logger.info("farm doesn't has vhi data.");
			Assert.assertTrue(false);
		}
	}
	
	@Test(dependsOnMethods= {"validateVHIMonitoringDetails_TC22"})
	public void validateVHIMonitoringGraph_TC23() {
		
		home.vhiMonitoringGraph().isDisplayed();
		logger.info("VHI monitoring monthly avg graph is displayed.");
	}
	
	
	@Test(dependsOnMethods= {"validateTheFarmID_TC08"})
	public void verifyTheRepaymentCapacityDetails_TC24() throws InterruptedException {
		
		scrollingToUp();
		Thread.sleep(2000);
		
		home.repaymentCapacity().click();
		logger.info("clicked on repayment capacity link.");
		
		home.repaymentCapacityText().isDisplayed();
		logger.info("repayment capacity text is displayed.");
	}
	
	
	@Test(dependsOnMethods= {"verifyTheRepaymentCapacityDetails_TC24"})
	public void validateRepaymentCapacityTable_TC25() {
		
		try {
			if(!home.repaymentCapacityTableHeaders().isEmpty()) {
				
				int headSize =home.repaymentCapacityTableHeaders().size();
				if(headSize !=0 && headSize <=12) {
					
					int rows =home.repaymentCapacityTableRows().size();
					if(rows !=0) {
						logger.info("repayment capacity table data is displayed.");
					}
				}
			}
		}
		catch(NoSuchElementException | TimeoutException e) {
			
			home.rcErrorMsg().isDisplayed();
			logger.info("farm doesn't has repayment capacity data.");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(dependsOnMethods= {"validateTheFarmID_TC08"})
	public void validateCreditScoreDetails_TC26() throws InterruptedException {
		
		scrollingToUp();
		Thread.sleep(2000);
		
		home.creditScoreLink().click();
		logger.info("clicked on credit score link.");
		
		home.creditScoreText().isDisplayed();
		logger.info("credit score text is displayed.");
	}
	
	@Test(dependsOnMethods= {"validateCreditScoreDetails_TC26"})
	public void validateCreditScoreImage_TC27() {
		
		try {
			
			home.creditScoreImage().isDisplayed();
			logger.info("credit score image is displayed.");
		}
		catch (NoSuchElementException | TimeoutException e) {
			
			home.csErrorMsg().isDisplayed();
			logger.info("farm doesn't has credit score data.");
			Assert.assertTrue(false);
		}
	}	
	
	
	@Test(dependsOnMethods= {"validateCreditScoreImage_TC27"})
	public void validateCreditScorePoints_TC28() {
		
		home.creditScorePoints().isDisplayed();
		logger.info("credit score points image is displayed.");
	}

}
