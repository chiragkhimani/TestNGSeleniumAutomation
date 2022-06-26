package com.automation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;

public abstract class BaseTests {

	static WebDriver driver;

	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void clearSession() {
		driver.manage().deleteAllCookies();
	}

	
	@BeforeSuite
	public void setUp() {
		ConfigReader.setUpConfig();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@AfterSuite
	public void cleanUp() {
		driver.quit();
	}
}
