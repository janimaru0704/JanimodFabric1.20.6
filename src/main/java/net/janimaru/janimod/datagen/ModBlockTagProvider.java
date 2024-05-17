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

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RUBY_BLOCK).forceAddTag(ModTags.Blocks.RUBY_ORES);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_BLOCK).forceAddTag(ModTags.Blocks.RUBY_ORES);
    }
}
