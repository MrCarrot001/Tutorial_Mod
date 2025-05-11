package net.pkand.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pkand.tutorialmod.TutorialMod;
import net.pkand.tutorialmod.item.custom.PoisonedStickItem;

public class ModItems {

    public static final Item FUNGAL_STICK= registerItem("fungal_stick", new Item(new Item.Settings()));
    public static final Item PINK_MUSHROOM= registerItem("pink_mushroom", new Item(new Item.Settings()));
    public static final Item PINK_MUSHROOM_STEW= registerItem("pink_mushroom_stew", new Item(new Item.Settings()));
    public static final Item GRILLED_PINK_MUSHROOM= registerItem("grilled_pink_mushroom", new Item(new Item.Settings()));

    public static final Item POISONED_STICK= registerItem("poisoned_stick",new PoisonedStickItem(new Item.Settings().maxDamage(64)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for "+TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(FUNGAL_STICK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->{
            entries.add(PINK_MUSHROOM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(POISONED_STICK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries ->{
            entries.add(PINK_MUSHROOM_STEW);
            entries.add(GRILLED_PINK_MUSHROOM);
        });
    }
}
