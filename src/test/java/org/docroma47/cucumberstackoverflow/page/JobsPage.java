package org.docroma47.cucumberstackoverflow.page;
import java.util.List;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.util.Map.*;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class JobsPage extends AbstractPage {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;
  private String jobId;

  @FindBy(id = "nav-jobs")
  private WebElement jobsLink;
  @FindBy(id = "TabJobs")
  private WebElement jobsBreadcrumb;
  @FindBy(id = "q")
  private WebElement searchField;
  @FindBy(id = "l")
  private WebElement locationFilterField;
  @FindBy(xpath = "//*[@id='content']//*[contains (@class, 'js-search-btn')]")
  private WebElement searchButton;

  public String getJobID() {
    return jobId;
  }

  public void navigateToJobs() {
    jobsLink.click();
  }

  public boolean isSearchFieldDisplayed() {
    return searchField.isDisplayed();
  }

  public boolean isLocationFilterFieldDisplayed() {
    return locationFilterField.isDisplayed();
  }

  public String getUrl() {
    return properties.getBaseUrl() + "jobs";
  }

  public boolean isBreadcrumbSelected() {
    return jobsBreadcrumb.getAttribute("class").contains("is-selected");
  }

  public void inputInSearchField(String text) {
    searchField.sendKeys(text);
  }

  public void clickSearchButton() {
    searchButton.click();
    WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
    wait.until(ExpectedConditions.visibilityOf(jobsLink));
  }

  public void selectJob(String index) {
    WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
    wait.until(ExpectedConditions.visibilityOf(jobsLink));
    List<WebElement> listAd = driver.findElements(By.xpath("//*[@id='content']//*[@class='listResults']/div"));
    jobId = listAd.get(Integer.valueOf(index)).getAttribute("data-jobid");
  }

  public void saveSelectedJobAdd() {
    WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
    wait.until(ExpectedConditions.visibilityOf(jobsLink));
    By xpath = By.xpath("//a[@data-jobid='" + getJobID() + "']");
    if (driver.findElement(xpath).getText().equals("Save")) {
      driver.findElement(xpath).click();
    }
  }

  public void clickSelectedJobAd() {
    WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
    wait.until(ExpectedConditions.visibilityOf(jobsLink));
    String path;
    path = "//*[@class='listResults']//*[@data-result-id='" + getJobID() + "']" + "//a[@class='s-link stretched-link']";
    driver.findElement(By.xpath(path)).click();
  }

}
