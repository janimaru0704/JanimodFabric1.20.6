package net.janimaru.janimod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent HAMBURGER = new FoodComponent.Builder().nutrition(8).saturationModifier(10.8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6000, 1), 0.5f).build();
}
