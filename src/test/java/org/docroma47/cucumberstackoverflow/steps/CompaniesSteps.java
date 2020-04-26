package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.CompaniesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class CompaniesSteps {
  @Autowired
  private WebDriver driver;
  @Autowired
  private CompaniesPage companiesPage;

  @When("I navigate to the companies page.")
  public void i_navigate_to_the_companies_page() {
    companiesPage.navigateToCompanies();
  }

  @Then("current page is companies page.")
  public void current_page_is_companies_page() {
    Assert.assertEquals("Search all companies", companiesPage.getTextPage());
  }
}
