package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class HotNetworkQuestionsSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private UserPreferencesPage userPreferencesPage;
  @Autowired
  private StackoverflowProperties properties;

  @When("I diasble 'Hide hot network questions'.")
  public void i_diasble_hide_hot_network_questions() {
    userPreferencesPage.setHideHotNetworkQuestions(false);
  }

  @Then("'Hot Network Questions' is not hidden.")
  public void hot_network_questions_is_not_hidden() {
    Assert.assertTrue(userPreferencesPage.isHotNetworkQuestionsDisplayed());
  }

  @When("I enable 'Hide hot network questions'.")
  public void i_enable_hide_hot_network_questions() {
    userPreferencesPage.setHideHotNetworkQuestions(true);
  }

  @Then("'Hot Network Questions' is hidden.")
  public void hot_network_questions_is_hidden() {
    Assert.assertFalse(userPreferencesPage.isHotNetworkQuestionsDisplayed());
  }

  @And("I navigate to the main page.")
  public void i_navigate_to_the_main_page() {
    driver.get(properties.getBaseUrl());
  }

  @And("I scroll to the middle page.")
  public void i_scroll_to_the_middle_page() {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollBy(0, 1500)", "");
  }

}
