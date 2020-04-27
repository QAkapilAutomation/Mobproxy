package com.hybridFramework.PageObject;

import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.hybridFramework.excelReader.Excel_reader;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.LogStatus;

public class ResearchCenter_FindSources extends ResearchCenter_Home{
	public static Properties OR;

	WebDriver driver;
	WaitHelper waitHelper;
	public static boolean status = false;
	SoftAssert softAssert = new SoftAssert();

	/************ All WebElements for Find Sources Page ***************************/
	
	@FindBy(xpath = "//a[@href='/Sources' and contains(@data-bind,'Tab')]")
	public WebElement findSourcesTab;
	
	@FindBy(xpath = "//input[@id='srch-term']")
	public WebElement findSourcesSearchEditbox;
	
	@FindBy(xpath = "//*[@id='accessSourceUrl'][@class='primary source-link']")
	public WebElement goToSource_Button;
	
	@FindBy(xpath = "//*[@id='detail-container']/div[2]/div/section/div[2]/button[1]/span[contains(text(),'Remove from favorites')]")
	public WebElement removeFromFavorites_Button;
	
	@FindBy(xpath = "//*[@id='detail-container']/div[2]/div/section/div[2]/button[1]/span[contains(text(),'Add to favorites')]")
	public WebElement addToFavoritesButton;
	
	@FindBy(xpath = "//a[contains(@data-bind,'click: shareWithColleagues')]")
	public WebElement shareWithColleaguesButon;
	
	@FindBy(xpath = "//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the Bureau van Dijk - Orbis logo to view more.\"]")
	public WebElement orbisSecondCardLogo;
	
	@FindBy(xpath = "//a[@class='secondary training'][contains(@data-bind,'visible: !trainingIsDisabled(), click: viewTraining')]")
	public WebElement clickHereForTrainingLink;
	
	@FindBy(xpath = "//a[@href='#Favorites'][contains(text(),'Favorite Sources')]")
	public WebElement favouriteSourceslink;
	
	@FindBy(xpath = "//a[@href='#EssentialSources'][contains(text(),'Essential')]")
	public WebElement essentialSourcesLink;
	
	@FindBy(xpath = "//button[@id='showRight']")
	public WebElement getHelpButton;
	
	@FindBy(xpath = "//nav[@id='cbp-spmenu-s2']/ul/li[3]/strong/a")
	public WebElement assistMe;
	
	@FindBy(xpath = "//a[@data-bind='click: trackItServiceCenterCall']")
	public WebElement itServiceCenterLink;
	
	@FindBy(xpath = "//a[@data-bind='click: trackResearchCenterCall']")
	public WebElement researchCenterLink;
	
	@FindBy(xpath = "//a[contains(@href, 'mailto:research@bcg.com?body=Dear%20Research%20Center%20Team%2c%0A%0ATraining%20Request')]")
	public WebElement trainingRequestlink;
	
	@FindBy(xpath = "//nav[@id='cbp-spmenu-s2']//a[text()=\"Error Message/My access isn't working for...\"]")
	public WebElement errorMessageMyaccessisntWorkingForLink;
	
	@FindBy(xpath = "//nav[@id='cbp-spmenu-s2']//a[text()='Other training or support request']")
	public WebElement otherTrainingSupportRequest;
	
	@FindBy(xpath = "//nav[@id='cbp-spmenu-s2']//a[text()=\"How can I get started using Research Center\"]")
	public WebElement howCanIGetStartedUsingResearchCenter;
	
	@FindBy(xpath = "//nav[@id='cbp-spmenu-s2']//a[text()=\"How can I get a company transcript on Research Center\"]")
	public WebElement howCanIGetACompanyTranscriptOnResearchCenter;
	
	/********************************************************************************/
	
	// // Class Constructor
	public ResearchCenter_FindSources(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);

	}
	// To verify Events and Evars
	public void verifyEventsAndEvars(String sheetName) {
		Excel_reader er = new Excel_reader(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\hybridFramework\\data\\FindSourcesTest_Data.xlsx");
		for (int i = 2; i <= er.getRowCount(sheetName); i++) {
			String parameterName = er.getCellData(sheetName, 0, i);
			System.out.println(parameterName);
			String expectedData = er.getCellData(sheetName, 1, i);
			System.out.println(expectedData);
			boolean status = verifyProxyPostGetData(parameterName, expectedData);
			System.out.println(status);
			if (status) {
				test.log(LogStatus.PASS, "" + parameterName + " is verified");
			} else {
				test.log(LogStatus.FAIL, "" + parameterName + " is not verified");
				softAssert.assertTrue(false, parameterName + " is not verified");
			}
		}
		softAssert.assertAll();
	}
	// Click on the find sources tab
	public void clickOnFindSources_Tab() {

		findSourcesTab.click();
	}
	// click on the search edit box and enter "banking" data in edit box 
	public void clickOndSedeKeysFindSourcesSearch_Editbox() {
		findSourcesSearchEditbox.click();
		findSourcesSearchEditbox.sendKeys("banking");
	}
	// Click on the go to sources button
	public void clickOnGotosource_Button() {

		goToSource_Button.click();
	}
	// remove card from favorite if it is already selected 
	public void cardPageRemoveCardFromFavorite() {
		try {
			if (removeFromFavorites_Button.isEnabled()) {
				removeFromFavorites_Button.click();
				Thread.sleep(10000);
			}

		} catch (Exception e) {
			System.out.println("No Such Element Exception");
		}

	}
	// click on the add to favorite button
	public void clikOnAddtofavoritesButton() {

		addToFavoritesButton.click();
	}
	
	// add card to favorite if it is already selected
	public void cardPageAddCardToFavorite() {
		try {
			if (addToFavoritesButton.isDisplayed()) {
				addToFavoritesButton.click();
				Thread.sleep(10000);
			}

		} catch (Exception e) {
			System.out.println("No such Element Exception");
		}
	}
	
	// click on the remove to favorite button
	public void clickOnRemovetofavoritesButton() {

		removeFromFavorites_Button.click();
	}
	
	// Click on the share with colleagues button
	public void clickOnShareWithColleaguesButon() {

		shareWithColleaguesButon.click();
	}
	
	// click on the orbis second logo 
	public void clickOnOrbisSecondCardLogo() {

		orbisSecondCardLogo.click();
	}

	// click on click here for training link
	public void clickOnClickHereForTrainingLink() {
		clickHereForTrainingLink.click();
	}

	// Click on favourite source link
	public void clickOnFavouriteSourcesLink() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", favouriteSourceslink);
	}

	// Click on the Essentail sources link
	public void clickOnEssentialSourcesLink() {

		essentialSourcesLink.click();
	}

	// click on the Get help button
	public void clickOnGetHelpBuuton() {

		getHelpButton.click();
	}

	// Click on the assist me 
	public void clickOnAssistMe() {
		assistMe.click();
	}

	// Click on the it service center link
	public void clickOnITServiceCenterLink() {
		itServiceCenterLink.click();
	}

	// Click on the research center link here
	public void clickOnResearchCenterLink() {

		researchCenterLink.click();
	}

	// click on training link request link
	public void clickOnTrainingRequestLink() {

		trainingRequestlink.click();
	}

	// Click on the Get help errorMessageMyaccessisntWorkingForLink 
	public void clickOnErrorMessageMyaccessisntworkingForLink() {

		errorMessageMyaccessisntWorkingForLink.click();
	}

	// click on otherTrainingSupportRequest
	public void clickOnOtherTrainingSupportRequest() {
		otherTrainingSupportRequest.click();
	}

	// click on the message "howCanIGetStartedUsingResearchCenter"
	public void clickOnHowCanIgetstartedusingResearchCenter() {
		howCanIGetStartedUsingResearchCenter.click();
	}

	// click on the get help message "howCanIGetACompanyTranscriptOnResearchCenter"
	public void clickOnHowCanIGetaCompanyTranscriptOnResearchCenter() {

		howCanIGetACompanyTranscriptOnResearchCenter.click();
	}
}
