package im.hunnybon.mobsplosion;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class MobsplosionConfig {
    public boolean destroyBlocks;
    public boolean createsFire;
    public float explosionDivisor;
    public float itemExplosionDivisor;

    public MobsplosionConfig(boolean destroyBlocks, boolean createsFire, float explosionDivisor, float itemExplosionDivisor) {
        this.destroyBlocks = destroyBlocks;
        this.createsFire = createsFire;
        this.explosionDivisor = explosionDivisor;
        this.itemExplosionDivisor = itemExplosionDivisor;
    }

}
