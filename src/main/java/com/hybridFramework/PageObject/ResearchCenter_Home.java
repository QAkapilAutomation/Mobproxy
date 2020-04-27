package com.hybridFramework.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.hybridFramework.excelReader.Excel_reader;
import com.hybridFramework.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class ResearchCenter_Home extends TestBase {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	public static boolean status = false;

	/************ All WebElements for Home Page ***************************/

	@FindBy(xpath = "//button[@data-bind='click: expandAll']")
	public WebElement expandAll;

	@FindBy(xpath = "//button[@data-bind='click: collapseAll']")
	public WebElement collapseAll;

	@FindBy(xpath = "//*[@id='SummaryView']")
	public WebElement viewSummaryCheckBox;

	@FindBy(xpath = "//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the BCG Financial Data Portal – S&P Capital IQ Financial Data logo to view more.\"]")
	public WebElement bCGFinancialDataPortalLogo;

	@FindBy(xpath = "//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the BCG Financial Data Portal – S&P Capital IQ Financial Data logo to view more.\"]/parent::div//a[text()='Go']")
	public WebElement goToSourceLink;

	@FindBy(xpath = "//div[@class='card-slide' and @style ='']//a[@title='More Info']")
	public WebElement viewFullSourcedetailsLink;

	@FindBy(xpath = "//a[contains(@href,'/Sources?s=AllSources&c=')][text()='All Sources']")
	public WebElement allSourceslink;

	@FindBy(xpath = "//*[@id='SummaryView']")
	public WebElement viewSummaryCheckbox;

	@FindBy(xpath = "//div[@class='card-slide' and @style ='']//a[@title='Share with colleagues']")
	public WebElement shareWithCollegue_link;

	@FindBy(xpath = "//div[@class='card-slide' and @style ='']//a[@title='Copyright']/span")
	public WebElement copyRightlink;

	@FindBy(xpath = "//div[@style='min-height: 430px;']//a[@title='Remove from favorites']")
	//// div[@style='min-height: 430px;']//a[@title='Remove from favorites']
	public WebElement removeFromFavorites;

	@FindBy(xpath = "//div[@style='min-height: 430px;']//a[@title='Add to favorites']")
	public WebElement addToFavoritesButton;

	@FindBy(xpath = "//div[@class='card-slide' and @style ='']//a[@title='Training']")
	public WebElement trainingLink;

	@FindBy(xpath = "//a[@href='#EssentialSources'][contains(text(),'Essential')]")
	public WebElement essentialSourcesLink;

	@FindBy(xpath = "//div[@class='customize-page']")
	public WebElement customiseThisPageLink;

	@FindBy(xpath = "//a[@href='/News/BCG']/button[text()='View All']")
	public WebElement bCGInNewsViewAllButton;

	@FindBy(xpath = "//a[@href='/News/NewsStand?newsSource=ECTIM'][text()='View All']")
	public WebElement newsStandViewAllButton;

	@FindBy(xpath = "//a[@href='/News/Industry']/button[text()='View All']")
	public WebElement industryNewsViewAllButton;

	@FindBy(xpath = "//a[@href='/Reports/ViewAll']/button[text()='View All']")
	public WebElement industryAnalystReprotViewAllButton;

	@FindBy(xpath = "//a[text()='+Choose Your Papers']")
	public WebElement chooseYourPaperlink;

	/********************************************************************************/

	// Class Constructor
	public ResearchCenter_Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// To verify Events and Evars
	public void verifyEventsAndEvars(String sheetName) {
		Excel_reader er = new Excel_reader(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\hybridFramework\\data\\Test_Data.xlsx");
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
	
	// Click On the expand all icon
	public void clickOnExpandAll() {
		expandAll.click();
	}

	// Click On the collapse all icon
	public void clickOnCollapseAll() {
		collapseAll.click();
	}

	// Click on the view summary check box
	public void clickOnViewSummaryCheckBox() {
		viewSummaryCheckBox.click();
	}

	// Click on the BCG Financial Data Portal Logo
	public void clickOnBCGFinancialDataPortalLogo() {
		bCGFinancialDataPortalLogo.click();
	}

	// Click on the go to source link
	public void ClickOnGotosourceLink() {
		goToSourceLink.click();
	}

	// Click on the view full sources details link
	public void clickOnViewFullSourceDetailsLink() {

		viewFullSourcedetailsLink.click();
	}

	// click on the all sources lin
	public void clickOnAllSourceslink() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", allSourceslink);
	}

	// Click on the view summary check box
	public void clickOnViewSummarycheckbox() {

		viewSummaryCheckbox.click();
	}

	// Click on the share with colleges link
	public void clickOnShareWithColleguelink() {

		shareWithCollegue_link.click();
	}

	// Click on the Copyright link
	public void clickOnCopyrightlink() {

		copyRightlink.click();
	}

	// Remove from the favorites
	public void removeFromFavorites() throws Exception {

		try {
			if (removeFromFavorites.isEnabled()) {
				removeFromFavorites.click();
				Thread.sleep(100000);
			}

		} catch (Exception e) {
			System.out.println("no such element");
		}

	}

	// Click on the add to favorite button
	public void clickOnAddToFavoritesButton() {

		addToFavoritesButton.click();
	}

	// Add to add favorites button
	public void addTofavorites() throws Exception {
		try {
			
			if (addToFavoritesButton.isEnabled()) {
				addToFavoritesButton.click();
				Thread.sleep(100000);
			}

		} catch (Exception e) {

		}
	}

	// Click on the remove from favorites
	public void clickOnRemoveFromFavorites() {

		removeFromFavorites.click();
	}

	// Click on the training link
	public void clickOnTrainingLink() {

		trainingLink.click();
	}

	// Click on the essetial Sources link
	public void clickOnEssentialSourcesLink() {

		essentialSourcesLink.click();
	}

	// Click on the customise this page
	public void clickOnCustomiseThisPage_Link() {

		customiseThisPageLink.click();
	}

	// Click on the BCG In News View All button
	public void clickOnBCGInNewsViewAllButton() {

		bCGInNewsViewAllButton.click();
	}

	// Click on the news Stand View All button
	public void clickOnNewsStandViewAll_Button() {

		newsStandViewAllButton.click();
	}

	// Click On the industry news view all button
	public void clickOnIndustryNewsViewAllButton() {

		industryNewsViewAllButton.click();
	}

	// Click on the Industry analyst report view all button
	public void clickOnIndustryAnalystReprotViewAllButton() {

		industryAnalystReprotViewAllButton.click();
	}

	// Click on the choose your paper link
	public void clickOnChooseYourPaperlink() {

		chooseYourPaperlink.click();
	}

}
