package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.of;

@Component
public class JobsPage {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='left-sidebar']//*[@id='nav-jobs']",
      "Text-field-left", "//*[@id='content']//*[@id='q']",
      "Text-field-right", "//*[@id='content']//*[@id='l']"
  );

  public JobsPage(WebDriver driver) {
    this.driver = driver;
  }

  private By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public void navigateToJobs() {
    driver.findElement(getUiElement("Jobs")).click();
  }

  public boolean isTextFieldLeftDisplayed() {
    return driver.findElement(getUiElement("Text-field-left")).isDisplayed();
  }

  public boolean isTextFieldRightDisplayed() {
    return driver.findElement(getUiElement("Text-field-right")).isDisplayed();
  }

  public String getJobsUrl() {
    return properties.getBaseUrl() + "jobs";
  }
}
