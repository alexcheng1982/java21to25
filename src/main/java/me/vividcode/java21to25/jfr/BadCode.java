package me.vividcode.java21to25.jfr;

import java.util.ArrayList;
import java.util.List;

public class BadCode {

  static void main() {
    List<String> items = new ArrayList<>();
    for (int i = 0; i < 100_000; i++) {
      items.add("Item " + i);
    }

    long count = 0;

    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).contains("999")) {
        count++;
      }
    }

    System.out.println("Found " + count + " items.");
  }
}
