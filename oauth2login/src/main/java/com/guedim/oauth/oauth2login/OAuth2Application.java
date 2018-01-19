package com.guedim.oauth.oauth2login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// http://www.baeldung.com/spring-security-5-oauth2-login
// https://developer.okta.com/blog/2017/12/18/spring-security-5-oidc#get-user-information-with-oidc
@SpringBootApplication
public class OAuth2Application {

  public static void main(String[] args) {
    SpringApplication.run(OAuth2Application.class, args);
  }
}
