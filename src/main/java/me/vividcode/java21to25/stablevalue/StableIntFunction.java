package me.vividcode.java21to25.stablevalue;

import java.util.function.IntFunction;

public class StableIntFunction {

  IntFunction<Double> intFunction() {
    return StableValue.intFunction(5, (value -> Math.pow(Math.PI, value)));
  }

  static void main() {
    var function = new StableIntFunction().intFunction();
    System.out.println(function.apply(3));
    System.out.println(function.apply(4));
    System.out.println(function.apply(5));
  }
}
