package ui;

import framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import ui.pages.ContainerPage;
import ui.pages.LoginPage;

/**
 * Created by jorgeavila on 11/25/2015.
 */
public class PageTransporter {
    private WebDriver driver = BrowserManager.getInstance().getDriver();
    private static String homeUrl = "https://www.twoodo.com/site/feed";
    private static String loginUrl = "https://www.twoodo.com/login";
    private static PageTransporter instance;

    public static PageTransporter getInstance(){
        if(instance==null){
            instance =  new PageTransporter();
        }
        return instance;
    }

    public ContainerPage goToMain(){
        driver.get(homeUrl);
        return new ContainerPage();
    }
    public LoginPage goToLoginPage(){
        driver.get(loginUrl);
        return new LoginPage();
    }
    public String getHomeUrl(){
        return homeUrl;
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
