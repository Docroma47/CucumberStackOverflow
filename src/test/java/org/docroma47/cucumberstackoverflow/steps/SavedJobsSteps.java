package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.SavedJobsPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SavedJobsSteps {

  @Autowired
  private SavedJobsPage savedJobsPage;

  @When("I navigate to the 'Jobs Saved Jobs' page")
  public void i_navigate_to_the_saved_jobs_page() {
    savedJobsPage.navigateToSavedJobs();
  }

  @Then("current page is 'Jobs Saved Jobs' page")
  public void current_page_is_saved_jobs_page() {
    savedJobsPage.assertUrlSavedJobsPage();
    savedJobsPage.assertBreadcrumbIsSelected();
  }
}
