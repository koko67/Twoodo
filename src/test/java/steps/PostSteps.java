package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import ui.pages.ContainerPage;
import ui.pages.LoginPage;
import ui.pages.PostComponentPage;
import ui.pages.PostsPanelPage;

/**
 * Created by jorgeavila on 11/25/2015.
 */
public class PostSteps {

    ContainerPage containerPage;
    PostComponentPage postComponentPage;
    PostsPanelPage postsPanelPage;
    LoginPage loginPage;

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
        containerPage.getPostComponentPage()
                .clickOnTaskButton();
    }

    @And("^I select the 'Add a #todo' button$")
    public void I_select_the_Add_a_todo_button() throws Throwable {
        containerPage.getPostComponentPage()
                .clickOnTodoTask();
    }

    @And("^I type a task name \"([^\"]*)\"$")
    public void I_type_a_task_name(String taskName) throws Throwable {
        postTaskName = taskName;
        containerPage.getPostComponentPage()
                .typeTextArea(taskName);
    }

    @When("^I perform the post$")
    public void I_click_in_the_button_Add_task() throws Throwable {
        containerPage.getPostComponentPage()
                .clickSend();
    }

    @Then("^the new task should be added in the posts section$")
    public void the_new_task_should_be_added_in_the_posts_section() throws Throwable {
        postsPanelPage = containerPage.getPostsPanelPage();
        containerPage.getPostsPanelPage()
                .existsPost(postTaskName);
    }

    @When("^I logout from the application$")
    public void I_logout_in_the_application() throws Throwable {
        loginPage = containerPage.clickUserButton()
                .logout();
    }

    @Given("^I post a voting question called \"([^\"]*)\"$")
    public void I_post_a_voting_question_called(String question) throws Throwable {
        postTaskName = question;
        containerPage.getPostComponentPage()
                .clickOnTaskButton()
                .clickOnVotingTask()
                .typeTextArea(question)
                .clickSend();
    }

    @And("^vote for the \"([^\"]*)\" option$")
    public void vote_for_the_yes_option(String option) throws Throwable {
        containerPage.getPostsPanelPage()
                .getPostByName(postTaskName)
                .voteFor(option);
    }

    @Then("^a notification counter should be displayed in the team$")
    public void a_notification_counter_should_be_displayed_in_the_team() throws Throwable {
        boolean existNotification = containerPage.getLeftPanelPage()
                .getLeftTeamsPanel()
                .existsNotificationInATeam("@TheTeam");
        Assert.assertTrue(existNotification);
    }

    @And("^I go to the company \"([^\"]*)\"$")
    public void I_go_to_the_company(String companyName) throws Throwable {
        containerPage.goToComapny(companyName);
    }

    @And("^another team member \"([^\"]*)\" with password \"([^\"]*)\" does login$")
    public void another_team_member_with_password_does_login(String arg1, String arg2) throws Throwable {
        loginPage.typeUserName(arg1)
                .typeUserPassword(arg2)
                .clickLoginButtonSuccessful();
    }

    @Then("^the counter for that answer option in the voting should increments to \"([^\"]*)\"$")
    public void the_counter_for_that_answer_option_in_the_voting_should_increments_to(String count) throws Throwable {
        String counter = containerPage.getPostsPanelPage()
                .getResultByOption("Yes");

        Assert.assertEquals(counter, count);
    }

    @And("^close the voting$")
    public void close_the_voting() throws Throwable {
        containerPage.getPostsPanelPage()
                .getPostByName(postTaskName)
                .closePostVoting();
    }

    @Then("^the voting is disabled for all users$")
    public void the_voting_is_disabled_for_all_users() throws Throwable {
        boolean isClosed = containerPage.getPostsPanelPage()
                .isPostVotingClosed();
        Assert.assertTrue(isClosed);
    }

    @When("^I finish this task with a check$")
    public void I_finish_this_task_with_a_check() throws Throwable {
        containerPage.getPostsPanelPage()
                .getPostByName(postTaskName)
                .checkTodo();
    }


    @And("^I navigate to Tasks section$")
    public void I_navigate_to_Tasks_section() throws Throwable {
        containerPage.getLeftPanelPage()
                .getLeftIntegrationPanel()
                .clickOnButtonTasks();
    }

    @And("^I select the 'My completed tasks' option$")
    public void I_select_the_My_completed_tasks_option() throws Throwable {
        containerPage.getPostsPanelPage()
                .clickOnSelectCompletedTasks();
    }

    @Then("^the Completed task should appears in the panel of tasks$")
    public void the_Completed_task_should_appears_in_the_panel_of_tasks() throws Throwable {
        boolean exists = containerPage.getPostsPanelPage()
                .existsCompletedTask(postTaskName);
        Assert.assertTrue(exists);
    }

    @And("^the task completed should be crossed out$")
    public void the_task_completed_should_be_crossed_out() throws Throwable {
        boolean isCrossed = containerPage.getPostsPanelPage()
                .todoIsCrossedOut(postTaskName);
    }

    @After("@posts")
    public void tearDown2() throws Throwable{
        containerPage.getLeftPanelPage()
                .clickOnDropdownCompany()
                .clickOnButtonCompanyTeams()
                .clickOnRemoveTeamByName(DirectMessagesSteps.teamName)
                .confirmRemoveTeam();
    }
}
