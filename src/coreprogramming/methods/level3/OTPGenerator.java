package coreprogramming.methods.level3;

/*
 * OTPGenerator
 * ------------
 * This program generates a 6-digit OTP using Math.random().
 * It generates the OTP 10 times, stores them in an array,
 * and checks whether all generated OTPs are unique.
 */
public class OTPGenerator {

    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000; // Generates number between 100000 and 999999
    }

    // Method to check if all OTPs in the array are unique
    public static boolean areOTPsUnique(int[] otps) {

        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // Duplicate found
                }
            }
        }
        return true; // All OTPs are unique
    }

    public static void main(String[] args) {

        int[] otpArray = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
            System.out.println("Generated OTP " + (i + 1) + " : " + otpArray[i]);
        }

        // Check uniqueness
        boolean isUnique = areOTPsUnique(otpArray);

        if (isUnique) {
            System.out.println("\nAll generated OTPs are unique.");
        } else {
            System.out.println("\nSome OTPs are repeated. They are not unique.");
        }
    }
}
