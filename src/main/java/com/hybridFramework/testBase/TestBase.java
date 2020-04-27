package com.hybridFramework.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.hybridFramework.PageObject.ResearchCenter_AnalystReports;
import com.hybridFramework.PageObject.ResearchCenter_CompanyInformation;
import com.hybridFramework.PageObject.ResearchCenter_FindSources;
import com.hybridFramework.PageObject.ResearchCenter_Footer;
import com.hybridFramework.PageObject.Home;
import com.hybridFramework.PageObject.ResearchCenter_MacroeconomicInformation;
import com.hybridFramework.PageObject.ResearchCenter_NewsSources;
import com.hybridFramework.excelReader.Excel_reader;
import com.hybridFramework.helper.Browser.BrowserHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.model.HarEntry;
import de.sstoehr.harreader.model.HarQueryParam;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class TestBase {
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Home homePage;
	public static ResearchCenter_Footer footer;
	public static ResearchCenter_FindSources findSources;
	public static ResearchCenter_MacroeconomicInformation macroEconomics;
	public static ResearchCenter_AnalystReports analystReport;
	public static ResearchCenter_NewsSources newSources;
	public static ResearchCenter_CompanyInformation companyInfo;
	public static Properties OR;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String globalBrowserName;	
//	public static WebDriver oldDriver = null;
	public static BrowserMobProxy proxy;
	public static String harLocation = System.getProperty("user.home").toString() + "\\Documents\\adobeData.har";
	public File f1;
	public FileInputStream file;
	public String url;
	public ITestResult result;
	SoftAssert softAssert = new SoftAssert();
	
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/src/main/java/com/hybridFramework/report/BCG_AdobeAnalytics_"
						+ formater.format(calendar.getTime()) + ".html",
				false);
	}
	
//	@BeforeClass
//	public void initializeObject() throws Exception {
//		homePage = new ResearchCenter_Home(driver);
//		footer = new ResearchCenter_Footer(driver);
//		findSources = new ResearchCenter_FindSources(driver);
//		macroEconomics = new ResearchCenter_MacroeconomicInformation(driver);
//		analystReport = new ResearchCenter_AnalystReports(driver);
//		newSources = new ResearchCenter_NewsSources(driver);
//		companyInfo = new ResearchCenter_CompanyInformation(driver);
//	}
//	
	
	@BeforeMethod
	public void Setup() throws Exception {		
		launchBrowser();
		singleLogin();
		rcWaitForPageLoad();
	}

	public void launchBrowser() throws Exception {

		// HarReadAndWrite hr= new HarReadAndWrite();
		// hr.Custom_LaunchBrowser(globalBrowserName, url);

		try {
			loadPropertiesFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Config config = new Config(OR);
			getBrowser(config.getBrowser());
			WaitHelper waitHelper = new WaitHelper(driver);
			waitHelper.setImplicitWait(config.getImplicitWait(), TimeUnit.SECONDS);
			waitHelper.setPageLoadTimeout(config.getPageLoadTimeOut(), TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("No Browser Launched");
		}
	}

	public void getBrowser(String browser) {

		try {
			globalBrowserName = browser;
			proxy = new BrowserMobProxyServer();
			proxy.setTrustAllServers(true);
			proxy.start(0);
			Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kumar kapil\\Downloads\\KCTool_Framework\\drivers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			LoggingPreferences logprefs = new LoggingPreferences();
			option.setCapability(CapabilityType.LOGGING_PREFS, logprefs);
			option.setCapability(CapabilityType.PROXY, seleniumProxy);
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			proxy.enableHarCaptureTypes(CaptureType.REQUEST_HEADERS, CaptureType.REQUEST_BINARY_CONTENT,
					CaptureType.REQUEST_CONTENT, CaptureType.REQUEST_COOKIES, CaptureType.RESPONSE_BINARY_CONTENT,
					CaptureType.RESPONSE_CONTENT, CaptureType.RESPONSE_COOKIES, CaptureType.RESPONSE_HEADERS);
			proxy.newHar("abc.com");
			driver.get(url);
			Config config = new Config(OR);
			driver.get(config.getWebsite());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	public void loadPropertiesFile() throws IOException {
		String log4jConfPath = System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		OR = new Properties();
		f1 = new File(System.getProperty("user.dir") + "/src/main/java/com/hybridFramework/config/config.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		logger.info("loading config.properties");
	}

	public String getScreenShot(String imageName) throws IOException {

		if (imageName.equals("")) {
			imageName = "BCG_AdobeAnalytics_";
		}
		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir") + "/src/main/java/com/hybridFramework/screenshot/";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imagelocation + imageName + "_" + formater.format(calendar.getTime()) + ".png";
		File destFile = new File(actualImageName);
		FileUtils.copyFile(image, destFile);
		return actualImageName;
	}

	public WebElement waitForElement(WebDriver driver, long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@SuppressWarnings("deprecation")
	public WebElement waitForElementWithPollingInterval(WebDriver driver, long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void impliciteWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenShot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	public void ReturnToParentwindow() {
		BrowserHelper BrowserHelper = new BrowserHelper(driver);
		BrowserHelper.switchToParentWithChildClose();
	}

	
	// This method is used to login to the application.
	public void singleLogin() throws Exception {

		Config config = new Config(OR);
		String url = config.getWebsite();
		System.out.println(url);
		driver.get(config.getWebsite());

		try {
			if (driver.findElement(By.xpath("//div[@class='okta-sign-in-header auth-header']")).isDisplayed()) {
				driver.findElement(By.id("okta-signin-username")).sendKeys("kumar.kapil@bcg.com");
				driver.findElement(By.id("okta-signin-password")).sendKeys("welcome@1234");
				driver.findElement(By.id("okta-signin-submit")).click();

			}
		} catch (Exception e) {

			System.out.println("no such element");
		}

	}

//	public void navigateToHome() {
//		driver.findElement(By.xpath("//img[@alt='Research Center at BCG']")).click();
//	}
	
//This method is used to wait until the page load
	public void rcWaitForPageLoad() {
		try {
			WebElement ele1 = driver.findElement(By.xpath("//a[contains(@href, '#') and contains(.,'Welcome')]"));
			WaitHelper WaitHelper = new WaitHelper(driver);
			WaitHelper.waitForElementToBeVisible(driver, 100, ele1);
		} catch (Exception e) {

			driver.navigate().refresh();
		}

	}
	// To verify user staff id
	public void verifyStaffID() {
		Config config = new Config(OR);
		String ParameterSearch = config.getParameterName();
		System.out.println(ParameterSearch);
		String ExpectedSearch = config.getExpectedParameter();
		System.out.println(ExpectedSearch);
		boolean staffId = verifyProxyPostGetData(ParameterSearch, ExpectedSearch);
		if (staffId) {
			test.log(LogStatus.PASS, "" + ParameterSearch + " is verified");
		} else {
			test.log(LogStatus.FAIL, "" + ParameterSearch + " is not verified");
			softAssert.assertTrue(staffId, "StaffId is not verified");
			softAssert.assertAll();
		}
	}
	
	

	public void clearProxyData() {
		try {
			Thread.sleep(20000);
			// 40000
			proxy.endHar();
			System.out.println("Proxy Cleared");
		} catch (Exception e) {
			// System.out.println(e.getStackTrace());
			e.printStackTrace();

		}
	}

	public void startProxyData() {
		try {
			proxy.newHar("abc.com");
			System.out.println("Proxy Started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeProxyData() {
		try {
			Thread.sleep(20000);
			// Utils.waitForAngularPageLoad();
			// Utils.waitForPageLoad(driver);
			Har har = proxy.getHar();
			har.writeTo(new File(harLocation));

		} catch (Exception e) {
			// System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
	}

	public boolean verifyActualExpectedProxyData(String parameterName, String expectedData) {
		String parameterValue = null;
		Boolean getValue = false;
		List<String> values = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();
		try {
			HarReader harReader = new HarReader();
			de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
			List<HarEntry> entries = har2.getLog().getEntries();

			for (HarEntry singleEntrie : entries) {
				if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
					List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
					for (HarQueryParam query : queries) {
						System.out.println(query.getName() + " : " + query.getValue());
						map.put(query.getName(), query.getValue());

					}
				}
			}

			for (HarEntry singleEntrie : entries) {
				if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
					List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
					for (HarQueryParam query : queries) {
						if (query.getName().equalsIgnoreCase(parameterName)) {
							parameterValue = query.getValue();
							values.add(parameterValue);
							if (parameterValue.equalsIgnoreCase(expectedData)) {
								getValue = true;
							}
						}
					}
				}
			}
			if (getValue == false) {
				// return .FAIL(ResultCodes.ERROR_TEXT_NOT_FOUND).setOutput(false)
				// .setMessage(parameterName+ " - " +values+" Value Not Found"+" Full Values
				// "+map).make();
				System.out.println(parameterName + " - " + values + " Value Not Found" + " Full Values " + map);
				return getValue;
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		System.out.println("Value matched");
		return getValue;
	}

	public String readProxyReportSuites() {
		String url = null;
		Boolean getValue = false;
		try {
			HarReader harReader = new HarReader();
			de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
			List<HarEntry> entries = har2.getLog().getEntries();
			for (HarEntry singleEntrie : entries) {
				if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
					url = singleEntrie.getRequest().getUrl();
					System.out.println(url);
					getValue = true;
					break;
				}
			}
			if (getValue == false) {
				// return getValue;
				return url;

			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
		return url;
	}

	public void verify_Report_Suite(String Global_Report) {
		String url = readProxyReportSuites();
		try {
			if (url.contains(Global_Report)) {
				System.out.println("Url found");
			}

		} catch (Exception e) {
			System.out.println("null pointer exception");

		}
	}

	public String javascriptExecutor(String script) {
		String response = null;
		try {

			response = ((JavascriptExecutor) driver).executeScript("return " + script, new Object[0]).toString().trim();
			if (response == null) {
				return response;
			}

		} catch (Exception e) {
			System.out.println(e.getStackTrace());

		}
		return response;
	}

	// with 2 parameters

	public boolean verifyActualExpectedData() {
		String parameterValue = null;
		Boolean getValue = false;
		//Boolean countCheck = false;
		String response = null;
		// int Parameter_count=0;
		Excel_reader er = new Excel_reader(
				"C:\\Users\\kumar kapil\\Downloads\\KCTool_Framework\\src\\main\\java\\com\\hybridFramework\\data\\TestData.xlsx");
		int row_count = er.getRowCount("SmartSearch");
		System.out.println(row_count);
		for (int i = 0; i <= row_count; i++) {
			String parameterName = er.getCellData("SmartSearch", 0, i + 2);
			System.out.println(parameterName);
			String expectedData = er.getCellData("SmartSearch", 1, i + 2);
			System.out.println(expectedData);

			try {
				// ************For Testing************************
				HarReader harReader1 = new HarReader();
				de.sstoehr.harreader.model.Har har21 = harReader1.readFromFile(new File(harLocation));

				for (HarEntry singleEntrie : har21.getLog().getEntries()) {
					if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
						List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
						for (HarQueryParam query : queries) {
							System.out.println(query.getName() + "=" + query.getValue());
						}
					}
				}
				// *******************END************************
				if (parameterName.equalsIgnoreCase("v3")) {
					HarReader harReader = new HarReader();
					de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
					List<HarEntry> entries = har2.getLog().getEntries();

					for (HarEntry singleEntrie : entries) {
						if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
							List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
							for (HarQueryParam query : queries) {
								if (query.getName().equalsIgnoreCase(parameterName)) {
									parameterValue = query.getValue();
									if (parameterValue.contains(expectedData)) {
										getValue = true;
									}
								}
							}
						}
					}
					if (getValue == false) {
						System.out.println("ERROR_TEXT_NOT_FOUND");
						return getValue;
					}
				} else if (!parameterName.contains("digital")) {
					HarReader harReader = new HarReader();
					de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
					List<HarEntry> entries = har2.getLog().getEntries();

					for (HarEntry singleEntrie : entries) {
						if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
							List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
							for (HarQueryParam query : queries) {
								if (query.getName().equalsIgnoreCase(parameterName)) {
									// Parameter_count ++;
									// System.out.println("count of current parameter in if nd for"+
									// Parameter_count);
									parameterValue = query.getValue();
									if (parameterValue.equalsIgnoreCase(expectedData)) {
										getValue = true;
									}
								}
							}
							// System.out.println("count of current parameter"+ Parameter_count);
							// if(Parameter_count != ParameterCount) {
							//
							// countCheck= false;
							// }
						}
					}
					if (getValue == false) {
						System.out.println("ERROR_TEXT_NOT_FOUND");
						return getValue;
					}
				} else if (parameterName.contains("digital")) {
					response = ((JavascriptExecutor) driver).executeScript("return " + parameterName).toString();
					if (response == null) {
						System.out.println("ERROR_TEXT_NOT_FOUND");
						return getValue;
					}
					if (response.equalsIgnoreCase(expectedData)) {
						getValue = true;
					}
					if (getValue == false) {
						System.out.println("ERROR_TEXT_NOT_FOUND");
						return getValue;
					}
				} else {
					System.out.println("ERROR_TEXT_NOT_FOUND");
					return getValue;
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		return getValue;
	}

	// with 3 parameters

	public boolean verifyActualExpectedData(String parameterName, String expectedData, int ParameterCount) {
		String parameterValue = null;
		Boolean getValue = false;
		//Boolean countCheck = false;
		String response = null;
		int Parameter_count = 0;

		try {
			// ************For Testing************************
			HarReader harReader1 = new HarReader();
			de.sstoehr.harreader.model.Har har21 = harReader1.readFromFile(new File(harLocation));

			for (HarEntry singleEntrie : har21.getLog().getEntries()) {
				if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
					List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
					for (HarQueryParam query : queries) {
						System.out.println(query.getName() + "=" + query.getValue());
					}
				}
			}
			// *******************END************************
			if (parameterName.equalsIgnoreCase("v3")) {
				HarReader harReader = new HarReader();
				de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
				List<HarEntry> entries = har2.getLog().getEntries();

				for (HarEntry singleEntrie : entries) {
					if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
						List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
						for (HarQueryParam query : queries) {
							if (query.getName().equalsIgnoreCase(parameterName)) {
								parameterValue = query.getValue();
								if (parameterValue.contains(expectedData)) {
									getValue = true;
								}
							}
						}
					}
				}
				if (getValue == false) {
					System.out.println("ERROR_TEXT_NOT_FOUND");
					return getValue;
				}
			} else if (!parameterName.contains("digital")) {
				HarReader harReader = new HarReader();
				de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
				List<HarEntry> entries = har2.getLog().getEntries();

				for (HarEntry singleEntrie : entries) {
					if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
						List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
						for (HarQueryParam query : queries) {
							if (query.getName().equalsIgnoreCase(parameterName)) {
								Parameter_count++;
								// System.out.println("count of current parameter in if nd for"+
								// Parameter_count);
								parameterValue = query.getValue();
								if (parameterValue.equalsIgnoreCase(expectedData)) {
									getValue = true;
								}
							}
						}
						System.out.println("count of current parameter" + Parameter_count);

					}
				}
				// if(Parameter_count == ParameterCount) {
				// System.out.println("passed parametercount: "+ParameterCount +"and counted
				// parameter value:"+Parameter_count+"matched");
				// countCheck= true;
				// }
				if (getValue == false /** ||countCheck==false */
				) {
					System.out.println("ERROR_TEXT_NOT_FOUND");
					return getValue;
				}
			} else if (parameterName.contains("digital")) {
				response = ((JavascriptExecutor) driver).executeScript("return " + parameterName).toString();
				if (response == null) {
					System.out.println("ERROR_TEXT_NOT_FOUND");
					return getValue;
				}
				if (response.equalsIgnoreCase(expectedData)) {
					getValue = true;
				}
				if (getValue == false) {
					return getValue;
				}
			} else {
				System.out.println("Please defined condition for parameter name");
				return getValue;

			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return getValue;
	}

	public int verifyEventTriggeredCount(int expectedEventCount, String reportSuiteName) {
		int actualEventcount = 0;
		List<String> values = new ArrayList<String>();
		try {
			HarReader harReader = new HarReader();
			de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));

			for (HarEntry singleEntrie : har2.getLog().getEntries()) {
				if (singleEntrie.getRequest().getUrl().contains("b/ss/")
						&& singleEntrie.getRequest().getUrl().contains(reportSuiteName)) {
					actualEventcount = actualEventcount + 1;
					List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
					for (HarQueryParam query : queries) {
						if (query.getName().equalsIgnoreCase("events")) {
							values.add(query.getValue());
						}
					}
				}
			}
			Set<String> set = new HashSet<String>(values);
			System.out.println("expectedEventCount=" + expectedEventCount);
			System.out.println("actualEventcount=" + actualEventcount);
			System.out.println("set.size()=" + set.size());
			System.out.println("values.size()=" + values.size());
			if (expectedEventCount != actualEventcount || set.size() < values.size()) {
				System.out.println("actualEventcount=" + actualEventcount + " expectedEventCount=" + expectedEventCount
						+ " || found events-->" + values);
				test.log(LogStatus.FAIL, "actualEventcount=" + actualEventcount + " expectedEventCount="
						+ expectedEventCount + " || found events-->" + values);
				Assert.assertEquals(actualEventcount, expectedEventCount);
				return expectedEventCount;
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return actualEventcount;

	}
//This method is used to verify post request
	public boolean verifyProxyPostData(String parameterName, String expectedData) {
		String parameterValue = null;
		Boolean getValue = false;
		String response = null;
		try {
			if (!parameterName.contains("digital")) {
				HarReader harReader = new HarReader();
				de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
				List<HarEntry> entries = har2.getLog().getEntries();
				for (HarEntry singleEntrie : entries) {
					try {
						if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
							System.out.println("expectedData=" + expectedData);
							parameterValue = java.net.URLDecoder.decode(
									singleEntrie.getRequest().getPostData().getText().split(parameterName + "=")[1]
											.split("&")[0],
									"UTF-8");
							System.out.println("parameterValue=" + parameterValue);
							if (parameterValue.contains(expectedData)) {
								getValue = true;
							}
						}
					} catch (Exception e) {
						// do nthg as get request has no post data
					}
				}

				if (getValue == false) {

					System.out.println("Actual Data=" + parameterValue + "  Expected Data=" + expectedData);
					return getValue;
				}
			} else if (parameterName.contains("digital")) {
				response = ((JavascriptExecutor) driver).executeScript("return " + parameterName).toString();
				if (response == null) {
					System.out.println("No Javascript Executor Value Found");
					return getValue;
				}
				if (response.equalsIgnoreCase(expectedData)) {
					getValue = true;
				}
				if (getValue == false) {
					System.out.println("Actual javascript value " + response);
					return getValue;

				}
			} else {
				System.out.println("Please defined condition for parameter name");
				return getValue;
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());

		}

		return getValue;
	}
//This method is used to verify the post and get request
	public boolean verifyProxyPostGetData(String parameterName, String expectedData) {
		String parameterValue = null;
		Boolean getValue = false;
		String response = null;

		try {

			if (parameterName.equalsIgnoreCase("v3")) {
				HarReader harReader = new HarReader();
				de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
				List<HarEntry> entries = har2.getLog().getEntries();

				for (HarEntry singleEntrie : entries) {
					String requestType = singleEntrie.getRequest().getMethod().toString();
					if (requestType.equalsIgnoreCase("GET")) {
						if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
							List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
							for (HarQueryParam query : queries) {
								if (query.getName().equalsIgnoreCase(parameterName)) {
									parameterValue = query.getValue();
									if (parameterValue.contains(expectedData)) {
										getValue = true;
									}
								}
							}
						}
					}
					if (requestType.equalsIgnoreCase("POST")) {
						// System.out.println("request is "+singleEntrie.getRequest().getMethod());
						if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
							System.out.println("expectedData=" + expectedData);
							parameterValue = java.net.URLDecoder.decode(
									singleEntrie.getRequest().getPostData().getText().split(parameterName + "=")[1]
											.split("&")[0],
									"UTF-8");
							System.out.println("parameterValue=" + parameterValue);
							if (parameterValue.contains(expectedData)) {
								getValue = true;
							}
						}
					}

				}
				if (getValue == false) {
					System.out.println(parameterName + " not match with expected " + expectedData);
					return getValue;
				}
			} else if (!parameterName.contains("digital")) {
				HarReader harReader = new HarReader();
				de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
				List<HarEntry> entries = har2.getLog().getEntries();

				for (HarEntry singleEntrie : entries) {
					String requestType = singleEntrie.getRequest().getMethod().toString();
					try {
						if (requestType.equalsIgnoreCase("POST")) {
							// System.out.println("request is "+singleEntrie.getRequest().getMethod());
							if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
								System.out.println("expectedData=" + expectedData);
								parameterValue = java.net.URLDecoder.decode(
										singleEntrie.getRequest().getPostData().getText().split(parameterName + "=")[1]
												.split("&")[0],
										"UTF-8");
								System.out.println("parameterValue=" + parameterValue);
								if (parameterValue.contains(expectedData)) {
									getValue = true;
								}
							}
						} else {
							if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
								List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
								for (HarQueryParam query : queries) {
									if (query.getName().equalsIgnoreCase(parameterName)) {
										// Parameter_count ++;
										// System.out.println("count of current parameter in if nd for"+
										// Parameter_count);
										parameterValue = query.getValue();
										if (parameterValue.equalsIgnoreCase(expectedData)) {
											getValue = true;
										}
									}
								}

							}
						}
					} catch (Exception e) {
						// do nthg as get request has no post data
					}
				}

				if (getValue == false) {
					test.log(LogStatus.FAIL, "Actual Data= " + parameterValue + "  Expected Data=" + expectedData);
					System.out.println("Actual Data= " + parameterValue + "  Expected Data=" + expectedData);
					return getValue;
				}
			} else if (parameterName.contains("digital")) {
				response = ((JavascriptExecutor) driver).executeScript("return " + parameterName).toString();
				if (response == null) {
					System.out.println("No Javascript Executor Value Found");
					return getValue;
				}
				if (response.equalsIgnoreCase(expectedData)) {
					getValue = true;
				}
				if (getValue == false) {
					System.out.println("Actual javascript value " + response);
					return getValue;
				}
			} else {
				System.out.println("Please defined condition for parameter name");
				return getValue;
			}
		} catch (Exception e) {
			// System.out.println(e.getStackTrace());
			System.out.println("Exception Handle");
		}
		return getValue;
	}
	
	
	
	
//This method is used to verify the exit link event
	public boolean verifyExitLinkPresentWithNoEvent() {
		String parameterValue = null;
		Boolean getValue = false;
		try {
			HarReader harReader = new HarReader();
			de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
			List<HarEntry> entries = har2.getLog().getEntries();

			for (HarEntry singleEntrie : entries) {
				if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {

					List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
					for (HarQueryParam query : queries) {
						if (query.getName().equalsIgnoreCase("pe")) {
							parameterValue = query.getValue();
							if (parameterValue.equalsIgnoreCase("lnk_e")) {

								for (@SuppressWarnings("unused") HarQueryParam query11 : queries) {
									if (query.getName().equalsIgnoreCase("events")) {
										getValue = false;
										break;
									} else {
										getValue = true;
									}
								}
							}
						}
					}

				}

			}

			if (getValue == false) {
				return getValue;
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return getValue;
	}

	// public void Custom_RemoveProxy() {
	// try {
	// if(!(driver==null)) {
	// driver.quit();
	// }
	// if(!(oldDriver==null)) {
	// oldDriver.quit();
	// }
	// Proxy noProxy = new Proxy();
	// noProxy.setProxyType(ProxyType.MANUAL);
	//
	// String ieDriverpath = Context.session().getDefaultPluginLocation() +
	// "\\Drivers\\IEDriverServer_64.exe";
	// System.out.println("ieDriverpath "+ ieDriverpath);
	// System.setProperty("webdriver.ie.driver", ieDriverpath);
	//
	// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	// capabilities.setCapability("ignoreProtectedModeSettings", true);
	// capabilities.setCapability(CapabilityType.PROXY, noProxy);
	// capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	// capabilities.setCapability("ie.ensureCleanSession", true);
	//
	// driver = new InternetExplorerDriver(capabilities);
	// driver.manage().window().maximize();
	// driver.manage().deleteAllCookies();
	//
	// driver.get("http://www.google.com");
	// driver.quit();
	//
	//
	//
	// Context.session().setTool(driver);
	// } catch (Exception e) {
	// return
	// Result.FAIL(ResultCodes.ERROR_UNSATISFIED_DEPENDENCIES).setOutput(false).setMessage(e.getMessage()).make();
	// }
	// return Result.PASS().setOutput("").setMessage("").make();
	// }

	// public void Custom_SwitchToFrame(String Frame_name) {
	// try {
	// WebDriver driver = Finder.findWebDriver();
	// driver.switchTo().frame(Frame_name);
	// } catch (Exception e) {
	// return
	// Result.FAIL(ResultCodes.ERROR_UNSATISFIED_DEPENDENCIES).setOutput(false).setMessage(e.getMessage())
	// .make();
	// }
	// return Result.PASS().setOutput("").setMessage("").make();
	// }
// This method is used to verify the not null value 
	public boolean verifyNotNull(String parameterName) {
		Boolean getValue = false;
		String response = null;
		String parameterValue = null;
		try {
			if (!parameterName.contains("digital")) {
				HarReader harReader = new HarReader();
				de.sstoehr.harreader.model.Har har2 = harReader.readFromFile(new File(harLocation));
				List<HarEntry> entries = har2.getLog().getEntries();
				for (HarEntry singleEntrie : entries) {
					if (singleEntrie.getRequest().getUrl().contains("b/ss/")) {
						if (singleEntrie.getRequest().getMethod().name().equalsIgnoreCase("get")) {
							if (parameterName.equalsIgnoreCase("v3")) {
								List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
								for (HarQueryParam query : queries) {
									if (query.getName().equalsIgnoreCase(parameterName)) {
										return true;
									}
								}
								if (getValue == false) {
									return getValue;
								}
							} else if (!parameterName.contains("digital")) {
								List<HarQueryParam> queries = singleEntrie.getRequest().getQueryString();
								for (HarQueryParam query : queries) {
									if (query.getName().equalsIgnoreCase(parameterName)) {
										return getValue;
									}
								}
								if (getValue == false) {
									return getValue;
								}
							}

						} else if (singleEntrie.getRequest().getMethod().name().equalsIgnoreCase("post")) {

							System.out.println("Post");
							parameterValue = java.net.URLDecoder.decode(
									singleEntrie.getRequest().getPostData().getText().split(parameterName + "=")[1]
											.split("&")[0],
									"UTF-8");
							if (parameterValue != null) {
								return getValue;
							} else {
								return getValue;
							}

						}
					}
				}
			} else if (parameterName.contains("digital")) {
				response = ((JavascriptExecutor) driver).executeScript("return " + parameterName).toString();
				if (response == null) {
					System.out.println("No Javascript Executor Value Found");
					return getValue;
				} else {
					return getValue;
				}
			} else {
				System.out.println("Please defined condition for parameter name");
				return getValue;
			}

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		return getValue;
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}
}
