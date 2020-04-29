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
public class JobsPage {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='left-sidebar']//*[@id='nav-jobs']",
      "Search-Field", "//*[@id='content']//*[@id='q']",
      "Location-Filter-Field", "//*[@id='content']//*[@id='l']",
      "Breadcrumb", "//*[@id='content']//*[@id='TabJobs']"
  );

  private By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public void navigateToJobs() {
    driver.findElement(getUiElement("Jobs")).click();
  }

  public boolean isSearchFieldDisplayed() {
    return driver.findElement(getUiElement("Search-Field")).isDisplayed();
  }

  public boolean isLocationFilterFieldDisplayed() {
    return driver.findElement(getUiElement("Location-Filter-Field")).isDisplayed();
  }

  public String getUrl() {
    return properties.getBaseUrl() + "jobs";
  }

  public boolean isBreadcrumbSelected() {
    return driver.findElement(getUiElement("Breadcrumb")).getAttribute("class").contains("is-selected");
  }
}