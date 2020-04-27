package com.hybridFramework.PageObject;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.hybridFramework.excelReader.Excel_reader;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.LogStatus;

public class ResearchCenter_NewsSources extends ResearchCenter_FindSources {
	public static Properties OR;

	WebDriver driver;
	WaitHelper waitHelper;
	public static boolean status = false;
	SoftAssert softAssert = new SoftAssert();
	
	/************ All WebElements for News Sources  ***************************/

	@FindBy(xpath = "//a[text()='News']")
	public WebElement newsTab;
	
	@FindBy(xpath = "//a[@href='/News' and contains(@data-bind,'Tab') and text()='News Sources']")
	public WebElement newsSourcesTab;
	
	@FindBy(xpath = "//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the Dow Jones - Factiva logo to view more.\"]")
	public WebElement dowJonesFactivaLogo;
	
	@FindBy(xpath = "//input[@id='srch-term']")
	public WebElement findSourcesSearchEditbox;
	
	@FindBy(xpath = "//input[@id='srch-words-in-title']")
	public WebElement wordsInTitleInput;
	
	@FindBy(xpath = "//button[@id='srchNews']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the Dow Jones - Factiva logo to view more.\"]/parent::div//a[text()='Go']")
	public WebElement go;
	
	@FindBy(xpath = "//div[@class='card-slide' and @style ='']//a[@title='More Info']")
	public WebElement viewFullSourceDetailsLink;
	
	@FindBy(xpath = "//a[@href='/Sources?s=Favorites'][contains(text(),'Favorite Sources')]")
	public WebElement favoriteSourcesLink;
	
	@FindBy(xpath = "//select[@id=\"srch-language\"]")
	public WebElement languageDropDown;
	
	@FindBy(xpath = "//input[@id='srch-date-from']")
	public WebElement dateFrom;
	
	@FindBy(xpath = "//input[@id='srch-date-to']")
	public WebElement dateTo;
	
	@FindBy(xpath = "(//*[@id='search-results-container']//div[@class='search-result']//a)[1]")
	public WebElement firstSearchResult;
	
	@FindBy(xpath = "//a[@href='/News/BCG' and contains(@data-bind,'Tab')]")
	public WebElement bcgInTheNewsTab;
	
	@FindBy(xpath = "//*[@id=\"search-results-container\"]/section/div[1]/a")
	public WebElement firstSearchResultNew;
	
	@FindBy(xpath = "//a[@href='/News/Industry' and contains(@data-bind,'Tab')]")
	public WebElement industryNewsTab;
	
	@FindBy(xpath = "//select[@id='dropdownPracticeArea']")
	public WebElement industryNewsDropdown;
	
	@FindBy(xpath = "//a[@href='/News/Newsstand' and contains(@data-bind,'Tab')]")
	public WebElement bcgNewsstandTab;
	
	@FindBy(xpath = "//input[@id='srch-make-default-language']")
	public WebElement makeMyDefaultLanguageCheckBox;
	
	
	/********************************************************************************/
	
	// Class Constructor
	public ResearchCenter_NewsSources(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);

	}
	// To verify Events and Evars
	public void verifyEventsAndEvars(String sheetName) {
		Excel_reader er = new Excel_reader(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\hybridFramework\\data\\NewsSourcesTest_Data.xlsx");
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
	
	// click on the news tab
	public void clickOnNewsTab() {
		newsTab.click();
	}

	// click on the news sources tab
	public void clickOnNewsSourcesTab() {

		newsSourcesTab.click();
	}
	
	// click on dow jones factival Logo
	public void clickOnDowJonesFactivaLogo() {
		dowJonesFactivaLogo.click();
	}
	
	// Search on news sources search page
	public void clickonNewsSourcesSearch() {
		findSourcesSearchEditbox.sendKeys("finance");
		wordsInTitleInput.sendKeys("data");
		searchButton.click();
	}

	// Click On the go button
	public void clickOnGO() {
		go.click();
	}
	
	// Click on the view full sources details link
	public void clickOnViewFullSourceDetails_Link() {
		viewFullSourceDetailsLink.click();
	}

	// click on the favorite sources link
	public void clickOnFavoriteSourcesLinkNewSources() {

		favoriteSourcesLink.click();
	}
	
	// enter data in find sources edit box 
	public void enter_Data_FindSourcesSearch_Editbox() {
		findSourcesSearchEditbox.sendKeys("JM Financial Asset Reconstruction Company and Reliance Industries");
	}
	// Enter data in words in title text box 
	public void enter_Data_WordsInTitle_Input() {

		wordsInTitleInput.sendKeys("Alok Ind bat for bid");
	}
	// selecting langauage dropwdown 
	public void selectLangauageDropdown() {

		Select sl = new Select(languageDropDown);
		sl.selectByValue("en");
	}
	// enter the start date 
	public void enterStartDate() {
		dateFrom.clear();
		dateFrom.sendKeys("03/27/2018");
	}
	// enter the end date 
	public void enterEndDate() {
		dateTo.clear();
		dateTo.sendKeys("06/25/2018");

	}
	
	// Click on the Search button
	public void clickOnSearchButton() {
		searchButton.click();
	}

	// click on the first search result 
	public void clickOnFirstSearchResult() {
		firstSearchResult.click();
	}
	
	// click on the Bcg in the news tab dropdown
	public void clickOnBCGInTheNewsTab() {
		bcgInTheNewsTab.click();
	}
	
	// Click on the first search result 
	public void clickOnFirstSearchResultNew() {
		firstSearchResultNew.click();
	}

	// Click on the industry news tab 
	public void clickOnIndustryNewsTab() {
		industryNewsTab.click();
	}
	
	// Select industry news dropdown and select cp- retail value
	public void selectIndustryNewsDropdown() {
		Select sl = new Select(industryNewsDropdown);
		sl.selectByValue("CP-Retail");
	}
	
	// click on the bcg newsstand tab
	public void clickOnBCGNewsstandTab() {
		bcgNewsstandTab.click();
	}
	// verify makeMyDefaultLanguage check box visibility 
	public void verifyCheckBoxVisibilty() {
		try {
			if (makeMyDefaultLanguageCheckBox.isSelected()) {
				makeMyDefaultLanguageCheckBox.click();
			
			}
		} catch (Exception e) {
			
		}
	}
	// click on the make my language check box 
	public void clickOnMakeMyDefaultLanguageCheckBox() {
		makeMyDefaultLanguageCheckBox.click();
	}

}
