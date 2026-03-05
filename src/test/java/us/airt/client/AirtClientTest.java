package us.airt.client;

import org.junit.jupiter.api.Test;
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
}
