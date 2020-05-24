package org.docroma47.cucumberstackoverflow.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({ StackoverflowProperties.class })
@ComponentScan(basePackages = "org.docroma47.cucumberstackoverflow")
@Configuration
public class CucumberConfiguration {

  @Autowired
  private StackoverflowProperties properties;

  @Bean(destroyMethod = "quit")
  public WebDriver webDriver() throws IOException {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.setHeadless(properties.getSelenium().isHeadless());
    chromeOptions.addArguments("disable-gpu");
    ChromeDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().window().setSize(properties.getSelenium().getWindowSize());

    Map<String, Object> map = new HashMap<>();
    map.put("offline", properties.getNetwork().isOffline());
    map.put("latency", properties.getNetwork().getLatency());
    map.put("download_throughput", properties.getNetwork().getDownloadThroughput());
    map.put("upload_throughput", properties.getNetwork().getUploadThroughput());

    CommandExecutor executor = driver.getCommandExecutor();
    executor.execute(new Command(driver.getSessionId(), "setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));
    Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
    return driver;
  }

}
