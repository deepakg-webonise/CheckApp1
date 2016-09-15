package com.Appdirect.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	public WebDriver driver;

	public LogInPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	private WebElement btnSignUp;

	public SignUPPage ClickSignUp(){
		
		btnSignUp.click();
		return new SignUPPage(driver);
	}
	
}
