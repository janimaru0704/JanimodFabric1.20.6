package net.janimaru.janimod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RUBY_ORE, rubyOre(ModBlocks.RUBY_ORE));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, rubyOre(ModBlocks.DEEPSLATE_RUBY_ORE));
    }

    private LootTable.Builder rubyOre(Block drop) {
        return dropsWithSilkTouch(drop, applyExplosionDecay(drop, ItemEntry.builder(ModItems.RUBY)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
