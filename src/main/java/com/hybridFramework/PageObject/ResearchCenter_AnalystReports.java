package com.hybridFramework.PageObject;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.hybridFramework.excelReader.Excel_reader;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.LogStatus;

public class ResearchCenter_AnalystReports extends ResearchCenter_NewsSources {
	public static Properties OR;
	WebDriver driver;
	WaitHelper waitHelper;
	public static boolean status = false;
	SoftAssert softAssert = new SoftAssert();
	
	/************ All WebElements for Analyst Report ***************************/
	
	@FindBy(xpath="(//div[@id=\"wrap\"]//a[contains(@href,'/Reports')])[2]")
	////li[@class='current']//a[contains(@href, '/Reports')]
	public WebElement analystReportsTab;
	
	@FindBy(xpath="//a[@href='/Sources?s=Favorites'][contains(text(),'Favorite Sources')]")
	public WebElement FavoriteSouces_Link;
	
	@FindBy(xpath="//section[@id='EssentialSourcesTab' or @class='essential']//img[@alt='Click on the Refinitiv - Thomson ONE logo to view more.']")
	public WebElement thomsonOneLogo;
	
	@FindBy(xpath="//input[@id='srch-term']")
	public WebElement searchInputAnalystReport;
	
	@FindBy(xpath="//input[@id='srch-title']")
	public WebElement wordsInTitleInputAnalystRepor;
	
	@FindBy(xpath="//button[@id='srchReports']")
	public WebElement searchButtonAnalystReport;
	
	/********************************************************************************/
	
	// Class Constructor
	public ResearchCenter_AnalystReports(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
	}
	// To verify Events and Evars 
	public void verifyEventsAndEvars(String sheetName) {
		Excel_reader er = new Excel_reader(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\hybridFramework\\data\\AnalystReportsTest_Data.xlsx");
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
	
	// Click on the analyst report tab
	public void clickOnAnalystReportsTab() {
		analystReportsTab.click();
	}
	// Click on the Thomson one logo
	public void clickOnThomsonOneLogo() {
		thomsonOneLogo.click();
	}
	//Enter data in search input
	public void enterdaataInSearchInputAnalystReport(String searchInput) {
		searchInputAnalystReport.sendKeys(searchInput);
	
	}
	// Enter data in word in title edit box
	public void enterdataInWordsInTitleInputAnalystReport(String inWordTitle) {
		wordsInTitleInputAnalystRepor.sendKeys(inWordTitle);
	}
	// Click On the search button 
	public void clickonSearchButtonAnalystReport() {
		searchButtonAnalystReport.click();
	}

}