package org.docroma47.cucumberstackoverflow.page;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CompaniesPage extends UIComponent {

  @Autowired
  private StackoverflowProperties properties;

  @FindBy(id = "nav-jobs")
  private WebElement jobsLink;
  @FindBy(id = "TabCompanies")
  private WebElement companiesBreadcrumb;
  @FindBy(id = "q")
  private WebElement searchField;
  @FindBy(id = "l")
  private WebElement locationFilterField;

  public void navigateToCompanies() {
    assertThatAndPerform(elementToBeClickable(jobsLink)).click();
    assertThatAndPerform(elementToBeClickable(companiesBreadcrumb)).click();
  }

  public void assertSearchFieldIsDisplayed() {
    assertThatAndPerform(visibilityOf(searchField));
  }

  public void assertLocationFilterFieldIsDisplayed() {
    assertThatAndPerform(visibilityOf(locationFilterField));
  }

  private String getUrl() {
    return properties.getBaseUrl() + "jobs/companies";
  }

  public void assertUrlCompamiesPage() {
    assertThatAndPerform(urlContains(getUrl()));
  }

  public void assertBreadcrumbIsSelected() {
    assertThatAndPerform(attributeContains(companiesBreadcrumb, "class", "is-selected"));
  }
}
