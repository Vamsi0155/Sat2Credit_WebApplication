package com.sat2credit.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigurationFile {

	Properties pro;
	
	public ReadConfigurationFile() {
		
		/**
		 * To specify the properties file location.
		 * To read file by using file input stream class.
		 */
		File source = new File (System.getProperty("user.dir") + "//src//test//resources//configuration files//config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(source);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPhoneNumber() {
		
		String phoneNumber = pro.getProperty("phoneNumber");
		return phoneNumber;
	}
	
	public String getPassword() {
		
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getURL() {
		
		String url = pro.getProperty("url");
		return url;
	}

	public String getBrowserName() {
		
		String browserName = pro.getProperty("browserName");
		return browserName;
	}
	
	public String getFirefoxDriver() {
		
		String firefoxPath = pro.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public String getEdgeDriver() {
		
		String edgePath= pro.getProperty("edgePath");
		return edgePath;
	}
	
	public String getChromeDriver() {
		
		String chromePath= pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getKMLFarmName() {
		
		String farmName= pro.getProperty("KMLFarmName");
		return farmName;
	}
	
	public String getKMLSurveyNumber() {
		
		String surveyNumber= pro.getProperty("KMLSurveyNumber");
		return surveyNumber;
	}
	public String getKMLState() {
	
		String state= pro.getProperty("KMLState");
		return state;
	}

	public String getKMLDistrict() {
	
		String district= pro.getProperty("KMLDistrict");
		return district;
	}

	public String getKMLTaluk() {
	
		String taluk= pro.getProperty("KMLTaluk");
		return taluk;
	}
	
	public String getKMLCropName() {
		
		String crop= pro.getProperty("KMLCropName");
		return crop;
	}

	public String getKMLFileName() {
		
		String kmlFile=pro.getProperty("KMLFileName");
		return kmlFile;
	}

	public String getFarmName() {
		
		String farmName=pro.getProperty("FarmName");
		return farmName;
	}

	public String deleteFarmName() {

		String farmName=pro.getProperty("deleteFarmName");
		return farmName;
	}

	public String forgotPhoneNum() {
		
		String number =pro.getProperty("forgotPhoneNum");
		return number;
	}
}
