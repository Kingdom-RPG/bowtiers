package ru.kingdomrpg.bowtiers.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import ru.kingdomrpg.bowtiers.item.bow.TieredBowItem;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {


    public AbstractClientPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile, @Nullable PlayerPublicKey publicKey) {
        super(world, pos, yaw, gameProfile, publicKey);
    }

    @ModifyVariable(method = "getFovMultiplier()F", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;lerp(FFF)F", shift = At.Shift.BEFORE), ordinal = 0)
    private float getFovMultiplierMixin(float finalFov) {
        if (isUsingItem() && getActiveItem().getItem() instanceof final TieredBowItem bow) {
            float customBow = getItemUseTime() / bow.getPowerDiv();

            if (customBow > 1.0F) {
                customBow = 1.0F;
            } else {
                customBow *= customBow;
            }

            finalFov *= 1.0F - (customBow * 0.15F);
        }

        return finalFov;
    }

}