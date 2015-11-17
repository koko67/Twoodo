package ui.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/11/2015.
 */
public class LoginPage extends BasePageObject {

    @FindBy(id = "login")
    @CacheLookup
    protected WebElement username;
    @FindBy(id = "password")
    @CacheLookup
    protected WebElement password;
    @FindBy(xpath = "/html/body/div[1]/form[1]/button")
    protected WebElement loginButton;

    public LoginPage typeUserName(String username){
        this.username.clear();
        this.username.sendKeys(username);
        return this;
    }

    public LoginPage typeUserPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public ContainerPage clickLoginButtonSuccessful(){
        loginButton.click();
        return new ContainerPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}
