package com.kayak.qa.pages;

import com.kayak.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class HotelsPage extends TestBase {

    //Page Factory - OR:
    @FindBy(xpath = "//div[@class='keel-grid v-c-p ']/div[@class='col _irH']/div[@class='keel-grid ']/div[contains(text(),'1 room, 2 guests')]")
    WebElement hotelsPagelabel1;

    @FindBy(xpath = "//div[text()='Enter a city, hotel, airport, address or landmark']")
    WebElement hotelsPagelabel2;

    @FindBy(xpath = "//div[(@data-placeholder='Check-in')]")
    WebElement startDatelabel3;

    @FindBy(xpath = "//div[(@data-placeholder='Check-out')]")
    WebElement endDatelabel4;

    @FindBy(xpath = "//div[contains(@data-placeholder,'Enter a city, hotel, airport, address or landmark')]/div")
    WebElement inputlabel5;

    @FindBy(xpath = "//div[contains(@id,'-next') and contains(@aria-label,'Next month')]")
    WebElement startdatelabel6;
    @FindBy(xpath = "//button[contains(@id,'-submit') and contains(@title,'Search hotels')]")
    WebElement searchbtton;

    //Initializing the Page Objects:
    public HotelsPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public boolean verifyhotelsPagelabel1() {
        return hotelsPagelabel1.isDisplayed();
    }


    public boolean verifyhotelsPagelabel2() {
        return hotelsPagelabel2.isDisplayed();
    }

    public String verifyStartDateText() {
        return startDatelabel3.getText();

    }

    public String verifyEndDateText() {
        return endDatelabel4.getText();

    }

    public String getOriginFieldText() {
        return inputlabel5.getText();

    }

    public void clickOverSearchField() {
        hotelsPagelabel2.click();
    }

    public void clickStartDateField() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(@id,'-dateRangeInput-display-start') and contains(@aria-label,'Check-in date input')][1]")));
        actions.click();
        actions.build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'_ia1 _iBD _iai')]/div[contains(@id,'-checkIn-input')][1]")));
        actions.click();
        actions.build().perform();
        Thread.sleep(1000);
        WebElement input = driver.findElement(By.xpath("//div[contains(@class,'_ia1 _iBD _iai')]/div[contains(@id,'-checkIn-input')][1]"));
        input.clear();
        Thread.sleep(1000);
        input.sendKeys("03/28/2020");
        input.sendKeys(Keys.TAB);
        input.sendKeys(Keys.ENTER);


    }

    public void selectEndDate() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(@id,'-dateRangeInput-display-end') and contains(@aria-label,'Check-out date input')][1]")));
        actions.click();
        actions.build().perform();

        actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'_ia1 _iBD _iai')]/div[contains(@id,'-checkOut-input')][1]")));
        actions.click();
        Thread.sleep(1000);
        WebElement input = driver.findElement(By.xpath("//div[contains(@class,'_ia1 _iBD _iai')]/div[contains(@id,'-checkOut-input')][1]"));
        input.clear();
        Thread.sleep(1000);
        input.sendKeys("03/29/2020");
        //input.sendKeys(Keys.TAB);
        input.sendKeys(Keys.ENTER);
    }

    public void clickOverSearchbtn() {
        searchbtton.click();
    }

    public void selectValueFromOriginDropDown() {
        String[] matches = new String[]{"Barcelona, Spain - Barcelona-El Prat", "Barcelona, Spain", "BCN"};
        //How we can handel dropdowns: boot StrapDownloads-Ul/li/div values
        WebElement pDropDown = driver.findElement(By.xpath("//input[@aria-label='Destination input']"));
        pDropDown.sendKeys(" BCN ");
        List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@role,'listbox')]/li/div/following-sibling::div"));
        System.out.println(list.size()); // it will return the size of the list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            for (String s : matches) {
                if (list.get(i).getText().contains(s)) {
                    list.get(i).click();
                    System.out.println("Value slected");
                    break;
                }
            }
        }
    }

    public String getStartDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE M/d");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        String newDate = sdf.format(c.getTime());
        System.out.println("Date Incremented by One: " + newDate);
        return newDate;
    }


    public String getEndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE M/d");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 2);
        String newDate = sdf.format(c.getTime());
        System.out.println("Date Incremented by One: " + newDate);
        return newDate;
    }


}
