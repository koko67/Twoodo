package steps.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.BrowserManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ui.PageTransporter;

/**
 * Created by silvia valencia on 11/10/2015.
 */
public class GlobalHooks {

    WebDriver webDriver = BrowserManager.getInstance().getDriver();
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        }
    }
//    @Before(order=1)
//    public void setUp() throws Exception {
//        if(!started) {
//
//            PageTransporter.getInstance().navigateToLoginPage();
//            started = true;
//        }
//    }
}
