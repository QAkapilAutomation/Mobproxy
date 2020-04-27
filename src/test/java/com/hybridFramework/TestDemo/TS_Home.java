package com.hybridFramework.TestDemo;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.hybridFramework.PageObject.Home;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;


public class TS_Home extends TestBase {
	private final Logger log = LoggerHelper.getLogger(TS_Home.class);
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
		log.info(TS_Home.class.getName() + "Home_ViewOptions_Collapse start");
		homePage = new Home(driver);
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
		log.info(TS_Home.class.getName() + "Home_ViewOptions_Collapse end");
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
