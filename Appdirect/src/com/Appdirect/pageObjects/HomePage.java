package com.Appdirect.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	private WebElement btnLogIn;
	
	public LogInPage ClickLogin(){
		
		btnLogIn.click();
		return new LogInPage(driver);
	}
	

}
