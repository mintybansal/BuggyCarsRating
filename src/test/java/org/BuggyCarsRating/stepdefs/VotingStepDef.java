package org.BuggyCarsRating.stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.BuggyCarsRating.pages.BasePage;
import org.BuggyCarsRating.pages.HomePage;
import utilities.WebDriverUtils;
import utilities.WebDriverUtils;





import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class VotingStepDef  {
    final WebDriverUtils web;

    int voteIncrement;
    String dateTime;
    String comment;
    String voteDateOld;
    String voteAuthorOld;
    String voteCommentOld;

    public VotingStepDef(WebDriverUtils web) {
        this.web = web;
    }

    @Given("I'm in Overall Rating page")
    public void i_m_in_overall_rating_page() {
        dateTime = web.home.preLogin();
        web.home.clickOverallRating();
    }

    @When("I select a car {string} & {string} from the list")
    public void i_select_a_car_from_the_list(String make, String model) {
        web.overallRating.selectCar(make, model);
    }

    @When("I vote with a comment {string}")
    public void i_vote_with_a_comment(String comment) {
        voteDateOld = web.model.getTopVoteDate();
        voteCommentOld = web.model.getTopVoteComment();
        this.comment = comment + " on " + dateTime;
        voteIncrement = web.model.vote(this.comment);
    }

    @Then("the vote count should increase by one")
    public void the_vote_count_should_increase_by_one() {
        assertEquals(1, voteIncrement);
    }

    @Then("I should be able to see my vote in the table")
    public void i_should_be_able_to_see_my_vote_in_the_table() {
        String voteDateNew = web.model.getTopVoteDate();
        String voteCommentNew = web.model.getTopVoteComment();

        assertFalse("vote date is empty", voteDateNew.isEmpty());

        assertFalse("vote comment is empty", voteCommentNew.isEmpty());

        assertNotEquals(voteDateOld, voteDateNew);

        assertNotEquals(voteCommentOld, voteCommentNew);

    }

    private void assertFalse(String vote_date_is_empty, boolean empty) {
    }

    @When("I vote without a comment")
    public void i_vote_without_a_comment() {
        voteDateOld = web.model.getTopVoteDate();
        voteAuthorOld = web.model.getTopVoteAuthor();
        voteCommentOld = web.model.getTopVoteComment();

        voteIncrement = web.model.vote("");
    }




}
