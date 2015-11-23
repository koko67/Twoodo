package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class LeftTeamsPanel extends LeftPanelPage {

    public final static String CREATION = "Create a team";

    @FindBy(xpath = "//div[@class='section']/a[@class='title' and contains(text(), 'Teams')]")
    WebElement teamsContainer;

    public TeamsCreationPage clickCreateNewTeam(){
//        wait.until(ExpectedConditions.visibilityOf(teamsContainer));
        clickElementForCreationByText(CREATION);
        return new TeamsCreationPage();
    }

    public ContainerPage clickSelectATeam(String teamName){
        clickElementForSelectionByText(teamName);
        return new ContainerPage();
    }
}
