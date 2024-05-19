package net.janimaru.janimod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

public class ModModelProvider extends FabricModelProvider {
    private static final BlockFamily MAPLE_FAMILY = BlockFamilies.register(ModBlocks.MAPLE_PLANKS)
            .stairs(ModBlocks.MAPLE_STAIRS).slab(ModBlocks.MAPLE_SLAB).fence(ModBlocks.MAPLE_FENCE)
            .fenceGate(ModBlocks.MAPLE_FENCE_GATE).door(ModBlocks.MAPLE_DOOR)
            .trapdoor(ModBlocks.MAPLE_TRAPDOOR).pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE)
            .button(ModBlocks.MAPLE_BUTTON).sign(ModBlocks.MAPLE_SIGN, ModBlocks.MAPLE_WALL_SIGN).build();

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.MAPLE_LOG).log(ModBlocks.MAPLE_LOG).wood(ModBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAPLE_LOG).log(ModBlocks.STRIPPED_MAPLE_LOG).wood(ModBlocks.STRIPPED_MAPLE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAPLE_LEAVES);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS).family(MAPLE_FAMILY);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MAPLE_LOG, ModBlocks.MAPLE_HANGING_SIGN, ModBlocks.MAPLE_WALL_HANGING_SIGN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ORE_DETECTOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HAMBURGER, Models.GENERATED);

        itemModelGenerator.register(ModItems.MAPLE_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAPLE_CHEST_BOAT, Models.GENERATED);
    }
}
