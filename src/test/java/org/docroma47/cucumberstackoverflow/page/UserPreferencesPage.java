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

  @FindBy(id = "left-sidebar")
  private WebElement leftNavigationPanel;
  @FindBy(id = "flag-leftnav")
  private WebElement hideLeftNavigationPanelCheckbox;
  @FindBy(id = "hot-network-questions")
  private WebElement hotNetwordkQuestionsPanel;
  @FindBy(id = "hotNetworkQuestions")
  private WebElement hideHotNetwordkQuestionsCheckbox;
  @FindBy(id = "RealName")
  private WebElement realNameInputField;
  @FindBy(id = "fixedHeader")
  private WebElement topBarSticknessCheckbox;
  @FindBy(xpath = "/html/body/header")
  private WebElement topBar;
  @FindBy(id = "keyboardShortcuts")
  private WebElement keyboardShortcatsCheckbox;
  @FindBy(id = "enableForcedLightmode")
  private WebElement lightThemeRadioButton;
  @FindBy(id = "enableForcedDarkmode")
  private WebElement darkThemeRadioButton;
  @FindBy(xpath = "//a[@class='my-profile js-gps-track']")
  private WebElement profileLink;
  @FindBy(linkText = "Edit profile and settings")
  private WebElement editProfileLink;
  @FindBy(linkText = "preferences")
  private WebElement preferenceLink;
  @FindBy(xpath = "//body")
  private WebElement body;

  public void navigateToPreferences() {
    preferenceLink.click();
  }

  public void assertThemeIsDark(boolean expected) {
    assertAttributeContains(body, "class", "theme-dark", expected);
  }

  public void navigateToProfile() {
    profileLink.click();
    editProfileLink.click();
  }

  public void inputHotKeysGAndH() {
    body.sendKeys(Keys.SHIFT + "?");
    body.sendKeys("G");
    body.sendKeys("H");
  }

  public void setKeyboardShortcuts(boolean enabled) {
    if (!keyboardShortcatsCheckbox.isSelected() && enabled || keyboardShortcatsCheckbox.isSelected() && !enabled) {
      keyboardShortcatsCheckbox.click();
    }
  }

  public void setTopBarStickiness(boolean enabled) {
    if (!topBarSticknessCheckbox.isSelected() && enabled || topBarSticknessCheckbox.isSelected() && !enabled) {
      topBarSticknessCheckbox.click();
    }
  }

  public void setTheme(String theme) {
    if (theme.equals("Dark-theme")) {
      darkThemeRadioButton.click();
    } else if (theme.equals("Light-theme")){
      lightThemeRadioButton.click();
    }
  }

  public Boolean isTopBarFixed() {
    return retry(ExpectedConditions.attributeContains(topBar, "class", "fixed")).booleanValue();
  }

  public void setHideHotNetworkQuestions(boolean enabled) {
    if (!hideHotNetwordkQuestionsCheckbox.isSelected() && enabled || hideHotNetwordkQuestionsCheckbox.isSelected() && !enabled) {
      hideHotNetwordkQuestionsCheckbox.click();
    }
  }

  public boolean isHotNetworkQuestionsDisplayed() {
    if (driver.findElements(By.xpath("//*[@id='sidebar']//*[@id='hot-network-questions']")).isEmpty()) {
      return false;
    } else {
      return hotNetwordkQuestionsPanel.isDisplayed();
    }
  }

  public String getRealName() {
    WebDriverWait wait = new WebDriverWait(driver, 2);
    wait.until(ExpectedConditions.visibilityOf(realNameInputField));
    return realNameInputField.getAttribute("value");
  }

  public void setHideLeftNavigation(boolean enabled) {
    if (!hideLeftNavigationPanelCheckbox.isSelected() && enabled || hideLeftNavigationPanelCheckbox.isSelected() && !enabled) {
      hideLeftNavigationPanelCheckbox.click();
    }
  }

  public void assertLeftNavigationVisible(boolean expected) {
    assertElementVisible(leftNavigationPanel, expected);
  }

  public void assertTopBarIsFixed(boolean expected) {
    assertAttributeContains(topBar, "class", "_fixed", expected);
  }

}
