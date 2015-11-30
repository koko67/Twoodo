package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import ui.pages.ContainerPage;
import ui.pages.SearchPage;

/**
 * Created by jorgeavila on 11/17/2015.
 */
public class SearchSteps {

    private ContainerPage containerPage;

    private String textToSearch;

    @Before
    public void setUp(){
        containerPage = new ContainerPage();
    }

    @And("^I posted \"([^\"]*)\"$")
    public void I_posted(String post) throws Throwable {
        textToSearch = post;
        containerPage.getPostComponentPage()
                .typeTextArea(post)
                .clickSend();
    }

    @Given("^I enter a text to search that is \"([^\"]*)\"$")
    public void I_make_a_post_called(String textSearch) throws Throwable {
        textToSearch = textSearch;
        containerPage.getLeftPanelPage()
                .setTextToSearch(textToSearch);
    }

    @When("^I click in the search button$")
    public void I_perform_a_search_with_that_word_in_the_search_panel() throws Throwable {
        containerPage.getLeftPanelPage()
                .clickSearch();
    }


    @Then("^a result with the text entered should be displayed in the search content$")
    public void the_result_should_display_a_result_of_that_word_searched() throws Throwable {
        boolean existPost = containerPage.getPostsPanelPage()
                .existsPost(textToSearch);
        Assert.assertTrue(existPost);
    }


}
