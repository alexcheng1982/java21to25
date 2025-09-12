package me.vividcode.java21to25.structuredconcurrency;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InvokeAny {

  static void main() throws Exception {
    System.out.println(new InvokeAny().invokeAny());
  }

  public int invokeAny() throws InterruptedException {
    try (var scope = StructuredTaskScope.open(
        Joiner.<Integer>anySuccessfulResultOrThrow())) {
      subTasks().forEach(scope::fork);
      return scope.join();
    }
  }

  private Stream<Callable<Integer>> subTasks() {
    return IntStream.range(0, 1000)
        .mapToObj(
            i ->
                () -> {
                  try {
                    Thread.sleep(Duration.ofSeconds(
                        1 + ThreadLocalRandom.current().nextLong(10)));
                  } catch (InterruptedException e) {
                    // ignore
                  }
                  return i;
                });
  }
}
