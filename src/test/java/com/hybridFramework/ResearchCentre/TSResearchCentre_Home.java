package com.hybridFramework.ResearchCentre;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.hybridFramework.PageObject.ResearchCenter_Home;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;


public class TSResearchCentre_Home extends TestBase {
	private final Logger log = LoggerHelper.getLogger(TSResearchCentre_Home.class);
	String applicationGlobalReport = "bcgrcprod";

			
	/*
	 * Custom_clearProxyData(); This method will clear the proxy
	 * Custom_startProxyData(); This method will start the proxy
	 * CustomVerify_Report_Suite(); This method will verify the report suits name
	 * Custom_verifyEventTriggeredCount(); This method will verify the no of event count
	 * Custom_verifyProxyPostGetData(); This method is used to verify the
	 * event, evars and props
	 */
	
	@Test(priority = 1)
	public void TC01_RC3_1_Home_ViewOptions_Collapse() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + "Home_ViewOptions_Collapse start");
		homePage = new ResearchCenter_Home(driver);
		homePage.clickOnExpandAll();
		clearProxyData();
		startProxyData();
		homePage.clickOnCollapseAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC01");
		log.info(TSResearchCentre_Home.class.getName() + "Home_ViewOptions_Collapse end");
	}

	@Test(priority = 2)
	public void TC02_RC3_1_Home_ViewOptions_Expand() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnCollapseAll();
		clearProxyData();
		startProxyData();
		obj.clickOnExpandAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC02");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority = 3)
	public void TC03_RC01_Home_Go() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.ClickOnGotosourceLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC03");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority = 4)
	public void TC04_RC01_Home_MoreInfo() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnViewFullSourceDetailsLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC04");
		
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 5)
	public void TC05_RC3_1_Home_ViewSummary_checkbox() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnAllSourceslink();
		clearProxyData();
		startProxyData();
		obj.clickOnViewSummaryCheckBox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC05");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 6)
	public void TC06_RC3_1_Home_ShareWithCollegues() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnShareWithColleguelink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC06");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority = 7)
	public void TC07_RC3_1_Home_Copyright() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnCopyrightlink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC07");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority = 8)
	public void TC08_RC01_Home_Add_To_Favorites() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		obj.removeFromFavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnAddToFavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC08");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 9)
	public void TC09_RC01_Home_Remove_From_Favorites() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		obj.addTofavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnRemoveFromFavorites();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC09");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 10)
	public void TC10_RC01_Home_Interested_in_Training() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnTrainingLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC10");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 11)
	public void TC11_RC_Home_BCGFinancial_Card_Expand_Collapse() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnBCGFinancialDataPortalLogo();
		obj.clickOnBCGFinancialDataPortalLogo();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC11");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 12)
	public void TC12_RC3_1_Home_Essential_Sources() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnEssentialSourcesLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC12");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 13)
	public void TC13_RC3_1_Home_Customize_This_Page() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		clearProxyData();
		startProxyData();
		obj.clickOnCustomiseThisPage_Link();
		writeProxyData();
		readProxyReportSuites();
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC13");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 14)
	public void TC14_RC3_1_Home_ViewAllClick_BCGInTheNews() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		clearProxyData();
		startProxyData();
		obj.clickOnBCGInNewsViewAllButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC14");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority = 15)
	public void TC15_RC3_1_Home_ViewAllClick_NewsStand() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		clearProxyData();
		startProxyData();
		obj.clickOnNewsStandViewAll_Button();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(3, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC15");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority = 16)
	public void TC16_RC3_1_Home_ViewAllClick_IndustryNews() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		clearProxyData();
		startProxyData();
		obj.clickOnIndustryNewsViewAllButton();
		writeProxyData();
		readProxyReportSuites();
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC16");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 17)
	public void TC17_RC3_1_Home_ViewAllClick_IndustryAnalystReport() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		clearProxyData();
		startProxyData();
		obj.clickOnIndustryAnalystReprotViewAllButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC17");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority = 18)
	public void TC18_RC3_1_Home_Newsstand_ChooseYourPapers() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_Home obj = new ResearchCenter_Home(driver);
		clearProxyData();
		startProxyData();
		obj.clickOnChooseYourPaperlink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC18");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
		driver.quit();
	}

	@AfterClass(alwaysRun = true)
	public void endTest() throws Exception {
		extent.endTest(test);
		extent.flush();
		// driver.quit();
	}
}
