package us.airt.client.core.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ConfigService {
    public <T> void saveJson(Path path, T value) throws IOException {
        Files.createDirectories(path.getParent());
        Files.writeString(path, String.valueOf(value));
    }

    public <T> T loadJson(Path path, Class<T> type) throws IOException {
        throw new UnsupportedOperationException("Typed JSON deserialization is pending integration.");
    }

    public <T> void saveYaml(Path path, T value) throws IOException {
        Files.createDirectories(path.getParent());
        Files.writeString(path, String.valueOf(value));
    }

    public <T> T loadYaml(Path path, Class<T> type) throws IOException {
        throw new UnsupportedOperationException("Typed YAML deserialization is pending integration.");
    }
}
