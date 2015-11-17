package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by jorgeavila on 11/10/2015.
 */
public class BrowserManager {
    public WebDriver driver;
    public WebDriverWait wait;

    public BrowserManager() {
        init();
    }

    public void init(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60, 1000);
    }

    private static BrowserManager INSTANCE;

    public static BrowserManager getInstance(){
        if (INSTANCE == null)
        {
            INSTANCE = new BrowserManager();
        }
        return INSTANCE;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
