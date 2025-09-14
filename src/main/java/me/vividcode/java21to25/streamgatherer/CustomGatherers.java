package me.vividcode.java21to25.streamgatherer;

import java.util.stream.Stream;

public class CustomGatherers {

  record Student(String id, String name) {

  }

  void distinctBy() {
    var result = Stream.of(
            new Student("001", "Alex"),
            new Student("002", "Bob"),
            new Student("001", "Alex")
        ).gather(DistinctBy.of(Student::id))
        .toList();
    // [Student[id=001, name=Alex], Student[id=002, name=Bob]]
    System.out.println(result);
  }

  static void main() {
    new CustomGatherers().distinctBy();
  }
}
