package org.docroma47.cucumberstackoverflow.page;
import java.util.List;
import java.util.Map;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
  private String saveButtonPath;
  private String adPath;

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

  private void setPathSaveButton(String idJob) {
    saveButtonPath = "//a[@data-jobid='" + idJob + "']";
  }

  private void setPathAd(String idJob) {
    adPath = "//*[@class='listResults']//*[@data-result-id='" + idJob + "']";
  }

  public String getPathSaveButton() {
    return saveButtonPath;
  }

  public String getPathAd() {
    return adPath;
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

  public void inputJava() {
    WebDriverWait wait = new WebDriverWait(driver, 2, 5000);
    driver.findElement(getUiElement("Search-Field")).sendKeys("java");
    wait.until(ExpectedConditions.elementToBeClickable(getUiElement("Search")));
    driver.findElement(getUiElement("Search")).click();
  }

  private String idAd() {
    List<WebElement> listAd = driver.findElements(getUiElement("ListJob"));
    return listAd.get(3).getAttribute("data-jobid");
  }

  public void saveJob() {
    setPathSaveButton(idAd());
    driver.findElement(By.xpath(getPathSaveButton())).click();
  }

  public void clickAd() {
    setPathAd(idAd());
    driver.findElement(By.xpath(getPathAd() + "//a[@class='s-link stretched-link']")).click();
  }

}
