package com.hybridFramework.ResearchCentre;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.hybridFramework.PageObject.ResearchCenter_AnalystReports;
import com.hybridFramework.helper.Browser.BrowserHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;

public class TSResearchCenter_AnalystReports extends TestBase {
	private final Logger log = LoggerHelper.getLogger(TSResearchCenter_AnalystReports.class);
	String applicationGlobalReport = "bcgrcprod,bcgglobalprod";
	
	
	/*
	 * Custom_clearProxyData(); This method will clear the proxy
	 * Custom_startProxyData(); This merhod will start the proxy
	 * CustomVerify_Report_Suite(); This method will verify the report suits name
	 * Custom_verifyEventTriggeredCount(); This method will verify the no of event
	 * count Custom_verifyProxyPostGetData(); This method is used to verify the
	 * event, evars and props
	 */
	

	@Test(priority = 77)
	public void TC77_RC01_AnalystReports_AddToFavorites() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		obj.removeFromFavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnAddToFavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC77");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 78)
	public void TC78_RC01_AnalystReports_Remove_From_Favorites() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		obj.addTofavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnRemoveFromFavorites();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC78");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 79)
	public void TC79_RC01_AnalystReports_Go() throws Exception {
		// This test case will run on the ie browser.
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnGotosource_Button();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC79");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 80)
	public void TC80_RC25_26_30_Analyst_Reports_Search() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		String searchInput = "investment";
		String inWordTitle = "plans";
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		clearProxyData();
		startProxyData();
		obj.enterdaataInSearchInputAnalystReport(searchInput);
		obj.enterdataInWordsInTitleInputAnalystReport(inWordTitle);
		obj.clickonSearchButtonAnalystReport();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC80");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 81)
	public void TC81_RC01_Analyst_Reports_InterestedinTraining() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnTrainingLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC81");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 82)
	public void TC82_RC01_Analyst_Reports_MoreInfo() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnViewFullSourceDetailsLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC82");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 83)
	public void TC83_RC3_1_Analyst_Reports_ShareWithCollegues() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnShareWithColleguelink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC83");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 84)
	public void TC84_RC19_Analyst_Reports_SourcePage_Go() throws Exception {
		// This Test Case will execute on Ie Browser
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnGotosource_Button();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC84");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 85)
	public void TC85_RC10_Analyst_Reports_SourcePage_AddtoFavorite() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		obj.clickOnViewFullSourceDetailsLink();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		rcWaitForPageLoad();
		obj.cardPageRemoveCardFromFavorite();
		clearProxyData();
		startProxyData();
		obj.clikOnAddtofavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		// String url=Custom_readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC85");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 86)
	public void TC86_RC13_Analyst_Reports_Source_Page_Remove_From_Favorite() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		obj.clickOnViewFullSourceDetailsLink();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		rcWaitForPageLoad();
		obj.cardPageAddCardToFavorite();
		clearProxyData();
		startProxyData();
		obj.clickOnRemovetofavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC86");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 87)
	public void TC87_RC16_Analyst_Reports_Source_Page_ShareWithCollegues() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		obj.clickOnViewFullSourceDetailsLink();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnShareWithColleaguesButon();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC87");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 88)
	public void TC88_RC22_Analyst_Reports_Source_Page_ClickHereForTrainingResources() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		obj.clickOnViewFullSourceDetailsLink();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnClickHereForTrainingLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC88");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 89)
	public void TC89_RC3_1_Analyst_Reports_Essential_AnalystReportSources() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnEssentialSourcesLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC89");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 90)
	public void TC90_RC3_1_AnalystReports_FavoriteSources() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnFavoriteSourcesLinkNewSources();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC90");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 91)
	public void TC91_RC64_65_Analyst_Reports_Thomas_One_ExpandCollapse() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		rcWaitForPageLoad();
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnThomsonOneLogo();
		obj.clickOnThomsonOneLogo();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC91");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 92)
	public void TC92_RC3_1_Analyst_Reports_Search_Search_Result() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		String Search_Input = "financial";
		String INWord_Title = "SWOT analysis";
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.enterdaataInSearchInputAnalystReport(Search_Input);
		obj.enterdataInWordsInTitleInputAnalystReport(INWord_Title);
		obj.selectLangauageDropdown();
		obj.enterStartDate();
		obj.enterEndDate();
		obj.clickonSearchButtonAnalystReport();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnFirstSearchResultNew();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC92");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 93)
	public void TC93_RC3_1_AnanlystReport_ViewOptions_Collapse() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnExpandAll();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnCollapseAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC93");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 94)
	public void TC94_RC3_1_AnalystReport_ViewOptions_Expand() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnCollapseAll();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnExpandAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC94");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 95)
	public void TC95_RC3_1_AnalystReports_ViewSummary_checkbox() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnAllSourceslink();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnViewSummaryCheckBox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC95");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 96)
	public void TC96_RC3_1_AnalystReport_Copyright() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.clickOnThomsonOneLogo();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnCopyrightlink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC96");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
	}

	@Test(priority = 97)
	public void TC97_RC3_1_Analyst_Reports_Search_Make_My_Default_Language() throws Exception {
		log.info(TSResearchCenter_AnalystReports.class.getName() + " start");
		ResearchCenter_AnalystReports obj = new ResearchCenter_AnalystReports(driver);
		obj.clickOnAnalystReportsTab();
		rcWaitForPageLoad();
		obj.selectLangauageDropdown();
		Thread.sleep(5000);
		obj.verifyCheckBoxVisibilty();
		clearProxyData();
		startProxyData();
		obj.clickOnMakeMyDefaultLanguageCheckBox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC97");
		log.info(TSResearchCenter_AnalystReports.class.getName() + " end");
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
