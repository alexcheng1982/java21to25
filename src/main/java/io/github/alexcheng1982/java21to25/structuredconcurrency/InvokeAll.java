package io.github.alexcheng1982.java21to25.structuredconcurrency;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InvokeAll {

  static void main() throws Exception {
    System.out.println(new InvokeAll().invokeAll());
  }

  public long invokeAll() throws InterruptedException {
    try (var scope = StructuredTaskScope.open(
        Joiner.<Integer>allSuccessfulOrThrow())) {
      subTasks().forEach(scope::fork);
      var subtasks = scope.join();
      return subtasks.map(Subtask::get).reduce(0, Integer::sum);
    }
  }

  private Stream<Callable<Integer>> subTasks() {
    return IntStream.range(0, 10_000)
        .mapToObj(
            i ->
                () -> {
                  try {
                    Thread.sleep(
                        Duration.ofSeconds(
                            ThreadLocalRandom.current().nextLong(3)));
                  } catch (InterruptedException e) {
                    // ignore
                  }
                  return i;
                });
  }
}
