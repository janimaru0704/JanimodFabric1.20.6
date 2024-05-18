package net.janimaru.janimod.item;

import net.janimaru.janimod.Janimod;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.custom.OreDetectorItem;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));

    public static final Item ORE_DETECTOR = registerItem("ore_detector",
            new OreDetectorItem(new Item.Settings().maxDamage(128)));

    public static final Item HAMBURGER = registerItem("hamburger", new Item(new Item.Settings()
            .food(ModFoodComponents.HAMBURGER)));

    public static final Item MAPLE_SIGN = registerItem("maple_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.MAPLE_SIGN, ModBlocks.MAPLE_WALL_SIGN));
    public static final Item MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign",
            new HangingSignItem(ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN,
                    new Item.Settings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Janimod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Janimod.LOGGER.info("Registering Mod Items for " + Janimod.MOD_ID);
    }
}
