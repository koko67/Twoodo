package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/25/2015.
 */
public class PostsPanelPage extends BasePageObject{
    @FindBy(id = "content")
    WebElement postingComponent;

    private static String postContentText = "//div[@class='post']//div[@class='right']/div[@class='content']//span[contains(text(),'text')]";


    public boolean existsPost(String postTaskName) {
        boolean existsPost = postingComponent.findElement(By.xpath(postContentText.replace("text", postTaskName))) != null;
        return existsPost;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

}
