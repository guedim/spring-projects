package com.guedim.spring.webclient.webclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class EmojiApplication {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  
  public static void main(String[] args) {
    SpringApplication.run(EmojiApplication.class, args);
  }

  //@EventListener(ApplicationReadyEvent.class)
  public void init() {
    final Flux<String> stream = EmojiWebClient.getEmojis();
    stream.subscribe(sse -> logger.info("Received: {} ",  sse));
  }
}