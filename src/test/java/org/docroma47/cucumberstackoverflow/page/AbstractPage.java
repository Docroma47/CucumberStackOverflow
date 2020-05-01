package org.docroma47.cucumberstackoverflow.page;

import javax.annotation.PostConstruct;

import org.docroma47.cucumberstackoverflow.config.StackoverflowProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
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
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, properties.getTimeout()), this);
  }

}
