package com.TestPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {

	//private static final WebElement SignInButton = null;
	// page Factory or container
	// we will keep all the locator and method in this class
	
	
	@FindBy(xpath = "//input[@id=\"username\"]")					//cant write FInd by
	WebElement Username;
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement Password;
	@FindBy(xpath ="//button[@type=\"submit\"]")
	WebElement SingInButton;
	@FindBy(xpath = "//img[@class=\"logo\"]")
	WebElement Logo;
	@FindBy(xpath = "//div[@class=\"alert alert-danger fade in\"]")
	WebElement ErrorMessage;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	
		public void VerifyLogin(String Un, String pw) {						// ALL Action
			
		Username.sendKeys(Un);
		Password.sendKeys(pw);
		SingInButton.click();
		}																	// return new HomePage();

	public String VerifyTItle() {
		return driver.getTitle();
	}

	public boolean verifyLogo() {
		return Logo.isDisplayed();
	}
	

}
