package com.qa.test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.Util.TestUtil;
import com.qa.page.ContactsPage;
import com.qa.page.HomePage;
import com.qa.page.LoginPage;

public class ContactsTestPage extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil; 
	ContactsPage contactpage;
	String sheetname="contacts";

	@BeforeTest
	public void setup() throws IOException
	{
		driver=initializer();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactpage=new ContactsPage();
		driver.get(prop.getProperty("url"));
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchto();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][]=TestUtil.getData(sheetname);
		return data;
	}
	
	@Test(priority=1,dataProvider="getData")
	public void validatenewcontact(String title, String fname, String lname,String company)
	{
		homepage.clicknewcontact();
		//contactpage.createnewcontact("Mr.","tom","latham","uber");
		contactpage.createnewcontact(title, fname, lname, company);
	}
	
	@AfterTest
	public void Done()
	{
		driver.quit();
	}
}
