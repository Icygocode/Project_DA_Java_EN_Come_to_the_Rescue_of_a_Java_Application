<<<<<<< HEAD
package com.hemebiotech.analytics.Reader;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 * The implementation does not need to order the list
 *
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates allowed
	 */
	List<String> getSymptoms() throws ReadException;
}
=======
package com.hemebiotech.analytics.reader;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 * The implementation does not need to order the list
 *
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates allowed
	 * @throws ReadException in case of error while reading
	 */
	List<String> getSymptoms() throws ReadException;
}
>>>>>>> 4999a44... Reader/Counter/Writer + Javadoc finished
