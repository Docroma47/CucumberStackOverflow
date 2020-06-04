package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.UsersPage;
import org.junit.Assert;

import org.springframework.beans.factory.annotation.Autowired;

public class UsersPageSteps {

  @Autowired
  private UsersPage usersPage;

  @When("I navigate to the 'Users' page")
  public void i_navigate_to_the_users_page() {
    usersPage.navigateToUsers();
  }

  @Then("current page is 'Users' page")
  public void current_page_is_users_page() {
    Assert.assertEquals("Users", usersPage.getTitle());
  }
}
