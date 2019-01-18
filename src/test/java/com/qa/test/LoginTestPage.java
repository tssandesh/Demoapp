package com.qa.test;

import java.awt.Button;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.page.HomePage;
//import com.qa.page.LandPage;
//import com.qa.page.Login;
import com.qa.page.LoginPage;

public class LoginTestPage extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	
	//before each test case - launch browser and begin
	//@test- excute tets case
	//after each test case- close the browser
	@BeforeTest
	public void setup() throws IOException
	{
	          driver=initializer();
	          loginpage=new LoginPage();
	          driver.get(prop.getProperty("url"));
	          System.out.println("started");
	}
	
	@Test(priority=1)
	public void Titletext()
	{
		String title=loginpage.Title();
	Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	
	@Test(priority=2)
	public void Logo()
	{
		
		boolean logo=loginpage.logo();
		Assert.assertTrue(logo);
		
	}
	
	/*@Test(priority=3)
	public void LoginTest()
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}*/
	
	
	@Test(dataProvider="getdata",priority=3)
	public void Grant(String user, String pass) //throws IOException
	{
		
		//driver.get(prop.getProperty("url"));
		//LandPage log=new LandPage(driver);
		//log.getLogin().click();
		
		//Login l=new Login(driver);
		homepage=loginpage.login(user,pass);
		//homepage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		//l.getEmail().sendKeys(user);
		//l.getPass().sendKeys(pass);
		//loginpage.click();
	}
	
	
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[2][2];
		
		data[0][0]="naveenk";//"nonrestrictuse@qw.com";
		data[0][1]="test123";//"123456";
		
		
		data[1][0]="restrictuse";
		data[1][1]="123";
		
		return data;
		
		}
	
	
	@AfterTest
	public void Done()
	{
		driver.quit();
	}
}
