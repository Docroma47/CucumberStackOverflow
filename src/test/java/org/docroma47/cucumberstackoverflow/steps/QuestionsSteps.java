package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.QuestionsPage;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionsSteps {

  @Autowired
  private QuestionsPage questionsPage;

  @When("I navigate to the 'Questions' page")
  public void i_navigate_to_the_questions_page() {
    questionsPage.navigateToQuestions();
  }

  @Then("current page is 'Questions' page")
  public void current_page_is_questions_page() {
    Assert.assertEquals("All Questions", questionsPage.getTitle());
  }
}
