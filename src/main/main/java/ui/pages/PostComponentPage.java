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
    WebElement headerDropDown;

    //@FindBy(xpath = "//html/body/div[2]/div[1]/div/command-box/form/div[2]/div[1]/div[1]/textarea")
    @FindBy(xpath = "//div[@id='main-cb']//div/pre/span")
    WebElement postTextArea;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(), 'Send')]")
    WebElement sendButton;

    @FindBy(xpath = "//div[@class='btn-group']/a[@title='Make it a task' and contains(text(), 'Task')]")
    WebElement taskButton;

    @FindBy(xpath = "//html/body/div[2]/top-header-bar/div[1]/div/button/img")
    WebElement userProfile;

    @FindBy(id = "logout")
    WebElement buttonLogout;

    @FindBy(id = "main-cb")
    WebElement centerContainer;

    public PostComponentPage(){
        //this.waitUntilPageObjectIsLoaded();
    }


    public void clickHeadeDropDown(){
        headerDropDown.click();
    }

    public PostComponentPage typeTextArea(String content){
        System.out.println("WAITING.....");
        wait.until(ExpectedConditions.visibilityOf(userProfile));
        System.out.println(postTextArea + "-----");
        System.out.println("WAITING#####");

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
        System.out.println("###$###" + centerContainer);
        System.out.println("###$###" + centerContainer);
        System.out.println("###$###" + centerContainer);
        System.out.println("###$###" + centerContainer);
        wait.until(ExpectedConditions.visibilityOf(centerContainer));
    }

    public boolean existsUserName(String username) {
        return userProfile.getAttribute("alt").equals(username);
    }
}
