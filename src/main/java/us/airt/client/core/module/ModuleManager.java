package us.airt.client.core.module;

import us.airt.client.api.module.Module;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public final class ModuleManager {
    private final Map<String, Module> modules = new LinkedHashMap<>();

    public void register(Module module) {
        modules.put(module.descriptor().id(), module);
    }

    public Optional<Module> find(String id) {
        return Optional.ofNullable(modules.get(id));
    }

    public Collection<Module> all() {
        return modules.values();
    }
}
