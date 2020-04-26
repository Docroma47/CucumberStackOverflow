package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.of;

@Component
public class TagsPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Tags", "//*[@id='nav-tags']",
      "Text", "//h1"
  );

  public TagsPage(WebDriver driver) {
    this.driver = driver;
  }

  private By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public String getTextPage() {
    return driver.findElement(getUiElement("Text")).getText();
  }

  public void navigateToTags() {
    driver.findElement(getUiElement("Tags")).click();
  }
}
