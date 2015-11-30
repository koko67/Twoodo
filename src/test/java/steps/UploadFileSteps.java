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

/**
 * Created by Jorge on 11/28/2015.
 */
public class UploadFileSteps {

    private ContainerPage containerPage;

    private String postContent;

    @Before
    public void setUp(){
        containerPage = new ContainerPage();
    }

    @Given("^I navigate to files section$")
    public void I_navigate_to_files_section() throws Throwable{
        Thread.sleep(500);
        containerPage.getLeftPanelPage()
                .getLeftIntegrationPanel()
                .clickOnButtonFiles();
    }

    @And("^I select the team \"([^\"]*)\"$")
    public void I_select_the_team(String teamName) throws Throwable {
        containerPage.getPostComponentPage()
                .clickOnDropDownTeams()
                .selectATeamByName(teamName);
    }

    @And("^I upload an image with name \"([^\"]*)\"$")
    public void I_upload_an_image_with_name(String fileName) throws Throwable {
        containerPage.getPostComponentPage()
                .clickOnDropDownFile()
                .clickOnComputerAndSelectFileByPath(fileName);

    }

    @And("^I type a question called \"([^\"]*)\"$")
    public void I_type_a_question_called(String question) throws Throwable {
        postContent = question;
        containerPage.getPostComponentPage()
                .clickOnTaskButton()
                .clickOnQuestionTask()
                .typeTextArea(question);
    }

    @And("^I click in the ask question button$")
    public void I_click_in_the_ask_question_button() throws Throwable {
        containerPage.getPostComponentPage()
                .clickSend();
    }

    @When("^I go to the team where I posted that image called \"([^\"]*)\"$")
    public void I_go_to_the_team_where_I_posted_that_image_called(String teamName) throws Throwable {
        containerPage.getLeftPanelPage()
                .getLeftTeamsPanel()
                .clickSelectATeam(teamName);
    }

    @Then("^the image uploaded should be displayed in the top of the posts$")
    public void the_image_uploaded_should_be_displayed_in_the_top_of_the_posts() throws Throwable {
        boolean existPost = containerPage.getPostsPanelPage()
                .getPostByName(postContent)
                .postContainsImage();
        Assert.assertTrue(existPost);
    }

    @After("@uploadImage")
    public void tearDownUploadImage() throws  Throwable{
        containerPage.clickDropDownTeam()
                .clickButtonTeamSettings()
                .clickLinkDeleteTeam()
                .confirmDeletingTeam();
    }
}
