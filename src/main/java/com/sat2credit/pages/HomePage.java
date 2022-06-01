package com.sat2credit.pages;

import java.io.File;
import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	
	public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	/*
	 * To identify the login page elements here.
	 */
	@FindBy(xpath="//a[@id='viewName']")
	WebElement userNameTextElement;
	
	@FindBy(id="farm-name")
	WebElement farmNameTextElement;
	
	@FindBy(how=How.XPATH, using="//div[@id='upload_farm']//button[@id='upload_btn']")
	WebElement uploadKMLButtonElement;
	
	@FindBy(how=How.LINK_TEXT, using="Portfolio")
	WebElement portfolioLinkElements;
	
	@FindBy(linkText="Farm Details")
	WebElement farmDetailsLinkElement;
	
	@FindBy(linkText="Credit Score")
	WebElement creditScoreLinkElement;
	
	@FindBy(linkText="Verification")
	WebElement verificationLinkElement;
	
	@FindBy(linkText="Risks")
	WebElement risksLinkElement;
	
	@FindBy(linkText="Income Statement")
	WebElement incomeStatementLinkElement;
	
	@FindBy(linkText="SM Monitoring")
	WebElement smMonitoringLinkElement;
	
	@FindBy(linkText="VHI Monitoring")
	WebElement vhiMonitoringLinkElement;
	
	@FindBy(xpath="//button[normalize-space()='+']")
	WebElement zoomInButtonElement;
	
	@FindBy(xpath="//button[contains(text(),'−')]")
	WebElement zoomOutButtonElement;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logOutButtonElement;
	
	
	
//	@FindBy(how=How.XPATH, using="//img[@src='img/photos/Vector.png']")
	@FindBy(xpath="//p[@class='drop-zoon__paragraph']")
	WebElement kmlFileUploadElement;
	
	@FindBy(linkText="Download a Sample KML File Format here")
	WebElement downloadSampleKMLFileElement;
	
	@FindBy(xpath="//div[@id='uploadArea']//button[@id='upload_btn']")
	WebElement closeButtonElement;
	
	// after uploading kml file, the 100% completed is text is displayed.
	@FindBy(xpath="//span[@class='uploaded-file__counter']")
	WebElement percentageCompletedTextElement;
	
	@FindBy(how=How.ID, using="farm-text")
	WebElement farmNameInputElement;
	
	@FindBy(how=How.ID, using="survey-text")
	WebElement surveyNumberInputElement;
	
	@FindBy(id="state-text")
	WebElement stateInputElement;
	
	@FindBy(id="district-text")
	WebElement districtInputElement;
	
	@FindBy(id="taluk-text")
	WebElement talukInputElement;
	
	@FindBy(id="crop-select")
	WebElement cropTypeDropdownElement;
	
	@FindBy(how=How.ID, using="sow-date-pick")
	WebElement sowingDateInputElement;
	
	@FindBy(how=How.XPATH, using="//span[normalize-space()='Submit Farm']")
	WebElement submitButtonElement;
	
	
	/*
	 * To write methods/actions for identified elements.
	 */
	public WebElement userNameText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(userNameTextElement));
		
		userNameTextElement.isDisplayed();
		
		return userNameTextElement;
	}
	
	public WebElement farmNameText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(farmNameTextElement));
		
		return farmNameTextElement;
	}
	
	public WebElement uploadKMLButton() {
		
		return uploadKMLButtonElement;
	}
	
	public WebElement portFolioLink() {
		
		return portfolioLinkElements;
	}
	
	public WebElement farmDetailsLink() {
		
		return farmDetailsLinkElement;
	}
	
	public WebElement creditScoreLink() {
		
		return creditScoreLinkElement;
	}
	
	public boolean checkCreditScoreText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//h1[normalize-space()='Credit Score']"))));
		return ldriver.findElement(By.xpath("//h1[normalize-space()='Credit Score']")).isDisplayed();
	}
	
	public WebElement verificationLink() {
		
		return verificationLinkElement;
	}
	
	public boolean checkVerificationText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//h1[normalize-space()='Verification']"))));
		return ldriver.findElement(By.xpath("//h1[normalize-space()='Verification']")).isDisplayed();
	}
	
	public WebElement risksLink() {
		
		return risksLinkElement;
	}
	
	public boolean checkRisksText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//h1[normalize-space()='Risks']"))));
		return ldriver.findElement(By.xpath("//h1[normalize-space()='Risks']")).isDisplayed();
	}
	
	public WebElement incomeStatementLink() {
		
		return incomeStatementLinkElement;
	}
	
	public boolean checkIncomeStatementText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//h1[normalize-space()='Income Statement']"))));
		return ldriver.findElement(By.xpath("//h1[normalize-space()='Income Statement']")).isDisplayed();
	}
	
	public WebElement smMonitoringLink() {
		
		return smMonitoringLinkElement;
	}
	
	public boolean checkSMMonitoringText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//h1[normalize-space()='SM Monitoring']"))));
		return ldriver.findElement(By.xpath("//h1[normalize-space()='SM Monitoring']")).isDisplayed();
	}
	
	public WebElement vhiMonitoringLink() {
		
		return vhiMonitoringLinkElement;
	}
	
	public boolean checkVHIMonitoringText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//h1[normalize-space()='VHI Monitoring']"))));
		return ldriver.findElement(By.xpath("//h1[normalize-space()='VHI Monitoring']")).isDisplayed();
	}
	
	public WebElement zoomInButton() {
		
		return zoomInButtonElement;
	}
	
	public WebElement zoomOutButton() {
		
		return zoomOutButtonElement;
	}
	
	public WebElement logOutButton() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(logOutButtonElement));
		
		return logOutButtonElement;
	}
	
	public void selectFarmFromList(String farmName) throws InterruptedException {
		
		WebElement element1=ldriver.findElement(By.xpath("//a[normalize-space()='"+farmName+"']"));
		
		JavascriptExecutor js=(JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", element1);
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element1));
		
		Thread.sleep(3000);
		element1.click();
	}
	
	
	/*
	 * kml file upload methods from here..
	 */
	public WebElement downloadSampleKMLFileButton() {
		
		return downloadSampleKMLFileElement;
	}
	
	public WebElement kmlFileUpload() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(kmlFileUploadElement));
		
		return kmlFileUploadElement;
	}
	
	public void uploadKMLFileFromFolder() throws AWTException{
		
		Robot robo=new Robot();
		
		// copy the file path to clipboard.
		//StringSelection str=new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\kml files\\Medida.kml");
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		// press Contol+V for pasting
		robo.delay(250);
	        
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
     
        // release Contol+V for pasting
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);
     
        // for pressing and releasing Enter
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.delay(50);
        robo.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public boolean verifyKMLFileInFolder() {
		
		boolean value=false;
		String path= System.getProperty("user.dir")+ "\\src\\test\\resources\\download kml files\\example.kml";
		File file=new File(path);
		if(file.exists()) {
			value=true;
		}
		return value;
	}
	
	public WebElement closeButton() {
		
		return closeButtonElement;
	}
	
	public WebElement percentageCompletedText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(percentageCompletedTextElement));
		
		return percentageCompletedTextElement;
	}
	
	public WebElement farmNameInput() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(farmNameInputElement));
		
		return farmNameInputElement;
	}
	
	public WebElement surveyNumberInput() {
		
		return surveyNumberInputElement;
	}
	
	public WebElement stateInput() {
		
		return stateInputElement;
	}
	
	public WebElement districtInput() {
		
		return districtInputElement;
	}
	
	public WebElement talukInput() {
		
		return talukInputElement;
	}
	
	public WebElement cropTypeDropdown() {
		
		return cropTypeDropdownElement;
	}
	
	public Select selectCropInDropDown() {
		
		Select dropdown=new Select(cropTypeDropdownElement);
		return dropdown;
	}
	
	public WebElement sowingDateInput() {
		
		return sowingDateInputElement;
	}
	
	public WebElement submitButton() {
		
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].scrollIntoView()", submitButtonElement);
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(submitButtonElement));
		
		return submitButtonElement;
	}
	
	public void acceptSuccessAlert() {
		
		//JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		//jse.executeScript("scroll(250, 0)");
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=ldriver.switchTo().alert();
		alert.accept();
	}
	
	public WebElement verifyFarmAfterAdding(String farmName) {
		
		JavascriptExecutor js=(JavascriptExecutor) ldriver;
		
		WebElement element1=ldriver.findElement(By.xpath("//a[normalize-space()='"+farmName+"']"));
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		
		js.executeScript("arguments[0].scrollIntoView(true);", element1);
		
		wait.until(ExpectedConditions.visibilityOf(element1));
		
		return element1;
	}
	
	public void mouseMoveTOFarms() {
		
		Actions action=new Actions(ldriver);
		WebElement element=ldriver.findElement(By.xpath("(//div[@class='card'])[1]"));
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		action.moveToElement(element).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void mouseMoveToFarmDetails() throws InterruptedException {
		
		Actions action=new Actions(ldriver);
		WebElement element=ldriver.findElement(By.xpath("//span[normalize-space()='Farm ID:']"));
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
		action.moveToElement(element).perform();
		Thread.sleep(2000);
	}
	
	public void scrollingToDown() throws InterruptedException {
		
		JavascriptExecutor js=(JavascriptExecutor) ldriver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}
	
	public void scrollingToUp() {
		
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}
	
}
