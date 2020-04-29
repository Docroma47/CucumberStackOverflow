package org.docroma47.cucumberstackoverflow.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.util.concurrent.TimeUnit.SECONDS;

@EnableConfigurationProperties({ StackoverflowProperties.class })
@ComponentScan(basePackages = "org.docroma47.cucumberstackoverflow")
@Configuration
public class CucumberConfiguration {

  @Bean(destroyMethod = "quit")
  @Scope(SCOPE_CUCUMBER_GLUE)
  public WebDriver webDriver() {
    if ((System.getProperty("os.name").substring(0, 3)).equals("Lin")) {
      System.setProperty("webdriver.gecko.driver", "Drivers/Linux/geckodriver");
    } else if ((System.getProperty("os.name").substring(0, 3)).equals("Mac")){
      System.setProperty("webdriver.gecko.driver", "Drivers/MacOs/geckodriver");
    } else {
      System.setProperty("webdriver.gecko.driver", "Drivers\\Windows\\geckodriver.exe");
    }

    FirefoxBinary firefoxBinary = new FirefoxBinary();
    firefoxBinary.addCommandLineOptions("--headless");

    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.setBinary(firefoxBinary);
    WebDriver driver = new FirefoxDriver(firefoxOptions);
    driver.manage().timeouts().implicitlyWait(15, SECONDS);
    driver.manage().window().maximize();
    return driver;
  }

}
