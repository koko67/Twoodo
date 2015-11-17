package ui.pages;

/**
 * Created by jorgeavila on 11/16/2015.
 */
public class LeftMembersPanel extends LeftPanelPage {

    public final static String ADD_TEAMMATE = "Add a teammate";

    public ManageMembersPage clickCreateNewMember(){
        clickElementForCreationByText(ADD_TEAMMATE);
        return new ManageMembersPage();
    }

    public ContainerPage clickSelectAMember(String teamName){
        clickElementForSelectionByText(teamName);
        return new ContainerPage();
    }

    public boolean existsNotification() {
        return findNotificationIcon() == null;
    }
}
