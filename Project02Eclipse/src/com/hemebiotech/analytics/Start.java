package com.hemebiotech.analytics;

import com.hemebiotech.analytics.counter.AnalyticsCounter;
import com.hemebiotech.analytics.counter.CounterException;
import com.hemebiotech.analytics.counter.IAnalyticsCounter;
import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.reader.ReadException;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.writer.ISymptomWriter;
import com.hemebiotech.analytics.writer.WriteException;
import com.hemebiotech.analytics.writer.WriteSymptomsDataToFile;
import java.util.List;
import java.util.Map;

/**
 * Starter which use a reader/counter/Writer method
 *
 * @author Fabien Guiret
 */

public class Start {

  public static void main(String[] args) {
    try {
      ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
      List<String> symptoms = reader.getSymptoms();

      IAnalyticsCounter counter = new AnalyticsCounter();
      Map<String, Integer> orderedSymptoms = counter.count(symptoms);

      ISymptomWriter writer = new WriteSymptomsDataToFile("result.txt");
      writer.write(orderedSymptoms);
    } catch (WriteException e) {
      e.printStackTrace();
    } catch (ReadException e) {
      e.printStackTrace();
    } catch (CounterException e) {
      e.printStackTrace();
    }
  }
}
