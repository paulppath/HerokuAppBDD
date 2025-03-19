package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtil;

public class InputPage
{
    public InputPage(){
        PageFactory.initElements(BrowserUtil.getDriver(),this);
    }

    @FindBy(xpath="//a[text()='Inputs']")
    public WebElement inputPageNavBtn;
    @FindBy(xpath="//input[@id='message']")
    public WebElement messageInputBox;
    @FindBy(xpath="//button[@name='button1']")
    public WebElement showMessageBtn;
    @FindBy(xpath="//span[@name='message1']")
    public WebElement messageOutput;

}
