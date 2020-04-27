package com.hybridFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.hybridFramework.excelReader.Excel_reader;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.LogStatus;

public class ResearchCenter_CompanyInformation extends ResearchCenter_AnalystReports{

	WebDriver driver;
	WaitHelper waitHelper;
	public static boolean status = false;
	SoftAssert softAssert = new SoftAssert();

	/************ All WebElements for Company Information ***************************/
	
	@FindBy(xpath = "//a[@href='/Info/Companies' and contains(@data-bind,'Tab')]")
	public WebElement companyInformationTab;
	
	@FindBy(xpath = "//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the BCG Financial Data Portal – S&P Capital IQ Financial Data logo to view more.\"]")
	public WebElement bcgValueScienceFinancialLogoIMG;
	
	@FindBy(xpath="//input[@id='idsk_searchQuery']")
	public WebElement searchByCompanyNameTextBlock;

	@FindBy(xpath="//div[contains(@class,'autocomplete-suggestions ')]/div[@code=\"ECODSB\"]")
	public WebElement firstSearchResult;
	
	@FindBy(xpath="//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the Bureau van Dijk - Orbis logo to view more.\"]")
	public WebElement orbisSecondCardLogo;
	
	@FindBy(xpath="//input[@id=\"idsk_transcriptSearchQuery\"]")
	public WebElement searchByCompanyNameQuickSearch;
	
	/********************************************************************************/
	
	// Class Constructor
	public ResearchCenter_CompanyInformation(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
	}
	// To verify Events and Evars
	public void verifyEventsAndEvars(String sheetName) {
		Excel_reader er = new Excel_reader(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\hybridFramework\\data\\CompanyInformationTest_Data.xlsx");
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
	// click on the company Information tab
	public void clickOnCompanyInformationTab() {
		companyInformationTab.click();
	}
	
	// click on the BCG value Science logo card
	public void clickOnBCGValueScienceFinancialLogoIMG() {
		bcgValueScienceFinancialLogoIMG.click();
	}
	
	// enter data in search filed and click on the first result
	public void enterDataInSearchClickOnFirstSearch() throws Exception {
		searchByCompanyNameTextBlock.sendKeys("terra santa");
		Thread.sleep(5000);
		firstSearchResult.click();
		
	}
	
	//  Click on the Orbis Second Logo
	public void clickOnOrbisSecondCardLogo() {
		orbisSecondCardLogo.click();
	}

}
