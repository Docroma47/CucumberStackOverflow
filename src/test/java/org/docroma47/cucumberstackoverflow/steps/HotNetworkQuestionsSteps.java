package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.springframework.beans.factory.annotation.Autowired;

public class HotNetworkQuestionsSteps {

  @Autowired
  private UserPreferencesPage userPreferencesPage;

  @When("I diasble 'Hide hot network questions'")
  public void i_diasble_hide_hot_network_questions() {
    userPreferencesPage.setHideHotNetworkQuestions(false);
  }

  @Then("'Hot Network Questions' is not hidden")
  public void hot_network_questions_is_not_hidden() {
    userPreferencesPage.assertHotNetworkQuestionsVisibility();
  }

  @When("I enable 'Hide hot network questions'")
  public void i_enable_hide_hot_network_questions() {
    userPreferencesPage.setHideHotNetworkQuestions(true);
  }

  @Then("'Hot Network Questions' is hidden")
  public void hot_network_questions_is_hidden() {
    userPreferencesPage.assertHotNetworkQuestionsInvisibility();
  }

}
