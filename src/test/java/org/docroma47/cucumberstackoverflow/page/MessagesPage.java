package org.docroma47.cucumberstackoverflow.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class MessagesPage extends UIComponent {

  @FindBy(id = "nav-jobs")
  private WebElement jobsLink;
  @FindBy(id = "TabMessages")
  private WebElement messagesBreadcrumb;
  @FindBy(xpath = "//*[@id='content']//*[contains (@class, 'fs-headline1')]")
  private WebElement title;

  public String getTitle() {
    return title.getText();
  }

  public void navigateToMessages() {
    assertThatAndPerform(elementToBeClickable(jobsLink)).click();
    assertThatAndPerform(elementToBeClickable(messagesBreadcrumb)).click();
  }

  public void isBreadcrumbSelected() {
    assertThatAndPerform(attributeContains(messagesBreadcrumb, "class", "is-selected"));
  }
}
