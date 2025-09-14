package me.vividcode.java21to25.structuredconcurrency;

import java.time.Duration;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;

public class OpenScopeWithConfiguration {

  int open() throws InterruptedException {
    try (var scope = StructuredTaskScope.open(
        Joiner.anySuccessfulResultOrThrow(),
        config -> config.withThreadFactory(
                Thread.ofVirtual().name("test-", 0).factory())
            .withName("Demo")
            .withTimeout(Duration.ofSeconds(10)))) {
      scope.fork(() -> {
        Thread.sleep(Duration.ofSeconds(15));
        return 10;
      });
      return (int) scope.join();
    }
  }

  static void main() throws InterruptedException {
    System.out.println(new OpenScopeWithConfiguration().open());
  }
}
