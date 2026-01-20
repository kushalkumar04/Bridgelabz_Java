package linearandbinarysearch.linearsearch;

/*
 * This program uses Linear Search to find the first sentence
 * that contains a specific word from an array of sentences.
 * If the word is found, the sentence is returned.
 * If not found in any sentence, "Not Found" is returned.
 */
public class LinearSearchWordInSentences {

    public static void main(String[] args) {

        // Array of sentences
        String[] sentences = {
                "Java is a powerful programming language",
                "Data structures are important for interviews",
                "I am learning algorithms",
                "Machine learning is the future"
        };

        // Word to search for
        String searchWord = "algorithms";

        // Call the search method
        String result = findSentenceContainingWord(sentences, searchWord);

        // Display result
        System.out.println("Search Result: " + result);
    }

    /*
     * This method performs linear search on the array of sentences
     * to find the first sentence that contains the given word.
     */
    public static String findSentenceContainingWord(String[] arr, String word) {

        // Traverse each sentence one by one
        for (int i = 0; i < arr.length; i++) {

            // Check if the current sentence contains the word
            if (arr[i].toLowerCase().contains(word.toLowerCase())) {
                return arr[i]; // Return the sentence if word is found
            }
        }

        // If the word is not found in any sentence
        return "Not Found";
    }
}
