package net.janimaru.janimod.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
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
    public static final Identifier MAPLE_SIGN_TEXTURE = new Identifier(Janimod.MOD_ID, "entity/signs/maple");
    public static final Identifier MAPLE_HANGING_SIGN_TEXTURE = new Identifier(Janimod.MOD_ID, "entity/signs/hanging/maple");
    public static final Identifier MAPLE_HANGING_SIGN_GUI_TEXTURE = new Identifier(Janimod.MOD_ID, "textures/gui/hanging_signs/maple");

    public static final BlockSetType MAPLE_SET_TYPE = new BlockSetTypeBuilder()
            .register(new Identifier(Janimod.MOD_ID, "maple"));
    public static final WoodType MAPLE_WOOD_TYPE = new WoodTypeBuilder()
            .register(new Identifier(Janimod.MOD_ID, "maple"), MAPLE_SET_TYPE);

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
    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
            new StairsBlock(MAPLE_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(MAPLE_PLANKS)));
    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.ORANGE)));
    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            new FenceGateBlock(MAPLE_WOOD_TYPE, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.ORANGE)));
    public static final Block MAPLE_DOOR = registerBlock("maple_door",
            new DoorBlock(MAPLE_SET_TYPE, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.ORANGE)));
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            new TrapdoorBlock(MAPLE_SET_TYPE, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.ORANGE)));
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            new PressurePlateBlock(MAPLE_SET_TYPE, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.ORANGE)));
    public static final Block MAPLE_BUTTON = registerBlock("maple_button", Blocks.createWoodenButtonBlock(MAPLE_SET_TYPE));

    public static final Block MAPLE_SIGN = registerBlockWithoutItem("maple_sign",
            new TerraformSignBlock(MAPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(MapColor.ORANGE)));
    public static final Block MAPLE_WALL_SIGN = registerBlockWithoutItem("maple_wall_sign",
            new TerraformWallSignBlock(MAPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                    .mapColor(MapColor.ORANGE).dropsLike(ModBlocks.MAPLE_SIGN)));
    public static final Block MAPLE_HANGING_SIGN = registerBlockWithoutItem("maple_hanging_sign",
            new TerraformHangingSignBlock(MAPLE_HANGING_SIGN_TEXTURE, MAPLE_HANGING_SIGN_GUI_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(MAPLE_LOG.getDefaultMapColor())));
    public static final Block MAPLE_WALL_HANGING_SIGN = registerBlockWithoutItem("maple_wall_hanging_sign",
            new TerraformWallHangingSignBlock(MAPLE_HANGING_SIGN_TEXTURE, MAPLE_HANGING_SIGN_GUI_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                            .mapColor(MAPLE_LOG.getDefaultMapColor()).dropsLike(ModBlocks.MAPLE_HANGING_SIGN)));

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Janimod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return registerBlockWithoutItem(name, block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Janimod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Janimod.LOGGER.info("Registering Mod Blocks for " + Janimod.MOD_ID);
    }
}
