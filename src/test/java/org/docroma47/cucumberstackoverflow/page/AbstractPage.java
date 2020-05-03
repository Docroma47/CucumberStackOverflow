package org.docroma47.cucumberstackoverflow.page;

import java.time.Duration;
import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPage {

  @Autowired
  private StackoverflowProperties properties;

  @Autowired
  protected WebDriver driver;

  @PostConstruct
  private void initElements() {
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, properties.getSelenium().getGlobalWaitTimeout()), this);
  }

  public <T> T retry(@Nonnull ExpectedCondition<T> action) {
    Wait<WebDriver> stubbornWait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(properties.getSelenium().getLocalWaitTimout()))
        .pollingEvery(Duration.ofSeconds(properties.getSelenium().getPollRate()))
        .ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class);
    return stubbornWait.until(action);
  }

}
