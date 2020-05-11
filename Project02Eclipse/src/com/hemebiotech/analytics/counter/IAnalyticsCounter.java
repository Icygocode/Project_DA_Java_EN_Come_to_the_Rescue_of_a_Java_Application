package com.hemebiotech.analytics.counter;

import java.util.List;
import java.util.SortedMap;

public interface IAnalyticsCounter {

  /**
   * Count the number of occurrences of symptoms.
   * @param symptoms symptoms to count
   * @return A map of sorted symptoms with the number of times they have been encountered as
   * Value, no duplicates allowed.
   * @throws CounterException in case of error while counting
   */
  SortedMap<String, Integer> count(List<String> symptoms) throws CounterException;

}
