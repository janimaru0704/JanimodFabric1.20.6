package net.janimaru.janimod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.janimaru.janimod.Janimod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JANIMOD_ALL = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Janimod.MOD_ID, "all"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.janimod_all"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries(((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                    })).build());

    public static void registerItemGroups() {
        Janimod.LOGGER.info("Registering Mod Item Groups for " + Janimod.MOD_ID);
    }
}
