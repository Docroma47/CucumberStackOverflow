package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.docroma47.cucumberstackoverflow.page.CompaniesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class CompaniesSteps {
  @Autowired
  private WebDriver driver;
  @Autowired
  private CompaniesPage companiesPage;
  @Autowired
  private StackoverflowProperties properties;

  @When("I navigate to the companies.")
  public void i_navigate_to_the_companies() {
    companiesPage.navigateToCompanies();
  }

  @Then("current page is companies.")
  public void current_page_is_companies() {
    Assert.assertTrue(driver.findElement(companiesPage.getUiElement("Text-field-left")).isDisplayed());
    Assert.assertTrue(driver.findElement(companiesPage.getUiElement("Text-field-right")).isDisplayed());
    Assert.assertEquals(properties.getBaseUrl() + "jobs/companies", driver.getCurrentUrl());
  }
}
