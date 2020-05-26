package org.docroma47.cucumberstackoverflow;

import java.nio.file.Path;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

  @Autowired
  private WebDriver driver;

  public void afterScenario(Scenario scenario) {
    embedScreenshot(scenario);
  }

  private void embedScreenshot(Scenario scenario) {
    if (scenario.isFailed()) {
      TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
      byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
      String fileName = String.format("%s [%s].png", scenario.getName(), scenario.getLine());
      scenario.attach(screenshot, "image/png", fileName);
      takesScreenshot.getScreenshotAs(OutputType.FILE).renameTo(Path.of("results/" + fileName).toFile());
    }
  }

}
