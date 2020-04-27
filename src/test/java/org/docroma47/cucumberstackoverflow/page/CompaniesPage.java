package org.docroma47.cucumberstackoverflow.page;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Map.of;

@Component
public class CompaniesPage {

  @Autowired
  private WebDriver driver;

  private Map<String, String> uiElements = of(
      "Jobs", "//*[@id='nav-jobs']",
      "Companies", "//*[@id='TabCompanies']",
      "Text-field-left", "//*[@id='content']//*[@id='q']",
      "Text-field-right", "//*[@id='content']//*[@id='l']"
  );

  public CompaniesPage(WebDriver driver) {
    this.driver = driver;
  }

  public By getUiElement(String key) {
    return By.xpath(uiElements.get(key));
  }

  public void navigateToCompanies() {
    driver.findElement(getUiElement("Jobs")).click();
    driver.findElement(getUiElement("Companies")).click();
  }
}
