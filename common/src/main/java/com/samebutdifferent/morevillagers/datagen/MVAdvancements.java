package com.samebutdifferent.morevillagers.datagen;

import com.samebutdifferent.morevillagers.registry.MVBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.predicates.NbtPredicate;
import net.minecraft.advancements.predicates.entity.EntityFlagsPredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.predicates.entity.PlayerPredicate;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.KilledTrigger;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.advancements.triggers.TameAnimalTrigger;
import net.minecraft.advancements.triggers.TradeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MVAdvancements {
    private final BootstrapContext<Advancement> output;
    private final Map<String, AdvancementHolder> advancements = new HashMap<>();
    private final HolderGetter<Item> items;
    private final HolderGetter<EntityType<?>> entities;
    private final HolderGetter<Structure> structures;
    private static final List<String> VILLAGES = List.of("plains", "desert", "savanna", "snowy", "taiga");

    private MVAdvancements(BootstrapContext<Advancement> output) {
        this.output = output;
        items = output.lookup(Registries.ITEM);
        entities = output.lookup(Registries.ENTITY_TYPE);
        structures = output.lookup(Registries.STRUCTURE);
    }

    public static void bootstrap(BootstrapContext<Advancement> output) {
        new MVAdvancements(output).generate();
    }

    private void generate() {
        save("root", Advancement.Builder.recipeAdvancement()
            .rootDisplay(Items.EMERALD_BLOCK, title("root"), description("root"),
                Identifier.withDefaultNamespace("block/lime_terracotta"), AdvancementType.TASK, false, false, false)
            .addCriterion("always", PlayerTrigger.TriggerInstance.tick()));
        save("first_trade", display("first_trade", "root", Items.EMERALD, false, false, 20)
            .addCriterion("villagertrade", TradeTrigger.TriggerInstance.tradedWithVillager()));
        CompoundTag master = new CompoundTag();
        master.putInt("level", 5);
        save("master_trade", display("master_trade", "first_trade", Items.DIAMOND, false, false, 50)
            .addCriterion("villagertrade", trade(villager(master), false)));
        save("buy_map", display("buy_map", "first_trade", Items.COMPASS, false, false, 50)
            .addCriterion("trade", trade(null, true)));
        dimensionTrade("nether_trade", "netherian", Items.NETHERRACK, Level.NETHER);
        dimensionTrade("end_trade", "enderian", Items.END_STONE, Level.END);
        map("map_bastion", "nether_trade", "netherian", Items.POLISHED_BLACKSTONE_BRICKS, "bastion", BuiltinStructures.BASTION_REMNANT);
        map("map_endcity", "end_trade", "enderian", Items.PURPUR_BLOCK, "end_city", BuiltinStructures.END_CITY);

        Advancement.Builder professions = display("all_professions_traded", "first_trade", Items.EXPERIENCE_BOTTLE, true, false, 200);
        for (String profession : List.of("armorer", "butcher", "cartographer", "cleric", "farmer", "fisherman",
            "fletcher", "leatherworker", "librarian", "mason", "shepherd", "toolsmith", "weaponsmith")) {
            professions.addCriterion(profession, trade(profession("minecraft:" + profession), false));
        }
        for (String profession : List.of("oceanographer", "netherian", "woodworker", "enderian", "engineer", "florist", "hunter", "miner")) {
            professions.addCriterion(profession, trade(profession("morevillagers:" + profession), false));
        }
        save("all_professions_traded", professions);

        workstations("first_workstation_get", "root", Items.STONECUTTER, false);
        workstations("all_workstations_get", "first_workstation_get", Items.SMITHING_TABLE, true);
        villages("first_village", "root", Items.MAP, false, 25);
        villages("all_villages", "first_village", Items.FILLED_MAP, true, 200);
        Advancement.Builder cats = display("tame_cat", "first_village", Items.COD, false, false, 20)
            .requirements(AdvancementRequirements.Strategy.OR);
        for (String village : VILLAGES) {
            cats.addCriterion(village, TameAnimalTrigger.TriggerInstance.tamedAnimal(EntityPredicate.Builder.entity()
                .of(entities, EntityTypes.CAT).located(village(village))));
        }
        save("tame_cat", cats);
        save("kill_villager", display("kill_villager", "root", Items.IRON_SWORD, false, true, 5)
            .addCriterion("killedvillager", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entities, EntityTypes.VILLAGER))));
        save("kill_babyvillager", display("kill_babyvillager", "kill_villager", Items.IRON_AXE, false, true, 10)
            .addCriterion("killedbabyvillager", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity()
                .of(entities, EntityTypes.VILLAGER).flags(EntityFlagsPredicate.Builder.flags().setIsBaby(true)))));
    }

    private void villages(String name, String parent, Item icon, boolean all, int experience) {
        Advancement.Builder advancement = display(name, parent, icon, all, false, experience);
        if (!all) advancement.requirements(AdvancementRequirements.Strategy.OR);
        for (String village : VILLAGES) advancement.addCriterion(village, PlayerTrigger.TriggerInstance.located(village(village)));
        save(name, advancement);
    }

    private LocationPredicate.Builder village(String type) {
        return LocationPredicate.Builder.inStructure(structures.getOrThrow(ResourceKey.create(Registries.STRUCTURE,
            Identifier.withDefaultNamespace("village_" + type))));
    }

    private void workstations(String name, String parent, Item icon, boolean all) {
        Advancement.Builder advancement = display(name, parent, icon, all, false, all ? 200 : 0);
        if (!all) advancement.requirements(AdvancementRequirements.Strategy.OR);
        for (Item item : List.of(Items.BLAST_FURNACE, Items.SMOKER, Items.CARTOGRAPHY_TABLE, Items.BREWING_STAND,
            Items.COMPOSTER, Items.BARREL, Items.FLETCHING_TABLE, Items.CAULDRON, Items.LECTERN, Items.STONECUTTER,
            Items.LOOM, Items.SMITHING_TABLE, Items.GRINDSTONE, MVBlocks.OCEANOGRAPHY_TABLE.get().asItem(),
            MVBlocks.DECAYED_WORKBENCH.get().asItem(), MVBlocks.WOODWORKING_TABLE.get().asItem(),
            MVBlocks.PURPUR_ALTAR.get().asItem(), MVBlocks.BLUEPRINT_TABLE.get().asItem(),
            MVBlocks.GARDENING_TABLE.get().asItem(), MVBlocks.HUNTING_POST.get().asItem(), MVBlocks.MINING_BENCH.get().asItem())) {
            advancement.addCriterion(BuiltInRegistries.ITEM.getKey(item).getPath().replace("_", ""),
                InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, item)));
        }
        save(name, advancement);
    }

    private void dimensionTrade(String name, String profession, Item icon, ResourceKey<Level> dimension) {
        save(name, display(name, "first_trade", icon, false, false, 100).addCriterion(profession,
            trade(profession("morevillagers:" + profession).located(LocationPredicate.Builder.inDimension(dimension)), false)));
    }

    private void map(String name, String parent, String profession, Item icon, String criterion, ResourceKey<Structure> structure) {
        save(name, display(name, parent, icon, true, false, 200)
            .addCriterion("has_map", trade(profession("morevillagers:" + profession), true))
            .addCriterion(criterion, PlayerTrigger.TriggerInstance.located(EntityPredicate.Builder.entity()
                .located(LocationPredicate.Builder.inStructure(structures.getOrThrow(structure)))
                .player(PlayerPredicate.Builder.player().checkAdvancementCriterions(id(name), Map.of("has_map", true)).build()))));
    }

    private EntityPredicate.Builder profession(String profession) {
        CompoundTag data = new CompoundTag();
        data.putString("profession", profession);
        return villager(data);
    }

    private EntityPredicate.Builder villager(CompoundTag data) {
        CompoundTag nbt = new CompoundTag();
        nbt.put("VillagerData", data);
        return EntityPredicate.Builder.entity().of(entities, EntityTypes.VILLAGER).nbt(new NbtPredicate(nbt));
    }

    private Criterion<TradeTrigger.TriggerInstance> trade(EntityPredicate.Builder villager, boolean map) {
        return CriteriaTriggers.TRADE.createCriterion(new TradeTrigger.TriggerInstance(Optional.empty(),
            villager == null ? Optional.empty() : Optional.of(EntityPredicate.wrap(villager)),
            map ? Optional.of(ItemPredicate.Builder.item().of(items, Items.FILLED_MAP).build()) : Optional.empty()));
    }

    private Advancement.Builder display(String name, String parent, Item icon, boolean goal, boolean hidden, int experience) {
        Advancement.Builder builder = Advancement.Builder.recipeAdvancement().parent(advancements.get(parent))
            .display(icon, title(name), description(name), goal ? AdvancementType.GOAL : AdvancementType.TASK, true, true, hidden);
        if (experience > 0) builder.rewards(AdvancementRewards.Builder.experience(experience));
        return builder;
    }

    private void save(String name, Advancement.Builder advancement) {
        advancements.put(name, advancement.save(output, id(name).toString()));
    }

    private static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath("morevillagers", path);
    }

    private static Component title(String name) {
        return Component.translatable("advancements." + name + ".title");
    }

    private static Component description(String name) {
        return Component.translatable("advancements." + name + ".description");
    }
}
