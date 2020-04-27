package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.of;

@Component
public class MessagesPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='nav-jobs']",
      "Messages", "//*[@id='TabMessages']",
      "Title", "//*[@id='content']//*[contains (@class, 'fs-headline1')]"
  );

  public MessagesPage(WebDriver driver) {
    this.driver = driver;
  }

  private By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public String getTitle() {
    return driver.findElement(getUiElement("Title")).getText();
  }

  public void navigateToMessages() {
    driver.findElement(getUiElement("Jobs")).click();
    driver.findElement(getUiElement("Messages")).click();
  }
}
