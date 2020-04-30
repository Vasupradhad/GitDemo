package test;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;


public class validateTitle extends base {
	 private Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {

		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");

	}
	
	@Test
	public void basepageNavigation() throws IOException {

		
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
		log.info("Successfully validated text message");

	
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
	

}
