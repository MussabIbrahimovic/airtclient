package us.airt.client.ui.clickgui;

import us.airt.client.api.module.Module;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public final class ClickGuiRenderer {
    public String render(Collection<Module> modules) {
        Map<String, Integer> counts = new TreeMap<>();
        for (Module module : modules) {
            counts.merge(module.descriptor().category().name(), 1, Integer::sum);
        }

        StringBuilder out = new StringBuilder();
        out.append("=== AIRT.US ClickGUI ===\n");
        out.append("Theme: Dark Purple/Black\n");
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            out.append(" - ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" modules\n");
        }
        out.append("Press Right Shift to close.\n");
        return out.toString();
    }
}
