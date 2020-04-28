package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.of;

@Component
public class SavedJobsPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='nav-jobs']",
      "SavedJobs", "//*[@id='TabSavedJobs']",
      "Svg-icon", "//*[@id='content']//*[@class='svg-icon native ']",
      "Button-browse-jobs", "//*[@id='content']//*[@class='s-btn s-btn__filled']"
  );

  public SavedJobsPage(WebDriver driver) {
    this.driver = driver;
  }

  private By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public void navigateToSavedJobs() {
    driver.findElement(getUiElement("Jobs")).click();
    driver.findElement(getUiElement("SavedJobs")).click();
  }

  public boolean isElementDisplayed(String keyXpath) {
    return driver.findElement(getUiElement(keyXpath)).isDisplayed();
  }
}
