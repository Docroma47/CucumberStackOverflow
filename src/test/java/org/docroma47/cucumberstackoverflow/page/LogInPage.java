package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.of;

@Component
public class LogInPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Log_in", "//header//li[@class='-ctas']//a[1]",
      "Field_email", "//input[@id='email']",
      "Field_password", "//input[@id='password']",
      "Submit", "//*[@id='submit-button']"
  );

  public LogInPage(WebDriver driver) {
    this.driver = driver;
  }

  public By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  private void inputText(By xpath, String text) {
    driver.findElement(xpath).sendKeys(text);
  }

  public void inputLoginDetails(String email, String password) {
    inputText(getUiElement("Field_email"), email);
    inputText(getUiElement("Field_password"), password);
  }

  public void navigateToLogin() {
    driver.findElement(getUiElement("Log_in")).click();
  }

  public void clickSubmitButton() {
    driver.findElement(getUiElement("Submit")).click();
  }

  public void login() {
    inputLoginDetails("romakolotov47@gmail.com", "79213980538r");
    clickSubmitButton();
  }

}