package ch12.examples;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleDescriptor.Version;
import java.util.Set;

/**
 * Uses the runtime Module API to inspect descriptors.
 */
public final class ModuleReflectionExamples {

    private ModuleReflectionExamples() {
    }

    public static Version versionOf(Module module) {
        ModuleDescriptor descriptor = module.getDescriptor();
        if (descriptor == null) {
            return null;
        }
        return descriptor.version().orElse(null);
    }

    public static Set<String> exportedPackages(Module module) {
        ModuleDescriptor descriptor = module.getDescriptor();
        if (descriptor == null) {
            return Set.of();
        }
        return descriptor.exports().stream().map(ModuleDescriptor.Exports::source).collect(java.util.stream.Collectors.toSet());
    }
}
