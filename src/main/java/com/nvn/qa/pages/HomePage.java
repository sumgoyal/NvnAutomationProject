package com.nvn.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nvn.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(name="search")
	WebElement searchBar;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchBtn;
	
	@FindBy(linkText="Components")
	WebElement componentBtn;
	
	@FindBy(xpath="//a[contains(text(),'Monitors')]")
	WebElement monitorsBtn;
	
	//init
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	
	//Actions
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public void searchItem() {
		searchBar.sendKeys(prop.getProperty("item"));
		searchBtn.click();
		
	}
	
	public MonitorsPage verifyComponents() {
		componentBtn.click();
		monitorsBtn.click();
		
		return new MonitorsPage();
	}
	
}
