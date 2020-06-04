package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.MessagesPage;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class MessagesSteps {

  @Autowired
  private MessagesPage messagesPage;

  @When("I navigate to the 'Jobs Messages' page.")
  public void i_navigate_to_the_jobs_messages_page() {
    messagesPage.navigateToMessages();
  }

  @Then("current page is 'Jobs Messages' page.")
  public void current_page_is_jobs_messages_page() {
    Assert.assertEquals("Messages", messagesPage.getTitle());
    messagesPage.assertBreadcrumbIsSelected();
  }
}
