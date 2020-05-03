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
public class SavedJobSearchesPage extends AbstractPage {

  @Autowired
  private WebDriver driver;

  @FindBy(id = "nav-jobs")
  private WebElement jobsLink;
  @FindBy(id = "TabSavedSearches")
  private WebElement savedJobsSearchesBreadcrumb;
  @FindBy(xpath = "//*[@id='content']//*[contains(@class, 'fs-headline1')]")
  private WebElement title;

  public String getTitle() {
    return title.getText();
  }

  public void navigateToSavedJobsSearches() {
    jobsLink.click();
    savedJobsSearchesBreadcrumb.click();
  }

  public boolean isBreadcrumbSelected() {
    return savedJobsSearchesBreadcrumb.getAttribute("class").contains("is-selected");
  }
}
