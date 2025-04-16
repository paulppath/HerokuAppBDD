package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtil;

public class CalendarPage
{
    public CalendarPage()
    {
        PageFactory.initElements(BrowserUtil.getDriver(), this);
    }

    @FindBy(xpath="//div/h1")
    public WebElement dateDisplayed;
    @FindBy(xpath="//button/abbr[contains(@aria-label,\"19\")]")
    public WebElement date19;

}
