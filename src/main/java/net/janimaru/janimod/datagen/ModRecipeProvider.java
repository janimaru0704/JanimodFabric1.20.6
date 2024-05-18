package net.janimaru.janimod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.janimaru.janimod.block.ModBlocks;
import net.janimaru.janimod.item.ModItems;
import net.janimaru.janimod.util.ModTags;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_WOOD)
                .pattern("XX").pattern("XX")
                .input('X', ModBlocks.MAPLE_LOG)
                .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MAPLE_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MAPLE_WOOD)
                .pattern("XX").pattern("XX")
                .input('X', ModBlocks.STRIPPED_MAPLE_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_MAPLE_LOG), conditionsFromItem(ModBlocks.STRIPPED_MAPLE_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STRIPPED_MAPLE_WOOD)));

        offerPlanksRecipe(exporter, ModBlocks.MAPLE_PLANKS, ModTags.Items.MAPLE_LOGS, 4);
        createStairsRecipe(ModBlocks.MAPLE_STAIRS, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                .criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_stairs").offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                .criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_slab").offerTo(exporter);
        createFenceRecipe(ModBlocks.MAPLE_FENCE, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                .criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_fence").offerTo(exporter);
        createFenceGateRecipe(ModBlocks.MAPLE_FENCE_GATE, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                .criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_fence_gate").offerTo(exporter);
        createDoorRecipe(ModBlocks.MAPLE_DOOR, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                .criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_door").offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.MAPLE_TRAPDOOR, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                .criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_trapdoor").offerTo(exporter);
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.MAPLE_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.MAPLE_PLANKS))
                .criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_pressure_plate").offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MAPLE_BUTTON)
                .input(ModBlocks.MAPLE_PLANKS, 1).criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_button").offerTo(exporter);
        createSignRecipe(ModBlocks.MAPLE_SIGN, Ingredient.ofItems(ModBlocks.MAPLE_BUTTON))
                .criterion("has_planks", conditionsFromItem(ModBlocks.MAPLE_PLANKS))
                .group("wooden_sign").offerTo(exporter);
        offerHangingSignRecipe(exporter, ModItems.MAPLE_HANGING_SIGN, ModBlocks.STRIPPED_MAPLE_LOG);
    }
}
