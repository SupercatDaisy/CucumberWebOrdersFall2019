package com.weborders.step_definitions;

import com.weborders.pages.LoginPage;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class LoginStepDefinitions {
LoginPage loginPage = new LoginPage();

    @Given("user is on landing page")
    public void userIsOnLandingPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters following credentials:")
    public void user_enters_following_credentials(Map<String,String> dataTable) {
    loginPage.login(dataTable.get("username"),dataTable.get("password"));

    }

    @Then("user click on submit button")
    public void userClickOnSubmitButton() {
        loginPage.clickLogin();
    }
}
