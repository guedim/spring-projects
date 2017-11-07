package com.guedim.ssl.ssltest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SslTestApplication {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private SSLClient sslClientl;

  public static void main(String[] args) {
    SpringApplication.run(SslTestApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void doSomethingAfterStartup() {
    logger.info("********************************");
    logger.info("****** START SSL TEST  *********");
    sslClientl.sslTest();
    logger.info("******** END SSL TEST  *********");
    logger.info("********************************");
  }
}
