package linearandbinarysearch.stringbuffer;
/*
 * This program compares the performance of StringBuffer and StringBuilder
 * when concatenating a large number of strings.
 * It appends the string "hello" one million times to both objects
 * and measures the time taken using System.nanoTime().
 */
public class StringBufferVsStringBuilder {

    public static void main(String[] args) {

        int n = 1_000_000; // Number of times to append the string

        // --------- Using StringBuffer ---------
        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime(); // Start time for StringBuffer

        for (int i = 0; i < n; i++) {
            stringBuffer.append("hello");
        }

        long endTimeBuffer = System.nanoTime(); // End time for StringBuffer
        long timeTakenBuffer = endTimeBuffer - startTimeBuffer;

        // --------- Using StringBuilder ---------
        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime(); // Start time for StringBuilder

        for (int i = 0; i < n; i++) {
            stringBuilder.append("hello");
        }

        long endTimeBuilder = System.nanoTime(); // End time for StringBuilder
        long timeTakenBuilder = endTimeBuilder - startTimeBuilder;

        // --------- Display Results ---------
        System.out.println("Time taken by StringBuffer   : " + timeTakenBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder : " + timeTakenBuilder + " nanoseconds");

        /*
         * Observation:
         * StringBuilder is usually faster than StringBuffer because
         * StringBuffer is thread-safe (synchronized), which adds overhead.
         * StringBuilder is not synchronized and hence performs faster
         * in single-threaded environments.
         */
    }
}
