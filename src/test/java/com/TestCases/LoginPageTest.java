package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage LoginPage;					//create an object with the class to communicate what is Login page.
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
		initil();
		LoginPage = new LoginPage();
	}
	
	@Test (priority =2)
	public void VerifyLoginPage() {
		LoginPage.VerifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@Test (priority =0)
	public void VerifyLogoofThePage () {
		boolean logo = LoginPage.verifyLogo();
		Assert.assertTrue(logo);                 //Assert is for validation
	}
	
	@Test (priority =1)
	public void VerifyTitleofThePage() {
		String title = LoginPage.VerifyTItle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing");      //getting path from web page logo
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
}
	

