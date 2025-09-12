package io.github.alexcheng1982.java21to25.stablevalue;

import java.util.Map;
import java.util.Set;

public class StableMap {

  Map<String, Integer> map() {
    return StableValue.map(Set.of("hello", "world"), String::length);
  }

  static void main() {
    var map = new StableMap().map();
    System.out.println(map.get("hello"));
    System.out.println(map.get("test"));
  }
}
