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
public class LogInPage extends AbstractPage {

  @Autowired
  private WebDriver driver;
  @Autowired
  private StackoverflowProperties properties;

  @FindBy(xpath = "//header//li[@class='-ctas']//a[1]")
  private WebElement loginButton;
  @FindBy(id = "email")
  private WebElement emailField;
  @FindBy(id = "password")
  private WebElement passwordField;
  @FindBy(id = "submit-button")
  private WebElement submitButton;
  @FindBy(xpath = "//button[text()='Log out']")
  private WebElement logoutButton;

  private void inputText(WebElement element, String text) {
    element.sendKeys(text);
  }

  public void inputLoginDetails(String email, String password) {
    inputText(emailField, email);
    inputText(passwordField, password);
  }

  private void clickOn(WebElement element) {
    element.click();
  }

  public void navigateToLogin() {
    loginButton.click();
  }

  public void clickSubmitButton() {
    submitButton.click();
  }

  public void login(String whichUser) {
    StackoverflowProperties.User user = properties.getUsers().get(whichUser);
    inputLoginDetails(user.getUsername(), user.getPassword());
    clickSubmitButton();
  }

  public void logout() {
    driver.get(properties.getBaseUrl() + "/users/logout");
    clickOn(logoutButton);
  }

}
