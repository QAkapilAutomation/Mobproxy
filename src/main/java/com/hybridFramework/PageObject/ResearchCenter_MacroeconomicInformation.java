package com.hybridFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.hybridFramework.excelReader.Excel_reader;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.LogStatus;


public class ResearchCenter_MacroeconomicInformation extends ResearchCenter_CompanyInformation {
	WebDriver driver;
	WaitHelper waitHelper;
	public static boolean status = false;
	SoftAssert softAssert = new SoftAssert();
	
	/************ All WebElements for Company Information ***************************/

	@FindBy(xpath="//a[@href='/Info/Macroeconomics' and contains(@data-bind,'Tab')]")
	public WebElement macroeconomicInformationTab;
	
	@FindBy(xpath="//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the Economist Intelligence Unit - EIU Data Tool logo to view more.\"]")
	public WebElement theEconmistIMG;
	
	@FindBy(xpath="//section[@id='EssentialSourcesTab' or @class='essential']/div/div/div/source-card/div/div/img[@alt=\"Click on the Economist Intelligence Unit - EIU Data Tool logo to view more.\"]/parent::div//a[text()='Go']")
	public WebElement goMacro;
	/********************************************************************************/
	
	// Class Constructor
	public ResearchCenter_MacroeconomicInformation(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
	}
	
	// To verify Events and Evars 
	public void verifyEventsAndEvars(String sheetName) {
		Excel_reader er = new Excel_reader(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\hybridFramework\\data\\MacroeconomicInformationTest_Data.xlsx");
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
	// click on theMacroeconomic Information Tab
	public void clickOnMacroeconomicInformationTab() {
		macroeconomicInformationTab.click();
	}
	
	// Click on The Econmist IMG card 
	public void clickOnTheEconmistIMG() {
		theEconmistIMG.click();
	}
	// Click on the Go button on second card 
	public void clickOnTheGOMacrobutton() {
		
		goMacro.click();
	}
}
