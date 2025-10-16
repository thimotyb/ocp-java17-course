package ch04.examples;

public final class StringIndentExamples {

    private StringIndentExamples() {
    }

    public static String block() {
        return """
                a
                 b
                c""";
    }

    public static String concat() {
        return " a\n" +
                "  b\n" +
                " c";
    }

    public static int blockLength() {
        return block().length();
    }

    public static int concatLength() {
        return concat().length();
    }

    public static int blockIndentLength(int indent) {
        return block().indent(indent).length();
    }

    public static int concatIndentLength(int indent) {
        return concat().indent(indent).length();
    }

    public static int concatStripIndentLength() {
        return concat().stripIndent().length();
    }
}
