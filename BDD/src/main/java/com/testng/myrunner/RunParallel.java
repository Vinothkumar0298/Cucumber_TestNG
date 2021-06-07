package com.testng.myrunner;


import java.io.File;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(features="src\\test\\resource\\com\\featurefiles",glue="classpath:com.setpdefinations")

public class RunParallel extends AbstractTestNGCucumberTests {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ExtentReports reports = null;
	public String suiteFilePath = null;
	 
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	@BeforeSuite
	
	public void intSetup() {
		
		File file = new File("."); 
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath().replace(".","")+"\\src\\main\\resources\\com\\drivers\\chromedriver\\chromedriver.exe");

		System.out.println(file.getAbsolutePath().replace(".","")+"\\src\\main\\resources\\com\\drivers\\chromedriver\\chromedriver.exe");
		//String file 
		
		String dateandtime = new Date().toLocaleString().replace(" ", "_").replace(":", "_").replace(",", "_");
		suiteFilePath = file.getAbsolutePath().replace(".", "target\\Test_Results\\")+dateandtime+".html".replace("\\\\", "\\");
		
		
		if(!new File(suiteFilePath).exists()) {
			
			reports = new ExtentReports(suiteFilePath);
			
		}
		System.out.println(suiteFilePath);
		//file.getAbsoluteFile().toString()
		//reports = new ExtentReports();
		
	}
	
	 @SuppressWarnings("unused")
	    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
	        // the 'featureWrapper' parameter solely exists to display the feature
	        // file in a test report
		 test.set(reports.startTest(pickleWrapper.getPickle().getName()));
	       super.runScenario(pickleWrapper, featureWrapper);
	       reports.endTest(test.get());
	       
	    }
      @Override
      @DataProvider(parallel = true,indices = 2)
      public Object[][] scenarios() {
            return super.scenarios();
      }
      
      @AfterSuite
  	
  	public void tearDown() {
    	  reports.flush();
    	  
      }
}