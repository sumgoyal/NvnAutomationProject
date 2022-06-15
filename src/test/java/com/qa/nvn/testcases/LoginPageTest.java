package com.qa.nvn.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nvn.qa.base.TestBase;
import com.nvn.qa.pages.FrontPage;
import com.nvn.qa.pages.HomePage;
import com.nvn.qa.pages.LoginPage;
import com.nvn.qa.pages.RegisterPage;

public class LoginPageTest extends TestBase {

	FrontPage frontPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		frontPage=new FrontPage();
		frontPage.loginp();
		
		
		
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle() {
		String loginTitle=loginPage.loginPageTitle();
		Assert.assertEquals(loginTitle, "Account Login", "Wrong title");
	}
	
	@Test(priority=3)
	public void clickOnContinue() {
	registerPage=loginPage.continueBtn();
	Assert.assertEquals(registerPage, registerPage);
	}
	@Test(priority=2)
	public void clickOnLoginBtn() {
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
}
