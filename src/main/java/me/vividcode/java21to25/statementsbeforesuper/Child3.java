package me.vividcode.java21to25.statementsbeforesuper;

/**
 * Sharing superclass constructor arguments
 */
class Super3 {

  private int v1;
  private int v2;

  Super3(int v1, int v2) {
    this.v1 = v1;
    this.v2 = v2;
  }
}

public class Child3 extends Super3 {

  Child3(int v) {
    int pv = v * 1024;
    super(pv, pv);
  }

  Child3(String str) {
    int v = str.length() * 100;
    this(v);
  }
}