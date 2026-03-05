package us.airt.client;

import org.junit.jupiter.api.Test;
import us.airt.client.api.input.KeyCode;
import us.airt.client.api.module.ModuleCategory;

import static org.junit.jupiter.api.Assertions.*;

class AirtClientTest {
    @Test
    void bootstrapsModulesFromCatalog() {
        AirtClient client = new AirtClient();
        client.bootstrap();

        assertTrue(client.moduleManager().all().size() >= 40);
        assertTrue(client.moduleManager().find("killaura").isPresent());
        assertEquals(ModuleCategory.COMBAT, client.moduleManager().find("killaura").orElseThrow().descriptor().category());
    }

    @Test
    void rightShiftTogglesClickGui() {
        AirtClient client = new AirtClient();
        client.bootstrap();

        assertFalse(client.isClickGuiOpen());
        client.onKeyInput(KeyCode.RIGHT_SHIFT.code(), true);
        assertTrue(client.isClickGuiOpen());
        assertTrue(client.renderClickGuiIfOpen().contains("AIRT.US ClickGUI"));

        client.onKeyInput(KeyCode.RIGHT_SHIFT.code(), true);
        assertFalse(client.isClickGuiOpen());
    }
}
