package net.janimaru.janimod.mixin;

import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(OrePlacedFeatures.class)
public interface OrePlacedFeaturesMixin {
    @Invoker("modifiersWithCount")
    static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        throw new AssertionError();
    }

    @Invoker("modifiersWithRarity")
    static List<PlacementModifier> modifiersWithRarity(int rarity, PlacementModifier heightModifier) {
        throw new AssertionError();
    }
}
