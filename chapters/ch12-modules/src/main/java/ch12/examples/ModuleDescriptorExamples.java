package ch12.examples;

import java.util.List;

/**
 * Provides string representations of module descriptors from Chapter 12 "Building Modules". These
 * snippets parallel the module-info listings used to explain exports, requires (including transitive)
 * and service directives.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c12.xhtml">OCP Java SE 17 Study Guide – Chapter 12: Building Modules</a>
 */
public final class ModuleDescriptorExamples {

    private ModuleDescriptorExamples() {
    }

    /**
     * @return descriptor string showing basic {@code exports} and {@code requires} directives.
     */
    public static String zooModuleDescriptor() {
        return "module zoo.animal.feeding {\n" +
            "    exports zoo.animal.feeding;\n" +
            "    requires zoo.animal.care;\n" +
            "}";
    }

    /**
     * @return descriptor string highlighting {@code exports ... to} and {@code requires transitive}.
     */
    public static String zooCareDescriptor() {
        return "module zoo.animal.care {\n" +
            "    exports zoo.animal.care.medical to zoo.staff;\n" +
            "    requires transitive zoo.animal.nutrition;\n" +
            "}";
    }

    /**
     * @return descriptors demonstrating {@code uses} and {@code provides ... with} service directives.
     */
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
