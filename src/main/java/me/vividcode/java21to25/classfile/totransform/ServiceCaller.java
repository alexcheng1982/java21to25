package me.vividcode.java21to25.classfile.totransform;

public class ServiceCaller {

  public static void call() {
    OldService.call();
  }

  static void main() {
    call();
  }
}
