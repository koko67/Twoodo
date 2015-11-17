package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class PostComponentPage extends BasePageObject{

    private static String SEND_BUTTON_NAME = "Send";

    @FindBy(xpath = "//div[@class='company']/div[@class='dropdown']/button")
    protected WebElement headerDropDown;

    @FindBy(xpath = "//form/div[@class='right']/div[1]/div[1]/textarea")
    protected WebElement postTextArea;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(), 'Send')]")
    protected WebElement sendButton;

    @FindBy(xpath = "//div[@class='btn-group']/a[@title='Make it a task' and contains(text(), 'Task')]")
    protected WebElement taskButton;

    @FindBy(xpath = "/html/body/div[2]/top-header-bar/div[1]/div/button/img")
    protected WebElement userProfile;

    @FindBy(id = "logout")
    protected WebElement buttonLogout;


    public void clickHeadeDropDown(){
        headerDropDown.click();
    }

    public PostComponentPage typeTextArea(String content){
        postTextArea.sendKeys(content);
        return this;
    }

    public ContainerPage clickSend(){
        sendButton.click();
        return new ContainerPage();
    }

    public LoginPage logout(){
        buttonLogout.click();
        return new LoginPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(headerDropDown));
    }
}
