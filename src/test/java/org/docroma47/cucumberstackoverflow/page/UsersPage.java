package org.docroma47.cucumberstackoverflow.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class UsersPage extends UIComponent {

  @Autowired
  private WebDriver driver;

  @FindBy(id = "nav-users")
  private WebElement usersLink;
  @FindBy(xpath = "//*[@id='content']//*[contains (@class, 'fs-headline1')]")
  private WebElement title;

  public String getTitle() {
    return title.getText();
  }

  public void navigateToUsers() {
    assertThatAndPerform(elementToBeClickable(usersLink)).click();
  }
}
