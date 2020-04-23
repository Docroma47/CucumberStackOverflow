package org.docroma47.cucumberstackoverflow.steps;

import java.nio.file.Path;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.docroma47.cucumberstackoverflow.config.CucumberConfiguration;
import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// This class should contain at least one step in order to force cucumber to auto-load all other steps
@SpringBootTest(classes = CucumberConfiguration.class)
public class CommonSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;

  @Given("I am on the main page.")
  public void i_am_on_the_main_page() {
    driver.get(properties.getBaseUrl());
  }

  @After
  public void embedScreenshotOnFail(Scenario scenario) {
    if (scenario.isFailed()) {
      TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
      byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
      scenario.embed(screenshot, "image/png", "Failure screenshot: " + scenario.getName());
      takesScreenshot.getScreenshotAs(OutputType.FILE).renameTo(
          Path.of("results/" + scenario.getName() + ".png").toFile());
    }
  }

}
