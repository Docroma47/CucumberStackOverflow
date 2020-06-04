package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.JobsPage;
import org.springframework.beans.factory.annotation.Autowired;

public class JobsSteps {

  @Autowired
  private JobsPage jobsPage;

  @When("I navigate to the 'Jobs' page")
  public void i_navigate_to_the_jobs_page() {
    jobsPage.navigateToJobs();
  }

  @Then("current page is 'Jobs' page")
  public void current_page_is_jobs_page() {
    jobsPage.assertSearchFieldIsDisplayed();
    jobsPage.assertLocationFilterFieldIsDisplayed();
    jobsPage.assertUrlJobsPage();
    jobsPage.assertBreadcrumbIsSelected();

  }

  @When("I input {string} on the search field and click search button")
  public void i_input_on_the_search_field_and_click_search_button(String text) {
    jobsPage.inputInSearchField(text);
    jobsPage.clickSearchButton();
  }

  @And("I select a job ad with index number {string}")
  public void i_select_a_job_ad_with_index(String index) {
    jobsPage.selectJob(index);
    jobsPage.clickSelectedJobAd();
  }

  @And("I add the selected job ad to the saved jobs")
  public void i_add_the_selected_job_ad_to_the_saved_jobs() {
    jobsPage.saveSelectedJobAdd();
  }
}
