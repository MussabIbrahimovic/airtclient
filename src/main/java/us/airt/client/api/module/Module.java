package us.airt.client.api.module;

import us.airt.client.api.setting.Setting;

import java.util.List;

public interface Module {
    ModuleDescriptor descriptor();

    boolean enabled();

    void setEnabled(boolean enabled);

    List<Setting<?>> settings();

    default void onEnable() {}

    default void onDisable() {}
}
