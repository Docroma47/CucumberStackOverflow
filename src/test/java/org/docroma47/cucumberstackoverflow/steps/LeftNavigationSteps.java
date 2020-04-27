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

  @When("I disable left navigation.")
  public void i_disable_left_navigation() {
    userPreferencesPage.setLeftNavigation(false);
  }

  @Then("left navigation is shown.")
  public void left_navigation_is_shown() {
    Assert.assertTrue(userPreferencesPage.isLeftNavigationPanel());
  }

  @When("I enable left navigation.")
  public void i_enable_left_navigation() {
    userPreferencesPage.setLeftNavigation(true);
  }

  @Then("left navigation is hidden.")
  public void left_navigation_is_hidden() {
    Assert.assertTrue(!userPreferencesPage.isLeftNavigationPanel()); //return false. !fasle == true(assertTrue)
  }
}
