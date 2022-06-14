package com.qa.nvn.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nvn.qa.base.TestBase;
import com.nvn.qa.pages.FrontPage;
import com.nvn.qa.pages.LoginPage;
import com.nvn.qa.pages.RegisterPage;


public class FrontPageTest extends TestBase {

	FrontPage frontPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	
	public FrontPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		frontPage=new FrontPage();
	}
	
	@Test
	public void verifyTitle_FrontPage() {

		String title=frontPage.verifyTitle();
		Assert.assertEquals(title, "Your Store");
	}
	
	@Test
	public void verifyLogoTest() {
		boolean flag=frontPage.verifyImage();
		Assert.assertEquals(flag, true);
	}
	
	@Test
	public void validateClickOnLogin() {
		loginPage=frontPage.loginp();
		Assert.assertEquals(loginPage, loginPage);
	}
	
	@Test
	public void validateClickOnRegister() {
		registerPage=frontPage.register();
		Assert.assertEquals(registerPage, registerPage);

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
