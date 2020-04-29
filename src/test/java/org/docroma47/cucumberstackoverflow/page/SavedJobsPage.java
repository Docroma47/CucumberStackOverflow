package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.util.Map.of;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class SavedJobsPage {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='nav-jobs']",
      "SavedJobs", "//*[@id='TabSavedJobs']",
      "Svg-icon", "//*[@id='content']//*[@class='svg-icon native ']",
      "Button-browse-jobs", "//*[@id='content']//*[@class='s-btn s-btn__filled']",
      "Breadcrumb", "//*[@id='content']//*[@id='TabSavedJobs']"
  );

  private By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public void navigateToSavedJobs() {
    driver.findElement(getUiElement("Jobs")).click();
    driver.findElement(getUiElement("SavedJobs")).click();
  }

  public String getUrl() {
    return properties.getBaseUrl() + "jobs/saved";
  }

  public boolean isBreadcrumbSelected() {
    return driver.findElement(getUiElement("Breadcrumb")).getAttribute("class").contains("is-selected");
  }
}
