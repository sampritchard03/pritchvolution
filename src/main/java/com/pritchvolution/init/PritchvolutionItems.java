package com.pritchvolution.init;

import com.pritchvolution.Pritchvolution;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PritchvolutionItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(Pritchvolution.MODID);
    public static final DeferredItem<Item> PRITCHANIMAL_SPAWN_EGG = REGISTRY.register("pritchanimal_spawn_egg", () -> new DeferredSpawnEggItem(PritchvolutionEntities.PRITCHANIMAL, -1, -16777216, new Item.Properties()));
    public static final DeferredItem<Item> RANDOM_PRITCHANIMAL_GENERATOR_SPAWN_EGG = REGISTRY.register("random_pritchanimal_generator_spawn_egg",
            () -> new DeferredSpawnEggItem(PritchvolutionEntities.RANDOM_PRITCHANIMAL_GENERATOR, -65383, -16777216, new Item.Properties()));
    public static final DeferredItem<Item> HUMAN_PRITCHANIMAL_GENERATOR_SPAWN_EGG = REGISTRY.register("human_pritchanimal_generator_spawn_egg",
            () -> new DeferredSpawnEggItem(PritchvolutionEntities.HUMAN_PRITCHANIMAL_GENERATOR, -13421569, -16777216, new Item.Properties()));
}
