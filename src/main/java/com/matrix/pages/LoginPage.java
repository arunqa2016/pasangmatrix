package com.matrix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.matrix.base.Base;
import com.matrix.utilityFile.Support;

public class LoginPage extends Base {

	@FindBy(how = How.XPATH, using = "//*[@id=\"user\"]")@CacheLookup WebElement username;
	@FindBy(how = How.XPATH, using = "//*[@id=\"login_form\"]/div/button")@CacheLookup	WebElement clickUserButton;
	@FindBy(how = How.NAME, using = "password")	@CacheLookup	WebElement password;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password-form\"]/div[6]/div[2]/button")	@CacheLookup	WebElement clickPassButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"accept_btn\"]")	@CacheLookup	WebElement agree;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String currentPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public String currentURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}
	
	public void validateLoginFunctionality(String un, String pass) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user")));
		Assert.assertTrue(username.isDisplayed());
		username.sendKeys(un);
		Assert.assertTrue(clickUserButton.isDisplayed());
		clickUserButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		Assert.assertTrue(password.isDisplayed());
		password.sendKeys(pass);
		
		Support.waitFor5Seconds();
		Assert.assertTrue(clickPassButton.isDisplayed());
		clickPassButton.click();
		
		Support.waitFor5Seconds();
		Assert.assertTrue(agree.isDisplayed());
		agree.click();
		//String currentUrl = driver.getCurrentUrl();
		//System.out.println("Current URL is - " + currentUrl);
		Support.waitFor5Seconds();
		
	}
	
}
