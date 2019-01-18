package com.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.Util.TestUtil;
import com.qa.page.ContactsPage;
import com.qa.page.HomePage;
import com.qa.page.LoginPage;

public class HomePagetest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil; 
	ContactsPage contactpage;
	
	@BeforeTest
	public void setup() throws IOException
	{
		driver=initializer();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		homepage=new HomePage();
		driver.get(prop.getProperty("url"));
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchto();
		
		//System.out.println("homepage");
	}
	
	
	
	@Test(priority=1)
	public void gettitltest()
	{
		String titles=homepage.Homepagetitle();
	Assert.assertEquals(titles, "CRMPRO");
	}
	
	@Test(priority=2)
	public void getname()
	{
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		boolean name=homepage.Homename();
		
		Assert.assertTrue(name);
		
	}
	@Test(priority=3)
	public void contact()
	{
		//testutil.switchto();
		contactpage=homepage.clickcontact();
	}
	
	@AfterTest
	public void Done()
	{
		driver.quit();
	}
}
