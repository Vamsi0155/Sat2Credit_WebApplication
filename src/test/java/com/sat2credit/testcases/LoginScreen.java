package com.sat2credit.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sat2credit.pages.HomePage;
import com.sat2credit.pages.LoginPage;
import com.sat2credit.utilities.BaseClass;

public class LoginScreen extends BaseClass {

	LoginPage login;
	HomePage home;
	
	@Test(priority=1)
	public void verifyTitleText_TC001() {
		
		login =new LoginPage(driver);
		
		login.titleText();
		Assert.assertEquals(login.titleText().getText(), "Sat2Credit");
		logger.debug("title text is verified.");
	}
	
	@Test(priority=2)
	public void verifyPhoneNumberInput_TC002() {
		
		login.phoneNumberInput();
		logger.debug("phone number input field is displayed.");
	}
	
	@Test(priority=3)
	public void clickOnPhoneNumber_TC003() {
		
		login.phoneNumberInput().click();
		logger.debug("clicked on phone number input.");
	}
	
	@Test(priority=4)
	public void enterPhoneNumberInField_TC004() {
		
		login.phoneNumberInput().sendKeys(phoneNumber);
		logger.info("phone number is entered.");
	}
	
	@Test(priority=5)
	public void verifyPasswordInput_TC005() {
		
		login.passwordInput();
		logger.debug("password field is displayed.");
	}
	
	@Test(priority=6)
	public void clickOnPassword_TC006() {
		
		login.passwordInput().click();
		logger.debug("clicked on password input");
	}
	
	@Test(priority=7)
	public void enterPasswordInField_TC007() {
		
		login.passwordInput().sendKeys(password);
		logger.info("password is entered.");
	}
	
	@Test(priority=8)
	public void verifyPasswordEncryption_TC008() throws IOException {
		
		getScreenShot("verifyPasswordEncryption_TC008", driver);
		logger.info("screenshot is taken for password encryption");
	}
	
	@Test(priority=9)
	public void verifyEyeButton_TC009() {
		
		login.eyeButton();
		logger.debug("eye button is displayed.");
	}
	
	@Test(priority=10)
	public void clickOnEyeButton_TC010() {
		
		login.eyeButton().click();
		logger.debug("clicked on eye button.");
	}
	
	@Test(priority=11)
	public void verifyPasswordUnencription_TC011() throws IOException {
		
		getScreenShot("verifyPasswordUnencription_TC011", driver);
		logger.info("screenshot is taken for password un-encryption");
	}
	
	@Test(priority=12)
	public void verifyPhoneNumberWarningMessage_TC012() throws IOException {
		
		login.phoneNumberInput().clear();
		login.loginButton().click();
		logger.info("clicked on login button.");
		
		getScreenShot("verifyPhoneNumberWarningMessage_TC012", driver);
		logger.info("screenshot is taken for phone number warning message");
	}
	
	@Test(priority=13)
	public void verifyPasswordWarningMessage_TC013() throws Exception {
		
		login.phoneNumberInput().sendKeys("64626446");
		logger.info("phone number is entered.");
		
		login.passwordInput().clear();
		login.loginButton().click();
		logger.info("clicked on login button.");
		Thread.sleep(1000);
		
		getScreenShot("verifyPasswordWarningMessage_TC013", driver);
		logger.info("screenshot is taken for password warning message");
	}
	
	@Test(priority=14)
	public void verifyLoginButton_TC014() {
		
		login.loginButton();
		logger.debug("login button is displayed");
	}
	
	
	@Test(priority=15)
	public void verifyForgotPasswordLink_TC015() {
		
		login.forgotPasswordLink();
		logger.debug("forgot password button is displayed.");
	}
	
	@Test(priority=16)
	public void enterValidCredentialsAndClickLoginButton_TC016() {
		
		login.phoneNumberInput().clear();
		login.phoneNumberInput().sendKeys(phoneNumber);
		logger.info("phone number is entered.");
		
		login.passwordInput().clear();
		login.passwordInput().sendKeys(password);
		logger.info("password is entered.");
		
		login.loginButton().click();
		logger.debug("clicked on login button.");
	
		home =new HomePage(driver);
		home.userNameText();
		Assert.assertEquals(home.userNameText().getText(), "Welcome, "+phoneNumber);
	}
	
}
