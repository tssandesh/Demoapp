package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.TestBase.TestBase;

public class HomePage extends TestBase
{
	
@FindBy(xpath="//td[contains(text(),'User: naveen k')]")
WebElement title;


@FindBy(xpath="//a[contains(text(),'Contacts')]")
WebElement contacts; 
	
@FindBy(xpath="//a[contains(text(),Deals)]")
WebElement deals; 

@FindBy(xpath="//a[contains(text(),Tasks)]")
WebElement Tasks; 

@FindBy(xpath="//a[contains(text(),'New Contact')]")
WebElement newcontact;


public HomePage()
{
	PageFactory.initElements(driver, this);
}

public String Homepagetitle()
{
	
	return driver.getTitle();
}

public boolean Homename()
{
	//WebDriverWait wait=new WebDriverWait(driver, 10);
	//WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'User: naveen k')]")));
	return title.isDisplayed();
	 
}

public ContactsPage clickcontact()
{
	contacts.click();
	return new ContactsPage();
}

public void clicknewcontact()
{
	Actions action=new Actions(driver);
	action.moveToElement(contacts).build().perform();
newcontact.click();

}

public DealsPage clickdeal()
{
	deals.click();
	return new DealsPage();
}


}