package com.Appdirect.TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Appdirect.constants.Constants;
import com.Appdirect.pageObjects.HomePage;
import com.Appdirect.pageObjects.LogInPage;
import com.Appdirect.pageObjects.SignUPPage;
import com.Appdirect.utility.CommonUtility;

public class TC_SignUp extends CommonUtility {

	public WebDriver driver;
	public LogInPage loginPage = null;
	public HomePage homepage = null;
	public SignUPPage signuppage = null;
	FileInputStream fis = null;

	@BeforeTest
	public void setup() {

		init();
		driver = loadWebBrowser();
		homepage = new HomePage(driver);
		loginPage = new LogInPage(driver);
		signuppage = new SignUPPage(driver);
	}

	@Test
	public void InValidEmail() throws BiffException, IOException,
			RowsExceededException, WriteException {

		homepage.ClickLogin();
		loginPage.ClickSignUp();

		Sheet sheet = readExcel(Constants.USER_DIR + Constants.TESTDATA_PATH,
				Constants.INPUT_FILE, "TestInputData");

		for (int i = 1; i < sheet.getRows(); i++) {

			signuppage.clearEmail();
			signuppage.enterEmail(sheet.getCell(0, i).getContents());
			signuppage.ClickSignUp();

			if (signuppage.getErrorAlert().size() > 0) {
				if (signuppage.getErrorMessage().equals(Constants.Alreadyexist)) {
					System.out.println(Constants.Valid + " : "
							+ sheet.getCell(0, i).getContents()
							+ ": But Already Exist");
					signuppage.closeError();
				} else {
					System.out.println(Constants.InValid + " : "
							+ sheet.getCell(0, i).getContents() + " : "
							+ signuppage.getErrorMessage());
					signuppage.closeError();
				}
			} else {
				if (signuppage.getRegistrationpage().size() > 0) {
					System.out.println(Constants.Valid + " : "
							+ sheet.getCell(0, i).getContents()
							+ ": Registration Successfull");
					signuppage.clickLogIn();
					loginPage.ClickSignUp();
				}
				if (signuppage.getRegistrationpage().size() == 0) {
					System.out.println(Constants.InValid + " : "
							+ sheet.getCell(0, i).getContents());
				}
			}
		}
	}

	@AfterTest
	public void teardown() throws IOException, WriteException {
		driver.quit();
	}

}
