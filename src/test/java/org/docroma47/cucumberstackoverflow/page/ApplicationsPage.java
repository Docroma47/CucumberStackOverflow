package org.docroma47.cucumberstackoverflow.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ApplicationsPage extends UIComponent {

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
    assertThatAndPerform(elementToBeClickable(jobsLink)).click();
    assertThatAndPerform(elementToBeClickable(applicationsBreadcrumb)).click();
  }

  public boolean isJobsCheckboxDisplayed() {
    return assertThatAndPerform(visibilityOf(displayJobsCheckbox)).isDisplayed();
  }

  public boolean isBreadcrumbSelected() {
    return assertThatAndPerform(attributeContains(applicationsBreadcrumb, "class", "is-selected"));
  }

}
