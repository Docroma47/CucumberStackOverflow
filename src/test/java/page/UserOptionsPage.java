package page;

import org.openqa.selenium.*;

public class UserOptionsPage extends PageNavigation {
  private static WebDriver driver;
  private By tags = By.xpath("//table//form//a[1]");
  private static java.util.Properties propUrlUserOptions = new java.util.Properties();

  public UserOptionsPage(WebDriver driver) {
    this.driver = driver;
    propUrl.setProperty("Main_page", "https://stackoverflow.com/users/edit/13143191");
  }

  public java.util.List<WebElement> listTags(WebDriver driver) {
    return driver.findElements(tags);
  }


  public void clearTags() {
    for (WebElement linkDelete : listTags(driver)) {
      linkDelete.click();
    }
  }

}
