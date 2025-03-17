package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BrowserUtil;
import utils.CucumberLogUtils;

public class Hooks
{
    @Before
    public void setUp(Scenario scenario)
    {
        BrowserUtil.getDriver();
        CucumberLogUtils.initScenario(scenario);
    }
    @After
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            CucumberLogUtils.logFail(scenario.getName(), true);
        }
        BrowserUtil.quitDriver();
    }
}
