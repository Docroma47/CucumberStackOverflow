package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.springframework.beans.factory.annotation.Autowired;

public class ThemeChangeSteps {

  @Autowired
  private UserPreferencesPage userPreferencesPage;

  @When("I switch Theme to Dark.")
  public void i_switch_theme_to_dark() {
    userPreferencesPage.setTheme("Dark-theme");
  }

  @When("I switch Theme to Light.")
  public void i_switch_theme_to_light() {
    userPreferencesPage.setTheme("Light-theme");
  }

  @Then("current theme is changed to Dark theme.")
  public void current_theme_is_changed_to_dark_theme() {
    userPreferencesPage.assertThemeIsDark(true);
  }

  @Then("current theme is changed to Light theme.")
  public void current_theme_is_changed_to_light_theme() {
    userPreferencesPage.assertThemeIsDark(false);
  }

  @When("I navigate to the user preferences page.")
  public void i_navigate_to_the_user_preferences_page() {
    userPreferencesPage.navigateToProfile();
    userPreferencesPage.navigateToPreferences();
  }

}
