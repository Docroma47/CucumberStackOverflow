package org.docroma47.cucumberstackoverflow.page;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
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
public class CompaniesPage extends UIComponent {

  @Autowired
  private WebDriver driver;
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

  public boolean isSearchFieldDisplayed() {
    return assertThatAndPerform(visibilityOf(searchField)).isDisplayed();
  }

  public boolean isLocationFilterFieldDisplayed() {
    return assertThatAndPerform(visibilityOf(locationFilterField)).isDisplayed();
  }

  public String getUrl() {
    return properties.getBaseUrl() + "jobs/companies";
  }

  public boolean isBreadcrumbSelected() {
    return assertThatAndPerform(attributeContains(companiesBreadcrumb, "class", "is-selected"));
  }
}
