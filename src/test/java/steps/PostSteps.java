package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import ui.pages.ContainerPage;
import ui.pages.PostComponentPage;
import ui.pages.PostsPanelPage;

/**
 * Created by jorgeavila on 11/25/2015.
 */
public class PostSteps {

    ContainerPage containerPage;
    PostComponentPage postComponentPage;
    PostsPanelPage postsPanelPage;

    private String postTaskName;

    @Before
    public void setUp(){
        containerPage = new ContainerPage();
    }


    @Given("^I type the name \"([^\"]*)\" of a member in the post section$")
    public void I_type_the_name_of_a_member_called(String memberName) throws Throwable {
        postComponentPage = containerPage.getPostComponentPage()
                .typeTextArea(memberName);
    }


    @And("^I click in the task button in the post section$")
    public void I_click_in_the_task_button() throws Throwable {
        postComponentPage.clickOnTaskButton();
    }

    @And("^I select the 'Add a #todo' button$")
    public void I_select_the_Add_a_todo_button() throws Throwable {
        postComponentPage.clickOnTodoTask();
    }

    @And("^I type a task name \"([^\"]*)\"$")
    public void I_type_a_task_name(String taskName) throws Throwable {
        postTaskName = taskName;
        postComponentPage.typeTextArea(taskName);
    }

    @When("^I perform the post$")
    public void I_click_in_the_button_Add_task() throws Throwable {
        postComponentPage.clickSend();
    }

    @Then("^the new task should be added in the posts section$")
    public void the_new_task_should_be_added_in_the_posts_section() throws Throwable {
        postsPanelPage = containerPage.getPostsPanelPage();
        postsPanelPage.existsPost(postTaskName);
    }

    @When("^I logout from the application$")
    public void I_logout_in_the_application() throws Throwable {
        containerPage.clickUserButton()
                .logout();
    }







    @Given("^I post a voting question called \"([^\"]*)\"$")
    public void I_post_a_voting_question_called(String question) throws Throwable {
        postComponentPage.clickOnTaskButton()
                .clickOnVotingTask()
                .typeTextArea(question)
                .clickSend();
    }

    @And("^I vote for the yes option$")
    public void I_vote_for_the_yes_option() throws Throwable {
        postsPanelPage.getPostByName("");
    }

    @Then("^a notification counter should be displayed in the team$")
    public void a_notification_counter_should_be_displayed_in_the_team() throws Throwable {
        boolean existNotification = containerPage.getLeftTeamsPanel()
                .existsNotificationInATeam("@TheTeam");
        Assert.assertTrue(existNotification);
    }

    @And("^I go to the company \"([^\"]*)\"$")
    public void I_go_to_the_company(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
