package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.ApplicationsPage;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationsSteps {

  @Autowired
  private ApplicationsPage applicationsPage;

  @When("I navigate to the 'Jobs Applications' page.")
  public void i_navigate_to_the_jobs_applications_page() {
    applicationsPage.navigateToApplications();
  }

  @Then("current page is 'Jobs Applications' page.")
  public void current_page_is_jobs_applications_page() {
    applicationsPage.getLabel("Display jobs you may have applied to");
    applicationsPage.isJobsCheckboxDisplayed();
    applicationsPage.isBreadcrumbSelected();
  }
}
