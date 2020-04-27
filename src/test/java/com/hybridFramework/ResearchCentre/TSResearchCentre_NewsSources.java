package com.hybridFramework.ResearchCentre;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.hybridFramework.PageObject.ResearchCenter_NewsSources;
import com.hybridFramework.helper.Browser.BrowserHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class TSResearchCentre_NewsSources extends TestBase {

	private final Logger log = LoggerHelper.getLogger(TSResearchCentre_NewsSources.class);
	String applicationGlobalReport = "bcgrcprod,bcgglobalprod";

	
	/*
	 * Custom_clearProxyData(); This method will clear the proxy
	 * Custom_startProxyData(); This merhod will start the proxy
	 * CustomVerify_Report_Suite(); This method will verify the report suits name
	 * Custom_verifyEventTriggeredCount(); This method will verify the no of event
	 * count Custom_verifyProxyPostGetData(); This method is used to verify the
	 * event, evars and props
	 */
	
	

	 @Test(priority=54)
	public void TC54_RC01_NewsSources_Add_To_Favorites() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		obj.removeFromFavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnAddToFavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC54");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=55)
	public void TC55_RC01_News_Sources_Remove_From_Favorites() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		obj.addTofavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnRemoveFromFavorites();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC55");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=56)
	public void TC56_RC25_26_30_NewsSources_Search() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickonNewsSourcesSearch();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC56");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority=57)
	public void TCT57_RC01_News_Sources_Go_To_Source() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnGO();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC57");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=58)
	public void TC58_RC01_News_Sources_Interested_in_Training() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnTrainingLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC58");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=59)
	public void TC59_RC01_News_Sources_MoreInfo() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnViewFullSourceDetailsLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC59");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=60)
	public void TC60_RC3_1_News_Sources_ShareWithCollegue() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnShareWithColleguelink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC60");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=61)
	public void TC61_RC19_News_Sources_Source_Page_GotoSource() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		obj.clickOnViewFullSourceDetails_Link();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		clearProxyData();
		startProxyData();
		obj.clickOnGotosource_Button();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC61");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=62)
	public void TC62_RC10_News_Sources_Source_Page_AddtoFavorite() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		obj.clickOnViewFullSourceDetails_Link();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		obj.cardPageRemoveCardFromFavorite();
		clearProxyData();
		startProxyData();
		obj.clikOnAddtofavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC62");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority=63)
	public void TC63_NewsSources_Source_Page_Remove_From_Favorite() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		obj.clickOnViewFullSourceDetails_Link();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		Thread.sleep(5000);
		obj.cardPageAddCardToFavorite();
		clearProxyData();
		startProxyData();
		obj.clickOnRemovetofavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC63");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=64)
	public void TC64_RC22_News_Sources_Source_Page_Click_Here_For_Training_Resources() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		obj.clickOnViewFullSourceDetails_Link();
		BrowserHelper.SwitchToWindow(1);
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnClickHereForTrainingLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC64");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority=65)
	public void TC65_RC3_1_New_Sources_Essential_Sources_Link() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnEssentialSourcesLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC65");
		log.info(TSResearchCentre_Home.class.getName() + " end");

	}

	@Test(priority=66)
	public void TC66_RC3_1_New_Sources_Favourite_Sources() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnFavoriteSourcesLinkNewSources();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC66");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority=67)
	public void TC67_RC64_65_New_Sources_CardExpandCollapse() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnDowJonesFactivaLogo();
		obj.clickOnDowJonesFactivaLogo();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC67");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority=68)
	public void TC68TC123_RC3_1_New_Sources_Search_Search_ResultClick() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.enter_Data_FindSourcesSearch_Editbox();
		obj.enter_Data_WordsInTitle_Input();
		obj.selectLangauageDropdown();
		obj.enterStartDate();
		obj.enterEndDate();
		obj.clickOnSearchButton();
		clearProxyData();
		startProxyData();
		obj.clickOnFirstSearchResult();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC68");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority=69)
	public void TC69_RC3_1_NewsSources_ViewOptions_Collapse() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		obj.clickOnExpandAll();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnCollapseAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC69");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority=70)
	public void TC70_RC3_1_NewsSources_ViewOptions_Expand() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		obj.clickOnCollapseAll();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnExpandAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC70");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	 @Test(priority=71)
	public void TC71_RC3_1_NewsSources_ViewSummary_checkbox() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		obj.clickOnAllSourceslink();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnViewSummaryCheckBox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC71");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}

	@Test(priority = 72)
	public void TC72_RC3_1_NewsSources_Copyright() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		rcWaitForPageLoad();
		obj.clickOnDowJonesFactivaLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnCopyrightlink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC72");
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}
	@Test(priority=73)
	public void TC73_RC3_1_Header_News_BCG_in_the_News_SearchResultClick() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnBCGInTheNewsTab();
		rcWaitForPageLoad();
		String first_Rsult =obj.firstSearchResultNew.getText();
		System.out.println(first_Rsult);
		clearProxyData();
		startProxyData();
		obj.clickOnFirstSearchResultNew();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC73");
		//verify Evar 40 value
		String searchResultName="v40";
		boolean status1 = verifyProxyPostGetData(searchResultName, first_Rsult);
		if (status1) {
			test.log(LogStatus.PASS, "" + searchResultName + " is verified");
		} else {
			test.log(LogStatus.FAIL, "" + searchResultName + " is not verified");
		}
		log.info(TSResearchCentre_Home.class.getName() + " end");
	}
	@Test(priority=74)
	public void TC74RC3_1_Header_News_IndustryNews_SearchResultClick() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnIndustryNewsTab();
		obj.selectIndustryNewsDropdown();
		rcWaitForPageLoad();
		String first_Rsult =obj.firstSearchResultNew.getText();
		System.out.println(first_Rsult);
		clearProxyData();
		startProxyData();
		obj.clickOnFirstSearchResultNew();
		writeProxyData();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC74");
		// verify evar40 value
		String searchResultName="v40";
		boolean status1 = verifyProxyPostGetData(searchResultName, first_Rsult);
		if (status1) {
			test.log(LogStatus.PASS, "" + searchResultName + " is verified");
		} else {
			test.log(LogStatus.FAIL, "" + searchResultName + " is not verified");
		}
		log.info(TSResearchCentre_Home.class.getName() + " end");	
	}
	@Test(priority=75)
	public void TC75_RC3_1_Header_News_BCGNewsstand_SearchResultClick() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnBCGNewsstandTab();
		rcWaitForPageLoad();
		String first_Rsult =obj.firstSearchResultNew.getText();
		System.out.println(first_Rsult);
		clearProxyData();
		startProxyData();
		obj.clickOnFirstSearchResultNew();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);;
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC75");
		// verify evar 40 value.
		String searchResultName="v40";
		boolean status1 = verifyProxyPostGetData(searchResultName, first_Rsult);
		if (status1) {
			test.log(LogStatus.PASS, "" + searchResultName + " is verified");
		} else {
			test.log(LogStatus.FAIL, "" + searchResultName + " is not verified");
		}
		log.info(TSResearchCentre_Home.class.getName() + " end");		
	}
	@Test(priority=76)
	public void TC76_RC3_1_News_Sources_Search_Make_My_Default_language() throws Exception{
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_NewsSources obj = new ResearchCenter_NewsSources(driver);
		rcWaitForPageLoad();
		obj.clickOnNewsTab();
		obj.clickOnNewsSourcesTab();
		obj.selectLangauageDropdown();
		obj.verifyCheckBoxVisibilty();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnMakeMyDefaultLanguageCheckBox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verify_Report_Suite(applicationGlobalReport);;
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		homePage.verifyEventsAndEvars("TC76");	
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
