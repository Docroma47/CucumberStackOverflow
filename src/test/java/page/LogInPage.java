package page;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;

import static java.util.Map.of;

public class LogInPage {
  private WebDriver driver;
  private HashMap<String, String> pageUrls = new HashMap();

  private Map<String, String> uiElements = of(
      "Log_in", "//header//li[@class='-ctas']//a[1]",
      "Field_email", "//input[@id='email']",
      "Field_password", "//input[@id='password']",
      "Submit", "//*[@id='submit-button']"
  );

  public LogInPage(WebDriver driver) {
    this.driver = driver;
    pageUrls.put("Home_page", "https://stackoverflow.com/");
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
