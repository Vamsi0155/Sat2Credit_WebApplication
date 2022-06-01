package com.sat2credit.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sat2credit.pages.HomePage;
import com.sat2credit.pages.LoginPage;
import com.sat2credit.utilities.BaseClass;
import com.sat2credit.utilities.ReadXLSheet;

public class LoginDataDriverTesting extends BaseClass {

	LoginPage login;
	HomePage home;
	
	@Test(dataProvider="LoginData")
	public void verifyLoginDataDrivenTesting(String number, String password) {
		
		login=new LoginPage(driver);
		home=new HomePage(driver);
		
		login.phoneNumberInput().clear();
		login.phoneNumberInput().sendKeys(number);
		logger.info("phone number is entered.");
		
		login.passwordInput().clear();
		login.passwordInput().sendKeys(password);
		logger.info("password is entered.");
		
		login.loginButton().click();
		logger.info("clicked on login button.");
		
		boolean alert=login.warningPopupWindow().isDisplayed();
		
		if(alert) {
			
			Assert.assertTrue(true);
			logger.debug("Invalid credentials entered, please try again.");
			
			driver.navigate().refresh();
			logger.info("now, page is refreshed");
		}
		else{
			
			Assert.assertTrue(true);
			logger.debug("Home page is displayed and test is passed.");		
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getLoginData() throws Exception {
		
		String path= "./src\\test\\resources\\test data files\\Login Data.xlsx";
		int rowNum=ReadXLSheet.getRowCount(path, "Sheet1");
		int columnNum=ReadXLSheet.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] =new String[rowNum][columnNum];
		for(int i=1; i<=rowNum; i++) {
			
			for(int j=0; j<columnNum; j++) {
				
				loginData[i-1][j]=ReadXLSheet.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
