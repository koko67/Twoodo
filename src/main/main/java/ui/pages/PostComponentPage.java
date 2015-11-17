package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class PostComponentPage {

    private static String SEND_BUTTON_NAME = "Send";

    @FindBy(xpath = "//div[@class='company']/div[@class='dropdown']/button")
    protected WebElement headerDropDown;

    @FindBy(xpath = "//form[@id='cb-164d3883-6886-4bad-8733-49aa0fa5df1d']/div[@class='right']/div/div/textarea[@wrap='off']")
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

    public PostComponentPage clickSend(){
        sendButton.click();
        return this;
    }

    public LoginPage logout(){
        buttonLogout.click();
        return new LoginPage();
    }
}
