package org.BuggyCarsRating.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.WebDriverUtils;

import static org.testng.Assert.assertEquals;

public class RegisterStepDef {

    final WebDriverUtils web;

    public RegisterStepDef(WebDriverUtils web) {
        this.web = web;
    }

    @Given("I'm in Register page")
    public void i_m_in_register_page() {
        web.home.clickRegister();
    }

    @When("I submit Login {string}, First Name {string}, Last Name {string}, Password {string}")
    public void i_submit_login_first_name_last_name_password(String login, String firstName, String lastName, String password) {
        web.register.registerANewUser(login, firstName, lastName, password);
    }

    @Then("I should be see success message {string}")
    public void i_should_be_see_success_message(String message) {
        assertEquals(message, web.register.getSuccessMessage());
    }

    @Then("I should be see error message {string}")
    public void i_should_be_see_error_message(String message) {
        assertEquals(message, web.register.getErrorMessage());
    }


}
