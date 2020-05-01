package org.docroma47.cucumberstackoverflow.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ApplicationsPage extends AbstractPage {

  @Autowired
  private WebDriver driver;

  @FindBy(id = "nav-jobs")
  private WebElement jobsLink;
  @FindBy(id = "TabApplication")
  private WebElement applicationsBreadcrumb;
  @FindBy(xpath = "//*[@id='content']//*[contains (@class, 's-label')]")
  private WebElement labelDisplayJobs;
  @FindBy(id = "includeExternals")
  private WebElement displayJobsCheckbox;

  public String getLabel() {
    return labelDisplayJobs.getText();
  }

  public void navigateToApplications() {
    jobsLink.click();
    applicationsBreadcrumb.click();
  }

  public boolean isJobsCheckboxDisplayed() {
    return displayJobsCheckbox.isDisplayed();
  }

  public boolean isBreadcrumbSelected() {
    return applicationsBreadcrumb.getAttribute("class").contains("is-selected");
  }

}
