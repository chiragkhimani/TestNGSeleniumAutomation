package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

	@FindBy(id = "txtUsername")
	WebElement userNameInput;

	@FindBy(id = "txtPassword")
	WebElement passwordInput;

	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openWebsite(String url) {
		driver.get(url);
	}

	public void verifyPage() {
		Assert.assertTrue(userNameInput.isDisplayed(), "Username input is missing from login page");
		Assert.assertTrue(passwordInput.isDisplayed(), "Password input is missing from login page");
	}

	public void doLogin(String username, String password) {
		userNameInput.sendKeys(username);
		System.out.println(userNameInput.getAttribute("value"));
		
		passwordInput.sendKeys(password);
		System.out.println(passwordInput.getAttribute("value"));
		
		loginBtn.click();
	}

}
