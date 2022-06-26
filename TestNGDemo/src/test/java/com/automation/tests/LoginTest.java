package com.automation.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.utils.ConfigReader;

public class LoginTest extends BaseTests {

	@Parameters({ "url" })
	@Test
	public void verifyUserCanLogin(String url) {
		loginPage.openWebsite(url);
		loginPage.verifyPage();
		loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
		homePage.verifyPage();
	}

	@Parameters({ "url" })
	@Test
	public void verifyUserCanLogout(String url) {
		loginPage.openWebsite(url);
		loginPage.verifyPage();
		loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
		homePage.verifyPage();
		homePage.clickOnUserIcon();
		homePage.selectLogoutLink();
		loginPage.verifyPage();
	}

}
