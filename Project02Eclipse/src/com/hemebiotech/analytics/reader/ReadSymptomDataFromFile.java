package com.hemebiotech.analytics.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

  private final String filepath;

  /**
   * @param filepath a full or partial path to file with symptom strings in it, one per line
   */

  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  public String getFilepath() {
    return filepath;
  }

  /**
   * The method getSymptoms is a simple loop which will take filepath as entry source and write
   * informations line by line in the List named result.
   * @return List<String> that contain all symptoms from the text file : filepath
   * @throws ReadException
   */

  @Override
  public List<String> getSymptoms() throws ReadException {
    ArrayList<String> result = new ArrayList<String>();

    if (filepath != null) {
      try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

        String line = reader.readLine();

        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
      } catch (IOException e) {
        throw new ReadException(e);
      }
    }
    return result;
  }
}