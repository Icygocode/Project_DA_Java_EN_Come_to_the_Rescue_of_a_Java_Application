package com.hemebiotech.analytics.writer;

import java.util.List;
import java.util.Map;


public interface ISymptomWriter {

   /**
    * Write a list of all symptoms one by line "Key = Value"
    * @param resultOut {@link com.hemebiotech.analytics.counter.IAnalyticsCounter#count(List)}
    * @throws WriteException in case of error while writing symptoms
    */
   void write (Map<String, Integer> resultOut) throws WriteException;

}
