package io.github.alexcheng1982.java21to25.stablevalue;

import java.util.List;

public class StableList {

  List<Double> list() {
    return StableValue.list(5, v -> {
      System.out.println("Calculate value for " + v);
      return Math.pow(Math.PI, v);
    });
  }

  static void main() {
    var list = new StableList().list();
    list.get(0);
    list.get(1);
  }
}
