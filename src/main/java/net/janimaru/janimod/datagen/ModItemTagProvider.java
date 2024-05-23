package net.janimaru.janimod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.ModItems;
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

        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS).add(ModItems.RUBY);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.RUBY_SWORD);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.RUBY_SHOVEL);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.RUBY_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.RUBY_AXE);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.RUBY_HOE);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.RUBY_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ModItems.RUBY_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ModItems.RUBY_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ModItems.RUBY_BOOTS);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).forceAddTag(ModTags.Items.MAPLE_LOGS);
        getOrCreateTagBuilder(ItemTags.LEAVES).add(ModBlocks.MAPLE_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.MAPLE_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(ModBlocks.MAPLE_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(ModBlocks.MAPLE_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(ModBlocks.MAPLE_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.MAPLE_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.MAPLE_PRESSURE_PLATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(ModBlocks.MAPLE_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.SIGNS).add(ModItems.MAPLE_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(ModItems.MAPLE_HANGING_SIGN);
        getOrCreateTagBuilder(ItemTags.BOATS).add(ModItems.MAPLE_BOAT);
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ModItems.MAPLE_CHEST_BOAT);
    }
}
