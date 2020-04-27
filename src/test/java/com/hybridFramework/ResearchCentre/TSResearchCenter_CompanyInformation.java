package com.hybridFramework.ResearchCentre;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.hybridFramework.PageObject.ResearchCenter_CompanyInformation;
import com.hybridFramework.helper.Browser.BrowserHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;

public class TSResearchCenter_CompanyInformation extends TestBase {
	private final Logger log = LoggerHelper.getLogger(TSResearchCenter_CompanyInformation.class);
	String applicationGlobalReport = "bcgrcprod,bcgglobalprod";
	

	
	/*
	 * Custom_clearProxyData(); This method will clear the proxy
	 * Custom_startProxyData(); This merhod will start the proxy
	 * CustomVerify_Report_Suite(); This method will verify the report suits name
	 * Custom_verifyEventTriggeredCount(); This method will verify the no of event
	 * count Custom_verifyProxyPostGetData(); This method is used to verify the
	 * event, evars and props
	 */

	
	
	@Test(priority = 98)
	public void TC98_RC01_Company_Information_AddToFavorites() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
		obj.removeFromFavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnAddToFavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC98");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 99)
	public void TC99_RC01_Company_Information_RemoveFromFavorites() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
		obj.addTofavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnRemoveFromFavorites();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC99");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 100)
	public void TC100_RC01_Company_Information_Go() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
		clearProxyData();
		startProxyData();
		obj.ClickOnGotosourceLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		obj.verifyEventsAndEvars("TC100");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 101)
	public void TC101_RC25_26_30_Company_Information_Search_Company_Infopack() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.enterDataInSearchClickOnFirstSearch();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		obj.verifyEventsAndEvars("TC101");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 102)
	public void TC102_RC01_Company_Information_InterestedinTraining() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
		clearProxyData();
		startProxyData();
		obj.clickOnTrainingLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC102");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 103)
	public void TC103_RC01_Company_Information_Moreinfo() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
		clearProxyData();
		startProxyData();
		obj.clickOnViewFullSourceDetailsLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC103");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 104)
	public void TC104_RC3_1_Company_Information_ShareWithCollegues() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
		clearProxyData();
		startProxyData();
		obj.clickOnShareWithColleguelink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC104");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 105)
	public void TC105_RC19_Company_Information_SourcePage_Go() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
		obj.clickOnViewFullSourceDetailsLink();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnGotosource_Button();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		obj.verifyEventsAndEvars("TC105");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 106)
	public void TC106_RC10_Company_Information_Source_Page_AddtoFavorite() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
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
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		obj.verifyEventsAndEvars("TC106");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 107)
	public void TC107_RC13_Company_Information_SourcePage_Remove_From_Favorite() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
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
		obj.verifyEventsAndEvars("TC107");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 108)
	public void TC108_RC16_Company_Information_SourcePage_ShareWithCollegues() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGValueScienceFinancialLogoIMG();
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
		obj.verifyEventsAndEvars("TC108");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 109)
	public void TC109_RC22_Company_Information_Source_Page_Click_HereForTrainingResources() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnOrbisSecondCardLogo();
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
		obj.verifyEventsAndEvars("TC109");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 110)
	public void TC110_RC3_1_Company_Information_Essential_Company_Sources() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnEssentialSourcesLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC110");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 111)
	public void TCTC111_RC3_1_Company_Information_Favourite_Sources() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnFavoriteSourcesLinkNewSources();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC111");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 112)
	public void TC112_RC64_65_Company_Information_OrbisCardExpand_Collapse() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnOrbisSecondCardLogo();
		obj.clickOnOrbisSecondCardLogo();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC112");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 113)
	public void TC113_RC3_1_CompanyInformation_ViewOptions_Collapse() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnExpandAll();
		clearProxyData();
		startProxyData();
		obj.clickOnCollapseAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC113");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 114)
	public void TC114_RC3_1_CompanyInformation_ViewOptions_Expand() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnCollapseAll();
		clearProxyData();
		startProxyData();
		obj.clickOnExpandAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC114");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 115)
	public void TC115_RC3_1_CompanyInformation_ViewSummary_checkbox() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnAllSourceslink();
		clearProxyData();
		startProxyData();
		obj.clickOnViewSummaryCheckBox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("115");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 116)
	public void TC116_RC3_1_CompanyInformation_Copyright() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnCopyrightlink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("116");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
	}

	@Test(priority = 117)
	public void TC117_RC25_26_30_Company_Information_Search_QuickSearch() throws Exception {
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " start");
		ResearchCenter_CompanyInformation obj = new ResearchCenter_CompanyInformation(driver);
		obj.clickOnCompanyInformationTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.enterDataInSearchClickOnFirstSearch();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("117");
		log.info(TSResearchCenter_CompanyInformation.class.getName() + " end");
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
