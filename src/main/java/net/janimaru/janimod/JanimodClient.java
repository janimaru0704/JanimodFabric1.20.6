package net.janimaru.janimod;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.entity.ModBoats;
import net.janimaru.janimod.item.ModItems;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;

public class JanimodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Janimod.LOGGER.info("Initializing Client for " + Janimod.MOD_ID);
        addItemsToGroups();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());

        TerraformBoatClientHelper.registerModelLayers(ModBoats.MAPLE_BOAT_ID, false);
    }

    private void addItemsToGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.RUBY);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModItems.MAPLE_SIGN);
            entries.add(ModItems.MAPLE_HANGING_SIGN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ModItems.RUBY_SWORD);
            entries.add(ModItems.RUBY_AXE);
            entries.add(ModItems.RUBY_HELMET);
            entries.add(ModItems.RUBY_CHESTPLATE);
            entries.add(ModItems.RUBY_LEGGINGS);
            entries.add(ModItems.RUBY_BOOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModItems.RUBY_SHOVEL);
            entries.add(ModItems.RUBY_PICKAXE);
            entries.add(ModItems.RUBY_AXE);
            entries.add(ModItems.RUBY_HOE);
            entries.add(ModItems.ORE_DETECTOR);
            entries.add(ModItems.MAPLE_BOAT);
            entries.add(ModItems.MAPLE_CHEST_BOAT);
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
            entries.add(ModBlocks.MAPLE_STAIRS);
            entries.add(ModBlocks.MAPLE_SLAB);
            entries.add(ModBlocks.MAPLE_FENCE);
            entries.add(ModBlocks.MAPLE_FENCE_GATE);
            entries.add(ModBlocks.MAPLE_DOOR);
            entries.add(ModBlocks.MAPLE_TRAPDOOR);
            entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);
            entries.add(ModBlocks.MAPLE_BUTTON);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.RUBY_ORE);
            entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
            entries.add(ModBlocks.MAPLE_LOG);
            entries.add(ModBlocks.MAPLE_LEAVES);
        });
    }
}
