package org.docroma47.cucumberstackoverflow.page;

import java.nio.file.Path;

import io.cucumber.java.Scenario;
import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CommonPage extends UIComponent {

  @Autowired
  private LogInPage logInPage;
  @Autowired
  private StackoverflowProperties properties;

  public void navigateToMainPage() {
    driver.get(properties.getBaseUrl());
  }

  public void refreshPage() {
    driver.navigate().refresh();
  }

  public void screenshotOnFail(Scenario scenario) {
    if (scenario.isFailed()) {
      TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
      byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
      scenario.embed(screenshot, "image/png", "Failure screenshot: " + scenario.getName());
      takesScreenshot.getScreenshotAs(OutputType.FILE).renameTo(
          Path.of("results/" + scenario.getName() + ".png").toFile());
    }
  }

  public void logInAs (String whichUser) {
    driver.get(properties.getBaseUrl());
    Cookie authCookie = driver.manage().getCookieNamed("acct");
    if (authCookie == null) {
      logInPage.navigateToLogin();
      logInPage.login(whichUser);
    }

    if (driver.getCurrentUrl().startsWith(properties.getBaseUrl() + "nocaptcha")) {
      System.out.println("Captcha validation");
    }

    assertThatAndPerform(urlToBe(properties.getBaseUrl()));
    authCookie = driver.manage().getCookieNamed("acct");
    Assert.assertNotNull(authCookie);
  }

}
