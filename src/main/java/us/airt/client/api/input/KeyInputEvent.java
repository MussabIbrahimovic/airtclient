package us.airt.client.api.input;

import us.airt.client.api.event.Event;

public record KeyInputEvent(KeyCode keyCode, KeyAction action) implements Event {
}
