package page;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class MainPage {
  private WebDriver driver;
  private HashMap<String, String> pageUrls = new HashMap();

  public MainPage(WebDriver driver) {
    this.driver = driver;
    pageUrls.put("Main_page", "https://stackoverflow.com/");
    pageUrls.put("Log_in_page", "https://stackoverflow.com/users/login?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f");
  }
}
