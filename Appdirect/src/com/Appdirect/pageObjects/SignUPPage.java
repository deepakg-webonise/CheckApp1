package com.Appdirect.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUPPage {

	public WebDriver driver;

	public SignUPPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "emailAddress")
	private WebElement txtEmail;

	@FindBy(name = "userSignupButton")
	private WebElement btnSignUp;

	@FindBy(xpath = "//h3[contains(text(),'Thanks for registering.')]")
	private WebElement txtRegistration;
	
	@FindBy(xpath="//*[@class='adb-form user-signup']/fieldset/div[2]/div/span//p")
	private WebElement txtErrorMessage;
	
	@FindBy(xpath="//*[@class='adb-form user-signup']/fieldset/div[2]/div/span//a")
	private WebElement closeErrorMessage;
	
	@FindBy(xpath="//p[@id='signupLoginLink']//a[contains(text(),'Log In')]")
	private WebElement linkLogIn;
	
	@FindBy(xpath="//*[@class='adb-form user-signup']/fieldset/div[2]/div/span/div[@class='adb-local_alert adb-local_alert__error']")
	private List<WebElement> ErrorAlert;
	
	@FindBy(xpath="//h3[contains(text(),'Thanks for registering.')]")
	private List<WebElement> RegistrationPage;
	
	public List<WebElement> getRegistrationpage(){
		return RegistrationPage;
	}

	public List<WebElement> getErrorAlert(){
		return ErrorAlert;
	}
	
	public void enterEmail(String text) {
		txtEmail.sendKeys(text);
	}

	public void clearEmail() {
		txtEmail.clear();
	}

	public void ClickSignUp() {
		btnSignUp.click();
	}
	
	public String getErrorMessage(){
		return txtErrorMessage.getText();
	}
	
	public void closeError(){
		closeErrorMessage.click();
	}
	
	public void clickLogIn() {
		linkLogIn.click();
	}
}
