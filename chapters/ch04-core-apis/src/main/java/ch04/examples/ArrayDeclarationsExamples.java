package ch04.examples;

public final class ArrayDeclarationsExamples {

    private ArrayDeclarationsExamples() {
    }

    public static int[][] createMultipleArrays() {
        int[] moreNumbers = {42, 55, 99};
        int[] numAnimals;
        int [] numAnimals2;
        int []numAnimals3;
        int numAnimals4[];
        int numAnimals5 [];
        return new int[][] {moreNumbers, new int[0], new int[0], new int[0], new int[0], new int[0]};
    }

    public static int[][] createIdsAndTypes() {
        int[] ids, types;
        ids = new int[] {1, 2};
        types = new int[] {3, 4};
        return new int[][] {ids, types};
    }

    public static Object[] bugsAlias() {
        String[] bugs = {"cricket", "beetle", "ladybug"};
        String[] alias = bugs;
        return new Object[] {bugs.equals(alias), bugs.toString()};
    }

    public static String[] namesField() {
        class Names {
            String names[] = new String[2];
        }
        return new Names().names;
    }

    public static Exception arrayStoreExceptionExample() {
        String[] strings = {"stringValue"};
        Object[] objects = strings;
        try {
            objects[0] = new StringBuilder();
            return null;
        } catch (Exception e) {
            return e;
        }
    }

    public static Object arrayCastingExample() {
        String[] strings = {"stringValue"};
        Object[] objects = strings;
        String[] againStrings = (String[]) objects;
        againStrings[0] = "updated";
        return objects[0];
    }

    public static int[] mammalsArray() {
        String[] mammals = {"monkey", "chimp", "donkey"};
        return new int[] {mammals.length, mammals[0].length(), mammals[1].length(), mammals[2].length()};
    }

    public static String[] fillNumbers() {
        var numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 5;
        }
        return java.util.Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
    }
}
