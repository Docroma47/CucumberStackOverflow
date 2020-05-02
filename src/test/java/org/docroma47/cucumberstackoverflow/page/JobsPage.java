package org.docroma47.cucumberstackoverflow.page;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class JobsPage extends AbstractPage {

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
  @FindBy(xpath = "//span[text() = 'featured']")
  private WebElement featured;

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
  }

  public void selectJob(String index) {
    retry(ExpectedConditions.visibilityOf(featured));
    By jobAdItemPath = By.xpath("//*[@id = 'content']//*[@class = 'listResults']/div[" + index + "]");
    jobId = retry(ExpectedConditions.presenceOfElementLocated(jobAdItemPath)).getAttribute("data-jobid");
  }

  public void saveSelectedJobAdd() {
    By jobAdSaveButtonPath = By.xpath("//a[@data-jobid = '" + getJobID() + "']");
    if (!retry(ExpectedConditions.presenceOfElementLocated(jobAdSaveButtonPath)).getText().equals("Saved")) {
      retry(ExpectedConditions.elementToBeClickable(jobAdSaveButtonPath)).click();
    }
  }

  public void clickSelectedJobAd() {
    By jobAdPath = By.xpath("//*[@class = 'listResults']//*[@data-result-id = '" + getJobID() + "']" + "//a[@class = 's-link stretched-link']");
    retry(ExpectedConditions.elementToBeClickable(jobAdPath)).click();
  }

}
