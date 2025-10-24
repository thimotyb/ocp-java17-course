package ch04.examples;

/**
 * Demonstrates array declaration, initialization, and usage covered in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Understanding Java Arrays</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>Array declaration syntax variations: int[] vs int[]</li>
 *   <li>Array initialization: anonymous arrays with new int[] {...}</li>
 *   <li>Array references and aliasing: multiple variables can reference same array</li>
 *   <li>Array covariance: String[] can be assigned to Object[]</li>
 *   <li>ArrayStoreException: runtime type checking prevents incompatible assignments</li>
 *   <li>Array casting: can cast Object[] back to String[] if underlying type matches</li>
 *   <li>Array length field: arrays.length returns number of elements</li>
 *   <li>Array iteration with for loop</li>
 * </ul>
 *
 * @see java.util.Arrays
 */
public final class ArrayDeclarationsExamples {

    private ArrayDeclarationsExamples() {
    }

    /**
     * Demonstrates various array declaration syntax styles.
     *
     * <p>Java allows brackets in multiple positions, though int[] is preferred style.
     * All declarations create array variables (some unused in this method).</p>
     *
     * @return 2D array containing the initialized array and empty arrays
     */
    public static int[][] createMultipleArrays() {
        int[] moreNumbers = {42, 55, 99};  // Anonymous array initialization
        int[] numAnimals;                  // Preferred style: brackets after type
        int [] numAnimals2;                // Brackets before variable name (space after type)
        int []numAnimals3;                 // Brackets after type (no space)
        int numAnimals4[];                 // Brackets after variable name (C-style)
        int numAnimals5 [];                // Brackets after variable name (with space)
        return new int[][] {moreNumbers, new int[0], new int[0], new int[0], new int[0], new int[0]};
    }

    /**
     * Demonstrates declaring multiple array variables in one statement.
     *
     * <p>When using int[] ids, types; both variables are array types.
     * Compare with: int ids[], types; where only ids is an array.</p>
     *
     * @return 2D array containing both initialized arrays: [[1,2], [3,4]]
     */
    public static int[][] createIdsAndTypes() {
        int[] ids, types;              // Both are int[] (array type on left)
        ids = new int[] {1, 2};        // Anonymous array syntax
        types = new int[] {3, 4};
        return new int[][] {ids, types};
    }

    /**
     * Demonstrates array references and aliasing.
     *
     * <p>Arrays are objects. Assigning one array to another creates an alias
     * (both variables reference the same array object).
     * Note: arrays don't override equals(), so bugs.equals(alias) uses == comparison.</p>
     *
     * @return [true, bugs.toString()] - true because bugs==alias, toString is default Object impl
     */
    public static Object[] bugsAlias() {
        String[] bugs = {"cricket", "beetle", "ladybug"};
        String[] alias = bugs;  // alias and bugs reference same array object
        return new Object[] {bugs.equals(alias), bugs.toString()};  // equals() uses ==
    }

    /**
     * Demonstrates array as instance field with C-style declaration.
     *
     * <p>Shows that brackets can appear after variable name in field declarations.
     * Array fields default to null if not initialized.</p>
     *
     * @return String array of length 2, initialized with null elements
     */
    public static String[] namesField() {
        class Names {
            String names[] = new String[2];  // C-style: brackets after variable
        }
        return new Names().names;  // Returns array with 2 null elements
    }

    /**
     * Demonstrates ArrayStoreException with array covariance.
     *
     * <p>Array covariance allows String[] to be assigned to Object[].
     * However, the underlying array is still String[], so storing a StringBuilder
     * (incompatible type) throws ArrayStoreException at runtime.</p>
     *
     * @return ArrayStoreException - runtime check prevents storing StringBuilder in String[]
     */
    public static Exception arrayStoreExceptionExample() {
        String[] strings = {"stringValue"};
        Object[] objects = strings;  // Legal: array covariance (compile-time)
        try {
            objects[0] = new StringBuilder();  // Runtime: ArrayStoreException
            return null;
        } catch (Exception e) {
            return e;  // ArrayStoreException: underlying type is String[]
        }
    }

    /**
     * Demonstrates array casting and shared references.
     *
     * <p>An Object[] that actually references a String[] can be cast back to String[].
     * Changes through any reference affect the underlying array.</p>
     *
     * @return "updated" - shows all three variables reference the same array
     */
    public static Object arrayCastingExample() {
        String[] strings = {"stringValue"};
        Object[] objects = strings;              // Upcast to Object[]
        String[] againStrings = (String[]) objects;  // Downcast back to String[]
        againStrings[0] = "updated";             // Modifies shared underlying array
        return objects[0];                       // Returns "updated"
    }

    /**
     * Demonstrates accessing array length and element lengths.
     *
     * <p>arrays.length gives number of elements.
     * array[i].length() calls the length() method on String element.</p>
     *
     * @return [3, 6, 5, 6] - array length and each String's length
     */
    public static int[] mammalsArray() {
        String[] mammals = {"monkey", "chimp", "donkey"};
        return new int[] {
            mammals.length,        // 3 elements in array
            mammals[0].length(),   // "monkey" has 6 characters
            mammals[1].length(),   // "chimp" has 5 characters
            mammals[2].length()    // "donkey" has 6 characters
        };
    }

    /**
     * Demonstrates array iteration with for loop.
     *
     * <p>Standard loop pattern: for (int i = 0; i < array.length; i++)
     * Populates array with values from 5 to 14.</p>
     *
     * @return String array ["5", "6", "7", ..., "14"]
     */
    public static String[] fillNumbers() {
        var numbers = new int[10];              // Array of 10 elements
        for (int i = 0; i < numbers.length; i++) {  // Loop from 0 to 9
            numbers[i] = i + 5;                 // Assign values 5 through 14
        }
        return java.util.Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
    }
}
