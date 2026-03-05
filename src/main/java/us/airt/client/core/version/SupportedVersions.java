package us.airt.client.core.version;

import java.util.Set;

public final class SupportedVersions {
    public static final Set<String> ALL = Set.of("1.8.9", "1.12.2", "1.16.5", "1.18.2", "1.19.4", "1.20.4", "1.21.1");

    private SupportedVersions() {}

    public static boolean isSupported(String version) {
        return ALL.contains(version);
    }
}
