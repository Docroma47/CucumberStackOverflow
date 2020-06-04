package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.CompaniesPage;
import org.springframework.beans.factory.annotation.Autowired;

public class CompaniesSteps {

  @Autowired
  private CompaniesPage companiesPage;

  @When("I navigate to the 'Jobs Companies' page.")
  public void i_navigate_to_the_jobs_companies_page() {
    companiesPage.navigateToCompanies();
  }

  @Then("current page is 'Jobs Companies' page.")
  public void current_page_is_jobs_companies_page() {
    companiesPage.assertSearchFieldIsDisplayed();
    companiesPage.assertLocationFilterFieldIsDisplayed();
    companiesPage.assertUrlCompamiesPage();
    companiesPage.assertBreadcrumbIsSelected();
  }
}
