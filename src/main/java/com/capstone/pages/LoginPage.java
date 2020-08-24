package com.capstone.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.base.BaseClass;

public class LoginPage extends BaseClass
{
	Logger log = Logger.getLogger(LoginPage.class);
	RegistrationPage registrationPage = new RegistrationPage();
	
	// Webelements or elements repository of the application page
	@FindBy(xpath="//input[@name='userName']")
	WebElement userName1;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password1;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement loginButton;
	
	@FindBy (xpath="//*[contains(text(),'REGISTER')]")
	WebElement registerLink;

	@FindBy (xpath="//a[contains(text(),'SIGN-OFF')]")
	WebElement signOut;
	
	@FindBy(xpath="//a[contains(text(),'sign-in')]")
	WebElement signInLink;
	
	// Methods or actions performed on the above elements
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	public void clickOnRegister()
	{
		registerLink.click();
	}
	
	public void login()
	{
		userName1.sendKeys(prop.getProperty("userName"));
		password1.sendKeys(prop.getProperty("password"));
		loginButton.click();
		if(verifyUserLoggedInStatus()) {
		log.info("New User has logged in successfully");
		System.out.println("New User has logged in successfully");
		log.info("--------------------------------");
		System.out.println("--------------------------------");
		} 
		else
		{
			log.info("New User is not logged in");
			System.out.println("New User is not logged in");
		}
	}
	
	public void verifySuccessMessage() {
		//Verify success message is displayed and correct
		if ((registrationPage.getRegistrationSuccessMessage()).contains(prop.getProperty("registrationMessage"))) {
			log.info("New User has been created successfully");
			System.out.println("New User has been created successfully");
		}
		else {
			log.info("New user is not created or succes message is incorrect");
			System.out.println("New user is not created or succes message is incorrect");
		}
	}
	
	public void clickOnSignIn() {
		signInLink.click();
	}
	
	public void logout()
	{
		signOut.click();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public boolean verifyUserLoggedInStatus()
	{
		return signOut.isDisplayed();
	}

}
