package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import ui.pages.ContainerPage;
import ui.pages.ManageMembersPage;

/**
 * Created by jorgeavila on 11/24/2015.
 */
public class TeamMemberSteps {

    ContainerPage containerPage;
    ManageMembersPage manageMembersPage;

    @Before
    public void setUp(){
        containerPage = new ContainerPage();
    }

    @And("^I enter to the team settings$")
    public void I_enter_to_the_team_settings(){
        manageMembersPage = containerPage.clickDropDownTeam()
                .clickButtonTeamSettings();
    }

    @When("^I click the Delete team button of the current team$")
    public void I_click_the_Delete_team_button_of_the_current_team() throws Throwable {
        manageMembersPage.clickLinkDeleteTeam();
    }

    @And("^I confirm the dialog for deleting$")
    public void I_confirm_the_dialog_for_deleting() throws Throwable {
        manageMembersPage.confirmDeletingTeam();
    }

    @Then("^the application should to redirect to the default team Called \"([^\"]*)\"$")
    public void the_application_should_to_redirect_to_the_default_team_Called(String teamName) throws Throwable {
        boolean redirected = containerPage.isTheTeamCalledSo(teamName);
        System.out.println(redirected);
        Assert.assertTrue(redirected);
    }

    @And("^a notification message should be displayed with the teamname deleted$")
    public void a_notification_message_should_be_displayed_with_the_teamname_deleted() throws Throwable {
        boolean exists = containerPage.existsDeletingSuccessfulMessage();
        Assert.assertTrue(exists);
    }

    @When("^I add a new member with mail \"([^\"]*)\" in that team$")
    public void I_add_a_new_member_with_mail_in_that_team(String member) throws Throwable {
        manageMembersPage = containerPage.clickDropDownTeam()
                .clickButtonTeamMembers();
        manageMembersPage.addNewMemberShip(member);
        manageMembersPage.closeManageMembersDialog();
    }

    @Then("^an information message should be displayed$")
    public void an_information_message_should_be_displayed() throws Throwable {
        boolean exists = containerPage.existsDeletingSuccessfulMessage();
        Assert.assertTrue(exists);
    }

    @When("^I enter to the member settings of the team$")
    public void I_enter_to_the_member_settings_of_the_team() throws Throwable {
        manageMembersPage = containerPage.clickDropDownTeam()
                .clickButtonTeamMembers();
    }

    @And("^I remove that member who has a user name \"([^\"]*)\"$")
    public void I_remove_that_member_who_has_a_user_name(String membername) throws Throwable {
        manageMembersPage.removeMemberByName(membername);
    }
}