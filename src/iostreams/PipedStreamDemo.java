package iostreams;
/*
 * Class Name: PipedStreamDemo
 *
 * Description:
 * This program demonstrates inter-thread communication in Java
 * using PipedInputStream and PipedOutputStream.
 *
 * One thread (WriterThread) writes data into a PipedOutputStream,
 * while another thread (ReaderThread) reads the data from a
 * connected PipedInputStream.
 *
 * Piped streams provide a safe communication channel between
 * two threads, ensuring synchronized data transfer and
 * preventing data loss.
 *
 * Proper exception handling is implemented to handle IO errors.
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {

    public static void main(String[] args) {

        try {
            // Create piped output stream
            PipedOutputStream pos = new PipedOutputStream();

            // Create piped input stream and connect it to output stream
            PipedInputStream pis = new PipedInputStream(pos);

            // Create writer and reader threads
            Thread writerThread = new Thread(new WriterThread(pos));
            Thread readerThread = new Thread(new ReaderThread(pis));

            // Start both threads
            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Error while connecting piped streams.");
        }
    }
}

/* ---------------- Writer Thread ---------------- */
class WriterThread implements Runnable {

    private PipedOutputStream pos;

    // Constructor
    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread";

            // Convert message to byte array
            byte[] data = message.getBytes();

            // Write data into piped output stream
            pos.write(data);

            // Close output stream after writing
            pos.close();

        } catch (IOException e) {
            System.out.println("Error in Writer Thread.");
        }
    }
}

/* ---------------- Reader Thread ---------------- */
class ReaderThread implements Runnable {

    private PipedInputStream pis;

    // Constructor
    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;

            System.out.print("Reader Thread received: ");

            // Read data from piped input stream
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }

            // Close input stream after reading
            pis.close();

        } catch (IOException e) {
            System.out.println("Error in Reader Thread.");
        }
    }
}
