package com.hybridFramework.testBase;

import java.util.Properties;

public class Config extends TestBase{
	
	private Properties OR;
	
	public Config(Properties OR){
		this.OR = OR;
	}
	public String getUserName() {
		return OR.getProperty("UserName");
	}

	public String getPassword() {
		return OR.getProperty("Password");
	}

	public String getWebsite() {
		return OR.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(OR.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("ExplicitWait"));
	}

	public String getDbdriver() {
		return OR.getProperty("DataBase.driver");
	}

	public String getDbConnStr() {
		return OR.getProperty("DataBase.ConnectionStr");
	}
	
	public String getBrowser() {
		return OR.getProperty("Browser");
	}
	
	public String getDBName() {
		return OR.getProperty("dbName");
	}
	public String getParameterName() {
		return OR.getProperty("ParameterValue");
	}
	public String getExpectedParameter() {
		return OR.getProperty("ExpectedData");
	}
	public String getSearchParameter() {
		return OR.getProperty("SearchParameter");
	}
	public String getSearchExpected() {
		return OR.getProperty("SearchExpected");
	}
}
