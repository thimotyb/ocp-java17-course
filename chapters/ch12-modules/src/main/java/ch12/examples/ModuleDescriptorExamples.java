package ch12.examples;

import java.util.List;

/**
 * Represents module descriptor snippets described in Chapter 12.
 */
public final class ModuleDescriptorExamples {

    private ModuleDescriptorExamples() {
    }

    public static String zooModuleDescriptor() {
        return "module zoo.animal.feeding {\n" +
            "    exports zoo.animal.feeding;\n" +
            "    requires zoo.animal.care;\n" +
            "}";
    }

    public static String zooCareDescriptor() {
        return "module zoo.animal.care {\n" +
            "    exports zoo.animal.care.medical to zoo.staff;\n" +
            "    requires transitive zoo.animal.nutrition;\n" +
            "}";
    }

    public static List<String> servicesDescriptor() {
        return List.of(
            "module zoo.staff {\n" +
                "    requires zoo.animal.feeding;\n" +
                "    uses zoo.animal.care.Caretaker;\n" +
                "}",
            "module zoo.animal.talent {\n" +
                "    provides zoo.animal.care.Caretaker with zoo.animal.talent.AcrobatCaretaker;\n" +
                "}"
        );
    }
}
