package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.springframework.beans.factory.annotation.Autowired;

public class LeftNavigationSteps {

  @Autowired
  private UserPreferencesPage userPreferencesPage;

  @When("I disable 'Hide left navigation'")
  public void i_disable_hide_left_navigation() {
    userPreferencesPage.setHideLeftNavigation(false);
  }

  @Then("left navigation panel is not hidden")
  public void left_navigation_panel_is_not_hidden() {
    userPreferencesPage.assertLeftNavigationVisible(true);
  }

  @When("I enable 'Hide left navigation'")
  public void i_enable_hide_left_navigation() {
    userPreferencesPage.setHideLeftNavigation(true);
  }

  @Then("left navigation panel is hidden")
  public void left_navigation_panel_is_hidden() {
    userPreferencesPage.assertLeftNavigationVisible(false);
  }
}
