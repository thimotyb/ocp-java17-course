package ch02.assignment;

/**
 * Demonstrates compound assignments and assignment expressions.
 */
public final class CompoundOperations {

    private CompoundOperations() {
    }

    public static int multiply(int base, long factor) {
        int value = base;
        value *= factor;
        return value;
    }

    public static short addToShort(short start, int delta) {
        short value = start;
        value += delta;
        return value;
    }

    public static boolean toggleWithAssignment(boolean start) {
        boolean flag = start;
        return flag = !flag;
    }

    public static int chainedAssignmentSum() {
        int wolf = 5;
        long coyote = (wolf = 3);
        return wolf + (int) coyote;
    }
}
