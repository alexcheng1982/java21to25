package io.github.alexcheng1982.java21to25.stablevalue;

public class OrElseSet {

  private final StableValue<String> value = StableValue.of();

  String orElseSet() {
    return value.orElseSet(() -> "hello");
  }

  static void main() {
    System.out.println(new OrElseSet().orElseSet());
  }
}
