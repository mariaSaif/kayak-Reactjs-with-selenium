package stepDefinitions;

import com.kayak.qa.base.TestBase;
import com.kayak.qa.pages.FlightsPage;
import com.kayak.qa.pages.HotelsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.testng.Assert;


public class FlightsPageTestStepsDefs extends TestBase {
    FlightsPage flightsPage ;
    HotelsPage hotelsPage ;


    @Before
    public void setup() {
        TestBase.initialization();
    }

    @Given("^user opens browser and land on website$")
    public void user_opens_browser() throws Throwable {
        flightsPage = new FlightsPage();
        boolean flag = flightsPage.validatekayakImage();
        Assert.assertTrue(flag);
    }


    @When("^user Navigates to Hotels page$")
    public void user_Navigates_to_Hotels_page() throws Throwable {
        hotelsPage = new HotelsPage();
        hotelsPage = flightsPage.clickOnHotelsLink();

    }

    @Then("^user verify if Origin field is present$")
    public void user_verify_if_Origin_field_is_present() throws Throwable {
        hotelsPage = new HotelsPage();
        hotelsPage=	flightsPage.clickOnHotelsLink();
        boolean flag = hotelsPage.verifyhotelsPagelabel1();
        Assert.assertTrue(flag);
    }

    @Then("^user verify if Start Date & End Date fields are present$")
    public void user_verify_if_Start_Date_End_Date_fields_are_present() throws Throwable {
        hotelsPage = flightsPage.clickOnHotelsLink();
        String Startdate2 =hotelsPage.getStartDate();
        System.out.println(Startdate2);
        String startDate =   hotelsPage.verifyStartDateText();
        System.out.println(startDate);
        Assert.assertEquals(startDate, Startdate2);
        //end date verification
        hotelsPage = flightsPage.clickOnHotelsLink();
        String enddate =hotelsPage.getEndDate();
        System.out.println(enddate);
        String enddate2 =   hotelsPage.verifyEndDateText();
        System.out.println(enddate2);
        Assert.assertEquals(enddate, enddate2);
    }

    @Then("^user verify if text '1 room, 2 guests' is present$")
    public void user_verify_if_text_room_guests_is_present() throws Throwable {
        hotelsPage = flightsPage.clickOnHotelsLink();
        boolean flag = hotelsPage.verifyhotelsPagelabel2();
        Assert.assertTrue(flag);
    }

    @Then("^user search Hotels Details$")
    public void user_search_Hotels_details() throws Throwable {
        hotelsPage = flightsPage.clickOnHotelsLink();
        hotelsPage.clickOverSearchField();
        hotelsPage.selectValueFromOriginDropDown();
        String originFiledtext =  hotelsPage.getOriginFieldText();
        System.out.println(originFiledtext);
        Assert.assertEquals(originFiledtext, "Barcelona, Spain - Barcelona-El Prat");
        //select start date
        hotelsPage.clickStartDateField();
        Thread.sleep(1000);
        //select end date
        hotelsPage.selectEndDate();
        hotelsPage.clickOverSearchbtn();
        Thread.sleep(2000);
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}