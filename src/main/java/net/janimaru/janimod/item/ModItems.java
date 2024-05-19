package net.janimaru.janimod.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.janimaru.janimod.Janimod;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.entity.ModBoats;
import net.janimaru.janimod.item.custom.OreDetectorItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                    ModToolMaterials.RUBY, 3, -2.4f
            )).rarity(Rarity.RARE)));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
                    ModToolMaterials.RUBY, 1.5f, -3.0f
            )).rarity(Rarity.RARE)));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
                    ModToolMaterials.RUBY, 1.0f, -2.8f
            )).rarity(Rarity.RARE)));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
                    ModToolMaterials.RUBY, 5.0f, -3.0f
            )).rarity(Rarity.RARE)));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterials.RUBY,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(
                    ModToolMaterials.RUBY, -8.0f, 1.0f
            )).rarity(Rarity.RARE)));

    public static final Item ORE_DETECTOR = registerItem("ore_detector",
            new OreDetectorItem(new Item.Settings().maxDamage(128)));

    public static final Item HAMBURGER = registerItem("hamburger", new Item(new Item.Settings()
            .food(ModFoodComponents.HAMBURGER)));

    public static final Item MAPLE_SIGN = registerItem("maple_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.MAPLE_SIGN, ModBlocks.MAPLE_WALL_SIGN));
    public static final Item MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign",
            new HangingSignItem(ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN,
                    new Item.Settings().maxCount(16)));

    public static final Item MAPLE_BOAT = TerraformBoatItemHelper
            .registerBoatItem(new Identifier(Janimod.MOD_ID, "maple_boat"), ModBoats.MAPLE_BOAT_KEY, false);
    public static final Item MAPLE_CHEST_BOAT = TerraformBoatItemHelper
            .registerBoatItem(new Identifier(Janimod.MOD_ID, "maple_chest_boat"), ModBoats.MAPLE_BOAT_KEY, true);

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Janimod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Janimod.LOGGER.info("Registering Mod Items for " + Janimod.MOD_ID);
    }
}
