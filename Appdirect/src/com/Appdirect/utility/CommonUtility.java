package com.Appdirect.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Appdirect.constants.Constants;

public class CommonUtility {

	public static Properties props;
	public static WebDriver driver;

	// To load the properties file
	public void init() {
		File file = null;
		FileInputStream fis = null;

		try {
			props = new Properties();
			// path to Parameters.properties file
			file = new File(Constants.USER_DIR + Constants.CONFIG_PATH);
			fis = new FileInputStream(file);
			props.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/*
	 * Load web browser based on configuration
	 */

	public WebDriver loadWebBrowser() {
		
			driver = new FirefoxDriver();
			driver.get(props.getProperty("applicationUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}

	public Sheet readExcel(String filePath, String fileName, String sheetName)
			throws BiffException, IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = Workbook.getWorkbook(inputStream);
		Sheet sh = workbook.getSheet(sheetName);
		return sh;
	}

}
