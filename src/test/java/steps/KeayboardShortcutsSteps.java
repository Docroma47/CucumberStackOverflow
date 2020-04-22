package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeayboardShortcutsSteps extends RunTest{

  @When("I enable keyboard shortcuts.")
  public void i_enable_keyboard_shortcuts() {
    driver.findElement(userPreferencesPage.getUiElement("Keyboard-shortcuts")).click();
  }

  @Then("current page is changed to home page.")
  public void current_page_is_changed_to_home_page() {
    WebDriverWait wait = new WebDriverWait(driver, 2);
    wait.until(ExpectedConditions.urlToBe("https://stackoverflow.com/"));
    Assert.assertEquals("https://stackoverflow.com/", driver.getCurrentUrl());
  }

  @And("I press hot keys G and H.")
  public void i_press_hot_keys_G_and_H() {
    userPreferencesPage.inputHotKeysGAndH();
  }

}
