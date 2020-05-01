package org.docroma47.cucumberstackoverflow.page;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CompaniesPage extends AbstractPage {

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
    jobsLink.click();
    companiesBreadcrumb.click();
  }

  public boolean isSearchFieldDisplayed() {
    return searchField.isDisplayed();
  }

  public boolean isLocationFilterFieldDisplayed() {
    return locationFilterField.isDisplayed();
  }

  public String getUrl() {
    return properties.getBaseUrl() + "jobs/companies";
  }

  public boolean isBreadcrumbSelected() {
    return companiesBreadcrumb.getAttribute("class").contains("is-selected");
  }
}
