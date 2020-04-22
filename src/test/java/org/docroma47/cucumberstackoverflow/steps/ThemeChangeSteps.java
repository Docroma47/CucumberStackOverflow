package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.LogInPage;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class ThemeChangeSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private UserPreferencesPage userPreferencesPage;
  @Autowired
  private LogInPage logInPage;


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
    Cookie authCookie = driver.manage().getCookieNamed("acct");
    if (authCookie == null) {
      logInPage.navigateToLogin();
      logInPage.login();
    }
    authCookie = driver.manage().getCookieNamed("acct");
    Assert.assertNotNull(authCookie);
  }

}
