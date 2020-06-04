package org.docroma47.cucumberstackoverflow.page;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import org.assertj.core.api.Assertions;
import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.docroma47.cucumberstackoverflow.utils.FluentAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Component
public abstract class UIComponent {

  @Autowired
  private StackoverflowProperties properties;
  @Autowired
  protected WebDriver driver;

  @PostConstruct
  private void initElements() {
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, properties.getSelenium().getWaitTimeout()), this);
  }

  public <T> FluentAsserts assertThat(ExpectedCondition<T> condition) {
    return new FluentAsserts(driver, properties.getSelenium().getWaitTimeout(), properties.getSelenium().getPollRate())
        .thenAssert(condition);
  }

  public <T> FluentAsserts assertThat(ExpectedCondition<T> condition, int timeout) {
    return new FluentAsserts(driver, timeout, properties.getSelenium().getPollRate())
        .thenAssert(condition);
  }

  public <T> T assertThatAndPerform(ExpectedCondition<T> condition) {
    return new FluentAsserts(driver, properties.getSelenium().getWaitTimeout(), properties.getSelenium().getPollRate())
        .thenAssertAndPerform(condition);
  }

  public void assertMenuItemsExist(List<String> expected, By containerPath) {
    List<String> actual = assertThatAndPerform(presenceOfElementLocated(containerPath))
        .findElements(containerPath)
        .stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
    Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
  }

  protected void assertElementVisible(WebElement element, boolean expected) {
    if (expected) {
      assertThatAndPerform(visibilityOf(element)).isDisplayed();
    } else {
      assertThatAndPerform(invisibilityOf(element));
    }
  }

  protected void assertAttributeContains(WebElement element, String attributeName, String value, boolean expected) {
    if (expected) {
      assertThatAndPerform(attributeContains(element, attributeName, value));
    } else {
      assertThatAndPerform(not(ExpectedConditions.attributeContains(element, attributeName, value)));
    }
  }
}
