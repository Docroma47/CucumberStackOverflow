package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.of;

@Component
public class UserPreferencesPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Preference", "//a[text()='preferences']",
      "Edit-profile", "//a[text()='Edit profile and settings']",
      "Profile", "//a[@class='my-profile js-gps-track']",
      "Dark-theme", "//input[@id='enableForcedDarkmode']",
      "Keyboard-shortcuts", "//input[@id='keyboardShortcuts']",
      "Top-bar-xpath", "/html/body/header",
      "Top-bar-stickiness", "//*[@id='fixedHeader']",
      "Start-download-button", "//button[text()='Start download']"
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
    navigateToPage(getUiElement("Edit-profile"));
  }

  public void inputHotKeysGAndH() {
    driver.findElement(By.tagName("body")).sendKeys(Keys.SHIFT + "?");
    driver.findElement(By.tagName("body")).sendKeys("G");
    driver.findElement(By.tagName("body")).sendKeys("H");
  }

  public void toggleKeyboardShortcuts(boolean enabled) {
    WebElement keyboard = driver.findElement(getUiElement("Keyboard-shortcuts"));
    if (!keyboard.isSelected() && enabled == true || keyboard.isSelected() && enabled == false) {
      keyboard.click();
    }
  }
}
