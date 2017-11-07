package com.guedim.ssl.ssltest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

  private String hostname;
  private Integer port;


  public ApplicationProperties() {}

  public ApplicationProperties(String hostname, Integer port) {
    super();
    this.hostname = hostname;
    this.port = port;
  }

  public String getHostname() {
    return hostname;
  }

  public Integer getPort() {
    return port;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public void setPort(Integer port) {
    this.port = port;
  }
}
