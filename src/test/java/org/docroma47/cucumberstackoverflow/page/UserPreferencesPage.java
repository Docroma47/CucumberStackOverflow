package org.docroma47.cucumberstackoverflow.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class UserPreferencesPage extends UIComponent {

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
    assertThatAndPerform(elementToBeClickable(preferenceLink)).click();
  }

  public void assertThemeIsDark(boolean expected) {
    assertAttributeContains(body, "class", "theme-dark", expected);
  }

  public void navigateToProfile() {
    assertThatAndPerform(elementToBeClickable(profileLink)).click();
    assertThatAndPerform(elementToBeClickable(editProfileLink)).click();
  }

  public void inputHotKeysGAndH() {
    body.sendKeys(Keys.SHIFT + "?");
    body.sendKeys("G");
    body.sendKeys("H");
  }

  public void setKeyboardShortcuts(boolean enabled) {
    if (!assertThatAndPerform(visibilityOf(keyboardShortcatsCheckbox)).isSelected() && enabled || assertThatAndPerform(visibilityOf(keyboardShortcatsCheckbox))
        .isSelected() && !enabled) {
      assertThatAndPerform(elementToBeClickable(keyboardShortcatsCheckbox)).click();
    }
  }

  public void setTopBarStickiness(boolean enabled) {
    if (!assertThatAndPerform(visibilityOf(topBarSticknessCheckbox)).isSelected() && enabled || assertThatAndPerform(visibilityOf(topBarSticknessCheckbox))
        .isSelected() && !enabled) {
      assertThatAndPerform(elementToBeClickable(topBarSticknessCheckbox)).click();
    }
  }

  public void setTheme(String theme) {
    if (theme.equals("Dark-theme")) {
      assertThatAndPerform(elementToBeClickable(darkThemeRadioButton)).click();
    } else if (theme.equals("Light-theme")){
      assertThatAndPerform(elementToBeClickable(lightThemeRadioButton)).click();
    }
  }

  public Boolean isTopBarFixed() {
    return assertThatAndPerform(attributeContains(topBar, "class", "fixed"));
  }

  public void setHideHotNetworkQuestions(boolean enabled) {
    if (!assertThatAndPerform(visibilityOf(hideHotNetwordkQuestionsCheckbox)).isSelected() && enabled ||
        assertThatAndPerform(visibilityOf(hideHotNetwordkQuestionsCheckbox)).isSelected() && !enabled) {
      assertThatAndPerform(elementToBeClickable(hideHotNetwordkQuestionsCheckbox)).click();
    }
  }

  public boolean isHotNetworkQuestionsDisplayed() {
    if (assertThatAndPerform(presenceOfAllElementsLocatedBy(By.xpath("//*[@id='sidebar']//*[@id='hot-network-questions']"))).isEmpty()) {
      return false;
    } else {
      return assertThatAndPerform(visibilityOf(hotNetwordkQuestionsPanel)).isDisplayed();
    }
  }

  public String getRealName() {
    WebDriverWait wait = new WebDriverWait(driver, 2);
    return assertThatAndPerform(visibilityOf(realNameInputField)).getAttribute("value");
  }

  public void setHideLeftNavigation(boolean enabled) {
    if (!assertThatAndPerform(visibilityOf(hideLeftNavigationPanelCheckbox)).isSelected() && enabled ||
        assertThatAndPerform(visibilityOf(hideLeftNavigationPanelCheckbox)).isSelected() && !enabled) {
      assertThatAndPerform(elementToBeClickable(hideLeftNavigationPanelCheckbox)).click();
    }
  }

  public void assertLeftNavigationVisible(boolean expected) {
    assertElementVisible(leftNavigationPanel, expected);
  }

  public void assertTopBarIsFixed(boolean expected) {
    assertAttributeContains(topBar, "class", "_fixed", expected);
  }

}
