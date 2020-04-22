package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement webElement = driver.findElement(By.xpath("//body"));
    wait.until(ExpectedConditions.attributeToBe(webElement, "background-color", "rgb(45, 45, 45)"));
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

}
