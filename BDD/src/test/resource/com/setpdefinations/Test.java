package com.setpdefinations;

import org.openqa.selenium.chrome.ChromeDriver;

import com.pageobjects.LoginPageObject;
import com.relevantcodes.extentreports.LogStatus;
import com.testng.myrunner.RunParallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
	@Given("I launch {string} browser with url as {string}")
	public void i_launch_browser_with_url_as(String string, String string2) throws InterruptedException {
		RunParallel.driver.set(new ChromeDriver());
		LoginPageObject loginPageObject = new LoginPageObject();
		
		RunParallel.driver.get().get(string2);
		Thread.sleep(3000);
		loginPageObject.userName.sendKeys(string);
		RunParallel.test.get().log(LogStatus.PASS, "Username entered as "+string);
		loginPageObject.passWord.sendKeys(string2);
		RunParallel.test.get().log(LogStatus.PASS, "Password entered as "+string2);
		Thread.sleep(3000);
		loginPageObject.logIn.click();
		RunParallel.test.get().log(LogStatus.PASS, "login successfull");
		
	}

	@When("I enter the username as {string} and password as {string}")
	public void i_enter_the_username_as_and_password_as(String string, String string2) {
	
	}

	@Then("I validate the homepage with successfully login message")
	public void i_validate_the_homepage_with_successfully_login_message() {
		

	}
}
