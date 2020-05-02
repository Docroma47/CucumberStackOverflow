package org.docroma47.cucumberstackoverflow.page;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

  public void navigateToSavedJobs() {
    if (!savedJobsBreadcrumb.isDisplayed()) {
      jobsLink.click();
    }
    savedJobsBreadcrumb.click();
  }

  public String getUrl() {
    return properties.getBaseUrl() + "jobs/saved";
  }

  public boolean isBreadcrumbSelected() {
    return savedJobsBreadcrumb.getAttribute("class").contains("is-selected");
  }

  public void deleteJob(String jobID) {
    retry(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id = '" + jobID + "' and @title = 'Unfavorite job']"))).click();
  }

  public boolean isJobAdPresent(String jobID) {
    return !driver.findElements(By.xpath("//*[@class = 'listResults']//div[@data-jobid = '" + jobID + "']")).isEmpty();
  }
}
