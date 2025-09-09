package io.github.alexcheng1982.java21to25.moduleimport;

import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameCounter {

  void count() {
    var result = Stream.of("Alice", "Alex", "Amelia", "Andrew",
            "Bob", "Bella", "Brian", "Bianca", "Ethan", "Emma")
        .collect(
            Collectors.groupingBy(name -> name.toUpperCase().substring(0, 1),
                Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Entry.comparingByValue())
        .toList();
    System.out.println(result);
  }

  static void main() {
    new NameCounter().count();
  }
}
