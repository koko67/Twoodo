package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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


    @Given("^I type the name of a member called \"([^\"]*)\"$")
    public void I_type_the_name_of_a_member_called(String memberName) throws Throwable {
        postComponentPage = containerPage.getPostComponentPage()
                .typeTextArea(memberName);
    }

    @And("^I type the TODO tag \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void I_type_the_TODO_tag_with_value(String task, String taskname) throws Throwable {
        postTaskName = taskname;
        postComponentPage.typeTextArea(task)
                .typeTextArea(taskname);
    }

    @When("^I click in the button Add task$")
    public void I_click_in_the_button_Add_task(){
        postComponentPage.clickSend();
    }

    @Then("^the new task should be added in the posts section$")
    public void the_new_task_should_be_added_in_the_posts_section() throws Throwable {
        postsPanelPage = containerPage.getPostsPanelPage();
        postsPanelPage.existsPost(postTaskName);
    }
}
