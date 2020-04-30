package org.docroma47.cucumberstackoverflow.page;
import java.util.List;
import java.util.Map;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.util.Map.*;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class JobsPage {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;
  private String jobId;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='left-sidebar']//*[@id='nav-jobs']",
      "Search-Field", "//*[@id='content']//*[@id='q']",
      "Location-Filter-Field", "//*[@id='content']//*[@id='l']",
      "Breadcrumb", "//*[@id='content']//*[@id='TabJobs']",
      "Search", "//*[@id='content']//*[contains (@class, 'js-search-btn')]",
      "ListJob", "//*[@id='content']//*[@class='listResults']/div"
  );

  private By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public String getJobID() {
    return jobId;
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

  public void inputInSearchField(String text) {
    driver.findElement(getUiElement("Search-Field")).sendKeys(text);
  }

  public void clickSearchButton() {
    driver.findElement(getUiElement("Search")).click();
  }

  public void selectJob(String index) {
    List<WebElement> listAd = driver.findElements(getUiElement("ListJob"));
    jobId = listAd.get(Integer.valueOf(index)).getAttribute("data-jobid");
  }

  public void clickSaveInSelectedJobAd() {
    By xpath = By.xpath("//a[@data-jobid='" + getJobID() + "']");
    if (driver.findElement(xpath).getText().equals("Save")) {
      driver.findElement(xpath).click();
    }
  }

  public void clickSelectedJobAd() {
    String path;
    path = "//*[@class='listResults']//*[@data-result-id='" + getJobID() + "']" + "//a[@class='s-link stretched-link']";
    driver.findElement(By.xpath(path)).click();
  }

}
