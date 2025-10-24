package ch12.examples;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleDescriptor.Version;
import java.util.Set;

/**
 * Uses the runtime {@link Module} API as shown in Chapter 12 "Deeper into the Module System" to read
 * descriptor details such as versions and exported packages.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c12.xhtml">OCP Java SE 17 Study Guide – Chapter 12: Deeper into the Module System</a>
 */
public final class ModuleReflectionExamples {

    private ModuleReflectionExamples() {
    }

    /**
     * @return module version if declared, otherwise {@code null}
     */
    public static Version versionOf(Module module) {
        ModuleDescriptor descriptor = module.getDescriptor();
        if (descriptor == null) {
            return null;
        }
        return descriptor.version().orElse(null);
    }

    /**
     * @return set of packages exported by the module, reinforcing descriptor inspection techniques
     */
    public static Set<String> exportedPackages(Module module) {
        ModuleDescriptor descriptor = module.getDescriptor();
        if (descriptor == null) {
            return Set.of();
        }
        return descriptor.exports().stream().map(ModuleDescriptor.Exports::source).collect(java.util.stream.Collectors.toSet());
    }
}
