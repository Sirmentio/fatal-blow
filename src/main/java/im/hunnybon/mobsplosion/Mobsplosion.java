package im.hunnybon.mobsplosion;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class Mobsplosion implements ModInitializer {
    public static MobsplosionConfig config = new MobsplosionConfig(
            true,
            false,
            7.0f,
            2.0f
    );
    public static Path configPath = Paths.get("config/mobsplosion.json");

    public static void saveData() {
        Gson data = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        try{
            if (configPath.toFile().exists()) {
                config = data.fromJson(new String(Files.readAllBytes(configPath)), MobsplosionConfig.class);
            } else {
                Files.write(configPath, Collections.singleton(data.toJson(config)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Screen buildConfigScreen(MobsplosionConfig cfg) {
        ConfigBuilder configBuilder = ConfigBuilder.create()
                .setTitle(new TranslatableText("title.mobsplosion.config"))
                .setSavingRunnable(Mobsplosion::saveData);
        ConfigCategory general = configBuilder.getOrCreateCategory(new TranslatableText("category.mobsplosion.general"));
        general.setCategoryBackground(Identifier.tryParse("minecraft:textures/block/tnt_side.png"));
        ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();

        general.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("option.mobsplosion.destroyBlocks"), cfg.destroyBlocks)
                .setDefaultValue(true)
                .setTooltip(new TranslatableText("option.mobsplosion.destroyBlocks.desc"))
                .setSaveConsumer(newValue -> cfg.destroyBlocks = newValue)
                .build());
        general.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("option.mobsplosion.createsFire"), cfg.createsFire)
                .setDefaultValue(false)
                .setTooltip(new TranslatableText("option.mobsplosion.createsFire.desc"))
                .setSaveConsumer(newValue -> cfg.createsFire = newValue)
                .build());
        general.addEntry(entryBuilder.startFloatField(new TranslatableText("option.mobsplosion.explosionDivisor"), cfg.explosionDivisor)
                .setDefaultValue(7.0f)
                .setTooltip(new TranslatableText("option.mobsplosion.explosionDivisor.desc"))
                .setSaveConsumer(newValue -> cfg.explosionDivisor = newValue)
                .build());
        general.addEntry(entryBuilder.startFloatField(new TranslatableText("option.mobsplosion.itemExplosionDivisor"), cfg.itemExplosionDivisor)
                .setDefaultValue(2.0f)
                .setTooltip(new TranslatableText("option.mobsplosion.itemExplosionDivisor.desc"))
                .setSaveConsumer(newValue -> cfg.itemExplosionDivisor = newValue)
                .build());

        return configBuilder.build();
    }

    @Override
    public void onInitialize() {
        saveData();
        System.out.println("Boom");
    }
}
