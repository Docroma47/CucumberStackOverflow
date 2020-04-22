package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.Given;
import org.docroma47.cucumberstackoverflow.config.CucumberConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// This class should contain at least one step in order to force cucumber to auto-load all other steps
@SpringBootTest(classes = CucumberConfiguration.class)
public class CommonSteps {

  @Autowired
  private WebDriver driver;

  @Given("I am on the main page.")
  public void i_am_on_the_main_page() {
    driver.get("https://stackoverflow.com/");
  }

}
