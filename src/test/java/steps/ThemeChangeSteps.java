package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ThemeChangeSteps extends RunTest {

  @Given("I am on the main page.")
  public void i_am_on_the_main_page() {
    driver.get("https://stackoverflow.com/");
  }

  @When("I switch Theme to Dark.")
  public void i_switch_theme_to_dark() {
    driver.findElement(userPreferencesPage.getUiElement("Dark-theme")).click();
  }

  @Then("current theme is changed to Dark theme.")
  public void current_theme_is_changed_to_dark_theme() {
    Assert.assertEquals("rgb(45, 45, 45)", userPreferencesPage.getPageColor());
  }

  @When("I navigate to the user preferences page.")
  public void i_navigate_to_the_user_preferences_page() {
    userPreferencesPage.navigateToProfile();
    userPreferencesPage.navigateToPreferences();
  }

  @Given("I am logged in as a regular user.")
  public void i_am_logged_in_as_a_regular_user() {
    logInPage.navigateToLogin();
    logInPage.login();
  }

  @When("I enable keyboard shortcuts.")
  public void i_enable_keyboard_shortcuts() {
    driver.findElement(userPreferencesPage.getUiElement("keyboard-shortcuts")).click();
  }

  @Then("current page is changed to home page.")
  public void current_page_is_changed_to_home_page() {
    Assert.assertEquals("https://stackoverflow.com/", driver.getCurrentUrl());
  }

  @And("I press hot keys G and H.")
  public void i_press_hot_keys_G_and_H() {
    userPreferencesPage.inputHotKeysGAndH();
  }
}
