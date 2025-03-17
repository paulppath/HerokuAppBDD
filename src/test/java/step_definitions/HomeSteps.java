package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HomePage;
import utils.BrowserUtil;

public class HomeSteps
{
    HomePage page;
    public HomeSteps(){ page = new HomePage(); }

    @Then("User should see title as {string}")
    public void user_should_see_title_as(String expectedTitle) {
        switch(expectedTitle)
        {
            case("TLA Automation"):
            case("Book Your Free Demo Now - Phptravels"):
            case("demoaut.com - demoaut Resources and Information."):
            case("The Internet"):
            case("InMotion Hosting"):
            case("practiceselenium.com - practiceselenium Resources and Information."):
            case("Swag Labs"):
            case("Typescript React Shopping cart"):
                String actualTitle = BrowserUtil.getDriver().getTitle();
                BrowserUtil.assertEquals(actualTitle, expectedTitle);
                System.out.println(actualTitle);
                break;
            default:
                Assert.fail("Invalid expectedTitle");
        }

    }
    @Given("User click the {string} to open new window")
    public void user_click_the_to_open_new_window(String footerLinks) {
        switch(footerLinks.toLowerCase())
        {
            case("php travels"):
            case("mercury tours"):
            case("internet"):
            case("e-commerce"):
            case("passion tea company"):
            case("saucedemo"):
            case("shopping cart"):
                BrowserUtil.click(BrowserUtil.getDriver().findElement(By.xpath("//a[text()='" + footerLinks + "']")));
                BrowserUtil.switchToNewWindow();
        }

    }

    @Then("User should see Header as {string}")
    public void userShouldSeeHeaderAs(String header) {
        String actualHeader = page.seleniumHeader.getText();
        BrowserUtil.assertEquals(actualHeader, header);
    }
}
