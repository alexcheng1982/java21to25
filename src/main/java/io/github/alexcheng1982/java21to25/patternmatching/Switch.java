package io.github.alexcheng1982.java21to25.patternmatching;

public class Switch {
  static void test(double d) {
    var value = switch (d) {
      case 0.0 -> "zero";
      case 100.0 -> "one hundred";
      case double x when x > 1000.0 -> "large value";
      default -> "small value";
    };
    System.out.println(value);
  }

  static void main() {
    test(0.0);
    test(100.0);
    test(2000);
    test(10);
  }
}
