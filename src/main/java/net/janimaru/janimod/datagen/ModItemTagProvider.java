package net.janimaru.janimod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG.asItem())
                .add(ModBlocks.MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).forceAddTag(ModTags.Items.MAPLE_LOGS);
        getOrCreateTagBuilder(ItemTags.LEAVES).add(ModBlocks.MAPLE_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.MAPLE_PLANKS.asItem());
    }
}
