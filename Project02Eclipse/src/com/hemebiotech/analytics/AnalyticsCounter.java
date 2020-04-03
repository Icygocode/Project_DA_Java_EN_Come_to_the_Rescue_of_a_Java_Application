package com.hemebiotech.analytics;

import com.sun.jdi.Value;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
  
  public static String newline = System.getProperty("line.separator");

  public static void main(String args[]) throws Exception {
// first get input by reading the symptoms.txt
    TreeMap<String, Integer> symptomsList = new TreeMap<String, Integer>();
    //FileReader fileReader = new FileReader("symptoms.txt");
    //BufferedReader reader = new BufferedReader(fileReader);
    BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
    String symptom = reader.readLine();

// get another symptom and Stop
    while (symptom != null) {
      if (symptomsList.containsKey(symptom)) {
        int value = symptomsList.get(symptom);
        symptomsList.put(symptom, value + 1);
      } else {
        symptomsList.put(symptom, 1);
      }
      symptom = reader.readLine();
    }
// Use symptom as key in Hashmap<String, Integer> named symptomsList
// Create a new function able to count occurency of symptom and set it as value in the Hashmap

    System.out.println(symptomsList);

// next generate output of symptomsList
    FileWriter writer = new FileWriter("result.out");
    writer.write(String.valueOf(symptomsList));
    writer.close();
  }
}
