package com.hybridFramework.ResearchCentre;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.hybridFramework.PageObject.ResearchCenter_FindSources;
import com.hybridFramework.PageObject.ResearchCenter_Footer;
import com.hybridFramework.helper.Browser.BrowserHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;

public class TSResearchCenter_FindSources extends TestBase {
	private final Logger log = LoggerHelper.getLogger(TSResearchCenter_FindSources.class);
	String Application_Global_Report = "bcgrcprod";
	
	
	
	/*
	 * Custom_clearProxyData(); This method will clear the proxy
	 * Custom_startProxyData(); This merhod will start the proxy
	 * CustomVerify_Report_Suite(); This method will verify the report suits name
	 * Custom_verifyEventTriggeredCount(); This method will verify the no of event
	 * count Custom_verifyProxyPostGetData(); This method is used to verify the
	 * event, evars and props
	 */
	
	

	// Find Sources Test Cases
	@Test(priority=19)
	public void TC19RC3_1Find_Sources_AddToFavorites() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		findSources=new ResearchCenter_FindSources(driver);
		findSources.clickOnFindSources_Tab();
		findSources.clickOnBCGFinancialDataPortalLogo();
		findSources.removeFromFavorites();
		clearProxyData();
		startProxyData();
		findSources.clickOnAddToFavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC19");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=20)
	public void TC20_RC25_26_30_FindSources_Search() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		clearProxyData();
		startProxyData();
		obj.clickOndSedeKeysFindSourcesSearch_Editbox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC20");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=21)
	public void TC21_RC01_FindSources_RemoveFromFavorites() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
		obj.addTofavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnRemoveFromFavorites();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC21");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=22)
	public void TC22_RC01_FindSources_Go() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.ClickOnGotosourceLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC22");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=23)
	public void TC23_RC01_Find_Sources_Interested_in_Training() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnTrainingLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC23");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=24)
	public void TC24_RC3_1_Find_Sources_ShareWithCollegues() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnShareWithColleguelink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC24");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=25)
	public void TC25_RC01_Find_Sources_MoreInfo() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnViewFullSourceDetailsLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC25");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=26)
	public void TC26_RC19_Find_Sources_Source_Page_GotoSource() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
		obj.clickOnViewFullSourceDetailsLink();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnGotosource_Button();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC26");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=27)
	public void TC27_RC10_Find_Sources_Source_Page_Add_to_Favorite() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
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
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC27");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=28)
	public void TC28_RC13_FindSources_SourcePage_RemoveFromFavorite() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
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
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC28");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=29)
	public void TC29_RC16_FindSources_SourcePage_ShareWithCollegues() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		obj.clickOnBCGFinancialDataPortalLogo();
		obj.clickOnViewFullSourceDetailsLink();
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.SwitchToWindow(1);
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnShareWithColleaguesButon();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC29");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=30)
	public void TC30_RC22_Find_Sources_SourcePage_Click_Here_For_Training_Resources() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
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
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC30");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=31)
	public void TC31_RC61_Find_Sources_All_Sources_Link() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnAllSourceslink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC31");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority = 32)
	public void TC32_RC3_1_Find_Sources_Favorite_Sources_Link_Under_Search() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnFavouriteSourcesLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC32");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=33)
	public void TC33_RC3_1_Find_Sources_Essential_sources() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnEssentialSourcesLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC33");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=34)
	public void TC34TC_RC64_65_Find_Sources_BCG_Financial_Card_Expand_Collapse() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnBCGFinancialDataPortalLogo();
		obj.clickOnBCGFinancialDataPortalLogo();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC34");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority=35)
	public void TC35_RC3_1_FindSources_ViewOptions_Collapse() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		rcWaitForPageLoad();
		obj.clickOnExpandAll();
		clearProxyData();
		startProxyData();
		obj.clickOnCollapseAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC35");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=36)
	public void TC36_RC3_1_FindSources_ViewOptions_Expand() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		rcWaitForPageLoad();
		obj.clickOnCollapseAll();
		clearProxyData();
		startProxyData();
		obj.clickOnExpandAll();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC36");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=37)
	public void TC37_RC3_1_FindSources_AllSources_ViewSummary_checkbox() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		rcWaitForPageLoad();
		obj.clickOnAllSourceslink();
		clearProxyData();
		startProxyData();
		obj.clickOnViewSummaryCheckBox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC37");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=38)
	public void TC38_RC3_1_FindSources_Copyright() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnFindSources_Tab();
		rcWaitForPageLoad();
		obj.clickOnBCGFinancialDataPortalLogo();
		clearProxyData();
		startProxyData();
		obj.clickOnCopyrightlink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC38");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=39)
	public void TC39_RC01_Find_Sources_Get_Help_Assist_Me() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnGetHelpBuuton();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnAssistMe();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC39");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority = 40)
	public void TC40_RC01_Find_Sources_Get_Help_IT_Service_Center() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnGetHelpBuuton();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnITServiceCenterLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC40");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=41)
	public void TC41_RC01_Find_Sources_Get_Help_Research_Center() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnGetHelpBuuton();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnResearchCenterLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC41");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority = 42)
	public void TC42_RC01_Find_Sources_Get_Help_DropDown_TrainingRequest_Contact_RC() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnGetHelpBuuton();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnTrainingRequestLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC42");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");

	}

	//@Test(priority = 43)
	public void TC43_NewReq_Find_Sources_Get_Help_Error_Message_My_access_isnt_working_for() throws Exception {
		log.info(TSResearchCentre_Home.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnGetHelpBuuton();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnErrorMessageMyaccessisntworkingForLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC43");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority = 44)
	public void TC44_NewReq_Find_Sources_Get_Help_Other_training_or_support_request() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnGetHelpBuuton();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnOtherTrainingSupportRequest();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC44");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority = 45)
	public void TC45_NewReq_Find_Sources_Get_Help_Howcan_I_get_started_using_Research_Center() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnGetHelpBuuton();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnHowCanIgetstartedusingResearchCenter();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC45");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=46)
	public void TC46_NewReq_FindSources_Get_Help_How_can_I_get_a_company_transcript_on_Research_Center()
			throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_FindSources obj = new ResearchCenter_FindSources(driver);
		rcWaitForPageLoad();
		obj.clickOnGetHelpBuuton();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnHowCanIGetaCompanyTranscriptOnResearchCenter();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC46");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	// Footer Test Cases start
	//@Test(priority=47)
	public void TC47_RC44_RC47_Footer_Training_Link() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_Footer obj = new ResearchCenter_Footer(driver);
		rcWaitForPageLoad();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnAnnouncementsLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC47");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=48)
	public void TC48_RC44_Copyright_Link() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_Footer obj = new ResearchCenter_Footer(driver);
		rcWaitForPageLoad();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnCopyrightLicensingInfoLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC48");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=49)
	public void TC49_RC44_Footer_Assist_Me_Link() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_Footer obj = new ResearchCenter_Footer(driver);
		rcWaitForPageLoad();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnAssistMeLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC49");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=50)
	public void TC50_RC44_Footer_Research_Center_Link() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_Footer obj = new ResearchCenter_Footer(driver);
		rcWaitForPageLoad();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnResearchbcgcomEmailLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(1, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC50");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=51)
	public void TC51_RC44_Footer_IT_Service_Center_Link() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_Footer obj = new ResearchCenter_Footer(driver);
		rcWaitForPageLoad();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnITSercviceCentre();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC51");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=52)
	public void TC52_RC44_Footer_About_Link() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_Footer obj = new ResearchCenter_Footer(driver);
		rcWaitForPageLoad();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnAboutLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC52");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
	}

	//@Test(priority=53)
	public void TC53TC031_RC44_Footer_BCG_Logo() throws Exception {
		log.info(TSResearchCenter_FindSources.class.getName() + " start");
		ResearchCenter_Footer obj = new ResearchCenter_Footer(driver);
		rcWaitForPageLoad();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnBCGLogo();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(Application_Global_Report);
		verifyEventTriggeredCount(2, Application_Global_Report);
		verifyStaffID();
		findSources.verifyEventsAndEvars("TC53");
		log.info(TSResearchCenter_FindSources.class.getName() + " end");
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
