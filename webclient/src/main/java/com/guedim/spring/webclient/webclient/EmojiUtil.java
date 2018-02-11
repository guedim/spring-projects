package com.guedim.spring.webclient.webclient;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.Map;

public final class EmojiUtil {

  public static final String BASE_URL = "http://emojitrack-gostreamer.herokuapp.com";
  public static final String BASE_GET_URI = "/subscribe/eps";

  
  public static String topEmojis(HashMap<String, Long> histogram, int max) {
    return histogram.entrySet().stream()
        .sorted(comparing(Map.Entry<String, Long>::getValue).reversed()).limit(max)
        .map(Map.Entry::getKey).collect(joining(" "));
  }

  public static String codeToEmoji(String hex) {
    final String[] codes = hex.split("-");
    if (codes.length == 2) {
      return hexToEmoji(codes[0]) + hexToEmoji(codes[1]);
    } else {
      return hexToEmoji(hex);
    }
  }

  public static String hexToEmoji(String hex) {
    return new String(Character.toChars(Integer.parseInt(hex, 16)));
  }
}
