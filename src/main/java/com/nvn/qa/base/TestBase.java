package com.nvn.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.nvn.qa.util.TestUtil;
import com.nvn.qa.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	FileInputStream ip;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	
	public TestBase() {
		
		prop=new Properties();
		try {
			ip=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\AutomationNaveenTest\\src\\main\\java\\com\\nvn\\qa\\config\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Sumit Stuff\\se2\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	
	
	
	
	
}
