package com.capstone.pages;

import java.lang.ref.PhantomReference;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.base.BaseClass;

public class RegistrationPage extends BaseClass
{
	
	// Webelements or elements repository of the application page
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='userName']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='address1']")
	WebElement address1;
	
	@FindBy(xpath="//input[@name='address2']")
	WebElement address2;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement postalCode;
	
	@FindBy(xpath="//select[@name='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//font[contains(text(),'Thank you for registering.')]")
	WebElement regitrationConfirmation;
	
	@FindBy(xpath="//a[contains(text(),'sign-in')]")
	WebElement signInLink;
	
	
	
	// Methods or actions performed on the above elements
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void fillRegistrationForm() throws InterruptedException
	{
		firstName.sendKeys(prop.getProperty("firstName"));
		lastName.sendKeys(prop.getProperty("lastName"));
		phone.sendKeys(prop.getProperty("phone"));
		email.sendKeys(prop.getProperty("email"));
		address1.sendKeys(prop.getProperty("address"));
		city.sendKeys(prop.getProperty("city"));
		state.sendKeys(prop.getProperty("state"));
		postalCode.sendKeys(prop.getProperty("postalCode"));
		country.sendKeys(prop.getProperty("country"));
		userName.sendKeys(prop.getProperty("userName"));
		password.sendKeys(prop.getProperty("password"));
		confirmPassword.sendKeys(prop.getProperty("password"));
		submitButton.click();	
		Thread.sleep(2000);
	}
	
	public void clickOnSignIn()
	{
		signInLink.click();
	}
	
	public String getRegistrationSuccessMessage()
	{
		return regitrationConfirmation.getText();
	}
	
}
