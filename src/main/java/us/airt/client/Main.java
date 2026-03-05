package us.airt.client;

import us.airt.client.api.input.KeyCode;

public final class Main {
    public static void main(String[] args) {
        AirtClient client = new AirtClient();
        client.bootstrap();
        System.out.println("AIRT.US bootstrap complete. Modules registered: " + client.moduleManager().all().size());

        // Demo: Right Shift toggles ClickGUI open/close.
        client.onKeyInput(KeyCode.RIGHT_SHIFT.code(), true);
        System.out.print(client.renderClickGuiIfOpen());
    }
}
