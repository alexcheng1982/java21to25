package io.github.alexcheng1982.java21to25.stablevalue;

public class SetOrThrow {

  private final StableValue<String> value = StableValue.of();

  void setOrThrow() {
    value.trySet("hello");
    value.setOrThrow("world");
  }

  static void main() {
    new SetOrThrow().setOrThrow();
  }
}
