package com.nvn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nvn.qa.base.TestBase;

public class FrontPage extends TestBase {

	//Page Factory of Front Page
	
	@FindBy(xpath="//img[@title='naveenopencart']")
	WebElement logo;
	
	@FindBy(xpath="/html/body/nav/div/div[2]/ul/li[2]/a")
	WebElement MyAccountBtn;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement RegisterBtn;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement LoginBtn;
	
	
	//initializing ?
	
	public FrontPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyImage() {
		return logo.isDisplayed();
	}
	
	
	public RegisterPage register() {
		MyAccountBtn.click();
		RegisterBtn.click();
		
		return new RegisterPage();
	
	}
	public LoginPage loginp() {
		MyAccountBtn.click();
		LoginBtn.click();
		
		return new LoginPage();
	}
	
	
	
	
	
	
}
