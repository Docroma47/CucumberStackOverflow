package org.docroma47.cucumberstackoverflow.page;
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

  public void deleteJob(String jobID) {
    String path = "//*[@class='listResults']//*[@data-result-id='" + jobID + "']";
    if (!driver.findElement(By.xpath(path)).getAttribute("class").contains("_selected")) {
      driver.findElement(By.xpath(path + "//a[@class='s-link stretched-link']")).click();
    }
    driver.findElement(By.xpath("//a[@data-jobid=" + jobID + "]")).click();
    driver.navigate().refresh();
    WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(getUiElement("Jobs"))));
  }

  public String findJob(String jobID) {
    WebElement jobAd;
    Boolean isEmpty;
    String path;
    path = "//*[@class='listResults']//*[@data-result-id='" + jobID + "']" + "//a[@class='s-link stretched-link']";
    isEmpty = driver.findElements(By.xpath(path)).isEmpty();
    if (isEmpty) {
      return null;
    } else {
      jobAd = driver.findElement(By.xpath(path));
      return jobAd.getText();
    }
  }
}
