package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserUtil
{
    // Singleton class -> private constructor
    private BrowserUtil(){}
    // Singleton class -> single static instance
    private static WebDriver driver;
    public static WebDriver getDriver()
    {
        if (driver == null)
        {
            initializeDriver("chrome");
        }
        return driver;
    }
    public static void closeDriver()
    {
        driver.close();
        driver = null;
    }
    public static void quitDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
    private static void initializeDriver(String browser)
    {
        switch(browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigReader.readProperty("config.properties", "url"));
    }
    public static void switchToNewWindow()
    {
        for(String eachId : driver.getWindowHandles())
        {
            driver.switchTo().window(driver.getWindowHandle()); // necessary?
            if(!eachId.equals(driver.getWindowHandle()))
                driver.switchTo().window(eachId);
        }
    }
    public static void highlightElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 2; i++)
        {
            try {
                if (i % 2 == 0) {
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black;" +
                            "border: 3px solid red; background: yellow");
                    // TODO -> apply report screenshot here
                    sleep(150);
                    CucumberLogUtils.logInfo("WebElement" + element.toString(), true);
                } else {
                    sleep(600);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void waitForClickAbility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void sleep (int milliSec)
    {
        try{
            Thread.sleep(milliSec);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public static void scrollIntoView(WebElement element)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void sendKeys(WebElement element, String inputText)
    {

        // TODO: Apply report -> log info ("Entered the text ", element);
        CucumberLogUtils.logInfo("Entered the text ", true);
        waitForClickAbility(element);
        scrollIntoView(element);
        element.sendKeys(inputText);
        highlightElement(element);
    }
    public static String getText (WebElement element)
    {
        // TODO: Apply report -> logInfo("Retrieved TEXT: ", element);
        waitForClickAbility(element);
        scrollIntoView(element);
        highlightElement(element);
        return element.getText();
    }
    public static void click(WebElement element)
    {
        //TODO : Apply report -> logInfo("Clicked on a BUTTON: ", element);
        waitForClickAbility(element);
        scrollIntoView(element);
        highlightElement(element);
        element.click();
    }
    public static void assertEquals(String actual, String expected)
    {
        // TODO : Apply report -> logInfo("Expected: " + expected);
        // TODO : Apply report -> logInfo("Actual: " + actual);
        CucumberLogUtils.logInfo("Expected: " + expected, false);
        CucumberLogUtils.logInfo("Actual: " + actual, false);
        Assert.assertEquals(actual, expected);
    }
    public static void assertFalse(boolean result)
    {
        // TODO : Apply report -> logInfo("Expected: + result);
        CucumberLogUtils.logInfo("Expected: " + result, false);
        Assert.assertFalse(result);
    }
    public static void assertTrue(boolean result)
    {
        // TODO : Apply report -> logInfo("Expected: + result);
        CucumberLogUtils.logInfo("Expected: " + result, false);
        Assert.assertTrue(result);
    }
    public static void isDisplayed(WebElement element)
    {
        //TODO: Apply report -> logInfo("Displayed at: ", element);
        scrollIntoView(element);
        waitForElementVisibility(element);
        highlightElement(element);
        Assert.assertTrue(element.isDisplayed());
    }
    public static boolean isEnable(WebElement element)
    {
        //TODO: Apply report -> logInfo("Is enable at: ", element);
        waitForElementVisibility(element);
        scrollIntoView(element);
        highlightElement(element);
        return element.isEnabled();
    }
    public static boolean isDisable(WebElement element)
    {
        //TODO: Apply report -> logInfo("Is disable at: ", element);
        scrollIntoView(element);
        highlightElement(element);
        if(element.isEnabled())
            return false;
        else
            return true;
    }
    public static void selectByVisibleText(WebElement element, String text)
    {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

}
