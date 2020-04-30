package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.JobsPage;
import org.docroma47.cucumberstackoverflow.page.SavedJobsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class SavedJobsAdSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private SavedJobsPage savedJobsPage;
  @Autowired
  private JobsPage jobsPage;

  @When("I input {string} on the search field and click search button.")
  public void i_input_on_the_search_field_and_click_search_button(String text) {
    jobsPage.inputInSearchField(text);
    jobsPage.clickSearchButton();
  }

  @And("I select a job ad with index number {string}.")
  public void i_select_a_job_ad_with_index(String index) {
    jobsPage.selectJob(index);
    jobsPage.clickSelectedJobAd();
  }

  @And("I delete the selected job ad.")
  public void i_delete_the_selected_job_ad() {
    savedJobsPage.deleteJob(jobsPage.getJobID());
  }

  @And("I add the selected job ad to the saved jobs.")
  public void i_add_the_selected_job_ad_to_the_saved_jobs() {
    jobsPage.saveSelectedJobAdd();
  }

  @And("I navigate to the 'Saved Jobs' page.")
  public void i_navigate_to_the_saved_jobs_page() {
    savedJobsPage.navigateToSavedJobs();
  }

  @Then("the selected job ad is deleted.")
  public void the_selected_job_ad_is_deleted() {
    if (savedJobsPage.findJob(jobsPage.getJobID()) == null) {
      Assert.assertTrue(true);
    } else {
      Assert.assertTrue(false);
    }
  }
}
