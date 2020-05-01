package org.docroma47.cucumberstackoverflow.page;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class SavedJobsPage extends AbstractPage {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;

  @FindBy(id = "nav-jobs")
  private WebElement jobsLink;
  @FindBy(id = "TabSavedJobs")
  private WebElement savedJobsBreadcrumb;
  @FindBy(xpath = "//*[@id='content']//*[@class='s-btn s-btn__filled']")
  private WebElement browseJobsButton;

  public void navigateToSavedJobs() {
    jobsLink.click();
    savedJobsBreadcrumb.click();
  }

  public String getUrl() {
    return properties.getBaseUrl() + "jobs/saved";
  }

  public boolean isBreadcrumbSelected() {
    return savedJobsBreadcrumb.getAttribute("class").contains("is-selected");
  }

  public void deleteJob(String jobID) {
    String path = "//*[@class='listResults']//*[@data-result-id='" + jobID + "']";
    if (!driver.findElement(By.xpath(path)).getAttribute("class").contains("_selected")) {
      driver.findElement(By.xpath(path + "//a[@class='s-link stretched-link']")).click();
    }
    driver.findElement(By.xpath("//a[@data-jobid=" + jobID + "]")).click();
    driver.navigate().refresh();
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
