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

  @When("I navigate to the applications page.")
  public void i_navigate_to_the_applications_page() {
    applicationsPage.navigateToApplications();
  }

  @Then("current page is applications page.")
  public void current_page_is_applications_page() {
    System.out.println(applicationsPage.getTextPage());
    Assert.assertEquals("Display jobs you may have applied to", applicationsPage.getTextPage());
  }
}
