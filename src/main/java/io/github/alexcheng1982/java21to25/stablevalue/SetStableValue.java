package io.github.alexcheng1982.java21to25.stablevalue;

import java.util.concurrent.Executors;

public class SetStableValue {

  private final StableValue<String> value = StableValue.of();

  void trySet() {
    var result = value.trySet("hello");
    if (result) {
      System.out.println(
          "Value set in thread: " + Thread.currentThread().getName());
    } else {
      System.out.println(
          "Value not set in thread: " + Thread.currentThread().getName());
    }
  }

  static void main() {
    var setStableValue = new SetStableValue();
    try (var executor = Executors.newFixedThreadPool(10)) {
      for (int i = 0; i < 10; i++) {
        executor.submit(setStableValue::trySet);
      }
    }
  }
}
