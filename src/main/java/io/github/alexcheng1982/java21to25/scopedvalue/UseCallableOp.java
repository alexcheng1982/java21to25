package io.github.alexcheng1982.java21to25.scopedvalue;

public class UseCallableOp {

  private final static ScopedValue<String> V1 = ScopedValue.newInstance();

  void call() {
    var result = ScopedValue.where(V1, "hello")
        .call(() -> V1.get().toUpperCase());
    System.out.println(result);
  }

  static void main() {
    new UseCallableOp().call();
  }
}
