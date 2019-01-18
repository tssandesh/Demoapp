package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement first;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement last;

	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement save;

	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}

	

	public void createnewcontact(String title, String fname, String lname,String comp)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		first.sendKeys(fname);
		last.sendKeys(lname);
		company.sendKeys(comp);
		save.click();
		
	}
}
