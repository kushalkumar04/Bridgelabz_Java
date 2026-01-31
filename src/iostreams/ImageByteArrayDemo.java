package iostreams;

/*
 * Class Name: ImageByteArrayDemo
 *
 * Description:
 * This class demonstrates the use of ByteArrayInputStream
 * and ByteArrayOutputStream in Java.
 *
 * The program reads an image file, converts it into a byte
 * array, and then writes the byte array back into another
 * image file.
 *
 * Finally, it verifies whether the original image and the
 * newly created image are identical by comparing their
 * byte data.
 *
 * Proper exception handling is implemented using try-catch
 * blocks to handle IO-related errors.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageByteArrayDemo {

    public static void main(String[] args) {

        // Source image file
        String sourceImage = "original.jpg";

        // Destination image file
        String destinationImage = "copy.jpg";

        try {
            /* --------- Step 1: Read image into ByteArrayOutputStream --------- */

            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read image data into ByteArrayOutputStream
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            // Convert output stream data to byte array
            byte[] imageBytes = baos.toByteArray();

            fis.close();
            baos.close();

            /* --------- Step 2: Write byte array back to image file --------- */

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(destinationImage);

            // Write byte data into new image file
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            bais.close();
            fos.close();

            System.out.println("Image copied successfully using ByteArray Streams.");

            /* --------- Step 3: Verify both files are identical --------- */

            boolean isIdentical = verifyImages(sourceImage, destinationImage);

            if (isIdentical) {
                System.out.println("Verification Successful: Images are identical.");
            } else {
                System.out.println("Verification Failed: Images are NOT identical.");
            }

        } catch (IOException e) {
            System.out.println("Error occurred while processing image files.");
        }
    }

    // Method to verify whether two files are identical
    private static boolean verifyImages(String file1, String file2) throws IOException {

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        int byte1, byte2;

        // Compare files byte by byte
        while (true) {
            byte1 = fis1.read();
            byte2 = fis2.read();

            if (byte1 != byte2) {
                fis1.close();
                fis2.close();
                return false;
            }

            // End of both files reached
            if (byte1 == -1) {
                break;
            }
        }

        fis1.close();
        fis2.close();
        return true;
    }
}
