package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/13/2015.
 */
public class TeamsCreationPage extends BasePageObject {

    @FindBy(xpath = "//input[@placeholder='Your team name']")
    WebElement inputTeamName;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block' and contains(text(),'Next')]")
    WebElement buttonNext;

    @FindBy(xpath = "//input[@placeholder='Enter an email or username...']")
    WebElement inputNewMember;

    @FindBy(xpath = "//a[contains(text(), 'Invite people later, next')]")
    WebElement linkPeopleLater;

    @FindBy(xpath = "//button[@type='submit' and contains(text(), ' Create team')]")
    WebElement buttonCreateNewTeam;


    public TeamsCreationPage setTeamNameForCreating(String teamName){
        inputTeamName.sendKeys(teamName);
        return this;
    }

    public TeamsCreationPage clickNext(){
        buttonNext.click();
        return this;
    }

    public TeamsCreationPage clickInvitePeopleLater(){
        linkPeopleLater.click();
        return this;
    }

    public TeamsCreationPage setNewTeamMember(String member){
        inputNewMember.sendKeys(member);
        return this;
    }

    public ContainerPage clickCreateTeam(){
        buttonCreateNewTeam.click();
        return new ContainerPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inputTeamName));
    }

    public void createTeam(String teamName) {
        setTeamNameForCreating(teamName);
        clickNext();
        clickInvitePeopleLater();
        clickCreateTeam();
    }
}
