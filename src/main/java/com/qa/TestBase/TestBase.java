package com.qa.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
		
		public static WebDriver driver;
		public static Properties prop;
		
		
		public WebDriver initializer() throws IOException
		{
			
			 prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\User2\\workspace\\Naveen\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver","");
		}
		
		/*String Url=prop.getProperty("url");
		
		driver.get(Url);*/
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
		
		}

		
		/*public void getScreenshot(String result)throws IOException 
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E://test//"+ result +"screenshot.png"));
		}*/


		
		
		
	}

