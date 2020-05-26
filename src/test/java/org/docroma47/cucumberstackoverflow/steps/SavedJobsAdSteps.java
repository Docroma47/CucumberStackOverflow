package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.docroma47.cucumberstackoverflow.page.SavedJobsPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SavedJobsAdSteps {

  @Autowired
  private SavedJobsPage savedJobsPage;

  @And("I delete the selected job ad.")
  public void i_delete_the_selected_job_ad() {
    savedJobsPage.deleteJob();
    savedJobsPage.navigateToSavedJobs();
  }

  @And("I navigate to the 'Saved Jobs' page.")
  public void i_navigate_to_the_saved_jobs_page() {
    savedJobsPage.navigateToSavedJobs();
  }

  @Then("the selected job ad is deleted.")
  public void the_selected_job_ad_is_deleted() {
    savedJobsPage.isJobAdPresent();
  }
}
