package com.samebutdifferent.morevillagers.datagen;

import com.samebutdifferent.morevillagers.registry.MVBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

import java.util.Set;
import java.util.stream.Stream;

public class MVRecipeProvider extends RecipeProvider {
    public MVRecipeProvider(BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        super(recipes, recipeAdvancements(advancements));
    }

    private static BootstrapContext<Advancement> recipeAdvancements(BootstrapContext<Advancement> context) {
        // Keep existing unlock advancement IDs when recipe builders add a category directory.
        return new BootstrapContext<>() {
            @Override
            public Holder.Reference<Advancement> register(ResourceKey<Advancement> key, Advancement advancement) {
                Identifier id = key.identifier();
                return context.register(ResourceKey.create(Registries.ADVANCEMENT,
                    id.withPath(id.getPath().replace("recipes/decorations/", "recipes/"))), advancement);
            }

            @Override
            public <S> HolderGetter<S> lookup(ResourceKey<? extends Registry<? extends S>> key) {
                return context.lookup(key);
            }

            @Override
            public <S> Stream<Holder.Reference<S>> listContextElements(ResourceKey<? extends Registry<? extends S>> key) {
                return context.listContextElements(key);
            }
        };
    }

    public static MultiRegistryBootstrap create() {
        return new MultiRegistryBootstrap() {
            @Override
            public Set<ResourceKey<? extends Registry<?>>> requestedRegistries() {
                return Set.of(Registries.RECIPE, Registries.ADVANCEMENT);
            }

            @Override
            public void run(BootstrapGetter registries) {
                new MVRecipeProvider(registries.get(Registries.RECIPE), registries.get(Registries.ADVANCEMENT)).buildRecipes();
            }
        };
    }

    @Override
    public void buildRecipes() {
        shapeless(RecipeCategory.DECORATIONS, MVBlocks.OCEANOGRAPHY_TABLE.get())
            .requires(Items.PAPER).requires(Items.STRING).requires(Items.BARREL)
            .unlockedBy("has_barrel", has(Items.BARREL)).save(output);
        shaped(RecipeCategory.DECORATIONS, MVBlocks.WOODWORKING_TABLE.get())
            .pattern("$$").pattern("##").pattern("@@")
            .define('$', ItemTags.LEAVES).define('#', ItemTags.PLANKS).define('@', ItemTags.LOGS)
            .unlockedBy("has_leaves", has(ItemTags.LEAVES)).save(output);
        shaped(RecipeCategory.DECORATIONS, MVBlocks.DECAYED_WORKBENCH.get())
            .pattern("@@").pattern("##").pattern("##")
            .define('@', Items.NETHER_BRICKS).define('#', Items.WARPED_PLANKS)
            .unlockedBy("has_nether_bricks", has(Items.NETHER_BRICKS)).save(output);
        shaped(RecipeCategory.DECORATIONS, MVBlocks.PURPUR_ALTAR.get())
            .pattern("@@").pattern("##").pattern("##")
            .define('@', Items.PURPUR_BLOCK).define('#', Items.END_STONE)
            .unlockedBy("has_end_stone", has(Items.END_STONE)).save(output);
        shaped(RecipeCategory.DECORATIONS, MVBlocks.BLUEPRINT_TABLE.get())
            .pattern("@$").pattern("##").pattern("##")
            .define('@', Items.PAPER).define('$', Items.DYE.blue()).define('#', ItemTags.PLANKS)
            .unlockedBy("has_paper", has(Items.PAPER)).save(output);
        shaped(RecipeCategory.DECORATIONS, MVBlocks.GARDENING_TABLE.get())
            .pattern("@@").pattern("##").pattern("##")
            .define('@', BlockItemTags.FLOWERS.item()).define('#', ItemTags.PLANKS)
            .unlockedBy("has_flower", has(BlockItemTags.FLOWERS.item())).save(output);
        shaped(RecipeCategory.DECORATIONS, MVBlocks.HUNTING_POST.get())
            .pattern("@$").pattern("##")
            .define('@', Items.LEATHER).define('$', Items.ARROW).define('#', ItemTags.LOGS)
            .unlockedBy("has_arrow", has(Items.ARROW)).save(output);
        shaped(RecipeCategory.DECORATIONS, MVBlocks.MINING_BENCH.get())
            .pattern("@$").pattern("##")
            .define('@', Items.IRON_PICKAXE).define('$', Items.RAW_IRON).define('#', Items.STONE)
            .unlockedBy("has_iron_pickaxe", has(Items.IRON_PICKAXE)).save(output);
    }
}
