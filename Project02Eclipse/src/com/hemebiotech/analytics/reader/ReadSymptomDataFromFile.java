package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

  private final String filePath;

  /**
   * @param filePath a full or partial path to file with symptoms strings in it, one per line
   */

  public ReadSymptomDataFromFile(String filePath) {
    this.filePath = filePath;
  }

  public String getFilepath() {
    return filePath;
  }

  /**
   * {@inheritDoc} <br/>
   * Simple loop which will take filepath as entry source and write
   * informations line by line in a List.
   * @return List<String> that contain all symptoms from the file : filepath
   * @throws ReadException
   */

  @Override
  public List<String> getSymptoms() throws ReadException {
    ArrayList<String> result = new ArrayList<String>();

    if (filePath != null) {
      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

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