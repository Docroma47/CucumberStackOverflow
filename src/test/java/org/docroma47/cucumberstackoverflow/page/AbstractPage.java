package org.docroma47.cucumberstackoverflow.page;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPage {

  @Autowired
  protected WebDriver driver;

  @PostConstruct
  private void initElements() {
    PageFactory.initElements(driver, this);
  }

}
