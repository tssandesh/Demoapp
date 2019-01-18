package com.qa.page;

import java.awt.Button;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="username") 
	WebElement username;
	
	@FindBy(name="password") 
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	//constructor so that initialize page objects in constructor of homepage, so all 4 elements initialised
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Title()
	{
		return driver.getTitle();
	}

	public boolean logo()
	{
		return logo.isDisplayed();
	}
	
	//public HomePage login(String usr,String pass)
	public HomePage login(String usr,String pass)
	{
		/*username.sendKeys();
	password.sendKeys();
	loginbtn.submit();*/
	username.sendKeys(usr);
		password.sendKeys(pass);		
		loginbtn.submit();
	return new HomePage();
	}
	
	
}
