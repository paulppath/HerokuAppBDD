package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import pages.HomePage;
import pages.InputPage;
import utils.BrowserUtil;

public class InputSteps
{
    InputPage page;
    HomePage homePage;
    public InputSteps(){

        page = new InputPage();
        homePage = new HomePage();
    }

    @Given("I open {string} page")
    public void i_open_page(String pages)
    {
        switch(pages.toLowerCase())
        {
            case("input"):
                BrowserUtil.click(homePage.inputPageNavBtn);
                break;
            case("calendar"):
                BrowserUtil.click(homePage.calendarNavBtn);
                break;
            default:
                Assert.fail("Invalid navigation button");
        }
    }
    @When("User enter text as {string}")
    public void user_enter_text_as(String messages) {
        switch (messages.toLowerCase()) {
            case ("aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiiijjjjjkkkkklllllmmmmmnnnnnooooopppppqqqqqrrrrrssssstttttuuuuuvvvvvwwwwwxxxxxyyyyyzzzzz"):
                BrowserUtil.sendKeys(page.messageInputBox, messages);
                break;
            case("3"):
                BrowserUtil.sendKeys(page.inputA, messages);
                break;
            case("4"):
                BrowserUtil.sendKeys(page.inputB, messages);
                break;
            case("f"):
                BrowserUtil.sendKeys(page.inputA, messages);
                break;
            case("5"):
                BrowserUtil.sendKeys(page.inputA, messages);
                break;
            case("k"):
                BrowserUtil.sendKeys(page.inputB, messages);
                break;
            case("5f"):
                BrowserUtil.sendKeys(page.inputA, messages);
                break;
            case("8k"):
                BrowserUtil.sendKeys(page.inputB, messages);
                break;
            default:
                Assert.fail("Invalid message!");
        }
    }
    @When("click {string} button")
    public void click_button(String btns)
    {
        switch(btns.toLowerCase())
        {
            case("show message"):
                BrowserUtil.click(page.showMessageBtn);
                break;
            case("get total"):
                BrowserUtil.click(page.getTotalBtn);
                break;
            default:
                Assert.fail("Invalid button!");
        }
    }
    @Then("Verify text is displayed as {string}")
    public void verify_text_is_displayed_as(String texts)
    {
        switch(texts.toLowerCase())
        {
            case("aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiiijjjjjkkkkklllllmmmmmnnnnnooooopppppqqqqqrrrrrssssstttttuuuuuvvvvvwwwwwxxxxxyyyyyzzzzz"):
                BrowserUtil.assertEquals(page.messageOutput.getText(), texts);
                break;
            case("7"):
                BrowserUtil.assertEquals(page.total.getText(), texts);
                break;
            default:
                Assert.fail("Invalid texts!");
        }
    }
//    @When("click {string} button with invalid input")
//    public void click_button_with_invalid_input(String buttons) {
//        switch(buttons.toLowerCase())
//        {
//            case("get total"):
//                BrowserUtil.click(page.getTotalBtn);
//
//        }
//    }
    @Then("Verify alert displayed with text {string}")
    public void verify_alert_displayed_with_text(String expectedAlertText) {
        Alert alert = BrowserUtil.getDriver().switchTo().alert();
        String actualAlertText = alert.getText();
        System.out.println(actualAlertText);
        BrowserUtil.assertEquals(actualAlertText, expectedAlertText);
    }
}
