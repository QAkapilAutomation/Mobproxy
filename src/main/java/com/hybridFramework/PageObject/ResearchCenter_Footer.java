package com.hybridFramework.PageObject;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.testBase.TestBase;

public class ResearchCenter_Footer extends TestBase{

	public static Properties OR;

	WebDriver driver;
	WaitHelper waitHelper;
	public static boolean status = false;
	
	/************ All WebElements for footer ***************************/
	
	@FindBy(xpath="//img[@alt='BCG']")
	public WebElement bcgLogo;
	
	@FindBy(xpath="//footer[@id='footer']//a[contains(@href, '/Help/About')]")
	public WebElement aboutLink;
	
	@FindBy(xpath="//footer[@id='footer']//a[contains(@href, '/Help/Copyright')]")
	public WebElement copyrightLicensingInfoLink;
	
	@FindBy(xpath="//footer[@id='footer']/div/div[3]//a[contains(text(),'research@bcg.com')]")
	public WebElement researchbcgcomEmailLink;
	
	@FindBy(xpath="//footer[@id='footer']//a[@href='http://its.bcg.com']")
	public WebElement itSercviceCentre;
	
	@FindBy(xpath="//footer[@id='footer']//a[contains(text(),'Assist Me')]")
	public WebElement assistMeLink;
	
	@FindBy(xpath="//footer[@id='footer']//a[contains(text(),'Announcements')]")
	public WebElement announcementsLink;
	
	
	/******************************************************************************/
	
	// Class constructor 
	public ResearchCenter_Footer(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);

	}
	
	// Click On the BCG logo
	public void clickOnBCGLogo() {
		
		bcgLogo.click();
	}
	
	// Click on the about link
	public void clickOnAboutLink() {
		aboutLink.click();
	}
	
	// Click on the copyright Lincensing Info pack
	public void clickOnCopyrightLicensingInfoLink() {
		copyrightLicensingInfoLink.click();
	}
	
	// click on the Research center bcg email link
	public void clickOnResearchbcgcomEmailLink() {
		researchbcgcomEmailLink.click();
	}
	
	// click on the it services Centre 
	public void clickOnITSercviceCentre() {
		itSercviceCentre.click();
	}
	
	// Click on the assist me link
	public void clickOnAssistMeLink() {
		assistMeLink.click();
	}
	
	// Click on the Announcements link
	public void clickOnAnnouncementsLink() {
		announcementsLink.click();
	}
}
