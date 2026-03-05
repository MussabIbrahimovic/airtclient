package us.airt.client.api.setting;

public interface Setting<T> {
    String key();

    T value();

    void setValue(T value);
}
