package regexandjunit;

/*
 * This class validates password strength.
 * A valid password must have:
 * - At least 8 characters
 * - At least one uppercase letter
 * - At least one digit
 */
public class PasswordValidator {

    public boolean isValid(String password) {

        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasUppercase && hasDigit;
    }
}
