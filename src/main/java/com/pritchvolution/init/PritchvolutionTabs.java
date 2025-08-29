package com.pritchvolution.init;

import com.pritchvolution.Pritchvolution;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PritchvolutionTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Pritchvolution.MODID);

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            tabData.accept(PritchvolutionItems.PRITCHANIMAL_SPAWN_EGG.get());
            tabData.accept(PritchvolutionItems.RANDOM_PRITCHANIMAL_GENERATOR_SPAWN_EGG.get());
            tabData.accept(PritchvolutionItems.HUMAN_PRITCHANIMAL_GENERATOR_SPAWN_EGG.get());
        }
    }
}
