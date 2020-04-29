package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.util.Map.of;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class SavedJobSearchesPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='nav-jobs']",
      "SavedJobsSearches", "//*[@id='TabSavedSearches']",
      "Title", "//*[@id='content']//*[contains(@class, 'fs-headline1')]",
      "Breadcrumb", "//*[@id='content']//*[@id='TabSavedSearches']"
  );

  private By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public String getTitle() {
    return driver.findElement(getUiElement("Title")).getText();
  }

  public void navigateToSavedJobsSearches() {
    driver.findElement(getUiElement("Jobs")).click();
    driver.findElement(getUiElement("SavedJobsSearches")).click();
  }

  public boolean isBreadcrumbSelected() {
    return driver.findElement(getUiElement("Breadcrumb")).getAttribute("class").contains("is-selected");
  }
}
