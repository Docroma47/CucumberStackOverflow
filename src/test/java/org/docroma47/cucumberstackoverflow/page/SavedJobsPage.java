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
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class SavedJobsPage extends UIComponent {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;

  @FindBy(id = "nav-jobs")
  private WebElement jobsLink;
  @FindBy(id = "TabSavedJobs")
  private WebElement savedJobsBreadcrumb;

  public void navigateToSavedJobs() {
    assertThatAndPerform(elementToBeClickable(jobsLink)).click();
    assertThatAndPerform(elementToBeClickable(savedJobsBreadcrumb)).click();
  }

  public String getUrl() {
    return properties.getBaseUrl() + "jobs/saved";
  }

  public boolean isBreadcrumbSelected() {
    return assertThatAndPerform(attributeContains(savedJobsBreadcrumb, "class", "is-selected"));
  }

  public void deleteJob(String jobID) {
    assertThatAndPerform(presenceOfElementLocated(By.xpath("//button[@data-id = '" + jobID + "' and @title = 'Unfavorite job']"))).click();
  }

  public boolean isJobAdPresent(String jobID) {
    return !assertThatAndPerform(presenceOfAllElementsLocatedBy(By.xpath("//*[@class = 'listResults']//div[@data-jobid = '" + jobID + "']"))).isEmpty();
  }
}
