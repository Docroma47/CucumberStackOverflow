package org.docroma47.cucumberstackoverflow.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentAsserts {

  private final WebDriver driver;
  private final int timeout;
  private final int pollRate;
  private final List<ExpectedCondition<?>> conditions = new ArrayList<>();

  public FluentAsserts(WebDriver driver, int timeout, int pollRate) {
    this.driver = driver;
    this.timeout = timeout;
    this.pollRate = pollRate;
  }

  public <T> FluentAsserts thenAssert(ExpectedCondition<T> condition) {
    conditions.add(condition);
    return this;
  }

  public <T> void thenAssertAndPerform(ExpectedCondition<T> condition, Consumer<T> consumer) {
    perform();
    consumer.accept(getWait().until(condition));
  }

  public <T> T thenAssertAndPerform(ExpectedCondition<T> condition) {
    perform();
    return getWait().until(condition);
  }

  public FluentAsserts thenMoveTo(WebElement element) {
    return then(() -> new Actions(driver).moveToElement(element).perform());
  }

  public FluentAsserts then(Runnable runnable) {
    conditions.add((driver) -> {
      runnable.run();
      return true;
    });
    return this;
  }

  public void perform() {
    getWait().until(ExpectedConditions.and(this.conditions.toArray(new ExpectedCondition[0])));
  }

  private Wait<WebDriver> getWait() {
    return new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofMillis(pollRate))
        .ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class);
  }

}
