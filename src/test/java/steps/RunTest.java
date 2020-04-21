package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import page.*;

import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/feature"},
    strict = false
)
public class RunTest {
  public static WebDriver driver;
  public static UserPreferencesPage userPreferencesPage;
  public static LogInPage logInPage;
  public static MainPage mainPage;

  @BeforeClass
  public static void setupDriver() {
    FirefoxBinary firefoxBinary = new FirefoxBinary();
    firefoxBinary.addCommandLineOptions("--headless");

    if ((System.getProperty("os.name").substring(0, 3)).equals("Lin")) {
      System.setProperty("webdriver.gecko.driver", "Drivers/Linux/geckodriver");
    } else if ((System.getProperty("os.name").substring(0, 3)).equals("Mac")){
      System.setProperty("webdriver.gecko.driver", "Drivers/MacOs/geckodriver");
    } else {
      System.setProperty("webdriver.gecko.driver", "Drivers\\Windows\\geckodriver.exe");
    }

    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.setBinary(firefoxBinary);
    driver = new FirefoxDriver(firefoxOptions);
    driver.manage().timeouts().implicitlyWait(15, SECONDS);
    driver.manage().window().maximize();
    userPreferencesPage = new UserPreferencesPage(driver);
    logInPage = new LogInPage(driver);
    mainPage = new MainPage(driver);
  }

  @AfterClass
  public static void exit() {
    driver.quit();
  }
}
