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

  @When("I diasble hide hot network questions.")
  public void i_diasble_hide_hot_network_questions() {
    userPreferencesPage.setHotNetworkQuestions(false);
  }

  @Then("hot network questions is shown.")
  public void hot_network_questions_is_shown() {
    Assert.assertTrue(userPreferencesPage.isHotNetworkQuestionsShown(true));
  }

  @When("I enable hide hot network questions.")
  public void i_enable_hide_hot_network_questions() {
    userPreferencesPage.setHotNetworkQuestions(true);
  }

  @Then("hot network questions is hidden.")
  public void hot_network_questions_is_hidden() {
    Assert.assertTrue(userPreferencesPage.isHotNetworkQuestionsHidden(true));
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
