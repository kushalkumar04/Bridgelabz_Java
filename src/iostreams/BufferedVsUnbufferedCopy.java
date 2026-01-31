package iostreams;

/*
 * Class Name: BufferedVsUnbufferedCopy
 *
 * Description:
 * This class demonstrates efficient file copying in Java
 * using Buffered Streams and compares its performance with
 * normal (unbuffered) file streams.
 *
 * The program copies a large file (e.g., 100MB) using:
 * 1. FileInputStream & FileOutputStream (Unbuffered)
 * 2. BufferedInputStream & BufferedOutputStream (Buffered)
 *
 * Data is read and written in chunks of 4 KB (4096 bytes).
 * Execution time for both approaches is measured using
 * System.nanoTime() to analyze performance differences.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedVsUnbufferedCopy {

    // Constant buffer size of 4 KB
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {

        String sourceFile = "largeFile.txt";
        String unbufferedDest = "unbufferedCopy.txt";
        String bufferedDest = "bufferedCopy.txt";

        // Copy using unbuffered streams
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, unbufferedDest);

        // Copy using buffered streams
        long bufferedTime = copyUsingBufferedStreams(sourceFile, bufferedDest);

        // Display performance comparison
        System.out.println("\n----- Performance Comparison -----");
        System.out.println("Unbuffered Stream Time : " + unbufferedTime + " ns");
        System.out.println("Buffered Stream Time   : " + bufferedTime + " ns");

        if (bufferedTime < unbufferedTime) {
            System.out.println("Buffered streams are faster.");
        } else {
            System.out.println("Unbuffered streams are faster (rare case).");
        }
    }

    // Method to copy file using unbuffered streams
    private static long copyUsingUnbufferedStreams(String src, String dest) {

        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            // Read and write data in 4 KB chunks
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in unbuffered file copy.");
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method to copy file using buffered streams
    private static long copyUsingBufferedStreams(String src, String dest) {

        long startTime = System.nanoTime();

        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            // Read and write data in 4 KB chunks
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in buffered file copy.");
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
