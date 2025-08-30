package com.pritchvolution.client.renderer;

import com.pritchvolution.entity.RandomPritchanimalGeneratorEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class RandomPritchanimalGeneratorRenderer extends HumanoidMobRenderer<RandomPritchanimalGeneratorEntity, HumanoidModel<RandomPritchanimalGeneratorEntity>> {
    public RandomPritchanimalGeneratorRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<RandomPritchanimalGeneratorEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(RandomPritchanimalGeneratorEntity entity) {
        return ResourceLocation.parse("pritchvolution:textures/entities/nothing.png");
    }
}
