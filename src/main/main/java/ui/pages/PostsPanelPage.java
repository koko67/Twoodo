package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/25/2015.
 */
public class PostsPanelPage extends BasePageObject{
    @FindBy(id = "content")
    WebElement postingComponent;

    @FindBy(id = "//div[@id='content']//span[contains(., 'My completed tasks')]")
    WebElement buttonCompletedTasks;

    WebElement post;

    private static String postContentText = "//div[@id='content']//div[@class='post' or @class='post open'][.//span[contains(text(),'#text#')]]";



    public boolean existsPost(String postTaskName) {
        String postXpath = postContentText.replace("#text#", postTaskName);
        boolean existsPost = postingComponent.findElement(By.xpath(postXpath)) != null;
        return existsPost;
    }

    public PostsPanelPage getPostByName(String postName) throws InterruptedException {
        Thread.sleep(3000);
//        wait.until(ExpectedConditions.visibilityOf(postingComponent.findElement(By.xpath("//div[@id='content']//span[contains(text(), '" + postName + "')]/ancestor::div[@class='right']"))));
        post = postingComponent.findElement(By.xpath("//div[@id='content']//span[contains(text(), '" + postName + "')]/ancestor::div[@class='right']"));
        return this;
    }

    public boolean postContainsImage(){
        try {
            boolean exists = post.findElement(By.xpath("//div[@class='post-attachment']")) != null;
            return exists;
        } catch(NoSuchElementException e){
            return false;
        }
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public PostsPanelPage voteFor(String option) {
        post.findElement(By.xpath("//span[contains(text(), '" + option + "')]")).click();
        return this;
    }

    public String getResultByOption(String option) {
        return post.findElement(By.xpath("//span[contains(text(), '" + option + "')]/preceding-sibling::span/span")).getText();
    }

    public PostsPanelPage closePostVoting() {
        post.findElement(By.xpath("//a[contains(text(), 'Close vote')]")).click();
        return this;
    }

    public boolean isPostVotingClosed() {
        try {
            return post.findElement(By.xpath("//div[@class='post-validate ignore-zoom post-validate-closed']")) != null;
        } catch(NoSuchElementException e){
            System.out.println("voting not closed or not found" + e.getMessage());
            return false;
        }
    }

    public PostsPanelPage checkTodo() throws InterruptedException {
        Thread.sleep(3000);
        post.findElement(By.xpath("//input[@type='checkbox']")).click();
        return this;
    }

    public PostsPanelPage clickOnSelectCompletedTasks() {
        wait.until(ExpectedConditions.visibilityOf(buttonCompletedTasks));
        buttonCompletedTasks.click();
        return this;
    }

    public boolean todoIsCrossedOut(String todoName) {
        try {
            return post.findElement(By.xpath("//strike[.//span[contains(., '" + todoName + "')]]")) != null;
        }
        catch(NoSuchElementException e){
            System.out.println("element is not crossed out or was not found");
            return false;
        }
    }
}
