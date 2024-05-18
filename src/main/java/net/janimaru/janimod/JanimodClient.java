package net.janimaru.janimod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.ModItems;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;

public class JanimodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Janimod.LOGGER.info("Initializing Client for " + Janimod.MOD_ID);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_LEAVES, RenderLayer.getCutout());
    }

    private void addItemsToGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.RUBY);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModItems.ORE_DETECTOR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModItems.HAMBURGER);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RUBY_BLOCK);
            entries.add(ModBlocks.MAPLE_LOG);
            entries.add(ModBlocks.MAPLE_WOOD);
            entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
            entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
            entries.add(ModBlocks.MAPLE_PLANKS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.RUBY_ORE);
            entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
            entries.add(ModBlocks.MAPLE_LOG);
            entries.add(ModBlocks.MAPLE_LEAVES);
        });
    }
}
