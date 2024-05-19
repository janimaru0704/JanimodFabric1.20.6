package net.janimaru.janimod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.RUBY_ORES)
                .add(ModBlocks.RUBY_ORE).add(ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.DETECTABLE_ORES)
                .forceAddTag(BlockTags.COAL_ORES).forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES).forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.GOLD_ORES).forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES).forceAddTag(ModTags.Blocks.RUBY_ORES)
                .add(Blocks.NETHER_QUARTZ_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG).add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).forceAddTag(ModTags.Blocks.MAPLE_LOGS);
        getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.MAPLE_LEAVES);

        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.MAPLE_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.MAPLE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.MAPLE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.MAPLE_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.MAPLE_BUTTON);

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(ModBlocks.MAPLE_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(ModBlocks.MAPLE_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.MAPLE_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.MAPLE_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RUBY_BLOCK).forceAddTag(ModTags.Blocks.RUBY_ORES);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_BLOCK).forceAddTag(ModTags.Blocks.RUBY_ORES);
    }
}
