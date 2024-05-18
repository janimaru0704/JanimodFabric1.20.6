package net.janimaru.janimod.block;

import net.janimaru.janimod.Janimod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.RED)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 5), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 5), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    public static final Block MAPLE_LOG = registerBlock("maple_log",
            Blocks.createLogBlock(MapColor.ORANGE, MapColor.SPRUCE_BROWN));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            Blocks.createLogBlock(MapColor.ORANGE, MapColor.ORANGE));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.ORANGE)));
    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            Blocks.createLeavesBlock(BlockSoundGroup.GRASS));

    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(DyeColor.ORANGE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Janimod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Janimod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Janimod.LOGGER.info("Registering Mod Blocks for " + Janimod.MOD_ID);
    }
}
