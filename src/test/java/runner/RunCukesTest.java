package runner;

import framework.BrowserManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import common.CommonMethods;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features"},
        monochrome = true)
public class RunCukesTest  extends AbstractTestNGCucumberTests {
    final static Logger logger = Logger.getLogger(RunCukesTest.class);
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before all the execution");
        CommonMethods.goToLoginPage();
    }

    @AfterTest
    public void afterExecution() {
        try {
            if(CommonMethods.isAccountLogged()){
//                CommonMethods.logout();
                BrowserManager.getInstance().getDriver().quit();
            }
            BrowserManager.getInstance().getDriver().quit();
        } catch (Exception e) {
            logger.error("Error exiting from driver", e);
        }
    }
}
