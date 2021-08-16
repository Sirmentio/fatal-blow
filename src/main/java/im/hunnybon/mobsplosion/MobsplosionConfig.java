package im.hunnybon.mobsplosion;

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
