package ui.pages;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class LeftTeamsPanel extends LeftPanelPage {

    public final static String CREATION = "Create a team";

    public TeamsCreationPage clickCreateNewTeam(){
        clickElementForCreationByText(CREATION);
        return new TeamsCreationPage();
    }

    public ContainerPage clickSelectATeam(String teamName){
        clickElementForSelectionByText(teamName);
        return new ContainerPage();
    }
}
