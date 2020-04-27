package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.SavedJobsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class SavedJobsSteps {
  @Autowired
  private WebDriver driver;
  @Autowired
  private SavedJobsPage savedJobsPage;

  @When("I navigate to the saved jobs.")
  public void i_navigate_to_the_saved_jobs() {
    savedJobsPage.navigateToSavedJobs();
  }

  @Then("current page is saved jobs.")
  public void current_page_is_saved_jobs() {
    Assert.assertTrue(driver.findElement(savedJobsPage.getUiElement("Button-browse-jobs")).isDisplayed());
    Assert.assertTrue(driver.findElement(savedJobsPage.getUiElement("Svg-icon")).isDisplayed());
  }
}
