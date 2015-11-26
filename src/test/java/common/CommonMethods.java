package common;

import framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import ui.PageTransporter;

/**
 * Created by jorge avila on 11/9/2015.
 */
public class CommonMethods {

    public static boolean isAccountLogged(){
        WebDriver driver = BrowserManager.getInstance().getDriver();
        if(driver.getCurrentUrl().contains("twoodo.com/site/feed")) {
            return true;
        }
        return false;
    }
//    public static void logout(){
//        PageTransporter.getInstance().goToMain().clickDropDownTeam().logout();
//    }

    public static void goToLoginPage(){
        PageTransporter.getInstance().goToLoginPage();
    }

    public static boolean isBrowserInLoginPage() {
        WebDriver driver = BrowserManager.getInstance().getDriver();
        if(driver.getCurrentUrl().contains("twoodo.com/login")){
            return true;
        }
        return false;
    }
}