package io.github.alexcheng1982.java21to25.scopedvalue;

public class Rebound {

  private final static ScopedValue<String> VALUE = ScopedValue.newInstance();

  void rebound() {
    ScopedValue.where(VALUE, "hello")
        .run(() -> {
          var result = ScopedValue.where(VALUE, "world")
              .call(() -> VALUE.get().toUpperCase());
          System.out.println(result);
        });
  }

  static void main() {
    new Rebound().rebound();
  }
}
