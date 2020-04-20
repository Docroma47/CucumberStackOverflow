package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepsChangingTheme extends RunTest {

  @Given("I am on the main page.")
  public void i_m_on_main_page_stackOverflow() {
    driver.get("https://stackoverflow.com/");
  }

  @When("I switch Theme to Dark.")
  public void i_switch_Theme_to_Dark() {
    logInPage.clickOnPage(driver, logInPage.getMapPage("Dark-theme"));
  }

  @Then("current theme is changed to Dark theme.")
  public void current_theme_is_changed_to_Dark() {
    Assert.assertEquals("rgb(45, 45, 45)", userOptions.colorPage(driver));
  }

  @When("I navigate to the user preferences page.")
  public void i_go_to_profile_preference() {
    userOptions.goToProfile(driver);
    userOptions.clickOnPage(driver, userOptions.getMapPage("Preference"));
  }

  @Given("I am logged in as a regular user.")
  public void i_am_logged_in_as_a_regular_user() {
    logInPage.clickOnPage(driver, logInPage.getMapPage("Log_in"));
    logInPage.logIn();
  }
}
