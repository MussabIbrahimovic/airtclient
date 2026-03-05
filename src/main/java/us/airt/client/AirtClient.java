package us.airt.client;

import us.airt.client.api.input.KeyAction;
import us.airt.client.api.input.KeyCode;
import us.airt.client.api.input.KeyInputEvent;
import us.airt.client.api.module.ModuleDescriptor;
import us.airt.client.core.config.ConfigService;
import us.airt.client.core.eventbus.EventBus;
import us.airt.client.core.input.GuiKeybindController;
import us.airt.client.core.module.BasicModule;
import us.airt.client.core.module.ModuleManager;
import us.airt.client.core.profile.Profile;
import us.airt.client.core.profile.ProfileManager;
import us.airt.client.feature.ModuleCatalog;
import us.airt.client.scripting.ScriptEngineFacade;
import us.airt.client.ui.clickgui.ClickGuiRenderer;
import us.airt.client.ui.clickgui.ClickGuiState;

import java.nio.file.Path;

public final class AirtClient {
    private final EventBus eventBus = new EventBus();
    private final ModuleManager moduleManager = new ModuleManager();
    private final ConfigService configService = new ConfigService();
    private final ProfileManager profileManager = new ProfileManager(configService, Path.of("configs", "profiles"));
    private final ScriptEngineFacade scriptEngine = new ScriptEngineFacade();
    private final ClickGuiState clickGuiState = new ClickGuiState();
    private final ClickGuiRenderer clickGuiRenderer = new ClickGuiRenderer();

    public void bootstrap() {
        for (ModuleDescriptor descriptor : ModuleCatalog.descriptors()) {
            moduleManager.register(new BasicModule(descriptor));
        }
        new GuiKeybindController(eventBus, clickGuiState);
    }

    public void onKeyInput(int keyCode, boolean pressed) {
        KeyCode key = KeyCode.fromCode(keyCode);
        if (key == null) {
            return;
        }
        eventBus.post(new KeyInputEvent(key, pressed ? KeyAction.PRESS : KeyAction.RELEASE));
    }

    public String renderClickGuiIfOpen() {
        if (!clickGuiState.isOpen()) {
            return "";
        }
        return clickGuiRenderer.render(moduleManager.all());
    }

    public boolean isClickGuiOpen() {
        return clickGuiState.isOpen();
    }

    public void saveDefaultProfile() throws Exception {
        Profile profile = Profile.empty("default", "*");
        profileManager.save(profile);
    }

    public ModuleManager moduleManager() {
        return moduleManager;
    }

    public EventBus eventBus() {
        return eventBus;
    }

    public ScriptEngineFacade scriptEngine() {
        return scriptEngine;
    }
}
