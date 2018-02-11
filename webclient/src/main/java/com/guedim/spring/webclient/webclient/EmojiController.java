package com.guedim.spring.webclient.webclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping(value="/api")
public class EmojiController {  

  @GetMapping("/emojis")
  public Flux<String> getAll() {  
    return EmojiWebClient.getEmojis();
  }
}
