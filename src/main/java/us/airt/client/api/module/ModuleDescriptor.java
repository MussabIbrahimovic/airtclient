package us.airt.client.api.module;

import java.util.List;

public record ModuleDescriptor(
        String id,
        String displayName,
        ModuleCategory category,
        RiskLevel riskLevel,
        List<String> supportedVersions
) {
}
