package me.vividcode.java21to25.streamgatherer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Gatherer;
import java.util.stream.Gatherer.Integrator;

/**
 * Distinct by an object's property, keep last duplicated element
 */
public class DistinctBy {

  /**
   * Create a new {@linkplain DistinctBy} gatherer
   *
   * @param extractor Extract the property from an element
   * @param <T>       Type of the element
   * @param <R>       Type of the element's property
   * @return A new {@linkplain DistinctBy} gatherer
   */
  static <T, R> Gatherer<T, ?, T> of(
      Function<? super T, ? extends R> extractor) {
    class State {

      final Map<R, T> seen = new HashMap<>();
    }

    return Gatherer.ofSequential(State::new, Integrator.ofGreedy(
            ((state, element, _) -> {
              state.seen.put(extractor.apply(element), element);
              return true;
            })),
        (state, downstream) -> state.seen.values().forEach(downstream::push)
    );
  }
}
