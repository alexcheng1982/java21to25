package me.vividcode.java21to25.statementsbeforesuper;

import java.util.UUID;

/**
 * Preparing superclass constructor arguments
 */
class Super2 {

  private String id;

  Super2(String id) {
    this.id = id;
  }
}

public class Child2 extends Super2 {

  Child2(String oldId) {
    String newId;
    if (oldId != null) {
      newId = "o_" + oldId.toLowerCase();
    } else {
      newId = UUID.randomUUID().toString();
    }
    super(newId);
  }
}