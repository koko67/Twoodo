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

    WebElement post;

    private static String postContentText = "//div[@id='content']//div[@class='post' or @class='post open'][.//span[contains(text(),'#text#')]]";


    public boolean existsPost(String postTaskName) {
        String postXpath = postContentText.replace("#text#", postTaskName);
        boolean existsPost = postingComponent.findElement(By.xpath(postXpath)) != null;
        return existsPost;
    }

    public PostsPanelPage getPostByName(String postName){
        post = postingComponent.findElement(By.xpath("//div[@id='content']//span[contains(text(), '" + postName + "')]/ancestor::div[@class='right']"));
        return this;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

}
