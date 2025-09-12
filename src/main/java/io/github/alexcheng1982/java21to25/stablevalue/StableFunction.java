package io.github.alexcheng1982.java21to25.stablevalue;

import java.util.Set;
import java.util.function.Function;

public class StableFunction {

  Function<String, Integer> function() {
    return StableValue.function(Set.of("hello", "world"),
        String::length);
  }

  static void main() {
    var function = new StableFunction().function();
    System.out.println(function.apply("hello"));
    System.out.println(function.apply("world"));
    System.out.println(function.apply("test"));
  }
}
