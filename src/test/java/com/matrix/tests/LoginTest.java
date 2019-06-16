package com.matrix.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.matrix.base.Base;
import com.matrix.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTest extends Base {

	LoginPage loginPage = new LoginPage();
	//String currentURL;
	
	@Test(priority=1)
	public void validateLoginPageTitle() {
		logger = extent.startTest("To validate Login Page title", "Below given login page title.");
		
		String actualTitle = prop.getProperty("loginPageTitle");
		String loginTitle = loginPage.currentPageTitle();
		System.out.println("Login page title is : " + " " + loginTitle);
		Assert.assertEquals(actualTitle, loginTitle, "Title not matched on login Page");
		logger.log(LogStatus.PASS, "<b>"+loginTitle+"</b>");
	}
	
	@Test(priority=2)
	public void validateCurrentURL() {
		logger = extent.startTest("To validate current URL of Login Page", "Below given login page URL.");
		
		String actualURL = prop.getProperty("url");
		String currentURL = loginPage.currentURL();
		System.out.println("Login page URL is : " + " " + currentURL);
		Assert.assertEquals(actualURL, currentURL, "URL not matched on login Page");
		logger.log(LogStatus.PASS, "<a href='https://www.pasangmatrix.net/'>"+currentURL+"</a>");
	}
	
	@Test(priority=3)
	public void validateValidLoginTest() throws InterruptedException {
		logger = extent.startTest("To validate valid login credentails", "Below given report for login validation");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL = prop.getProperty("url");
		System.out.println("Actual URL is : " + " " + actualURL);
		String currentURL = loginPage.currentURL();
		System.out.println("Dashboard page URL is : " + " " + currentURL);
		if(currentURL.equals(actualURL)) {
			//Assert.assertEquals(actualURL, currentURL, "URL not matched on Dashboard Page");
			logger.log(LogStatus.FAIL, "<a href='https://www.pasangmatrix.net/dashboard'>"+currentURL+"</a>"+" "+"and"+" " + actualURL);
		}else {	
			logger.log(LogStatus.PASS, "<a href='https://www.pasangmatrix.net/dashboard'>"+currentURL+"</a>");
		}
	}
	
	
}
