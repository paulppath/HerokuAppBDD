package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CalendarPage;
import utils.BrowserUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarSteps
{
    CalendarPage page;
    public CalendarSteps(){
        page = new CalendarPage();
    }

    @Then("Verify that the date is displayed as {string} date")
    public void verify_that_the_date_is_displayed_as_date(String date) {
        String actualDate = "";
        switch(date.toLowerCase())
        {
            case ("today"):
                String today = todayDate();
                System.out.println(today);
                actualDate = page.dateDisplayed.getText();
                actualDate = refineDate(actualDate);
                System.out.println(actualDate);
                BrowserUtil.assertEquals(actualDate, today);
                break;
            case ("4/19/2025"):
                actualDate = page.dateDisplayed.getText();
                BrowserUtil.assertEquals(actualDate, date);
                break;
            default:
                Assert.fail("Invalid input!");
        }

    }
    @When("user click date {string} in the calendar")
    public void user_click_date_in_the_calendar(String date) {
        switch (date.toLowerCase())
        {
            case "19":
                BrowserUtil.click(page.date19);
                break;
            default:
                Assert.fail("Invalid date!");
        }
    }
    public static String refineDate(String date)
    {
        String[] strs = date.split("/");
        if (strs[0].length() < 2) {
            strs[0] = "0" + strs[0];
        }
        if (strs[1].length() < 2) {
            strs[1] = "0" + strs[1];
        }
        return strs[0] + "/" + strs[1] + "/" + strs[2];
    }
    public static String todayDate()
    {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate todayDate = LocalDate.now();
        String date = todayDate.format(f);
        return date;
    }

}
