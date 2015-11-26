package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/13/2015.
 */
public class ContainerPage extends BasePageObject{

    LeftTeamsPanel leftTeamsPanel;
    LeftMembersPanel leftMembersPanel;
    PostComponentPage postComponentPage;
    PostsPanelPage postsPanelPage;

    //###### header dropdown components
    @FindBy(xpath = "//div[@class='company']/div[@class='dropdown']/button/span[1]")
    WebElement dropdownTeam;

    @FindBy(xpath = "//top-header-bar[@id='teamFocusTop']//a[contains(text(), 'Team settings')]")
    WebElement buttonTeamSettings;

    @FindBy(xpath = "//top-header-bar[@id='teamFocusTop']//a[contains(text(), 'Members')]")
    WebElement buttonTeamMembers;


    //###### user profile components
    @FindBy(xpath = "//div[@id='logged-user']//button[@data-toggle='dropdown']/img")
    WebElement userProfile;

    @FindBy(id = "logout")
    WebElement buttonLogout;

    public ContainerPage(){
        leftTeamsPanel = new LeftTeamsPanel();
        leftMembersPanel = new LeftMembersPanel();
        postComponentPage = new PostComponentPage();
        postsPanelPage = new PostsPanelPage();
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

    public PostsPanelPage getPostsPanelPage() {
        return postsPanelPage;
    }

    public ContainerPage clickUserButton(){
        userProfile.click();
        return this;
    }

    public ContainerPage clickDropDownTeam(){
        dropdownTeam.click();
        return this;
    }

    public TeamGeneralPage clickButtonTeamSettings(){
        buttonTeamSettings.click();
        return new TeamGeneralPage();
    }

    public TeamMembersPage clickButtonTeamMembers(){
        buttonTeamMembers.click();
        return new TeamMembersPage();
    }

    public LoginPage logout(){
        buttonLogout.click();
        return new LoginPage();
    }

    public boolean existsUserName(String username){
        return userProfile.getAttribute("alt").equals("username");
    }



    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public boolean isTheTeamCalledSo(String teamName) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("####" + dropdownTeam.getText());
        return dropdownTeam.getText().equalsIgnoreCase(teamName);
    }

    public boolean existsDeletingSuccessfulMessage() throws InterruptedException {
        Thread.sleep(500);
        String message = driver.findElement(By.xpath("//ul[@id='noty_bottomCenter_layout_container']//div[@class='noty_message']/span[@class='noty_text']")).getText();
        System.out.println(message);
        return message != null;
    }
}
