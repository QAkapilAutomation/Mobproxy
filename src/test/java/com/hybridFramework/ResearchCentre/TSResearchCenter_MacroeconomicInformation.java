package com.hybridFramework.ResearchCentre;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.hybridFramework.PageObject.ResearchCenter_MacroeconomicInformation;
import com.hybridFramework.helper.Browser.BrowserHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;

public class TSResearchCenter_MacroeconomicInformation extends TestBase {

	private final Logger log = LoggerHelper.getLogger(TSResearchCenter_MacroeconomicInformation.class);
	String applicationGlobalReport = "bcgrcprod,bcgglobalprod";
	
	/*
	 * Custom_clearProxyData(); This method will clear the proxy
	 * Custom_startProxyData(); This merhod will start the proxy
	 * CustomVerify_Report_Suite(); This method will verify the report suits name
	 * Custom_verifyEventTriggeredCount(); This method will verify the no of event
	 * count Custom_verifyProxyPostGetData(); This method is used to verify the
	 * event, evars and props
	 */

	//@Test(priority = 118)
	public void TC118_RC01_Macroeconomic_Information_AddToFavorites() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
		obj.removeFromFavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnAddToFavoritesButton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC118");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");
	}

	//@Test(priority = 119)
	public void TC119_RC01_MacroeconomicInformation_Remove_From_Favorites() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
		obj.addTofavorites();
		clearProxyData();
		startProxyData();
		obj.clickOnRemoveFromFavorites();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC119");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");
	}

	//@Test(priority = 120)
	public void TC120_RC01_Macroeconomic_Information_Go() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
		clearProxyData();
		startProxyData();
		obj.clickOnTheGOMacrobutton();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyExitLinkPresentWithNoEvent();
		verifyStaffID();
		obj.verifyEventsAndEvars("TC120");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");

	}
	//@Test(priority=121)
	public void TC121059_RC01_MacroeconomicInformation_InterestedinTraining() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
		clearProxyData();
		startProxyData();
		obj.clickOnTrainingLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC121");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");
		
	}
	//@Test(priority=122)
	public void TC122MacroeconomicInformation_MoreInfo() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
		clearProxyData();
		startProxyData();
		obj.clickOnViewFullSourceDetailsLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC122");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
	}
	//@Test(priority=123)
	public void TC123RC3_1_MacroeconomicInformation_ShareWithCollegues() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
		clearProxyData();
		startProxyData();
		obj.clickOnShareWithColleguelink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC123");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
	}
	//@Test(priority=124)
	public void TC124_RC19_MacroeconomicInformation_SourcePage_Go() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
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
		obj.verifyEventsAndEvars("TC124");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
	}
	//@Test(priority=125)
	public void TC125_RC10_MacroeconomicInformation_SourcePage_AddtoFavorite() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
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
		verifyStaffID();
		obj.verifyEventsAndEvars("TC125");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
	}
	//@Test(priority=126)
	public void TC126_RC13_MacroeconomicInformation_SourcePage_RemoveFromFavorite() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
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
		obj.verifyEventsAndEvars("TC126");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
		
	}
	//@Test(priority=127)
	public void TC127_RC16_MacroeconomicInformation_SourcePage_ShareWithCollegue() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
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
		obj.verifyEventsAndEvars("TC127");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");
	}
	//@Test(priority=128)
	public void TC128RC22_MacroeconomicInformation_SourcePage_ClickHereForTrainingResources() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
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
		obj.verifyEventsAndEvars("TC128");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
	}
	//@Test(priority=129)
	public void TC129_RC3_1_MacroeconomicInformation_EssentialMacroeconomicsSources() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnEssentialSourcesLink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC129");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");		
	}
	//@Test(priority=130)
	public void TC130_RC3_1_Macroeconomic_Info_FavouriteSources() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnFavoriteSourcesLinkNewSources();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC130");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");		
	}
	//@Test(priority=131)
	public void TC131_RC64_65_MacroeconomicInfo_TheEconomist_CardExpandCollapse() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		clearProxyData();
		startProxyData();
		obj.clickOnTheEconmistIMG();
		obj.clickOnTheEconmistIMG();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(2, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC131");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");
	}
	//@Test(priority=132)
	public void TC132_RC3_1_MacroeconomicInfo_ViewOptions_Collapse() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
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
		obj.verifyEventsAndEvars("TC132");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
	}
	//@Test(priority=133)
	public void TC133_RC3_1_MacroeconomicInfo_ViewOptions_Expand() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
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
		obj.verifyEventsAndEvars("TC133");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
	}
	@Test(priority=134)
	public void TC134TC160_RC3_1_MacroeconomicInformation_ViewSummary_checkbox() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnAllSourceslink();
		clearProxyData();
		startProxyData();
		obj.clickOnViewSummarycheckbox();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC134");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");		
	}
	@Test(priority=135)
	public void TC135_RC3_1_MacroeconomicInformation_Copyright() throws Exception {
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " start");
		ResearchCenter_MacroeconomicInformation obj = new ResearchCenter_MacroeconomicInformation(driver);
		obj.clickOnMacroeconomicInformationTab();
		rcWaitForPageLoad();
		obj.clickOnTheEconmistIMG();
		clearProxyData();
		startProxyData();
		obj.clickOnCopyrightlink();
		writeProxyData();
		readProxyReportSuites();
		verify_Report_Suite(applicationGlobalReport);
		verifyEventTriggeredCount(1, applicationGlobalReport);
		verifyStaffID();
		obj.verifyEventsAndEvars("TC135");
		log.info(TSResearchCenter_MacroeconomicInformation.class.getName() + " end");	
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
