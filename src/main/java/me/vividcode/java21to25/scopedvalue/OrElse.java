package me.vividcode.java21to25.scopedvalue;

public class OrElse {

  private final static ScopedValue<String> VALUE = ScopedValue.newInstance();
  private final static ScopedValue<String> UNBOUND = ScopedValue.newInstance();

  void orElse() {
    var result = ScopedValue.where(VALUE, "hello")
        .call(() -> VALUE.get() + " " + UNBOUND.orElse("default"));
    System.out.println(result);
  }

  static void main() {
    new OrElse().orElse();
  }
}
