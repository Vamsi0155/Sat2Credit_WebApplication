package com.sat2credit.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.sat2credit.utilities.Reports.class)
public class BaseClass {

	public ReadConfigurationFile readConfig = new ReadConfigurationFile();
	public String phoneNumber = readConfig.getPhoneNumber();
	public String password = readConfig.getPassword();
	public String url = readConfig.getURL();
	public String browserName = readConfig.getBrowserName();
	
	
	public static Logger logger;
	
	public static WebDriver driver;
	
	@BeforeClass
	public WebDriver setUp() {
		
		logger=Logger.getLogger(BaseClass.class.getName());
		PropertyConfigurator.configure("log4j.properties");
		
		/*
		 * To specify download location for downloading sample kml files.
		 */
		String downloadPath = System.getProperty("user.dir")+"\\src\\test\\resources\\download kml files";
		
		if(browserName.equals("chrome")) {
			
			HashMap<String, Object> chromePref=new HashMap<String, Object>();
			chromePref.put("profile.default_content_settings.popups", 0);
			chromePref.put("download.default_directory", downloadPath);
			      
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("prefs", chromePref);
			
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriver());
			driver =new ChromeDriver(options);
			logger.info("chrome browser is initialized.");
		}
		else if(browserName.equals("firefox")) {
			
			FirefoxProfile profile=new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.dir", downloadPath);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		                "text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml, application/kml");
			FirefoxOptions options = new FirefoxOptions();
	        options.setProfile(profile);
			
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxDriver());
			driver =new FirefoxDriver(options);
			logger.info("firefox browser is initialized.");
		}
		else if(browserName.equals("edge")) {
			
			HashMap<String, Object> edgePrefs= new HashMap<String, Object>();
			edgePrefs.put("download.default_directory", downloadPath);
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("prefs", edgePrefs);
			
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.edge.driver", readConfig.getEdgeDriver());
			driver =new EdgeDriver(options);
			logger.info("edge browser is initialized.");
		}
		
		driver.get(url);
		logger.info("url is opened.");
		
		driver.manage().window().maximize();
		logger.info("browser window is maximized.");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("driver quited..");
		//driver.quit();
	}
	
	public String getScreenShot(String testCaseName, WebDriver rdriver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		logger.info("screenshot is taken.");
		return destinationFile;
	}
	
	public String randomSurveyNumber() {
		
		String number=RandomStringUtils.randomNumeric(4);
		return number;
	}
	
	
}
