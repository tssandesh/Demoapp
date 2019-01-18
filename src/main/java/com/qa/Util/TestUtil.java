package com.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.TestBase.TestBase;

public class TestUtil extends TestBase {

	public static String TESTDATA_SHEET_PATH="C:\\Users\\User2\\workspace\\Naveen\\src\\main\\java\\com\\qa\\Testdata\\Naveen.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public void switchto()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static  Object[][] getData(String sheetname)
	{
		FileInputStream file=null;
		try
		{
			file=new FileInputStream(TESTDATA_SHEET_PATH);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		return data;
	}
	public void getScreenshot(String result)throws IOException 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E://test//"+ result +"screenshot.png"));
	}

}
