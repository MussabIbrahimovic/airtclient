package us.airt.client.core.module;

import us.airt.client.api.module.Module;
import us.airt.client.api.module.ModuleDescriptor;
import us.airt.client.api.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public final class BasicModule implements Module {
    private final ModuleDescriptor descriptor;
    private final List<Setting<?>> settings = new ArrayList<>();
    private boolean enabled;

    public BasicModule(ModuleDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public ModuleDescriptor descriptor() {
        return descriptor;
    }

    @Override
    public boolean enabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled) return;
        this.enabled = enabled;
        if (enabled) onEnable();
        else onDisable();
    }

    @Override
    public List<Setting<?>> settings() {
        return settings;
    }
}
