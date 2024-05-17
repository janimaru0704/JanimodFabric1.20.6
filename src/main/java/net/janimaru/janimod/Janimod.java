package net.janimaru.janimod;

import net.fabricmc.api.ModInitializer;

import net.janimaru.janimod.item.ModItemGroups;
import net.janimaru.janimod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Janimod implements ModInitializer {
	public static final String MOD_ID = "janimod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}