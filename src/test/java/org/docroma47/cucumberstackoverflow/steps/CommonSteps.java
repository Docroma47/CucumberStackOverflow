package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.docroma47.cucumberstackoverflow.TestListener;
import org.docroma47.cucumberstackoverflow.config.CucumberConfiguration;
import org.docroma47.cucumberstackoverflow.page.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CucumberConfiguration.class)
public class CommonSteps {

  @Autowired
  private TestListener listener;
  @Autowired
  private CommonPage commonPage;

  @Given("I am on the main page.")
  public void i_am_on_the_main_page() {
    commonPage.navigateToMainPage();
  }

  @After
  public void embedScreenshotOnFail(Scenario scenario) {
    listener.afterScenario(scenario);
  }

  @Given("I am logged in as a {string} user.")
  public void i_am_logged_in_as_a_regular_user(String whichUser) {
    commonPage.logInAs(whichUser);
  }

  @And("I navigate to the main page.")
  public void i_navigate_to_the_main_page() {
    commonPage.navigateToMainPage();
  }

  @And("I refresh page.")
  public void i_refresh_page() {
    commonPage.refreshPage();
  }
}
