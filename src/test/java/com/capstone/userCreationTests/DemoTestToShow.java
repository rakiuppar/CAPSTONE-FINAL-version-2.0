package com.capstone.userCreationTests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.capstone.base.BaseClass;
import com.capstone.pages.LoginPage;
import com.capstone.pages.RegistrationPage;

public class DemoTestToShow extends BaseClass {
	Logger log = Logger.getLogger(DemoTestToShow.class);
	LoginPage loginPage;
	RegistrationPage registrationPage;

	DemoTestToShow() {
		super();
	}
	

	@BeforeTest()
	public void openApplication() {
		initialization();
		registrationPage = new RegistrationPage();
		loginPage = new LoginPage();
	}

	
	@Test
	public void createUser() throws InterruptedException {
		loginPage.clickOnRegister();
		registrationPage.fillRegistrationForm();
		loginPage.clickOnSignIn();
		loginPage.login();
		loginPage.logout();
	}


	@AfterTest()
	public void closeBrowser() {
		// Close the browser
		driver.quit();
	}
}
