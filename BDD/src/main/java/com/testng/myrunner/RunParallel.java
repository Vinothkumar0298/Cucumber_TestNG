package com.testng.myrunner;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(features="C:\\Users\\vkvin\\Desktop\\Cucumber_TestNG\\Cucumber_TestNG\\BDD\\src\\test\\resource\\com\\featurefiles",glue="classpath:com.setpdefinations")
public class RunParallel extends AbstractTestNGCucumberTests {

	
	
	 @SuppressWarnings("unused")
	    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
	        // the 'featureWrapper' parameter solely exists to display the feature
	        // file in a test report
	       super.runScenario(pickleWrapper, featureWrapper);
	    }
      @Override
      @DataProvider(parallel = true)
      public Object[][] scenarios() {
            return super.scenarios();
      }
}