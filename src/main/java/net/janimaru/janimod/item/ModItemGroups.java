package net.janimaru.janimod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.janimaru.janimod.Janimod;
import net.janimaru.janimod.block.ModBlocks;
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
                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.ORE_DETECTOR);
                        entries.add(ModItems.HAMBURGER);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.MAPLE_LOG);
                        entries.add(ModBlocks.MAPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
                        entries.add(ModBlocks.MAPLE_PLANKS);
                        entries.add(ModBlocks.MAPLE_STAIRS);
                        entries.add(ModBlocks.MAPLE_SLAB);
                        entries.add(ModBlocks.MAPLE_FENCE);
                        entries.add(ModBlocks.MAPLE_FENCE_GATE);
                        entries.add(ModBlocks.MAPLE_DOOR);
                        entries.add(ModBlocks.MAPLE_TRAPDOOR);
                        entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);
                        entries.add(ModBlocks.MAPLE_BUTTON);
                        entries.add(ModItems.MAPLE_SIGN);
                        entries.add(ModItems.MAPLE_HANGING_SIGN);
                        entries.add(ModItems.MAPLE_BOAT);
                        entries.add(ModItems.MAPLE_CHEST_BOAT);
                        entries.add(ModBlocks.MAPLE_LEAVES);
                    })).build());

    public static void registerItemGroups() {
        Janimod.LOGGER.info("Registering Mod Item Groups for " + Janimod.MOD_ID);
    }
}
