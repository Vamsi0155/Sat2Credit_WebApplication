package com.sat2credit.testcases;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat2credit.pages.HomePage;
import com.sat2credit.pages.LoginPage;
import com.sat2credit.utilities.BaseClass;

public class UploadKMLFile extends BaseClass {

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
	
	@Test(priority=1)
	public void verifyUploadKMLButton_TC01() {
		
		Assert.assertEquals(home.uploadKMLButton().isDisplayed(), true);
		logger.info("upload KML button is displayed.");
	}
	
	@Test(priority=2)
	public void clickOnUploadKMLButton_TC02() {
		
		home.uploadKMLButton().click();
		logger.info("clicked on upload KML button.");
		
		Assert.assertEquals(home.kmlFileUpload().isDisplayed(), true);
		logger.info("upload KML button is working.");
	}
	
	@Test(priority=3)
	public void verifySampleKMLFileButton_TC03() {
		
		Assert.assertEquals(home.downloadSampleKMLFileButton().isDisplayed(), true);
		logger.debug("download sample KML file button is displayed.");
	}
	
	@Test(priority=4)
	public void clickOnSampleKMLFileButton_TC04() throws InterruptedException {
		
		home.downloadSampleKMLFileButton().click();
		logger.info("clicked on sample kml file button.");
		Thread.sleep(6000);
		
		Assert.assertEquals(home.verifyKMLFileInFolder(), true);
		logger.debug("downloaded a sample KML file.");
	}
	
	@Test(priority=5)
	public void verifyCloseButton_TC05() {
		
		Assert.assertEquals(home.closeButton().isDisplayed(), true);
		logger.debug("close button is displayed.");
	}
	
	@Test(priority=6)
	public void clickOnCloseButton_TC06() {
		
		home.closeButton().click();
		logger.info("clicked on close button.");
		
		Assert.assertEquals(home.farmNameText().isDisplayed(), true);
		logger.debug("closed button is verified.");
	}
	
	@Test(priority=7)
	public void verifyKMLFileUpload_TC07() {
		
		home.uploadKMLButton().click();
		logger.info("agian, clicked on upload kml button.");
	
		Assert.assertEquals(home.kmlFileUpload().isDisplayed(), true);
		logger.debug("kml file upload option is displayed.");
	} 
	
	@Test(priority=8)
	public void clickOnKMLFileUpload_TC08() throws InterruptedException {
		
		home.kmlFileUpload().click();
		Thread.sleep(4000);
		logger.info("clicked on kml file upload place.");
		
	}
	
	@Test(priority=9)
	public void uploadKMLFileFromFolder_TC09() throws AWTException {
		
		StringSelection str=new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\kml files\\"+readConfig.getKMLFileName()+".kml");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		home.uploadKMLFileFromFolder();
		logger.info("kml file uploaded successfully.");
	}
	
	@Test(priority=10)
	public void verify100PercentageCompletedText_TC10() {
		
		Assert.assertEquals(home.percentageCompletedText().isDisplayed(), true);
		logger.info("100 % uploading completed.");
	}
	
	@Test(priority=11)
	public void verifyFarmNameInput_TC11() {
		
		Assert.assertEquals(home.farmNameInput().isDisplayed(), true);
		logger.info("farm name input field is displayed.");
	}
	
	@Test(priority=12)
	public void enterFarmNameInField_TC12() {
		
		home.farmNameInput().sendKeys(readConfig.getKMLFarmName());
		logger.info("farm name is entered.");
	}
	
	@Test(priority=13)
	public void verifySurveyNumberInput_TC13() {
		
		Assert.assertEquals(home.surveyNumberInput().isDisplayed(), true);
		logger.info("survey number input field is displayed.");
	}
	
	@Test(priority=14)
	public void  enterSurveyNumberInField_TC14() {
		
		home.surveyNumberInput().sendKeys(readConfig.getKMLSurveyNumber());
		logger.info("survey number is entered.");
	}
	
	@Test(priority=15)
	public void verifyStateInput_TC15() {
		
		Assert.assertEquals(home.stateInput().isDisplayed(), true);
		logger.info("state input field is displayed.");
	}
	
	@Test(priority=16)
	public void enterStateInField_TC16() {
		
		home.stateInput().sendKeys(readConfig.getKMLState());
		logger.info("state is entered.");
	}
	
	@Test(priority=17)
	public void verifyDistrictInput_TC17() {
		
		Assert.assertEquals(home.districtInput().isDisplayed(), true);
		logger.info("district input field is displayed.");
	}
	
	@Test(priority=18)
	public void enterDistrictInField_TC18() {
		
		home.districtInput().sendKeys(readConfig.getKMLDistrict());
		logger.info("district is entered.");
	}
	
	@Test(priority=19)
	public void verifyTalukInput_TC19() {
		
		Assert.assertEquals(home.talukInput().isDisplayed(), true);
		logger.info("taluk input field is displayed.");
	}
	
	@Test(priority=20)
	public void enterTalukInField_TC20() {
		
		home.talukInput().sendKeys(readConfig.getKMLTaluk());
		logger.info("taluk is entered.");
	}
	
	@Test(priority=21)
	public void verifyCropTypeDropDown_TC21() {
		
		Assert.assertEquals(home.cropTypeDropdown().isDisplayed(), true);
		logger.info("crop type drop-down is displayed.");
	}
	
	@Test(priority=22)
	public void clickOnCropTypeDropdown_TC22() {
		
		home.cropTypeDropdown().click();
		logger.info("clicked on crop type drop-down.");
	}
	
	@Test(priority=23)
	public void selectOneCropInDropdwon_TC23() {
		
		home.selectCropInDropDown().selectByVisibleText(readConfig.getKMLCropName());
		logger.info("one crop is selected in list.");
		
		Assert.assertEquals(driver.findElement(By.xpath("//option[normalize-space()='Broccoli']")).isSelected(), true);
		logger.info("selected crop type is verified.");
	}
	
	@Test(priority=24)
	public void verifySowingDateInput_TC24() {
		
		Assert.assertEquals(home.sowingDateInput().isDisplayed(), true);
		logger.info("sowing date input is displayed.");
	}
	
	@Test(priority=25)
	public void clickOnSowingDateInput_TC25() {
		
		home.sowingDateInput().sendKeys("29032022");
		logger.info("date entered...");
	}
	
	@Test(priority=26)
	public void verifySubmitButton_TC26() {
		
		Assert.assertEquals(home.submitButton().isDisplayed(), true);
		logger.info("submit button is displayed.");
	}
	
	@Test(priority=27)
	public void clickOnSubmitButton_TC27() throws InterruptedException {
		
		home.submitButton().click();
		logger.info("submit button is working.");
		Thread.sleep(2000);
	}
	
	@Test(priority=28)
	public void verifySuccessAlert_TC28() {
		
		home.acceptSuccessAlert();
		logger.info("Alert is verified.");
	}
	
	@Test(priority=28)
	public void verifyTheAddedFarm_TC28() throws IOException {
		
		home.mouseMoveTOFarms();
		logger.info("mouse is moved to farms.");
		
		Assert.assertEquals(home.verifyFarmAfterAdding(readConfig.getKMLFarmName()).isDisplayed(), true);
		logger.info("The added farm is displayed.");
		getScreenShot("verifyTheAddedFarm_TC28", driver);
	}
	
}
