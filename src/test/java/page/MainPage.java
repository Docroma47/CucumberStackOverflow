package page;

import org.openqa.selenium.WebDriver;

public class MainPage extends PageNavigation {
  private static WebDriver driver;

  public MainPage(WebDriver driver) {
    this.driver = driver;
    propUrl.setProperty("Main_page", "https://stackoverflow.com/");
    propUrl.setProperty("Log_in_page", "https://stackoverflow.com/users/login?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f");
  }
}
