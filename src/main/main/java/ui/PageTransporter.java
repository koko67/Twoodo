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
    private static String homeUrl;
    private static String loginUrl;
    private static PageTransporter instance;

    private PageTransporter(){
        homeUrl = "https://www.twoodo.com/site/feed";
        loginUrl = "https://www.twoodo.com/login";
    }

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
