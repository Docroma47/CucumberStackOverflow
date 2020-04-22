package org.docroma47.cucumberstackoverflow.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.docroma47.cucumberstackoverflow.page.UserPreferencesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class KeyboardShortcutsSteps {

  @Autowired
  private WebDriver driver;
  @Autowired
  private UserPreferencesPage userPreferencesPage;

  @When("I enable keyboard shortcuts.")
  public void i_enable_keyboard_shortcuts() {
    WebElement keyboard = driver.findElement(userPreferencesPage.getUiElement("Keyboard-shortcuts"));
    if (!keyboard.isSelected()) {
      keyboard.click();
    }

  }

  @When("I disable keyboard shortcuts.")
  public void i_disable_keyboard_shortcuts() {
    WebElement keyboard = driver.findElement(userPreferencesPage.getUiElement("Keyboard-shortcuts"));
    if (keyboard.isSelected()) {
      keyboard.click();
    }
  }

  @Then("current page is changed to home page.")
  public void current_page_is_changed_to_home_page() {
    WebDriverWait wait = new WebDriverWait(driver, 2);
    wait.until(ExpectedConditions.urlToBe("https://stackoverflow.com/"));
    Assert.assertEquals("https://stackoverflow.com/", driver.getCurrentUrl());
  }

  @Then("current page is preferences page.")
  public void current_page_is_preferences_page() {
    WebDriverWait wait = new WebDriverWait(driver, 2);
    if (driver.getCurrentUrl().contains("preferences")) {
      Assert.assertTrue(true);
    } else {
      Assert.assertTrue(false);
    }
  }

  @And("I press hot keys G and H.")
  public void i_press_hot_keys_G_and_H() {
    userPreferencesPage.inputHotKeysGAndH();
  }

  @And("I refresh page.")
  public void i_refresh_page() {
    driver.navigate().refresh();
  }

}
