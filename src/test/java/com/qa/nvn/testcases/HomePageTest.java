package com.qa.nvn.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nvn.qa.base.TestBase;
import com.nvn.qa.pages.FrontPage;
import com.nvn.qa.pages.HomePage;
import com.nvn.qa.pages.LoginPage;
import com.nvn.qa.pages.MonitorsPage;

public class HomePageTest extends TestBase {

	FrontPage frontPage;
	LoginPage loginPage;
	HomePage homePage;
	MonitorsPage monitorsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		frontPage=new FrontPage();
		loginPage=new LoginPage();
		homePage=new HomePage();
		frontPage.loginp();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyhomePageTitle() {
		String title=homePage.homePageTitle();
		Assert.assertEquals(title, "My Account","Incorrect HomePage");
	}
	
	@Test
	public void verifySearchFunction() {
		homePage.searchItem();
	}
	
	@Test
	public void verifyMonitors() {
		homePage.verifyComponents();
		Assert.assertEquals(monitorsPage, monitorsPage);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
