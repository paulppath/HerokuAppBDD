package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.InputPage;
import utils.BrowserUtil;

public class InputSteps
{
    InputPage page;
    public InputSteps(){
        page = new InputPage();
    }

    @Given("I open {string} page")
    public void i_open_page(String pages)
    {
        switch(pages.toLowerCase())
        {
            case("input"):
                BrowserUtil.click(page.inputPageNavBtn);
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
            default:
                Assert.fail("Invalid texts!");
        }
    }
}
