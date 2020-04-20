package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.util.Map.entry;

public abstract class PageNavigation {
  private By colorPage = By.xpath("//body");
  public static java.util.Properties propUrl = new java.util.Properties();

  private java.util.Map<String, String> mapPage = java.util.Map.ofEntries(
      entry("Log_in", "//header//li[@class='-ctas']//a[1]"),
      entry("Home", "//header//span[@class='-img _glyph']"),

      entry("Field_email", "//input[@id='email']"),
      entry("Field_password", "//input[@id='password']"),
      entry("Submit", "//*[@id='submit-button']"),

      entry("Preference", "//a[text()='preferences']"),
      entry("Edit_profile", "//a[text()='Edit profile and settings']"),
      entry("Profile", "//a[@class='my-profile js-gps-track']"),
      entry("Dark-theme", "//input[@id='enableForcedDarkmode']")
  );

  public By getMapPage(String key) {
    return By.xpath(mapPage.get(key));
  }

  public String getPropUrl(String key) {
    return propUrl.getProperty(key);
  }

  public void clickOnPage(WebDriver driver, By xpath) {
    driver.findElement(xpath).click();
  }

  public void clickOnLogIn(WebDriver driver) {
    driver.findElement(getMapPage("Log_in")).click();
  }

  public void clickOnSignUp(WebDriver driver) {
    driver.findElement(getMapPage("Sign_up")).click();
  }

  public void clickHomeButton(WebDriver driver) {
    driver.findElement(getMapPage("Home")).click();
  }

  public String getHeadingText(WebDriver driver, By xpath) {
    return driver.findElement(xpath).getText();
  }

  public String colorPage(WebDriver driver) {
    return driver.findElement(colorPage).getCssValue("background-color");
  }

  public By getHomeImageButton() {
    return getMapPage("Home");
  }

  public String getTextOrName(WebDriver driver, By xpath) {
    return getHeadingText(driver, xpath);
  }

  public Boolean visibleElement(WebDriver driver, By xpath) {
    return driver.findElement(xpath).isDisplayed();
  }

  public void goToProfile(WebDriver driver) {
    clickOnPage(driver, getMapPage("Profile"));
    clickOnPage(driver, getMapPage("Edit_profile"));
  }
}
