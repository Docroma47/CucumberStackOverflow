package org.docroma47.cucumberstackoverflow.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "stackoverflow")
public class StackoverflowProperties {

  private final String baseUrl;
  private final SeleniumProperties selenium;
  private final NetworkProperties network;
  private final Map<String, User> users;

  public StackoverflowProperties(String baseUrl, SeleniumProperties selenium, NetworkProperties network, Map<String, User> users) {
    this.baseUrl = baseUrl;
    this.selenium = selenium;
    this.network = network;
    this.users = users;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public SeleniumProperties getSelenium() {
    return selenium;
  }

  public NetworkProperties getNetwork() {
    return network;
  }

  public Map<String, User> getUsers() {
    return users;
  }

  public static class User {

    private final String username;
    private final String password;

    public User(String username, String password) {
      this.username = username;
      this.password = password;
    }

    public String getUsername() {
      return username;
    }

    public String getPassword() {
      return password;
    }

  }

  @ConstructorBinding
  public static class NetworkProperties {

    private final boolean offline;
    private final int latency;
    private final int downloadThroughput;
    private final int uploadThroughput;

    public NetworkProperties(boolean offline, int latency, int downloadThroughput, int uploadThroughput) {
      this.offline = offline;
      this.latency = latency;
      this.downloadThroughput = downloadThroughput;
      this.uploadThroughput = uploadThroughput;
    }

    public boolean isOffline() {
      return offline;
    }

    public int getLatency() {
      return latency;
    }

    public int getDownloadThroughput() {
      return downloadThroughput;
    }

    public int getUploadThroughput() {
      return uploadThroughput;
    }
  }

  @ConstructorBinding
  public static class SeleniumProperties {

    private final boolean headless;
    private final int globalWaitTimeout;
    private final int localWaitTimeout;
    private final int pollRate;

    public SeleniumProperties(boolean headless, int globalWaitTimeout, int localWaitTimeout, int pollRate) {
      this.headless = headless;
      this.globalWaitTimeout = globalWaitTimeout;
      this.localWaitTimeout = localWaitTimeout;
      this.pollRate = pollRate;
    }

    public boolean isHeadless() {
      return headless;
    }

    public int getGlobalWaitTimeout() {
      return globalWaitTimeout;
    }

    public int getLocalWaitTimeout() {
      return localWaitTimeout;
    }

    public int getPollRate() {
      return pollRate;
    }
  }

}
