package org.docroma47.cucumberstackoverflow.page;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class JobsPage extends UIComponent {

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

  public String getJobId() {
    return jobId;
  }

  public void navigateToJobs() {
    assertThatAndPerform(elementToBeClickable(jobsLink)).click();
  }

  public void assertSearchFieldIsDisplayed() {
    assertThatAndPerform(visibilityOf(searchField));
  }

  public void assertLocationFilterFieldIsDisplayed() {
    assertThatAndPerform(visibilityOf(locationFilterField));
  }

  private String getUrl() {
    return properties.getBaseUrl() + "jobs";
  }

  public void assertUrlJobsPage() {
    assertThatAndPerform(urlContains(getUrl()));
  }

  public void assertBreadcrumbIsSelected() {
    assertThatAndPerform(attributeContains(jobsBreadcrumb, "class", "is-selected"));
  }

  public void inputInSearchField(String text) {
    searchField.sendKeys(text);
  }

  public void clickSearchButton() {
    assertThatAndPerform(elementToBeClickable(searchButton)).click();
  }

  public void selectJob(String index) {
    assertThatAndPerform(visibilityOf(featured));
    By jobAdItemPath = By.xpath("//*[@id = 'content']//*[@class = 'listResults']/div[" + index + "]");
    jobId = assertThatAndPerform(presenceOfElementLocated(jobAdItemPath)).getAttribute("data-jobid");
  }

  public void saveSelectedJobAdd() {
    By jobAdSaveButtonPath = By.xpath("//a[@data-jobid = '" + getJobId() + "']");
    if (!assertThatAndPerform(presenceOfElementLocated(jobAdSaveButtonPath)).getText().equals("Saved")) {
      assertThatAndPerform(elementToBeClickable(jobAdSaveButtonPath)).click();
    }
  }

  public void clickSelectedJobAd() {
    String id = getJobId();
    By jobAdPath = By.xpath("//*[@class = 'listResults']//*[@data-result-id = '" + id + "']" + "//a[@class = 's-link stretched-link']");
    if (!assertThatAndPerform(presenceOfElementLocated(By.xpath("//*[@class = 'listResults']//*[@data-result-id = '" + id + "']"))).getAttribute("class")
        .contains("selected")) {
      assertThatAndPerform(elementToBeClickable(jobAdPath)).click();
    }
  }

}
