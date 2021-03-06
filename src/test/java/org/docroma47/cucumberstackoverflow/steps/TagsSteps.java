package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.TagsPage;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class TagsSteps {

  @Autowired
  private TagsPage tagsPage;

  @When("I navigate to the 'Tags' page")
  public void i_navigate_to_the_tags_page() {
    tagsPage.navigateToTags();
  }

  @Then("current page is 'Tags' page")
  public void current_page_is_tags_page() {
    Assert.assertEquals("Tags", tagsPage.getTitle());
  }
}
