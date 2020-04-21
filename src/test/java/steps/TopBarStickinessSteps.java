package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class TopBarStickinessSteps extends RunTest{

  @When("I enable Top bar stickiness.")
  public void i_enable_top_bar_stickiness() {
    driver.findElement(userPreferencesPage.getUiElement("Top-bar-stickiness")).click();
  }

  @Then("Top bar is not shown.")
  public void top_bar_is_not_shown() {
    if (driver.findElement(userPreferencesPage.getUiElement("Top-bar-xpath")).getAttribute("class").contains("fixed")) {
      Assert.assertTrue(false);
    } else {
      Assert.assertTrue(true);
    }
  }

  @And("I scroll to the bottom.")
  public void i_scroll_to_the_bottom() {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(userPreferencesPage.getUiElement("Start-download-button")));
  }
}
