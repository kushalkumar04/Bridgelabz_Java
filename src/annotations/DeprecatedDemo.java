package annotations;

/*
 * This program demonstrates the use of @Deprecated annotation.
 * The LegacyAPI class contains an old method marked as deprecated
 * to indicate it should no longer be used.
 * A new method is introduced as its replacement.
 */

class LegacyAPI {

    /**
     * This method is outdated and should not be used.
     * The @Deprecated annotation signals developers
     * and IDEs that this method is discouraged.
     */
    @Deprecated
    public void oldFeature() {
        System.out.println("Executing old feature...");
    }

    /**
     * Recommended replacement method.
     */
    public void newFeature() {
        System.out.println("Executing new feature...");
    }
}


/*
 * Main class to demonstrate deprecated method usage.
 * Calling oldFeature() will generate a compile-time warning.
 */
public class DeprecatedDemo {

    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        // Calling deprecated method (compiler will show warning)
        api.oldFeature();

        // Calling recommended method
        api.newFeature();
    }
}