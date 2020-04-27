package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.docroma47.cucumberstackoverflow.page.JobsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class JobsSteps {
  @Autowired
  private WebDriver driver;
  @Autowired
  private JobsPage jobsPage;
  @Autowired
  private StackoverflowProperties properties;

  @When("I navigate to the 'Jobs'.")
  public void i_navigate_to_the_jobs() {
    jobsPage.navigateToJobs();
  }

  @Then("current page is 'Jobs'.")
  public void current_page_is_jobs() {
    Assert.assertTrue(driver.findElement(jobsPage.getUiElement("Text-field-left")).isDisplayed());
    Assert.assertTrue(driver.findElement(jobsPage.getUiElement("Text-field-right")).isDisplayed());
    Assert.assertEquals(properties.getBaseUrl() + "jobs", driver.getCurrentUrl());
  }
}
