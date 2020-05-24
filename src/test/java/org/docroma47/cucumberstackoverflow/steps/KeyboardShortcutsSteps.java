package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class KeyboardShortcutsSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private UserPreferencesPage userPreferencesPage;
  @Autowired
  private StackoverflowProperties properties;

  @When("I enable keyboard shortcuts.")
  public void i_enable_keyboard_shortcuts() {
    userPreferencesPage.setKeyboardShortcuts(true);
  }

  @When("I disable keyboard shortcuts.")
  public void i_disable_keyboard_shortcuts() {
    userPreferencesPage.setKeyboardShortcuts(false);
  }

  @Then("current page is changed to home page.")
  public void current_page_is_changed_to_home_page() {
    Assert.assertTrue(userPreferencesPage.assertThatAndPerform(urlContains(properties.getBaseUrl())));
  }

  @Then("current page is preferences page.")
  public void current_page_is_preferences_page() {
    Assert.assertTrue(driver.getCurrentUrl().contains("preferences"));
  }

  @And("I press hot keys G and H.")
  public void i_press_hot_keys_G_and_H() {
    userPreferencesPage.inputHotKeysGAndH();
  }

  @And("I refresh page.")
  public void i_refresh_page() {
    driver.navigate().refresh();
  }

}
