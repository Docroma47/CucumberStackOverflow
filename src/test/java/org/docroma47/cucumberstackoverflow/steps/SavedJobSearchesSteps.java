package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.SavedJobSearchesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class SavedJobSearchesSteps {
  @Autowired
  private WebDriver driver;
  @Autowired
  private SavedJobSearchesPage savedJobSearchesPage;

  @When("I navigate to the 'Jobs Saved Jobs Searches' page.")
  public void i_navigate_to_the_job_saved_job_searches_page() {
    savedJobSearchesPage.navigateToSavedJobsSearches();
  }

  @Then("current page is 'Jobs Saved Jobs Searches' page.")
  public void current_page_is_jobs_saved_job_searches_page() {
    Assert.assertEquals("Saved job searches", savedJobSearchesPage.getTitle());
  }
}
