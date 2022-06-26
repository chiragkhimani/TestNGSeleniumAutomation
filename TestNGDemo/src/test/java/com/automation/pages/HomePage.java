package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

	@FindBy(id = "welcome")
	WebElement userNameIcon;

	@FindBy(id = "branding")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyPage() {
		Assert.assertTrue(userNameIcon.isDisplayed(), "Username icon is missing from home page");
		Assert.assertTrue(logo.isDisplayed(), "logo is missing from home page");
	}

	public void clickOnUserIcon() {
		userNameIcon.click();
	}

	public void selectLogoutLink() {
		logoutLink.click();
	}

}
