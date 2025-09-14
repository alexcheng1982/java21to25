package me.vividcode.java21to25.structuredconcurrency;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;

public class OpenAnySuccessfulScope {

  int open() throws InterruptedException {
    try (var scope = StructuredTaskScope.open(
        Joiner.anySuccessfulResultOrThrow())) {
      scope.fork(() -> 3);
      scope.fork(() -> 4);
      return (int) scope.join();
    }
  }

  static void main() throws InterruptedException {
    System.out.println(new OpenAnySuccessfulScope().open());
  }
}
