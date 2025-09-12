package me.vividcode.java21to25.patternmatching;

public class TypePattern {

  static void test(int i) {
    switch (i) {
      case byte b -> System.out.println("byte: " + b);
      case int x when x > 1000 -> System.out.println("large int: " + x);
      default -> System.out.println("small int: " + i);
    }
  }

  static void main() {
    test(1);
    test(300);
    test(2000);
  }
}
