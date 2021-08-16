package im.hunnybon.mobsplosion;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import im.hunnybon.mobsplosion.*;

public class ModMenuIntegration implements ModMenuApi {

    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            // Return the screen here with the one you created from Cloth Config Builder
            return Mobsplosion.buildConfigScreen(Mobsplosion.config);
        };
    }
}
