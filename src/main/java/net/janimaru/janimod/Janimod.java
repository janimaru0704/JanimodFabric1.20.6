package net.janimaru.janimod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.ModItemGroups;
import net.janimaru.janimod.item.ModItems;
import net.janimaru.janimod.util.ModTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Janimod implements ModInitializer {
	public static final String MOD_ID = "janimod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		StrippableBlockRegistry.register(ModBlocks.MAPLE_LOG, ModBlocks.STRIPPED_MAPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModTags.Blocks.MAPLE_LOGS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_PLANKS, 5, 20);
	}
}