package me.vividcode.java21to25.streamgatherer;

import java.time.Duration;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class BuiltInGatherers {

  void fold() {
    var result = Stream.of(1, 2, 3, 4, 5).gather(
        Gatherers.fold(
            () -> "",
            (output, value) -> output + value + ", "
        )
    ).findFirst();
    // 1, 2, 3, 4, 5,
    result.ifPresent(System.out::println);
  }

  void scan() {
    var result = Stream.of(1, 2, 3, 4, 5).gather(
        Gatherers.scan(() -> 0, Integer::sum)
    ).toList();
    // [1, 3, 6, 10, 15]
    System.out.println(result);
  }

  void windowFixed() {
    var result = Stream.of(1, 2, 3, 4, 5).gather(
        Gatherers.windowFixed(2)
    ).toList();
    // [[1, 2], [3, 4], [5]]
    System.out.println(result);
  }

  void windowSliding() {
    var result = Stream.of(1, 2, 3, 4, 5).gather(
        Gatherers.windowSliding(2)
    ).toList();
    // [[1, 2], [2, 3], [3, 4], [4, 5]]
    System.out.println(result);
  }

  void mapConcurrent() {
    var result = Stream.of(1, 2, 3, 4, 5).gather(
        Gatherers.mapConcurrent(3, value -> {
          try {
            Thread.sleep(Duration.ofSeconds(1));
          } catch (InterruptedException e) {
            //ignore
          }
          return value * 10;
        })
    ).toList();
    // [10, 20, 30, 40, 50]
    System.out.println(result);
  }

  static void main() {
    var builtInGatherers = new BuiltInGatherers();
    builtInGatherers.fold();
    builtInGatherers.scan();
    builtInGatherers.windowFixed();
    builtInGatherers.windowSliding();
    builtInGatherers.mapConcurrent();
  }
}
