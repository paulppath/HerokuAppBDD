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


    @FindBy(xpath="//input[@id='message']")
    public WebElement messageInputBox;
    @FindBy(xpath="//button[@name='button1']")
    public WebElement showMessageBtn;
    @FindBy(xpath="//span[@name='message1']")
    public WebElement messageOutput;
    @FindBy(xpath="//input[@id='a']")
    public WebElement inputA;
    @FindBy(xpath="//input[@id='b']")
    public WebElement inputB;
    @FindBy(xpath="//button[@name='button2']")
    public WebElement getTotalBtn;
    @FindBy(xpath="//span[@name='answer2']")
    public WebElement total;

}
