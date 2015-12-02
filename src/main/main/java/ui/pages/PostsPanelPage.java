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

//    @FindBy(id = "//div[@id='content']//span[contains(., 'My completed tasks')]")
//    WebElement buttonCompletedTasks;


    private static String postContentText = "//div[@class='post' or @class='post open'][.//span[contains(text(),'#text#')]]";
    WebElement post;



    public boolean existsCompletedTask(String completedTodoName){
        boolean existCompletedPost = postingComponent.findElement(By.xpath("//div/div[@class='details']//span[contains(., '" + completedTodoName + "')]")) != null;
        return existCompletedPost;
    }

    public boolean existsPost(String postTaskName) {
        String postXpath = postContentText.replace("#text#", postTaskName);
        boolean existsPost = postingComponent.findElement(By.xpath(postXpath)) != null;
        return existsPost;
    }

    public PostsPanelPage getPostByName(String postName) throws InterruptedException {
        By postBy = By.xpath("//div[@id='content']//span[contains(text(), '" + postName + "')]/ancestor::div[@class='right']");
        wait.until(ExpectedConditions.presenceOfElementLocated(postBy));
        post = postingComponent.findElement(By.xpath("//span[contains(text(), '" + postName + "')]/ancestor::div[@class='right']"));
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

    public String getResultByOption(String option) throws InterruptedException {
        Thread.sleep(5000);
        By resultBy = By.xpath("//span[contains(text(), '" + option + "')]/preceding-sibling::span/span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultBy));
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
        WebElement checkbox = post.findElement(By.xpath("//div[@class='post-content']/div/span/label"));
        checkbox.click();
        return this;
    }

    public PostsPanelPage clickOnSelectCompletedTasks() {
        By completedTasksBy = By.xpath("//div[@id='content']//span[contains(., 'My completed tasks')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(completedTasksBy));
//        wait.until(ExpectedConditions.visibilityOf(buttonCompletedTasks));
        WebElement buttonCompletedTasks = postingComponent.findElement(By.xpath("//div[@id='content']//span[contains(., 'My completed tasks')]"));
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
