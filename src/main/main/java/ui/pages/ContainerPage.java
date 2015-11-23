package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/13/2015.
 */
public class ContainerPage extends BasePageObject{

    LeftTeamsPanel leftTeamsPanel;
    LeftMembersPanel leftMembersPanel;
    PostComponentPage postComponentPage;

    @FindBy(id = "content")
    WebElement postingComponent;

    public ContainerPage(){
        leftTeamsPanel = new LeftTeamsPanel();
        leftMembersPanel = new LeftMembersPanel();
        postComponentPage = new PostComponentPage();
    }

    public LeftTeamsPanel getLeftTeamsPanel() {
        return leftTeamsPanel;
    }

    public PostComponentPage getPostComponentPage() {
        return postComponentPage;
    }

    public LeftMembersPanel getLeftMembersPanel() {
        return leftMembersPanel;
    }

    public boolean existsPost(String postContent){
        return postingComponent.findElement(By.xpath("//div[@class='right']/div[@class='content']/p/div[@class='post-content']/div/span[contains(text(), '" + postContent + "')]")) == null;
    }

    public boolean existsUserName(String username){
        return postComponentPage.existsUserName(username);
    }



    @Override
    public void waitUntilPageObjectIsLoaded() {
        System.out.println("enter");
        wait.until(ExpectedConditions.visibilityOf(postComponentPage.headerDropDown));
        System.out.println("exit");
    }
}
