package us.airt.client.feature;

import us.airt.client.api.module.ModuleCategory;
import us.airt.client.api.module.ModuleDescriptor;
import us.airt.client.api.module.RiskLevel;

import java.util.List;

public final class ModuleCatalog {
    private static final List<String> ALL_VERSIONS = List.of("1.8.9", "1.12.2", "1.16.5", "1.18.2", "1.19.4", "1.20.4", "1.21.1");

    private ModuleCatalog() {}

    public static List<ModuleDescriptor> descriptors() {
        return List.of(
                md("killaura", "KillAura", ModuleCategory.COMBAT, RiskLevel.HIGH),
                md("triggerbot", "TriggerBot", ModuleCategory.COMBAT, RiskLevel.HIGH),
                md("autoclicker", "AutoClicker", ModuleCategory.COMBAT, RiskLevel.MEDIUM),
                md("velocity", "Velocity", ModuleCategory.COMBAT, RiskLevel.HIGH),
                md("reach", "Reach", ModuleCategory.COMBAT, RiskLevel.HIGH),
                md("criticals", "Criticals", ModuleCategory.COMBAT, RiskLevel.HIGH),
                md("autoarmor", "AutoArmor", ModuleCategory.COMBAT, RiskLevel.MEDIUM),
                md("autototem", "AutoTotem", ModuleCategory.COMBAT, RiskLevel.MEDIUM),
                md("autoshield", "AutoShield", ModuleCategory.COMBAT, RiskLevel.MEDIUM),
                md("bowaimbot", "BowAimbot", ModuleCategory.COMBAT, RiskLevel.HIGH),
                md("antibot", "AntiBot", ModuleCategory.COMBAT, RiskLevel.SAFE),

                md("flight", "Flight", ModuleCategory.MOVEMENT, RiskLevel.HIGH),
                md("speed", "Speed", ModuleCategory.MOVEMENT, RiskLevel.HIGH),
                md("longjump", "LongJump", ModuleCategory.MOVEMENT, RiskLevel.HIGH),
                md("step", "Step", ModuleCategory.MOVEMENT, RiskLevel.MEDIUM),
                md("nofall", "NoFall", ModuleCategory.MOVEMENT, RiskLevel.HIGH),
                md("jesus", "Jesus", ModuleCategory.MOVEMENT, RiskLevel.HIGH),
                md("scaffold", "Scaffold", ModuleCategory.MOVEMENT, RiskLevel.HIGH),
                md("spider", "Spider", ModuleCategory.MOVEMENT, RiskLevel.HIGH),
                md("noslow", "NoSlow", ModuleCategory.MOVEMENT, RiskLevel.MEDIUM),
                md("sprint", "Sprint", ModuleCategory.MOVEMENT, RiskLevel.SAFE),

                md("autoeat", "AutoEat", ModuleCategory.PLAYER, RiskLevel.SAFE),
                md("autotool", "AutoTool", ModuleCategory.PLAYER, RiskLevel.SAFE),
                md("autowalk", "AutoWalk", ModuleCategory.PLAYER, RiskLevel.SAFE),
                md("antivoid", "AntiVoid", ModuleCategory.PLAYER, RiskLevel.MEDIUM),
                md("blink", "Blink", ModuleCategory.PLAYER, RiskLevel.HIGH),
                md("freecam", "Freecam", ModuleCategory.PLAYER, RiskLevel.SAFE),
                md("inventorymanager", "InventoryManager", ModuleCategory.PLAYER, RiskLevel.SAFE),
                md("cheststealer", "ChestStealer", ModuleCategory.PLAYER, RiskLevel.MEDIUM),

                md("esp", "ESP", ModuleCategory.RENDER, RiskLevel.SAFE),
                md("tracers", "Tracers", ModuleCategory.RENDER, RiskLevel.SAFE),
                md("xray", "X-Ray", ModuleCategory.RENDER, RiskLevel.MEDIUM),
                md("fullbright", "Fullbright", ModuleCategory.RENDER, RiskLevel.SAFE),
                md("chams", "Chams", ModuleCategory.RENDER, RiskLevel.SAFE),
                md("animations", "Animations", ModuleCategory.RENDER, RiskLevel.SAFE),
                md("hud", "HUD", ModuleCategory.RENDER, RiskLevel.SAFE),
                md("weatherchanger", "WeatherChanger", ModuleCategory.RENDER, RiskLevel.SAFE),

                md("nuker", "Nuker", ModuleCategory.WORLD, RiskLevel.HIGH),
                md("autofarm", "AutoFarm", ModuleCategory.WORLD, RiskLevel.MEDIUM),
                md("autofish", "AutoFish", ModuleCategory.WORLD, RiskLevel.SAFE),
                md("crystalbreaker", "CrystalBreaker", ModuleCategory.WORLD, RiskLevel.HIGH),
                md("chestaura", "ChestAura", ModuleCategory.WORLD, RiskLevel.MEDIUM),
                md("entitycontrol", "EntityControl", ModuleCategory.WORLD, RiskLevel.MEDIUM),

                md("anticheatdetector", "AntiCheatDetector", ModuleCategory.MISC, RiskLevel.SAFE),
                md("bypassloader", "BypassLoader", ModuleCategory.MISC, RiskLevel.HIGH),
                md("configgenerator", "ConfigGenerator", ModuleCategory.MISC, RiskLevel.SAFE),
                md("actester", "ACTester", ModuleCategory.MISC, RiskLevel.HIGH),

                md("jsruntime", "JavaScript Runtime", ModuleCategory.SCRIPT, RiskLevel.SAFE),
                md("luaruntime", "Lua Runtime", ModuleCategory.SCRIPT, RiskLevel.SAFE),
                md("macros", "Macros", ModuleCategory.SCRIPT, RiskLevel.SAFE),
                md("autobuilder", "AutoBuilder", ModuleCategory.SCRIPT, RiskLevel.MEDIUM)
        );
    }

    private static ModuleDescriptor md(String id, String name, ModuleCategory category, RiskLevel riskLevel) {
        return new ModuleDescriptor(id, name, category, riskLevel, ALL_VERSIONS);
    }
}
