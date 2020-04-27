package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.ApplicationsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationsSteps {
  @Autowired
  private WebDriver driver;
  @Autowired
  private ApplicationsPage applicationsPage;

  @When("I navigate to the applications.")
  public void i_navigate_to_the_applications() {
    applicationsPage.navigateToApplications();
  }

  @Then("current page is applications.")
  public void current_page_is_applications() {
    Assert.assertEquals("Display jobs you may have applied to", applicationsPage.getLabel());
    Assert.assertTrue(driver.findElement(applicationsPage.getUiElement("Display-jobs-checkbox")).isSelected());
  }
}
