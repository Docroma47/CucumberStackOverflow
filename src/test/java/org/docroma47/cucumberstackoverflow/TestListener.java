package com.landy.sesame;

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
  private String currentFeature;
  private String currentScenario;

  private void beforeFeature(String feature) {
    driver.manage().deleteAllCookies();
  }

  private void beforeScenarioOnce(Scenario scenario) {
    if (scenario.getSourceTagNames().contains("@CleanOnceBefore")) {
      driver.manage().deleteAllCookies();
    }
  }

  public void beforeScenario(Scenario scenario) {
    String feature = Path.of(scenario.getUri()).getFileName().toString();
    if (this.currentFeature == null || !this.currentFeature.equals(feature)) {
      this.beforeFeature(feature);
      this.currentFeature = feature;
    }
    if (this.currentScenario == null || !this.currentScenario.equals(scenario.getName())) {
      this.beforeScenarioOnce(scenario);
      this.currentScenario = scenario.getName();
    }
    if (scenario.getSourceTagNames().contains("@CleanBefore")) {
      driver.manage().deleteAllCookies();
    }
  }

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
