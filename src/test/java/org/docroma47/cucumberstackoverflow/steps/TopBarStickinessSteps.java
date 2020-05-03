package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;


public class TopBarStickinessSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private UserPreferencesPage userPreferencesPage;

  @When("I enable top bar stickiness.")
  public void i_enable_top_bar_stickiness() {
    userPreferencesPage.setTopBarStickiness(true);
  }

  @When("I disable top bar stickiness.")
  public void i_disable_top_bar_stickiness() {
    userPreferencesPage.setTopBarStickiness(false);
  }

  @Then("Top bar is not fixed.")
  public void top_bar_is_not_fixed() {
    Assert.assertFalse(!userPreferencesPage.isTopBarFixed());
  }

  @Then("Top bar is fixed.")
  public void top_bar_is_fixed() {
    Assert.assertTrue(userPreferencesPage.isTopBarFixed());
  }

  @And("I scroll to the bottom.")
  public void i_scroll_to_the_bottom() {
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }
}
