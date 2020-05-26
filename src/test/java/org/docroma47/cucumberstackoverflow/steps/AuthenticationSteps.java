package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.LogInPage;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationSteps {

  @Autowired
  private UserPreferencesPage userPreferencesPage;
  @Autowired
  private LogInPage logInPage;

  @When("I navigate to the user profile page.")
  public void i_navigate_to_the_user_profile_page() {
    userPreferencesPage.navigateToProfile();
  }

  @Then("current full name is {string}.")
  public void current_username_is(String username) {
    Assert.assertEquals(username, userPreferencesPage.getRealName());
  }

  @After(value = "@LogoutRequired")
  public void logout() {
    logInPage.logout();
  }
}
