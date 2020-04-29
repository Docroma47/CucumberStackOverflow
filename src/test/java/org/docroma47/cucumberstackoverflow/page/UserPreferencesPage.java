package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.util.Map.entry;
import static java.util.Map.ofEntries;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class UserPreferencesPage extends AbstractPage {

  @FindBy(id = "left-sidebar")
  private WebElement leftSidebar;

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
      entry("hide-Hot-network-questions", "//input[@id='hotNetworkQuestions']"),
      entry("Hot-network-questions", "//*[@id='sidebar']//*[@id='hot-network-questions']"),
      entry("hide-Left-navigation", "//*[@id='content']//*[@id='flag-leftnav']"),
      entry("Left-navigation-panel", "//*[@id='left-sidebar']")
  );

  private By getUiElement(String key) {
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

  public void setHideHotNetworkQuestions(boolean enabled) {
    WebElement keyboard = driver.findElement(getUiElement("hide-Hot-network-questions"));
    if (!keyboard.isSelected() && enabled || keyboard.isSelected() && !enabled) {
      keyboard.click();
    }
  }

  public boolean isHotNetworkQuestionsDisplayed() {
    if (driver.findElements(getUiElement("Hot-network-questions")).isEmpty()) {
      return false;
    } else {
      return driver.findElement(getUiElement("Hot-network-questions")).isDisplayed();
    }
  }

  public String getRealName() {
    WebDriverWait wait = new WebDriverWait(driver, 2);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(getUiElement("Real-name"))));
    return driver.findElement(getUiElement("Real-name")).getAttribute("value");
  }

  public void setHideLeftNavigation(boolean enabled) {
    WebElement hideLeftNavigation = driver.findElement(getUiElement("hide-Left-navigation"));
    if (!hideLeftNavigation.isSelected() && enabled || hideLeftNavigation.isSelected() && !enabled) {
      hideLeftNavigation.click();
    }
  }

  public Boolean isLeftNavigationPanelDisplayed() {
    return leftSidebar.isDisplayed();
  }

}
