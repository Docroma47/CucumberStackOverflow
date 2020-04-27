package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.of;

@Component
public class ApplicationsPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='nav-jobs']",
      "Applications", "//*[@id='TabApplication']",
      "Label-display-jobs", "//*[@id='content']//*[contains (@class, 's-label')]",
      "Display-jobs-checkbox", "//*[@id='content']//*[@id='includeExternals']"
  );

  public ApplicationsPage(WebDriver driver) {
    this.driver = driver;
  }

  public By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public String getLabel() {
    return driver.findElement(getUiElement("Label-display-jobs")).getText();
  }

  public void navigateToApplications() {
    driver.findElement(getUiElement("Jobs")).click();
    driver.findElement(getUiElement("Applications")).click();
  }
}
