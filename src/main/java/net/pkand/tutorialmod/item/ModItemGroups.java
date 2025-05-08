package net.pkand.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pkand.tutorialmod.TutorialMod;
import net.pkand.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup FUNGAL_BLOCKS_ITEMS_GROUP= Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"fungal_blocks"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModBlocks.PINK_MUSHROOM_BLOCK))
                    .displayName(Text.translatable("item_groups.tutorialmod.fungal_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PINK_MUSHROOM_STEM);
                    }).build());

    public static final ItemGroup FUNGAL_ITEMS_ITEMS_GROUP= Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"fungal_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModItems.PINK_MUSHROOM))
                    .displayName(Text.translatable("item_groups.tutorialmod.fungal_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_MUSHROOM);
                        entries.add(ModItems.PINK_MUSHROOM_STEW);
                        entries.add(ModItems.FUNGAL_STICK);
                    }).build());


    public static void registerModItemGroups() {
        TutorialMod.LOGGER.info("Registering Mod Item Groups for " + TutorialMod.MOD_ID);
    }
}
