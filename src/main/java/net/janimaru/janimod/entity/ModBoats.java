package net.janimaru.janimod.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.janimaru.janimod.Janimod;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier MAPLE_BOAT_ID = new Identifier(Janimod.MOD_ID, "maple");

    public static final RegistryKey<TerraformBoatType> MAPLE_BOAT_KEY = TerraformBoatTypeRegistry.createKey(MAPLE_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType mapleBoat = new TerraformBoatType.Builder()
                .item(ModItems.MAPLE_BOAT).chestItem(ModItems.MAPLE_CHEST_BOAT)
                .planks(ModBlocks.MAPLE_PLANKS.asItem()).build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, MAPLE_BOAT_KEY, mapleBoat);
    }
}
