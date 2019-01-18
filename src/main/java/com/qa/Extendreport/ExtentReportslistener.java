package com.qa.Extendreport;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.DynamicGraph.Status;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class ExtentReportslistener implements IReporter
{
	 /*private static final String OUTPUT_FOLDER = "test-output/";
	    private static final String FILE_NAME = "Extent.html";*/

	private ExtentReports extent;
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);
		
		for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
  
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
  
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }
		extent.flush();
		extent.close();
    }
	 private void buildTestNodes(IResultMap tests, LogStatus status) {
	        ExtentTest test;
	        
	        if (tests.size() > 0) {
	            for (ITestResult result : tests.getAllResults()) {
	                test = extent.startTest(result.getMethod().getMethodName());
	                
	                /*test.getTest().getStartedTime(getTime(result.getStartMillis()));
	                test.getTest().endedTime = getTime(result.getEndMillis());*/
	              test.setStartedTime(getTime(result.getStartMillis()));
	                test.setEndedTime((getTime(result.getEndMillis())));
	                
	                for (String group : result.getMethod().getGroups())
	                    test.assignCategory(group);

	                //String message = "Test " + status.toString().toLowerCase() + "ed";
	                
	                if (result.getThrowable() != null) {
	                    test.log(status, result.getThrowable());
	                }
	                else {
	                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
	                }
	                extent.endTest(test);
	                }
	                
	               
	            }
	        }
	    
	    
	    private Date getTime(long millis) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(millis);
	        return calendar.getTime();      
	    }
	}
	

	
    
/*public class ExtentReports {
		
	public ExtentHtmlReporter extenthtmlreporter;
	public ExtentTest extenttest;
	public ExtentReports extentreports;
	
	@BeforeClass
	public void beforeclass()
	{
		extenthtmlreporter=new ExtentHtmlReporter("extent.html");
		extentreports.att
	}
	 
	@Test
	public void test1()
	{
		
	}
	@Test
	public void test2()
	{
		
	}
	@AfterClass
	public void Afterclass()
	{
		
	}
	
	
		 }*/
		
   /* public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportTestNG.html", true);
  
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
  
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
  
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }
  
        extent.flush();
        extent.close();
    }
  
    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;
  
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());
  
                test.getTest().startedTime = getTime(result.getStartMillis());
                test.getTest().endedTime = getTime(result.getEndMillis());
  
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
  
                String message = "Test " + status.toString().toLowerCase() + "ed";
  
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
  
                test.log(status, message);
  
                extent.endTest(test);
            }
        }
    }
  
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();     */   
    

	
	

