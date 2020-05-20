package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class AnalyticsCounter {

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


    // next generate output of symptomsList => result.out
    PrintWriter writer = new PrintWriter("result.out");

    // Creation of a variable entries which regroup all Keys/Value couples
    Set<Entry<String, Integer>> entries = symptomsList.entrySet();

    // Initiating a loop which will take each entry (K/V) inside entries and write it in result.out file
    for (Entry<String, Integer> entry : entries )
    {
      writer.println(entry.getKey() + " = " + entry.getValue());
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }
    writer.close();
  }
}
