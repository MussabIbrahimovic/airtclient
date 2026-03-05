package us.airt.client.core.module;

import us.airt.client.api.setting.Setting;

public final class BasicSetting<T> implements Setting<T> {
    private final String key;
    private T value;

    public BasicSetting(String key, T value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String key() {
        return key;
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
