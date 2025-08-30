package com.pritchvolution.client;

import com.pritchvolution.Pritchvolution;
import com.pritchvolution.client.model.Modelpritchanimal;
import com.pritchvolution.client.renderer.PritchanimalRenderer;
import com.pritchvolution.client.renderer.RandomPritchanimalGeneratorRenderer;
import com.pritchvolution.init.PritchvolutionEntities;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = Pritchvolution.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Pritchvolution.MODID, value = Dist.CLIENT)
public class PritchvolutionClient {
    public PritchvolutionClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        Pritchvolution.LOGGER.info("HELLO FROM CLIENT SETUP");
        Pritchvolution.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PritchvolutionEntities.PRITCHANIMAL.get(), PritchanimalRenderer::new);
        event.registerEntityRenderer(PritchvolutionEntities.RANDOM_PRITCHANIMAL_GENERATOR.get(), RandomPritchanimalGeneratorRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Modelpritchanimal.LAYER_LOCATION, Modelpritchanimal::createBodyLayer);
    }
}
