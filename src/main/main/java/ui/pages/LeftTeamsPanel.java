package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class LeftTeamsPanel extends BasePageObject {

    public final static String CREATION = "Create a team";

    @FindBy(xpath = "//div[@class='section']/a[@class='title' and contains(text(), 'Teams')]")
    WebElement teamsContainer;

    @FindBy(xpath = "//menu-left[@id='menu-left-content']//div/a[contains(text(), 'Create a team')]")
    WebElement buttonCreationTeam;

    WebElement team;

    private static String teamXpath = "//menu-left[@id='menu-left-content']//a[contains(text(), 'Teams')]/following-sibling::a[.//span[contains(text(),'#team#')]]";

    public TeamsCreationPage clickCreateNewTeam(){
//        wait.until(ExpectedConditions.visibilityOf(teamsContainer));
//        clickElementForCreationByText(CREATION);
        buttonCreationTeam.click();
        return new TeamsCreationPage();
    }

    public ContainerPage clickSelectATeam(String teamName){
        team = getTeamWebElementByName(teamName);
        team.click();
        return new ContainerPage();
    }

    public boolean existsNotificationInATeam(String teamName){
        team = getTeamWebElementByName(teamName);
        return team.getText() != "" || team.getText() != null;
    }

    private String constructXpath(String name){
        String teamXpathText = teamXpath.replace("#team#", name);
        return teamXpathText;
    }

    private WebElement getTeamWebElementByName(String teamName){
        try {
            return teamsContainer.findElement(By.xpath(constructXpath(teamName)));
        } catch(NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
