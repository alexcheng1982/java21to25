package me.vividcode.java21to25.scopedvalue;

public class MultipleScopedValues {

  private final static ScopedValue<String> V1 = ScopedValue.newInstance();
  private final static ScopedValue<String> V2 = ScopedValue.newInstance();

  void multiple() {
    ScopedValue.where(V1, "hello")
        .where(V2, "world")
        .run(() -> System.out.println(V1.get() + " " + V2.get()));
  }

  static void main() {
    new MultipleScopedValues().multiple();
  }
}
