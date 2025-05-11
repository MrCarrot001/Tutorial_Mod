package net.pkand.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MushroomBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.pkand.tutorialmod.TutorialMod;

public class ModBlocks {

    public static final Block PINK_MUSHROOM_BLOCK=registerBlock("pink_mushroom_block",
            new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS)
                    .strength(0.2f).sounds(BlockSoundGroup.HONEY)));

    public static final Block PINK_MUSHROOM_STEM=registerBlock("pink_mushroom_stem",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool().instrument(NoteBlockInstrument.BASS)
                    .strength(2f).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block PINK_MUSHROOM_PLANKS=registerBlock("pink_mushroom_planks",
            new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,Identifier.of(TutorialMod.MOD_ID,name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block,new Item.Settings()));
    }


    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->{
            entries.add(PINK_MUSHROOM_PLANKS);
            entries.add(PINK_MUSHROOM_STEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->{
            entries.add(PINK_MUSHROOM_BLOCK);
            entries.add(PINK_MUSHROOM_STEM);
        });
    }
}
