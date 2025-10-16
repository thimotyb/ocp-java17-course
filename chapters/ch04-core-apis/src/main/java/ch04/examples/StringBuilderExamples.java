package ch04.examples;

public final class StringBuilderExamples {

    private StringBuilderExamples() {
    }

    public static String appendExample() {
        var sb = new StringBuilder().append(1).append('c');
        sb.append("-").append(true);
        return sb.toString();
    }

    public static String sharedReferenceExample() {
        var a = new StringBuilder("abc");
        var b = a.append("de");
        b.append("f");
        return a.toString();
    }

    public static String createWithCapacity() {
        var sb1 = new StringBuilder();
        var sb2 = new StringBuilder("animal");
        var sb3 = new StringBuilder(10);
        return sb1.toString() + "," + sb2 + "," + sb3.capacity();
    }

    public static String insertExample() {
        var sb = new StringBuilder("animals");
        sb.insert(7, "-");
        sb.insert(0, "-");
        sb.insert(4, "-");
        return sb.toString();
    }

    public static String deleteExample() {
        var sb = new StringBuilder("abcdef");
        sb.delete(1, 3);
        return sb.toString();
    }

    public static Exception deleteCharAtException() {
        var sb = new StringBuilder("abcdef");
        sb.delete(1, 3);
        try {
            sb.deleteCharAt(5);
            return null;
        } catch (Exception e) {
            return e;
        }
    }

    public static String deletePastEnd() {
        var sb = new StringBuilder("abcdef");
        sb.delete(1, 100);
        return sb.toString();
    }

    public static String replaceExample() {
        var builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 6, "sty");
        return builder.toString();
    }

    public static String replaceWithEmpty() {
        var builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 100, "");
        return builder.toString();
    }

    public static String reverseExample() {
        var sb = new StringBuilder("ABC");
        sb.reverse();
        return sb.toString();
    }

    public static boolean sameReference() {
        var one = new StringBuilder();
        var two = new StringBuilder();
        return one == two;
    }
}
