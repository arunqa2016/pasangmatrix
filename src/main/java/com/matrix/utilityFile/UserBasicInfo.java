package com.matrix.utilityFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.matrix.base.Base;
public class UserBasicInfo extends Base {
	
	public static String userCurrentBalanceInfo() { 
		WebElement currentBalance = driver.findElement(By.xpath("/html/body/div[1]/aside/div[1]/div[2]/div[1]/p"));
		String userBalance = currentBalance.getText();
		return userBalance;
		
	}
	// Current Username of the login user
	public static String userCurrentName() {
		WebElement userInfo = driver.findElement(By.xpath("/html/body/div[1]/aside/div[1]/div[2]/h4"));
		String userName = userInfo.getText();
		return userName;

	}
	// Current Title of the current open Page
	public static String currentTitleOfOpenPage() {
		String currentTitle = driver.getTitle();
		return currentTitle;
		
	}
	public static String currentURLOfOpenPage() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static String currentGamePeriode() {
		
		String gamePeriode = driver.findElement(By.xpath("//*[@id=\"fourdgame\"]/div[1]/h5")).getText();
		return gamePeriode;
	}

}
