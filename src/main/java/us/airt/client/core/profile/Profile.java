package us.airt.client.core.profile;

import java.util.HashMap;
import java.util.Map;

public record Profile(String name, String serverPattern, Map<String, Boolean> enabledModules, Map<String, Map<String, Object>> moduleSettings) {
    public static Profile empty(String name, String serverPattern) {
        return new Profile(name, serverPattern, new HashMap<>(), new HashMap<>());
    }
}
