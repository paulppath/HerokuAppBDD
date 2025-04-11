package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtil;

import java.util.List;

public class HomePage
{
    public HomePage(){
        PageFactory.initElements(BrowserUtil.getDriver(),this);
    }
    @FindBy(xpath="//div/img[contains(@src,\'selenium\') and contains(@src,\'.png\')]")
    public WebElement seleniumImage;

    @FindBy(xpath="//h1[@id='title']")
    public WebElement seleniumHeader;

    @FindBy(xpath="//a[starts-with(@href,\"http\")]")
    public List<WebElement> links;
    @FindBy(xpath="//a[text()='Inputs']")
    public WebElement inputPageNavBtn;
    @FindBy(xpath="//nav/a[text()='Calendar']")
    public WebElement calendarNavBtn;

}
