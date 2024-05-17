package net.janimaru.janimod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELT_INGREDIENTS = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RUBY,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK,
                getRecipeName(ModBlocks.RUBY_BLOCK), null, getRecipeName(ModItems.RUBY), "ruby");

        offerSmelting(exporter, RUBY_SMELT_INGREDIENTS, RecipeCategory.MISC, ModItems.RUBY,
                1.2f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELT_INGREDIENTS, RecipeCategory.MISC, ModItems.RUBY,
                0.6f, 100, "ruby");

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.HAMBURGER)
                .pattern("B").pattern("C").pattern("B")
                .input('B', Items.BREAD).input('C', Items.COOKED_BEEF)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HAMBURGER)));
    }
}
