package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.LogInPage;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private UserPreferencesPage userPreferencesPage;
  @Autowired
  private LogInPage logInPage;

  @When("I navigate to the user profile page.")
  public void i_navigate_to_the_user_profile_page() {
    userPreferencesPage.navigateToProfile();
  }

  @Then("current full name is {string}.")
  public void current_username_is(String username) {
    WebDriverWait wait = new WebDriverWait(driver, 2);
    WebElement realName = driver.findElement(userPreferencesPage.getUiElement("Real-name"));
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(userPreferencesPage.getUiElement("Real-name"))));
    Assert.assertEquals(username, realName.getAttribute("value"));
  }

  @After(value = "@LogoutRequired")
  public void logout() {
    logInPage.logout();
  }
}
