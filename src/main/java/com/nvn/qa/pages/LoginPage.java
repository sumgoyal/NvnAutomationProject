package com.nvn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nvn.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	
	//page factory items
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement id;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	WebElement continueBtn;
	
	//Init
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		id.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	public RegisterPage continueBtn() {
		continueBtn.click();
		return new RegisterPage();
		
		
	}
	
	
}
