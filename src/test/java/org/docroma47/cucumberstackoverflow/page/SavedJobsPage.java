package org.docroma47.cucumberstackoverflow.page;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class SavedJobsPage extends UIComponent {

  @Autowired
  private StackoverflowProperties properties;
  @Autowired
  private JobsPage jobsPage;

  @FindBy(id = "nav-jobs")
  private WebElement jobsLink;
  @FindBy(id = "TabSavedJobs")
  private WebElement savedJobsBreadcrumb;

  public void navigateToSavedJobs() {
    assertThatAndPerform(elementToBeClickable(jobsLink)).click();
    assertThatAndPerform(elementToBeClickable(savedJobsBreadcrumb)).click();
  }

  private String getUrl() {
    return properties.getBaseUrl() + "jobs/saved";
  }

  public void assertUrlSavedJobsPage() {
    assertThatAndPerform(urlContains(getUrl()));
  }

  public void assertBreadcrumbIsSelected() {
    assertThatAndPerform(attributeContains(savedJobsBreadcrumb, "class", "is-selected"));
  }

  public void deleteJob(String jobId) {
    assertThatAndPerform(presenceOfElementLocated(By.xpath("//button[@data-id = '" + jobId + "' and @title = 'Unfavorite job']"))).click();
  }

  public void assertJobAdIsPresent(String jobId) {
    assertThatAndPerform(invisibilityOfElementLocated(By.xpath("//*[@class = 'listResults']//div[@data-jobid = '" + jobId + "']")));
  }
}
