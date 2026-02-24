package annotations;

/*
 * This program demonstrates suppression of unchecked warnings
 * using @SuppressWarnings("unchecked") annotation.
 * A raw ArrayList is used without generics, which normally
 * produces a compilation warning.
 */

import java.util.ArrayList;
import java.util.List;

public class SuppressWarningDemo {

    public static void main(String[] args) {

        // Creating a raw ArrayList (no generics used)
        ArrayList rawList = new ArrayList();

        // Adding different types of elements (no type safety)
        rawList.add("Java");
        rawList.add(100);
        rawList.add(3.14);

        /*
         * Suppressing unchecked warning during type casting.
         * Normally, this cast produces:
         * "Unchecked cast from ArrayList to List<String>"
         */
        @SuppressWarnings("unchecked")
        List<String> stringList = rawList;

        // Accessing elements (may cause runtime ClassCastException)
        for (String str : stringList) {
            System.out.println(str);
        }
    }
}
