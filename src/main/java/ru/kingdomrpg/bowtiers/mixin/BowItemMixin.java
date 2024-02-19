package ru.kingdomrpg.bowtiers.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import ru.kingdomrpg.bowtiers.BowManager;

@SuppressWarnings("ConstantValue")
@Mixin(BowItem.class)
public class BowItemMixin {

    @Inject(method = "onStoppedUsing", at = @At(value = "INVOKE_ASSIGN", shift = At.Shift.BEFORE, target = "Lnet/minecraft/enchantment/EnchantmentHelper;getLevel(Lnet/minecraft/enchantment/Enchantment;Lnet/minecraft/item/ItemStack;)I", ordinal = 1), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void onStoppedUsingMixin(ItemStack stack,
                                     World world,
                                     LivingEntity user,
                                     int remainingUseTicks,
                                     CallbackInfo info,
                                     PlayerEntity playerEntity,
                                     boolean bl,
                                     ItemStack itemStack,
                                     int i,
                                     float f,
                                     boolean bl2,
                                     ArrowItem arrowItem,
                                     PersistentProjectileEntity persistentProjectileEntity) {
        // If its a default bow, we subtract damage

        BowItem b = (BowItem) (Object) this;
        BowManager.INSTANCE.modifyBowDamage(b, persistentProjectileEntity);
        BowManager.INSTANCE.modifyProjectileSpeed(b, persistentProjectileEntity);
    }

}
