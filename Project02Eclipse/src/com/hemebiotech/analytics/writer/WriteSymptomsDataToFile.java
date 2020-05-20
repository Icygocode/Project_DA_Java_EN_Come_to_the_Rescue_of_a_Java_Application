package com.hemebiotech.analytics.writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class WriteSymptomsDataToFile implements ISymptomWriter {


  private final String fileName;

  /**
   * @param fileName The name of the file to use as the destination of this writer. If the file
   *                 exists then it will be truncated to zero size; otherwise, a new file will be
   *                 created.  The output will be written to the file and is buffered. {@link
   *                 PrintWriter#PrintWriter(String)}
   */
  public WriteSymptomsDataToFile(String fileName) {
    this.fileName = fileName;
  }

  /**
   * {@inheritDoc}
   *
   *<br/> Write symptoms into file given in the constructor
   */
  @Override
  public void write(Map<String, Integer> resultOut) throws WriteException {
    try (PrintWriter writer = new PrintWriter(fileName)) {
      //Create a variable which regroup all Keys/Value couples
      Set<Entry<String, Integer>> entries = resultOut.entrySet();

      //loop which will take each entry (K/V) and write it in "fileName" file
      for ( Entry<String, Integer> entry : entries ) {
        writer.println(entry.getKey() + " = " + entry.getValue());
        System.out.println(entry.getKey() + " = " + entry.getValue());
      }
    } catch (FileNotFoundException e) {
      throw new WriteException(e);
    }
  }
}
