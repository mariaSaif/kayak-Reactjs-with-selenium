package com.kayak.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kayak.qa.base.TestBase;
import com.kayak.qa.pages.FlightsPage;
import com.kayak.qa.pages.HotelsPage;

public class FlightsPageTest extends TestBase{
	FlightsPage flightsPage;
	HotelsPage hotelsPage;
	public FlightsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		flightsPage = new FlightsPage();	
	}

	@Test(priority=1)
	public void kayakLogoImageTest(){
		boolean flag = flightsPage.validatekayakImage();
		Assert.assertTrue(flag);
	}

	@Test(priority=2)
	public void navigateToHotelsLinkTest(){	
		hotelsPage = flightsPage.clickOnHotelsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
	
	
	

}
