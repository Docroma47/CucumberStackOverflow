package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.springframework.beans.factory.annotation.Autowired;

public class TopBarStickinessSteps {

  @Autowired
  private UserPreferencesPage userPreferencesPage;

  @When("I enable top bar stickiness.")
  public void i_enable_top_bar_stickiness() {
    userPreferencesPage.setTopBarStickiness(true);
  }

  @When("I disable top bar stickiness.")
  public void i_disable_top_bar_stickiness() {
    userPreferencesPage.setTopBarStickiness(false);
  }

  @Then("Top bar is not fixed.")
  public void top_bar_is_not_fixed() {
    userPreferencesPage.assertTopBarIsFixed(false);
  }

  @Then("Top bar is fixed.")
  public void top_bar_is_fixed() {
    userPreferencesPage.assertTopBarIsFixed(true);
  }

  @And("I scroll to the bottom.")
  public void i_scroll_to_the_bottom() {
    userPreferencesPage.scrollToTheBottom();
  }
}
