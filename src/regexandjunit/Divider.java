package regexandjunit;

/*
 * This class provides a divide method.
 * It throws an ArithmeticException
 * if the divisor is zero.
 */
public class Divider {

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero not allowed");
        }
        return a / b;
    }
}
