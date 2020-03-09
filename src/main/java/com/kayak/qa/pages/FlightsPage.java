package com.kayak.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kayak.qa.base.TestBase;

public class FlightsPage extends TestBase{
	
	//Page Factory - OR:
	
	
	@FindBy(xpath="//a[contains(@id,'logo') and contains(@aria-label,'KAYAK logo')]")
	WebElement kayakLogo;
	
	@FindBy(linkText="Hotels")
	WebElement hotelsBtn;
	
	
	
	//Initializing the Page Objects:
	public FlightsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public   HotelsPage clickOnHotelsLink(){
		hotelsBtn.click();
		return new HotelsPage();
	}
	
	public boolean validatekayakImage(){
		return kayakLogo.isDisplayed();
	}
	

  
}
