package com.matrix.utilityFile;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.matrix.base.Base;

public class Support extends Base {
	
	@FindBy(how = How.XPATH, using = "btn btn-primary") @CacheLookup WebElement clickOK;
	@FindBy(how = How.XPATH, using = "btn btn-default") @CacheLookup WebElement clickBATAL;
	
	public static JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public static void waitFor5Seconds() throws InterruptedException {
		Thread.sleep(5000);
	}

	public static void waitFor3Seconds() throws InterruptedException {
		//Thread.sleep(2000);
	}

	public static void scrollPage(WebDriver driver) {
		
		jse.executeScript("window.scrollBy(0,300)", "");
		System.out.println("Page scrolled Down and JS called");
	}
	
public static void scrollUpPage(WebDriver driver) {
		
		jse.executeScript("window.scrollBy(0,-300)", "");
		System.out.println("Page scrolled UP and JS called");
	}

	public void clickKirimButton() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn btn-primary")));
		clickOK.click();
	}
	
	public void clickBatalButton() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn btn-default")));
		clickBATAL.click();
	}
}
