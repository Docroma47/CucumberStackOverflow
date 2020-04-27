package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class LeftNavigationSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private UserPreferencesPage userPreferencesPage;

  @When("I disable 'Hide left navigation'.")
  public void i_disable_hide_left_navigation() {
    userPreferencesPage.setLeftNavigation(false);
  }

  @Then("left navigation panel is not hidden.")
  public void left_navigation_panel_is_not_hidden() {
    Assert.assertTrue(userPreferencesPage.isLeftNavigationPanelDisplayed());
  }

  @When("I enable 'Hide left navigation'.")
  public void i_enable_hide_left_navigation() {
    userPreferencesPage.setLeftNavigation(true);
  }

  @Then("left navigation panel is hidden.")
  public void left_navigation_panel_is_hidden() {
    Assert.assertFalse(userPreferencesPage.isLeftNavigationPanelDisplayed());
  }
}
