package com.hemebiotech.analytics.counter;

import com.hemebiotech.analytics.reader.ISymptomReader;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class AnalyticsCounter implements IAnalyticsCounter {

  /**
   * {@inheritDoc} <br/>
   * Create a TreeMap and will "Value +1" each time symptoms are encountered.
   * In case of duplicate it will add +1 to the value but not duplicate the key.
   * @param  items  {@link ISymptomReader#getSymptoms()}
   * @return count of symptoms sorted by alphabetical ascending order.
   */
  @Override
  public SortedMap<String, Integer> count(List<String> items) throws CounterException {
    TreeMap<String, Integer> resultOut = new TreeMap<>();

    for ( String item : items ) {
      if (resultOut.containsKey(item)) {
        resultOut.put(item, resultOut.get(item) + 1);
      } else {
        resultOut.put(item, 1);
      }
      //resultOut.put(item,resultOut.getOrDefault(item, 0)+1);
    }
    return resultOut;
  }
}
