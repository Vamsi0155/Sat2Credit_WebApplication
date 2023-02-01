package com.sat2credit.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	/*
	 * To identify the login page elements here.
	 */
	@FindBy(how=How.CSS, using="form[id='login'] h1[class='title']")
	WebElement sat2creditTextElement;
	
	@FindBy(how=How.XPATH, using="//form[@id='login']//input[@placeholder='Phone']")
	WebElement phoneNumberInputElement;
	
	@FindBy(id="typepass")
	WebElement passwordInputElement;
	
	@FindBy(how=How.ID, using="togglePassword")
	WebElement eyeButtonElement;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButtonElement;
	
	@FindBy(linkText="Forgot password?")
	WebElement forgotPasswordLink;
	
	// forgot password pop-up elements.
	@FindBy(id="swal2-title")
	WebElement forgotPasswordPopUpTitleElement;
	
	@FindBy(id="phoneForgot")
	WebElement phoneNumberForgotElement;
	
	@FindBy(id="swal2-validation-message")
	WebElement forgotWarningMessageElement;  // Please enter the registered phone number
	
	@FindBy(xpath="//button[normalize-space()='Send details']")
	WebElement forgotSendDetailsButtonElement;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement alertTextElement;
	
	// success pop-up message after forgot password.
	@FindBy(id="swal2-title")
	WebElement successMsgPopUpElement;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement successMsgOkButton;
	
	// failed pop-up message after forgot password.
	@FindBy(id="swal2-title")
	WebElement failedMsgPopUpElement;
		
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement failedMsgOkButton;
	
	
	/*
	 * To write methods/actions for identified elements.
	 */
	public WebElement titleText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sat2creditTextElement));
		
		sat2creditTextElement.isDisplayed();
		return sat2creditTextElement;
	}
	
	public WebElement phoneNumberInput() {
		
		phoneNumberInputElement.isDisplayed();
//		Assert.assertEquals(phoneNumberInputElement.getText(), "Phone");
		
		return phoneNumberInputElement;
	}
	
	public WebElement passwordInput() {
		
		passwordInputElement.isDisplayed();
//		Assert.assertEquals(passwordInputElement.getText(), "Password");
		
		return passwordInputElement;
	}
	
	public WebElement eyeButton() {
		
		eyeButtonElement.isDisplayed();
		
		return eyeButtonElement;
	}
	
	public WebElement loginButton() {
		
		loginButtonElement.isDisplayed();
		
		return loginButtonElement;
	}
	
	public WebElement warningPopupWindow() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(alertTextElement));
		
		return alertTextElement;
	}
	
	public WebElement forgotPasswordLink() {
		forgotPasswordLink.isDisplayed();
		return forgotPasswordLink;
	}
	
	/*
	 * Forgot password pop-up methods.
	 */
	public WebElement forgotPassowrdPopUpTitle() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(forgotPasswordPopUpTitleElement));
		
		return forgotPasswordPopUpTitleElement;
	}
	
	public WebElement forgotPasswordPhoneNumInput() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(phoneNumberForgotElement));
		
		phoneNumberForgotElement.isDisplayed();
		
		return phoneNumberForgotElement;
	}
	
	public WebElement forgotPasswordWarningMsg() {
		
		forgotWarningMessageElement.isDisplayed();
		return forgotWarningMessageElement;
	}
	
	public WebElement forgotPasswordSendButton() {
		
		forgotSendDetailsButtonElement.isDisplayed();
		return forgotSendDetailsButtonElement;
	}
	
	public WebElement successMsgPopUp() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(successMsgPopUpElement));
		
		successMsgPopUpElement.isDisplayed();
		return successMsgPopUpElement;
	}
	
	public WebElement successMsgPopUpOKButton() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(successMsgOkButton));
		
		successMsgOkButton.isDisplayed();
		return successMsgOkButton;
	}
	
	
	public WebElement failedMsgPopUp() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(failedMsgPopUpElement));
		
		failedMsgPopUpElement.isDisplayed();
		return failedMsgPopUpElement;
	}
	
	public WebElement failedMsgPopUpOKButton() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(failedMsgOkButton));
		
		failedMsgOkButton.isDisplayed();
		return failedMsgOkButton;
	}
}
