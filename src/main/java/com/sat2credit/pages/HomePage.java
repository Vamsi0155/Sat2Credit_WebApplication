package com.sat2credit.pages;

import java.io.File;
import java.time.Duration;
import java.util.List;
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
	 * To identify the home page elements here..
	 * Below some elements are commented because of the few functions are removed in the Application.
	 */
	@FindBy(xpath="//a[@id='viewName']")
	WebElement userNameTextElement;
	
	@FindBy(id="farm-name")
	WebElement farmNameTextElement;
	
	@FindBy(how=How.XPATH, using="//div[@id='upload_farm']//button[@id='upload_btn']")
	WebElement uploadKMLButtonElement;
	
	@FindBy(how=How.LINK_TEXT, using="Portfolio")
	WebElement portfolioLinkElements;
	
	@FindBy(linkText="Farm Details Verification")
	WebElement farmDetailsLinkElement;
	
	@FindBy(linkText="Credit Score")
	WebElement creditScoreLinkElement;
	
//	@FindBy(linkText="Verification")
//	WebElement verificationLinkElement;
	
	@FindBy(linkText="Risk")
	WebElement riskLinkElement;
	
//	@FindBy(linkText="Income Statement")
//	WebElement incomeStatementLinkElement;
	
//	@FindBy(linkText="SM Monitoring")
//	WebElement smMonitoringLinkElement;
	
	@FindBy(linkText="Repayment Capacity")
	WebElement repaymentCapacityLinkElement;
	
	@FindBy(xpath="//button[normalize-space()='+']")
	WebElement zoomInButtonElement;
	
	@FindBy(xpath="//button[contains(text(),'−')]")
	WebElement zoomOutButtonElement;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logOutButtonElement;
	
	
	/*
	 * To identify upload KML file elements here..
	 */
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
	 * To identify the farm details verification elements here..
	 */
	@FindBy(xpath="//span[@id='farmID']")
	WebElement farmIDElement;
	
	@FindBy(xpath="//span[@id='farmName']")
	WebElement farmNameElement;
	
	@FindBy(xpath="//span[@id='cropType']")
	WebElement cropNameElement;
	
	@FindBy(xpath="//span[@id='crop_age']")
	WebElement cropAgeElement;
	
	@FindBy(xpath="//span[@id='latitude']")
	WebElement latitudeElement;
	
	@FindBy(xpath="//span[@id='longitude']")
	WebElement lonitudeElement;
	
	@FindBy(xpath="//h1[normalize-space()='Risk Estimation']")
	WebElement ristEstimationTextElement;
	
	@FindBy(xpath="//h2[normalize-space()='Drought Risks']")
	WebElement droughtRiskTextElement;
	
	@FindBy(xpath="//div[@id='drought-row']/div[1]/div[1]/canvas[@class='chartjs-render-monitor']")
	WebElement droughtRiskGraphElement;
	
	@FindBy(id="drought-error")
	WebElement drErrorElement;
	
	@FindBy(xpath="//h2[normalize-space()='Flood Risk']")
	WebElement floodRiskTextElement;
	
	@FindBy(xpath="//div[@id='flood-row']/div[1]/div[1]/canvas[@class='chartjs-render-monitor']")
	WebElement floofRiskGraphElement;
	
	@FindBy(id="flood-error")
	WebElement frErrorElement;
	
	@FindBy(xpath="//h2[normalize-space()='Annual Rainfall']")
	WebElement annualRainfallTextElement;
	
	@FindBy(xpath="//div[@id='rainfall-row']/div[1]/div[1]/canvas[@class='chartjs-render-monitor']")
	WebElement annualRainfallGraphElement;
	
	@FindBy(id="rainfall-error")
	WebElement arErrorElement;
	
	@FindBy(xpath="//div[@id='sm-row']//h2[@class='title2']")
	WebElement smMonitoringTextElement;
	
	@FindBy(xpath="//div[@id='sm_monitering']/div[1]/div[1]/div[1]/canvas[@class='sm_monitering_image chartjs-render-monitor']")
	WebElement smMonitoringGraphElement;
	
	@FindBy(id="sm-error")
	WebElement smErrorElement;
	
	@FindBy(xpath="//div[@id='vhi-row']//h2[@class='title2']")
	WebElement vhiMonitoringTextElement;
	
	@FindBy(xpath="//div[@id='vhi_monitering']/div[1]/div[1]/div[1]/canvas[@class='vhi_monitering_image chartjs-render-monitor']")
	WebElement vhiMonitoringGraphElement;
	
	@FindBy(id="vhi-error")
	WebElement vhiErrorElement;
	
	@FindBy(xpath="//h1[normalize-space()='Repayment Capacity']")
	WebElement repaymenrCapacityTextElement;
	
	@FindBy(xpath="//table[@id='income-table']/thead/tr/th")
	List<WebElement> rcTableHeadElement;
	
	@FindBy(xpath="//table[@id='income-table']/tbody/tr")
	List<WebElement> rcTableRowElement;
	
	// //table[@id='income-table']/tbody[@id='income-table']/tr
	// heads: //table[@id='income-table']/thead/tr/th
	
	@FindBy(id="income-error")
	WebElement rcErrorElement;
	
	@FindBy(xpath="//h1[normalize-space()='Credit Score']")
	WebElement creditScoreTextElement;
	
	@FindBy(xpath="//div[@class='credit-image outer credit-container']")
	WebElement csImageElement;
	
	@FindBy(xpath="//div[@id='points']")
	WebElement csPointsElement;
	
	@FindBy(id="credit-error")
	WebElement csErrorElement;
	
	
	/*
	 * To write methods/actions for identified elements.
	 */
	public WebElement userNameText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(35));
		wait.until(ExpectedConditions.visibilityOf(userNameTextElement));
		
		userNameTextElement.isDisplayed();
		
		return userNameTextElement;
	}
	
	public WebElement farmNameText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
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
	
/*	These below methods of function was removed in the application.
 * 
 * public WebElement verificationLink() {
		
		return verificationLinkElement;
	}
	
	public boolean checkVerificationText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//h1[normalize-space()='Verification']"))));
		return ldriver.findElement(By.xpath("//h1[normalize-space()='Verification']")).isDisplayed();
	}
*/	
	public WebElement riskLink() {
		
		return riskLinkElement;
	}
	
	public boolean checkRisksText() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//h1[normalize-space()='Risks']"))));
		return ldriver.findElement(By.xpath("//h1[normalize-space()='Risks']")).isDisplayed();
	}
	
	public WebElement repaymentCapacity() {
		
		return repaymentCapacityLinkElement;
	}
	
/*	These below methods of function was removed in the application.
 * 
 * public WebElement incomeStatementLink() {
		
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
*/	
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
	
	public int getFarmsList() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(ldriver.findElements(By.id("farm-card"))));
		List<WebElement> farmList = ldriver.findElements(By.id("farm-card"));
		
		return farmList.size();
	}
	
	public int getFarmIndex(String farmName, int size) {
		// //div[@id='Farmlist']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[@class='card-title']
		int index=0;
		
		for(int i=1; i<=size; i++) {
			
			String name =ldriver.findElement(By.xpath("//div[@id='Farmlist']/div["+i+"]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[@class='card-title']")).getText();
			if(name.equalsIgnoreCase(farmName)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public WebElement farmImage(int index) {
		
		WebElement element =ldriver.findElement(By.xpath("//div[@id='Farmlist']/div["+index+"]/div[1]/div[1]/img[@class='card-img h-100']"));
		return element;
	}
	
	public WebElement farmName(int index) {
		
		WebElement element =ldriver.findElement(By.xpath("//div[@id='Farmlist']/div["+index+"]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[@class='card-title']"));
		return element;
	}
	
	public WebElement cropName(int index) {
		
		WebElement cropName =ldriver.findElement(By.xpath("//div[@id='Farmlist']/div["+index+"]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[@class='card-text']"));
		return cropName;
	}
	
	public WebElement cropAge(int index) {
		
		WebElement text = ldriver.findElement(By.xpath("//div[@id='Farmlist']/div["+index+"]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[@class='card-text']"));
		return text;
	}
	
	public WebElement farmUploadDate(int index) {
		
		WebElement text =ldriver.findElement(By.xpath("//div[@id='Farmlist']/div["+index+"]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/span[@class='text']"));
		return text;
	}
	
	public WebElement deleteButton(int index) {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//div[@id='farm-sidebar']//div["+index+"]//div[2]//div[1]//button[1]"))));
		
		WebElement element1 =ldriver.findElement(By.xpath("//div[@id='farm-sidebar']//div["+index+"]//div[2]//div[1]//button[1]"));
		return element1;
	}
	
	public WebElement deleteAlertMsg() {
		
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.id("swal2-title"))));
		
		WebElement element1 =ldriver.findElement(By.id("swal2-title"));
		return element1;
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
	 * Farm details verification methods..
	 */
	
	public WebElement farmID() {
		
		waitFewSeconds(ldriver, 15, farmIDElement);
		return farmIDElement;
	}
	
	public WebElement farmName() {
		
		return farmNameElement;
	}
	
	public WebElement cropName() {
		
		return cropNameElement;
	}
	
	public WebElement cropAge() {
		
		return cropAgeElement;
	}
	
	public WebElement latitude() {
		
		return latitudeElement;
	}
	
	public WebElement longitude() {
		
		return lonitudeElement;
	}
	
	public WebElement riskEstimationText() {
		
		waitFewSeconds(ldriver, 15, ristEstimationTextElement);
		return ristEstimationTextElement;
	}
	
	public WebElement droughtRiskText() {
		
		return droughtRiskTextElement;
	}
	
	public WebElement droughtRiskGraph() {
		
		waitFewSeconds(ldriver, 15, droughtRiskGraphElement);
		return droughtRiskGraphElement;
	}
	
	public WebElement drErrorMsg() {
		
		return drErrorElement;
	}
	
	public WebElement floodRiskText() {
		
		return floodRiskTextElement;
	}
	
	public WebElement floodRiskGraph() {
		
		waitFewSeconds(ldriver, 15, floofRiskGraphElement);
		return floofRiskGraphElement;
	}
	
	public WebElement frErrorMsg() {
		
		return frErrorElement;
	}
	
	public WebElement annualRainFallText() {
		
		return annualRainfallTextElement;
	}
	
	public WebElement annualRainFallGraph() {
		
		waitFewSeconds(ldriver, 15, annualRainfallGraphElement);
		return annualRainfallGraphElement;
	}
	
	public WebElement arfErrorMsg() {
		
		return arErrorElement;
	}
	
	public WebElement smMonitoringText() {
		
		return smMonitoringTextElement;
	}
	
	public WebElement smMonitoringGraph() {
		
		waitFewSeconds(ldriver, 15, smMonitoringGraphElement);
		return smMonitoringGraphElement;
	}
	
	public WebElement smErrorMsg() {
		
		return smErrorElement;
	}
	
	public WebElement vhiMonitoringText() {
		
		return vhiMonitoringTextElement;
	}
	
	public WebElement vhiMonitoringGraph() {
		
		waitFewSeconds(ldriver, 15, vhiMonitoringGraphElement);
		return vhiMonitoringGraphElement;
	}
	
	public WebElement vhiErrorMsg() {
		
		return vhiErrorElement;
	}
	
	public WebElement repaymentCapacityText() {
		
		return repaymenrCapacityTextElement;
	}
	
	// here validate only headers & rows only. if header has >0 then true. Also, row =!0 && row >=1 then true.
	public List<WebElement> repaymentCapacityTableHeaders() {
		
		//waitFewSeconds(ldriver, 15, rcTableHeadElement);
		return rcTableHeadElement;
	}
	
	public List<WebElement> repaymentCapacityTableRows() {
		
		//waitFewSeconds(ldriver, 15, rcTableRowElement);
		return rcTableRowElement;
	}
	
	public WebElement rcErrorMsg() {
		
		return rcErrorElement;
	}
	
	public WebElement creditScoreText() {
		
		return creditScoreTextElement;
	}
	
	public WebElement creditScoreImage() {
		
		waitFewSeconds(ldriver, 15, csImageElement);
		return csImageElement;
	}
	
	public WebElement creditScorePoints() {
		
		waitFewSeconds(ldriver, 15, csPointsElement);
		return csPointsElement;
	}
	
	public WebElement csErrorMsg() {
		
		return csErrorElement;
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
	
	
	/*
	 * Utility methods..
	 */
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
	
	public static void waitFewSeconds(WebDriver drive, int time, WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(drive, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
