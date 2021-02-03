package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.TestUtil.TestUtil;

public class TestBase {
	private static final long TestUtil = 0;
	// prop is just an object.
	
	public static Properties prop; // if you put static then it can use for globally. Otherwise it would
	public static WebDriver driver; // be only for this class.

	public TestBase() {

		prop = new Properties();

		try {
			FileInputStream fle = new FileInputStream(
					"C:\\Users\\nafis\\eclipse-workspace\\dell.qa\\src\\main\\java\\com\\Config\\Config.properties");
			// get this path from config.properties
			prop.load(fle); // doing try catch here from right click surrounded by try catch
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // load is coming from properties
	}

	public static void initil() {
		
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","\\C:\\Driver\\chromedriver.exe\\");
		    driver = new ChromeDriver();
		}
			
		else if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","\\C:\\Driver\\chromedriver.exe\\");
		    driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies ();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
		
	}

}
