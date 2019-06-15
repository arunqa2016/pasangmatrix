package com.matrix.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	
	
	public static WebDriver driver;
	//public static HtmlUnitDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Properties prop;
	public static WebDriverWait wait;
	private String propPath = "E:\\Arun Backup Data\\workspace-eclipse\\TGWEB-OFFICE\\src\\main\\java\\com\\tgweb\\config\\config.properties";
	private static String reportLocation = "E:\\Automation_Reports\\PasangMatrix_Web_AutomationReport.html";

	public Base() {
		
		FileInputStream file;
		try {
			file = new FileInputStream(propPath);
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeSuite
	public static void initialize() throws FileNotFoundException,IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");*/
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		extent = new ExtentReports(reportLocation);
	//	String reportConfigPath = prop.getProperty("reportConfigPath");
		System.out.println("---------- 1. Base class initialized ----------.");
	}
	
	@AfterSuite
	public static void tearDown() {
		System.out.println("---------- 4. In EndTest method.----------");
		extent.endTest(logger);
		extent.flush();
		driver.get(reportLocation);
	}

}
