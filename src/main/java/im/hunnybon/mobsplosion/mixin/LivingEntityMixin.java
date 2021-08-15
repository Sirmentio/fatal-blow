package im.hunnybon.mobsplosion.mixin;


import im.hunnybon.mobsplosion.Mobsplosion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin extends Entity {

    @Shadow public abstract float getMaxHealth();

    @Shadow protected abstract void drop(DamageSource source);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onDeath", at = @At(value = "HEAD"))
    public void onDeath(DamageSource source, CallbackInfo ci){
        if (this.getMaxHealth() > 2.0f & this.world instanceof ServerWorld){
            this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(),
                    this.getMaxHealth() / Mobsplosion.config.explosionDivisor, Mobsplosion.config.createsFire, Mobsplosion.config.destroyBlocks ? Explosion.DestructionType.BREAK : Explosion.DestructionType.NONE);
        }
    }
}
