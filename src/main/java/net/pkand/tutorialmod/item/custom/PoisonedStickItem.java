package net.pkand.tutorialmod.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class PoisonedStickItem extends Item {
    public PoisonedStickItem(Settings settings) {
        super(settings);
    }



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
       World world = target.getEntityWorld();
        if(!world.isClient) {
            stack.damage(1,((ServerWorld) world),((ServerPlayerEntity) attacker),
                    item -> attacker.sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            if(stack.getDamage()==0){

            }
        }

        return super.postHit(stack, target, attacker);
    }
}
