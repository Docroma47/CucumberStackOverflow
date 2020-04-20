package page;
import org.openqa.selenium.*;

public class LogInPage extends PageNavigation {
  private static WebDriver driver;

  public LogInPage(WebDriver driver) {
    this.driver = driver;
    propUrl.setProperty("Home_page", "https://stackoverflow.com/");
  }

  private void inputText(By xpath, String text) {
    driver.findElement(xpath).sendKeys(text);
  }

  public void inputLogIn(String email, String password) {
    inputText(getMapPage("Field_email"), email);
    inputText(getMapPage("Field_password"), password);
  }

  public void clickSubmitButton() {
    driver.findElement(getMapPage("Submit")).click();
  }

  public void logIn() {
    inputLogIn("romakolotov47@gmail.com", "79213980538r");
    clickSubmitButton();
  }

  public void logout() {
    clickOnPage(driver, getMapPage("Menubar"));
    clickOnPage(driver, getMapPage("Log_out"));
    clickOnPage(driver, getMapPage("Logout"));
  }

}
