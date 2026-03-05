package us.airt.client.core.input;

import us.airt.client.api.event.EventPriority;
import us.airt.client.api.input.KeyAction;
import us.airt.client.api.input.KeyCode;
import us.airt.client.api.input.KeyInputEvent;
import us.airt.client.core.eventbus.EventBus;
import us.airt.client.ui.clickgui.ClickGuiState;

public final class GuiKeybindController {
    public GuiKeybindController(EventBus eventBus, ClickGuiState clickGuiState) {
        eventBus.subscribe(KeyInputEvent.class, EventPriority.NORMAL, event -> {
            if (event.action() == KeyAction.PRESS && event.keyCode() == KeyCode.RIGHT_SHIFT) {
                clickGuiState.toggle();
            }
        });
    }
}
