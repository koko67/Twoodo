package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

import java.util.concurrent.TimeUnit;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class PostComponentPage extends BasePageObject{

    private static String SEND_BUTTON_NAME = "Send";



    //@FindBy(xpath = "//html/body/div[2]/div[1]/div/command-box/form/div[2]/div[1]/div[1]/textarea")
    //@FindBy(xpath = "//div[@id='main-container']/div[@class='center-container']/div[@id='main-cb']//command-box/form/div[@class='right']/div/div/textarea[@wrap='off']")

    WebElement postTextArea;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(), 'Send')]")
    WebElement sendButton;

    @FindBy(xpath = "//div[@class='btn-group']/a[@title='Make it a task' and contains(text(), 'Task')]")
    WebElement taskButton;

    @FindBy(id = "main-cb")
    WebElement centerContainer;

    @FindBy(xpath = "//div[@id='main-container']//div[@class='CodeMirror cm-s-default CodeMirror-wrap']")
    WebElement focusDiv;

    public PostComponentPage(){
        //waitUntilPageObjectIsLoaded();
    }

    public PostComponentPage typeTextArea(String content) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(centerContainer));

        postTextArea = centerContainer.findElement(By.xpath("//form/div[@class='right']/div[1]/div[1]/textarea"));
        Actions actions = new Actions(driver);

//        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/command-box/form/div[2]/div[1]/div[4]/div[1]/div/div/div/div[5]/pre")))
                .click()
                .sendKeys(content)
                .perform();

        System.out.println("before thread n####" + postTextArea == null);
//        Thread.sleep(10000);
//        postTextArea.click();
//        postTextArea.sendKeys(content);
        return this;
    }

    public ContainerPage clickSend(){
        sendButton.click();
        return new ContainerPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(centerContainer));
    }
}
