package org.docroma47.cucumberstackoverflow.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class TagsPage extends UIComponent {

  @FindBy(id = "nav-tags")
  private WebElement tagsLink;
  @FindBy(xpath = "//*[@id='content']//*[contains (@class, 'fs-headline1')]")
  private WebElement title;

  public String getTitle() {
    return title.getText();
  }

  public void navigateToTags() {
    assertThatAndPerform(elementToBeClickable(tagsLink)).click();
  }
}
