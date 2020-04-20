package page;
import java.util.Map;

import org.openqa.selenium.*;

import static java.util.Map.of;

public class UserOptionsPage {
  private static WebDriver driver;

  private Map<String, String> uiElements = of(
      "Log_in", "//header//li[@class='-ctas']//a[1]",
      "Field_email", "//input[@id='email']",
      "Field_password", "//input[@id='password']",
      "Submit", "//*[@id='submit-button']",

      "Preference", "//a[text()='preferences']",
      "Edit_profile", "//a[text()='Edit profile and settings']",
      "Profile", "//a[@class='my-profile js-gps-track']",
      "Dark-theme", "//input[@id='enableForcedDarkmode']"
  );

  public UserOptionsPage(WebDriver driver) {
    this.driver = driver;
  }

  public By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public void navigateToPage(By xpath) {
    driver.findElement(xpath).click();
  }

  public void clickLoginButton() {
    driver.findElement(getUiElement("Log_in")).click();
  }

  public String getPageColor() {
    return driver.findElement(By.xpath("//body")).getCssValue("background-color");
  }

  public void goToProfile() {
    navigateToPage(getUiElement("Profile"));
    navigateToPage(getUiElement("Edit_profile"));
  }

  private void inputText(By xpath, String text) {
    driver.findElement(xpath).sendKeys(text);
  }

  public void inputLogIn(String email, String password) {
    inputText(getUiElement("Field_email"), email);
    inputText(getUiElement("Field_password"), password);
  }

  public void clickSubmitButton() {
    driver.findElement(getUiElement("Submit")).click();
  }

  public void logIn() {
    inputLogIn("romakolotov47@gmail.com", "79213980538r");
    clickSubmitButton();
  }
}
