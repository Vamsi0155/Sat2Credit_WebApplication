package com.sat2credit.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement alertTextElement;
	
	
	/*
	 * To write methods/actions for identified elements.
	 */
	public void titleText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sat2creditTextElement));
		
		sat2creditTextElement.isDisplayed();
		Assert.assertEquals(sat2creditTextElement.getText(), "Sat2credit");
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
	
	
}
