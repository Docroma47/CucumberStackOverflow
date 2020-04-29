package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.JobsPage;
import org.docroma47.cucumberstackoverflow.page.SavedJobsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchAndSaveSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private SavedJobsPage savedJobsPage;
  @Autowired
  private JobsPage jobsPage;

  @When("I input 'Java' on the search field.")
  public void i_input_java_on_the_search_field() {
    jobsPage.inputJava();
  }

  @And("I press 'Save'.")
  public void i_press_save() {
    jobsPage.saveJob();
  }

  @And("I delete new ad.")
  public void i_delete_new_ad() {
    savedJobsPage.deleteAd();
  }

  @And("I click on the ad.")
  public void i_click_on_the_ad() {
    jobsPage.clickAd();
  }

  @Then("new ad is deleted.")
  public void the_ad_is_deleted() {
    Assert.assertTrue(savedJobsPage.isAdDeleted());
  }
}
