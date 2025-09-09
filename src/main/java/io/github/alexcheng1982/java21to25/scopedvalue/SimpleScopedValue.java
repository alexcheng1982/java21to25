package io.github.alexcheng1982.java21to25.scopedvalue;

public class SimpleScopedValue {

  private final static ScopedValue<String> VALUE = ScopedValue.newInstance();

  void print() {
    ScopedValue.where(VALUE, "hello")
        .run(() -> System.out.println(VALUE.get()));
  }

  static void main() {
    new SimpleScopedValue().print();
  }
}
