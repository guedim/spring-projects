package com.guedim.spring.webclient.webclient;

import static com.guedim.spring.webclient.webclient.EmojiUtil.BASE_GET_URI;
import static com.guedim.spring.webclient.webclient.EmojiUtil.BASE_URL;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class EmojiWebClient {

  
  public static Flux<String> getEmojis() {
    return WebClient
          .create(BASE_URL)
          .get().uri(BASE_GET_URI)
          .retrieve()
          .bodyToFlux(ServerSentEvent.class)
          .flatMap(e -> Mono.justOrEmpty(e.data()))
          .map(x -> (Map<String, Integer>)x)
          .flatMapIterable(Map::entrySet)
          .flatMap(entry -> Flux.just(entry.getKey()).repeat(entry.getValue()))
          .map(EmojiUtil::codeToEmoji)
          .scan(new HashMap<String, Long>(), (histogram, emoji) -> {
              histogram.merge(emoji, 1L, Math::addExact);
              return histogram;
          })
          .map(hist -> EmojiUtil.topEmojis(hist, 50));
  }
}