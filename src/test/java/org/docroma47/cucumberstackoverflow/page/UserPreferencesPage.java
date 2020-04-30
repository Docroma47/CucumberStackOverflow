package org.docroma47.cucumberstackoverflow.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class UserPreferencesPage extends AbstractPage {

  @FindBy(xpath = "//*[@id='left-sidebar']")
  private WebElement leftNavigationPanel;
  @FindBy(xpath = "//*[@id='content']//*[@id='flag-leftnav']")
  private WebElement hideLeftNavigationPanel;
  @FindBy(xpath = "//*[@id='sidebar']//*[@id='hot-network-questions']")
  private WebElement hotNetwordkQuestions;
  @FindBy(xpath = "//input[@id='hotNetworkQuestions']")
  private WebElement hideHotNetwordkQuestions;
  @FindBy(xpath = "//*[@id='RealName']")
  private WebElement realName;
  @FindBy(xpath = "//button[text()='Start download']")
  private WebElement startDownloadButton;
  @FindBy(xpath = "//*[@id='fixedHeader']")
  private WebElement topBarStickness;
  @FindBy(xpath = "/html/body/header")
  private WebElement topBar;
  @FindBy(xpath = "//input[@id='keyboardShortcuts']")
  private WebElement keyboardShortcats;
  @FindBy(xpath = "//input[@id='enableForcedLightmode']")
  private WebElement lightTheme;
  @FindBy(xpath = "//input[@id='enableForcedDarkmode']")
  private WebElement darkTheme;
  @FindBy(xpath = "//a[@class='my-profile js-gps-track']")
  private WebElement profile;
  @FindBy(xpath = "//a[text()='Edit profile and settings']")
  private WebElement editProfile;
  @FindBy(xpath = "//a[text()='preferences']")
  private WebElement preference;
  @FindBy(xpath = "//body")
  private WebElement body;

  public void navigateToPreferences() {
    preference.click();
  }

  public String getPageColor() {
    return body.getCssValue("background-color");
  }

  public void navigateToProfile() {
    profile.click();
    editProfile.click();
  }

  public void inputHotKeysGAndH() {
    driver.findElement(By.tagName("body")).sendKeys(Keys.SHIFT + "?");
    driver.findElement(By.tagName("body")).sendKeys("G");
    driver.findElement(By.tagName("body")).sendKeys("H");
  }

  public void setKeyboardShortcuts(boolean enabled) {
    if (!keyboardShortcats.isSelected() && enabled || keyboardShortcats.isSelected() && !enabled) {
      keyboardShortcats.click();
    }
  }

  public void setTopBarStickiness(boolean enabled) {
    if (!topBarStickness.isSelected() && enabled || topBarStickness.isSelected() && !enabled) {
      topBarStickness.click();
    }
  }

  public void setTheme(String theme) {
    if (theme.equals("Dark-theme")) {
      darkTheme.click();
    } else if (theme.equals("Light-theme")){
      lightTheme.click();
    }
  }

  public Boolean isTopBarFixed() {
    return topBar.getAttribute("class").contains("fixed");
  }

  public void setHideHotNetworkQuestions(boolean enabled) {
    if (!hideHotNetwordkQuestions.isSelected() && enabled || hideHotNetwordkQuestions.isSelected() && !enabled) {
      hideHotNetwordkQuestions.click();
    }
  }

  public boolean isHotNetworkQuestionsDisplayed() {
    if (driver.findElements(By.xpath("//*[@id='sidebar']//*[@id='hot-network-questions']")).isEmpty()) {
      return false;
    } else {
      return hotNetwordkQuestions.isDisplayed();
    }
  }

  public String getRealName() {
    WebDriverWait wait = new WebDriverWait(driver, 2);
    wait.until(ExpectedConditions.visibilityOf(realName));
    return realName.getAttribute("value");
  }

  public void setHideLeftNavigation(boolean enabled) {
    if (!hideLeftNavigationPanel.isSelected() && enabled || hideLeftNavigationPanel.isSelected() && !enabled) {
      hideLeftNavigationPanel.click();
    }
  }

  public Boolean isLeftNavigationPanelDisplayed() {
    return leftNavigationPanel.isDisplayed();
  }

}
