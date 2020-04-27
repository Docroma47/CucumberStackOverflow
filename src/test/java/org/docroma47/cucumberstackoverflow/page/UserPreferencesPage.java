package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;


@Component
public class UserPreferencesPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = ofEntries(
      entry("Preference", "//a[text()='preferences']"),
      entry("Edit-profile", "//a[text()='Edit profile and settings']"),
      entry("Profile", "//a[@class='my-profile js-gps-track']"),
      entry("Dark-theme", "//input[@id='enableForcedDarkmode']"),
      entry("Light-theme", "//input[@id='enableForcedLightmode']"),
      entry("Keyboard-shortcuts", "//input[@id='keyboardShortcuts']"),
      entry("Top-bar-xpath", "/html/body/header"),
      entry("Top-bar-stickiness", "//*[@id='fixedHeader']"),
      entry("Start-download-button", "//button[text()='Start download']"),
      entry("Real-name", "//*[@id='RealName']"),
      entry("hide-Left-navigation", "//*[@id='mainbar']//*[@id='hotNetworkQuestions']"),
      entry("Left-navigation-panel", "//*[@id='left-sidebar']")
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

  public void setKeyboardShortcuts(boolean enabled) {
    WebElement keyboard = driver.findElement(getUiElement("Keyboard-shortcuts"));
    if (!keyboard.isSelected() && enabled || keyboard.isSelected() && !enabled) {
      keyboard.click();
    }
  }

  public void setTopBarStickiness(boolean enabled) {
    WebElement topBarStickiness = driver.findElement(getUiElement("Top-bar-stickiness"));
    if (!topBarStickiness.isSelected() && enabled || topBarStickiness.isSelected() && !enabled) {
      topBarStickiness.click();
    }
  }

  public void setTheme(String theme) {
    WebElement setTheme = driver.findElement(getUiElement(theme));
    setTheme.click();
  }

  public Boolean isTopBarFixed() {
    return driver.findElement(getUiElement("Top-bar-xpath")).getAttribute("class").contains("fixed");
  }

  public void setLeftNavigation(boolean enabled) {
    WebElement keyboard = driver.findElement(getUiElement("hide-Left-navigation"));
    if (!keyboard.isSelected() && enabled || keyboard.isSelected() && !enabled) {
      keyboard.click();
    }
  }

  public Boolean isLeftNavigationPanelHidden(boolean hidden) {
    if (hidden) {
      return driver.findElement(getUiElement("Left-navigation-panel")).isDisplayed();
    } else {
      return false;
    }
  }

  public Boolean isLeftNavigationPanelShown(boolean shown) {
    if (shown) {
      return driver.findElement(getUiElement("Left-navigation-panel")).isDisplayed();
    } else {
      return false;
    }
  }
}
