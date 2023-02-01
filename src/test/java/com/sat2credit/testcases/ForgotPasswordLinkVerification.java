package com.sat2credit.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat2credit.pages.LoginPage;
import com.sat2credit.utilities.BaseClass;

public class ForgotPasswordLinkVerification extends BaseClass{

	LoginPage login;
	
	@Test(priority=1)
	public void verifyForgotPasswordLink_TC01() {
		
		login =new LoginPage(driver);
		
		login.forgotPasswordLink();
		logger.debug("forgot password button is displayed.");
	}
	
	@Test(priority=2)
	public void clickOnForgotPasswordLink_TC02() {
		
		login.forgotPasswordLink().click();
		logger.debug("clicked on Forgot password link.");
	}
	
	@Test(priority=3)
	public void verifyForgotPasswordPopUp_TC03() throws IOException {
		
		login.forgotPassowrdPopUpTitle();
		logger.info("forgot password pop-up is displayed.");
		
		getScreenShot("verifyForgotPasswordPopUp_TC03", driver);
		logger.info("screenshot is taken for password warning message");
	}
	
	@Test(priority=4)
	public void verifyForgotPasswordPopUpTitle_TC04() {
		
		Assert.assertEquals(login.forgotPassowrdPopUpTitle().getText(), "Forgot password");
		logger.info("forgot password pop-up title is verified.");
	}
	
	@Test(priority=5)
	public void verifyForgotPasswordPhoneNumInput_TC05() {
		
		login.forgotPasswordPhoneNumInput();
		logger.debug("forgot password phone number field is displayed.");
	}
	
	@Test(priority=6)
	public void verifyForgotPasswordSendButton_TC06() {
		
		login.forgotPasswordSendButton();
		logger.info("forgot password send details button is displayed.");
	}
	
	@Test(priority=7)
	public void clickOnForgotPasswordPhoneNumInput_TC07() {
		
		login.forgotPasswordPhoneNumInput().click();
		logger.debug("click on forgot password phone input field.");
	}
	
	@Test(priority=8)
	public void enterPhoneNumOfForgotPasswordField_TC08() {
		
		login.forgotPasswordPhoneNumInput().sendKeys("hello");
		logger.info("phone number is entered.");
	}
	
	@Test(priority=9)
	public void enterBlankValueAndVerifyWarningMsg_TC09() {
		
		login.forgotPasswordPhoneNumInput().clear();
		login.forgotPasswordSendButton().click();
		
		login.forgotPasswordWarningMsg();
		logger.debug("warning message is displayed.");
		
		Assert.assertEquals(login.forgotPasswordWarningMsg().getText(), "Please enter the registered phone number");
		logger.info("warning message text is verified.");
	}
	
	@Test(priority=10)
	public void enterInvalidValueANDverifyPopUpMsg_TC10() throws InterruptedException {
		
		driver.navigate().refresh();
		logger.info("login page is refreshed.");
		
		login.forgotPasswordLink().click();
		logger.info("clicked on forgot password link.");
		
		login.forgotPasswordPhoneNumInput().sendKeys("1234@#an");
		logger.info("Invalid value is entered into phone number.");
		
		login.forgotPasswordSendButton().click();
		logger.info("clicked on send details button.");
		Thread.sleep(3500);
		
		Assert.assertEquals(login.failedMsgPopUp().getText(), "Phone number not registered. Please register before Login into Sat2Credit application");
		login.failedMsgPopUpOKButton().click();
		logger.debug("failed pop-up msg is displayed & clicked on OKAY button.");
	}
	
	@Test(priority=11)
	public void enterValidValueANDverifyPopUpMsg_TC11() throws InterruptedException {
		
		driver.navigate().refresh();
		logger.info("login page is refreshed.");
		
		login.forgotPasswordLink().click();
		logger.info("clicked on forgot password link.");
		
		login.forgotPasswordPhoneNumInput().sendKeys(readConfig.forgotPhoneNum());
		logger.info("Invalid value is entered into phone number.");
		
		login.forgotPasswordSendButton().click();
		logger.info("clicked on send details button.");
		Thread.sleep(3500);
		
		Assert.assertEquals(login.successMsgPopUp().getText(), "Login details sent to the registered phone number");
		login.successMsgPopUpOKButton().click();
		logger.debug("success pop-up msg is displayed & clicked on OKAY button.");
	}
	
	
	
	
}
