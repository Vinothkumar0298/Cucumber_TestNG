package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testng.myrunner.RunParallel;

public class LoginPageObject {

	@FindBy(xpath = "//input[@id='email']")

	public WebElement userName;
	@FindBy(xpath = "//input[@id='pass']")

	public WebElement passWord;
	@FindBy(xpath = "//button[@type='submit']")

	public WebElement logIn;

	public LoginPageObject() {

		PageFactory.initElements(RunParallel.driver.get(), this);
	}

}
