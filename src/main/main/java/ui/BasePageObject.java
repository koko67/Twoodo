package ui;

import framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jorgeavila on 11/12/2015.
 */
public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Initializes the web driver, wait and web elements
     */
    public BasePageObject() {
        this.driver = BrowserManager.getInstance().getDriver();
        this.wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public abstract void waitUntilPageObjectIsLoaded();
}
