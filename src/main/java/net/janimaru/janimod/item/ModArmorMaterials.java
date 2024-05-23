package net.janimaru.janimod.item;

import net.janimaru.janimod.Janimod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> RUBY = register("ruby", new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 5);
        map.put(ArmorItem.Type.LEGGINGS, 9);
        map.put(ArmorItem.Type.CHESTPLATE, 12);
        map.put(ArmorItem.Type.HELMET, 5);
        map.put(ArmorItem.Type.BODY, 17);
    }), 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.RUBY),
            List.of(new ArmorMaterial.Layer(new Identifier(Janimod.MOD_ID, "ruby"))), 4.5f, 0.2f));

    private static RegistryEntry<ArmorMaterial> register(String name, ArmorMaterial material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, new Identifier(Janimod.MOD_ID, name), material);
    }

    public static void registerModArmorMaterials() {
        Janimod.LOGGER.info("Registering Mod Armor Materials for " + Janimod.MOD_ID);
    }
}
