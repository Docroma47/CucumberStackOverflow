package org.docroma47.cucumberstackoverflow.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "stackoverflow")
public class StackoverflowProperties {

  private final String baseUrl;
  private final String logoutUrl;
  private final Map<String, User> users;

  public StackoverflowProperties(String baseUrl, Map<String, User> users, String logoutUrl) {
    this.baseUrl = baseUrl;
    this.logoutUrl = logoutUrl;
    this.users = users;
  }

  public String getLogoutUrl() {
    return logoutUrl;
  }

  public String getBaseUrl() {
    return baseUrl;
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

}
