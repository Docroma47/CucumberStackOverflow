package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.QuestionsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionsSteps {
  @Autowired
  private WebDriver driver;
  @Autowired
  private QuestionsPage questionsPage;

  @When("I navigate to the questions.")
  public void i_navigate_to_the_questions() {
    questionsPage.navigateToQuestions();
  }

  @Then("current page is questions.")
  public void current_page_is_questions() {
    Assert.assertEquals("All Questions", questionsPage.getTitle());
  }
}
