package com.kayak.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kayak.qa.base.TestBase;
import com.kayak.qa.pages.FlightsPage;
import com.kayak.qa.pages.HotelsPage;

public class HotelsPageTest extends TestBase{
	FlightsPage flightsPage;
	HotelsPage hotelsPage;
	public HotelsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		hotelsPage = new HotelsPage();
		flightsPage = new FlightsPage();
	}
	@Test(priority=1)
	public void verifyHostelsPageLabel1(){
		hotelsPage=	flightsPage.clickOnHotelsLink();
		boolean flag = hotelsPage.verifyhotelsPagelabel1();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=2)
	public void verifyOriginfieldPrasent(){
	 hotelsPage = flightsPage.clickOnHotelsLink();
		boolean flag = hotelsPage.verifyhotelsPagelabel2();
		Assert.assertTrue(flag);
		
	}
	
	
	@Test(priority=3)
	public void verifyStartDatefieldPrasent(){
	hotelsPage = flightsPage.clickOnHotelsLink();
	 String Startdate2 =hotelsPage.getStartDate();
	 System.out.println(Startdate2);
     String startDate =   hotelsPage.verifyStartDateText();	
		 System.out.println(startDate);
		Assert.assertEquals(startDate, Startdate2);
		
	}
	
	@Test(priority=4)
	public void verifyEndDatefieldPrasent(){
	hotelsPage = flightsPage.clickOnHotelsLink();
	 String Startdate2 =hotelsPage.getEndDate();
	 System.out.println(Startdate2);
     String startDate =   hotelsPage.verifyEndDateText();	
		 System.out.println(startDate);
		Assert.assertEquals(startDate, Startdate2);
		
	}
	
	
	@Test(priority=5)
	public void searchHotelsDetailsTest() throws InterruptedException{
	hotelsPage = flightsPage.clickOnHotelsLink();
	hotelsPage.clickOverSearchField();
	hotelsPage.selectValueFromOriginDropDown();
      String originFiledtext =  hotelsPage.getOriginFieldText();
      System.out.println(originFiledtext);
      Assert.assertEquals(originFiledtext, "Barcelona, Spain - Barcelona-El Prat");
      hotelsPage.clickStartDateField();
  	  Thread.sleep(1000);
  	  hotelsPage.selectEndDate();
    	hotelsPage.clickOverSearchbtn();	
  	 Thread.sleep(2000);
	}
		
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
