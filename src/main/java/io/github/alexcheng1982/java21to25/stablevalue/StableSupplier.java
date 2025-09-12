package io.github.alexcheng1982.java21to25.stablevalue;

import java.util.function.Supplier;

public class StableSupplier {

  Supplier<String> underlying() {
    return () -> {
      System.out.println("Called the underlying supplier");
      return "hello";
    };
  }

  Supplier<String> stable() {
    return StableValue.supplier(underlying());
  }

  static void main() {
    var supplier = new StableSupplier().stable();
    supplier.get();
    supplier.get();
    supplier.get();
  }
}
