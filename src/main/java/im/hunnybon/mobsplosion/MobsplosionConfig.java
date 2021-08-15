package im.hunnybon.mobsplosion;

import me.shedaniel.clothconfig2.api.ConfigBuilder;

public class MobsplosionConfig {
    public boolean destroyBlocks;
    public boolean createsFire;
    public float explosionDivisor;
    public float itemExplosionDivisor;
    public MobsplosionConfig(boolean ayyy, boolean bee, float cee, float dee) {
        this.destroyBlocks = ayyy;
        this.createsFire = bee;
        this.explosionDivisor = cee;
        this.itemExplosionDivisor = dee;
    }
}
