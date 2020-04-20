package page;
import java.util.Map;

import org.openqa.selenium.*;

import static java.util.Map.of;

public class UserPreferencesPage {
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Preference", "//a[text()='preferences']",
      "Edit_profile", "//a[text()='Edit profile and settings']",
      "Profile", "//a[@class='my-profile js-gps-track']",
      "Dark-theme", "//input[@id='enableForcedDarkmode']"
  );

  public UserPreferencesPage(WebDriver driver) {
    this.driver = driver;
  }

  public By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  private void navigateToPage(By xpath) {
    driver.findElement(xpath).click();
  }

  public void navigateToPreferences() {
    driver.findElement(getUiElement("Preference")).click();
  }

  public String getPageColor() {
    return driver.findElement(By.xpath("//body")).getCssValue("background-color");
  }

  public void navigateToProfile() {
    navigateToPage(getUiElement("Profile"));
    navigateToPage(getUiElement("Edit_profile"));
  }
}
