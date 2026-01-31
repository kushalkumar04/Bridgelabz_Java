package iostreams;

/*
 * Class Name: WordFrequencyCounter
 *
 * Description:
 * This class reads a text file and counts the number of
 * occurrences of each word using a HashMap.
 *
 * The program then sorts the words based on their frequency
 * and displays the top 5 most frequently occurring words.
 *
 * FileReader and BufferedReader are used for efficient
 * character-based file reading.
 *
 * Proper exception handling is implemented to handle
 * IO-related errors.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        // File path of the text file
        String filePath = "input.txt";

        // HashMap to store word counts
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        BufferedReader reader = null;

        try {
            // Create BufferedReader for reading file efficiently
            reader = new BufferedReader(new FileReader(filePath));

            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {

                // Convert line to lowercase and split into words
                String[] words = line.toLowerCase().split("\\W+");

                // Count each word
                for (String word : words) {

                    // Ignore empty strings
                    if (!word.isEmpty()) {
                        wordCountMap.put(word,
                                wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            /* -------- Sort words by frequency (Descending Order) -------- */

            List<Map.Entry<String, Integer>> sortedWords =
                    wordCountMap.entrySet()
                            .stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .collect(Collectors.toList());

            /* -------- Display Top 5 Most Frequent Words -------- */

            System.out.println("Top 5 most frequent words:");

            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                count++;
                if (count == 5) {
                    break;
                }
            }

        } catch (IOException e) {
            // Handle file reading errors
            System.out.println("Error while reading the file.");
        } finally {
            try {
                // Close BufferedReader
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // Handle closing errors
                System.out.println("Error while closing the file.");
            }
        }
    }
}
