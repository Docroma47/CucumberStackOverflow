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

  @When("I diasble hide left navigation.")
  public void i_diasble_left_navigation() {
    userPreferencesPage.setHideLeftNavigation(false);
  }

  @Then("left navigation is not shown.")
  public void left_navigation_is_not_shown() {
    Assert.assertTrue(userPreferencesPage.isLeftNavigationPanelHidden());
  }

  @When("I enable hide left navigation.")
  public void i_enable_left_navigation() {
    userPreferencesPage.setHideLeftNavigation(true);
  }

  @Then("left navigation is shown.")
  public void left_navigation_is_shown() {
    Assert.assertFalse(userPreferencesPage.isLeftNavigationPanelHidden());
  }
}
