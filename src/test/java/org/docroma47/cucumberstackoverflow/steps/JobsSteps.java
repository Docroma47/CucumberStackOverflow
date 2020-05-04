package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.JobsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class JobsSteps {
  @Autowired
  private WebDriver driver;
  @Autowired
  private JobsPage jobsPage;

  @When("I navigate to the 'Jobs' page.")
  public void i_navigate_to_the_jobs_page() {
    jobsPage.navigateToJobs();
  }

  @Then("current page is 'Jobs' page.")
  public void current_page_is_jobs_page() {
    Assert.assertTrue(jobsPage.isSearchFieldDisplayed());
    Assert.assertTrue(jobsPage.isLocationFilterFieldDisplayed());
    Assert.assertTrue(driver.getCurrentUrl().startsWith(jobsPage.getUrl()));
    Assert.assertTrue(jobsPage.isBreadcrumbSelected());

  }
}
