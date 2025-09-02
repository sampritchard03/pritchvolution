package com.pritchvolution.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.pritchvolution.client.model.Modelpritchanimal;
import com.pritchvolution.entity.PritchanimalEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;

public class PritchanimalRenderer extends MobRenderer<PritchanimalEntity, Modelpritchanimal<PritchanimalEntity>> {
    public PritchanimalRenderer(EntityRendererProvider.Context context) {
        super(context, new AnimatedModel(context.bakeLayer(Modelpritchanimal.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public void render(PritchanimalEntity p_115308_, float p_115309_, float p_115310_, PoseStack p_115311_, MultiBufferSource p_115312_, int p_115313_) {
        if (net.neoforged.neoforge.common.NeoForge.EVENT_BUS.post(new net.neoforged.neoforge.client.event.RenderLivingEvent.Pre<PritchanimalEntity, Modelpritchanimal<PritchanimalEntity>>(p_115308_, this, p_115310_, p_115311_, p_115312_, p_115313_)).isCanceled())
            return;
        p_115311_.pushPose();
        this.model.attackTime = this.getAttackAnim(p_115308_, p_115310_);
        boolean shouldSit = p_115308_.isPassenger() && (p_115308_.getVehicle() != null && p_115308_.getVehicle().shouldRiderSit());
        this.model.riding = shouldSit;
        this.model.young = p_115308_.isBaby();
        float f = Mth.rotLerp(p_115310_, p_115308_.yBodyRotO, p_115308_.yBodyRot);
        float f1 = Mth.rotLerp(p_115310_, p_115308_.yHeadRotO, p_115308_.yHeadRot);
        float f2 = f1 - f;
        if (shouldSit && p_115308_.getVehicle() instanceof LivingEntity livingentity) {
            f = Mth.rotLerp(p_115310_, livingentity.yBodyRotO, livingentity.yBodyRot);
            f2 = f1 - f;
            float f7 = Mth.wrapDegrees(f2);
            if (f7 < -85.0F) {
                f7 = -85.0F;
            }
            if (f7 >= 85.0F) {
                f7 = 85.0F;
            }
            f = f1 - f7;
            if (f7 * f7 > 2500.0F) {
                f += f7 * 0.2F;
            }
            f2 = f1 - f;
        }
        float f6 = Mth.lerp(p_115310_, p_115308_.xRotO, p_115308_.getXRot());
        if (isEntityUpsideDown(p_115308_)) {
            f6 *= -1.0F;
            f2 *= -1.0F;
        }
        f2 = Mth.wrapDegrees(f2);
        if (p_115308_.hasPose(Pose.SLEEPING)) {
            Direction direction = p_115308_.getBedOrientation();
            if (direction != null) {
                float f3 = p_115308_.getEyeHeight(Pose.STANDING) - 0.1F;
                p_115311_.translate((float) (-direction.getStepX()) * f3, 0.0F, (float) (-direction.getStepZ()) * f3);
            }
        }
        float f8 = p_115308_.getScale();
        p_115311_.scale(f8, f8, f8);
        float f9 = this.getBob(p_115308_, p_115310_);
        this.setupRotations(p_115308_, p_115311_, f9, f, p_115310_, f8);
        p_115311_.scale(-1.0F, -1.0F, 1.0F);
        this.scale(p_115308_, p_115311_, p_115310_);
        p_115311_.translate(0.0F, -1.501F, 0.0F);
        float f4 = 0.0F;
        float f5 = 0.0F;
        if (!shouldSit && p_115308_.isAlive()) {
            f4 = p_115308_.walkAnimation.speed(p_115310_);
            f5 = p_115308_.walkAnimation.position(p_115310_);
            if (p_115308_.isBaby()) {
                f5 *= 3.0F;
            }
            if (f4 > 1.0F) {
                f4 = 1.0F;
            }
        }
        this.model.prepareMobModel(p_115308_, f5, f4, p_115310_);
        this.model.setupAnim(p_115308_, f5, f4, f9, f2, f6);
        Minecraft minecraft = Minecraft.getInstance();
        boolean flag = this.isBodyVisible(p_115308_);
        boolean flag1 = !flag && !p_115308_.isInvisibleTo(minecraft.player);
        boolean flag2 = minecraft.shouldEntityAppearGlowing(p_115308_);
        RenderType rendertype = this.getRenderType(p_115308_, flag, flag1, flag2);
        if (rendertype != null) {
            VertexConsumer vertexconsumer = p_115312_.getBuffer(rendertype);
            int i = getOverlayCoords(p_115308_, this.getWhiteOverlayProgress(p_115308_, p_115310_));
            this.model.renderToBuffer(p_115311_, vertexconsumer, p_115313_, i, hsbToInt(p_115308_.getEntityData().get(PritchanimalEntity.DATA_hue), p_115308_.getEntityData().get(PritchanimalEntity.DATA_saturation), p_115308_.getEntityData().get(PritchanimalEntity.DATA_brightness)));
        }
        if (!p_115308_.isSpectator()) {
            for (RenderLayer<PritchanimalEntity, Modelpritchanimal<PritchanimalEntity>> renderlayer : this.layers) {
                renderlayer.render(p_115311_, p_115312_, p_115313_, p_115308_, f5, f4, p_115310_, f9, f2, f6);
            }
        }
        p_115311_.popPose();
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.post(new net.neoforged.neoforge.client.event.RenderLivingEvent.Post<PritchanimalEntity, Modelpritchanimal<PritchanimalEntity>>(p_115308_, this, p_115310_, p_115311_, p_115312_, p_115313_));
    }
    public static int hsbToInt(int hue, int saturation, int brightness) {
        // Clamp values to 0–255
        hue = Math.max(0, Math.min(255, hue));
        saturation = Math.max(0, Math.min(255, saturation));
        brightness = Math.max(0, Math.min(255, brightness));

        // Convert to floats for HSBtoRGB (range 0.0–1.0)
        float h = hue / 255f;
        float s = saturation / 255f;
        float b = brightness / 255f;

        // java.awt.Color.HSBtoRGB returns 0xFFRRGGBB (includes alpha = 255)
        int rgb = java.awt.Color.HSBtoRGB(h, s, b);

        // Strip alpha (if you only want 0xRRGGBB)
        return rgb & 0xFFFFFF;
    }


    @Override
    protected void scale(PritchanimalEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(entity.getScale(), entity.getScale(), entity.getScale());
    }

    @Override
    public ResourceLocation getTextureLocation(PritchanimalEntity entity) {
        return ResourceLocation.parse("pritchvolution:textures/entities/" + entity.getEntityData().get(PritchanimalEntity.DATA_skin) + ".png");
    }

    private static final class AnimatedModel extends Modelpritchanimal<PritchanimalEntity> {
        private final ModelPart root;
        private final HierarchicalModel animator = new HierarchicalModel<PritchanimalEntity>() {
            @Override
            public ModelPart root() {
                return root;
            }

            @Override
            public void setupAnim(PritchanimalEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                this.root().getAllParts().forEach(ModelPart::resetPose);


                //Head offset
                float scaleHeadX = 0.0F;
                float scaleHeadY = 0.0F;
                float scaleHeadZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_head_type) != 0) {
                    scaleHeadX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Head_x) / 100;
                    scaleHeadY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Head_y) / 100;
                    scaleHeadZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Head_z) / 100;
                }
                //Nose offset
                float scaleNoseX = 0.0F;
                float scaleNoseY = 0.0F;
                float scaleNoseZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_nose_type) == 1) {
                    scaleNoseX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Nose_x) / 100;
                    scaleNoseY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Nose_y) / 100;
                    scaleNoseZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Nose_z) / 100;
                }
                //Snout offset
                float scaleSnoutX = 0.0F;
                float scaleSnoutZ = 0.0F;
                float rotationSnoutX = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_nose_type) == 2) {
                    scaleSnoutX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Snout_x) / 100;
                    scaleSnoutZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Snout_z) / 100;
                    rotationSnoutX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Snout_x) / 10;
                }
                //Beak offset
                float scaleBeakX = 0.0F;
                float scaleBeakY = 0.0F;
                float scaleBeakZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_nose_type) == 3) {
                    scaleBeakX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Beak_x) / 100;
                    scaleBeakY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Beak_y) / 100;
                    scaleBeakZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Beak_z) / 100;
                }
                //Ear offset
                float scaleEarX = 0.0F;
                float scaleEarY = 0.0F;
                float scaleEarZ = 0.0F;
                float positionEarY = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_ears_type) == 1) {
                    scaleEarX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Ear_x) / 100;
                    scaleEarY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Ear_y) / 100;
                    scaleEarZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Ear_z) / 100;
                    positionEarY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Ear_y) / 100;
                }
                //Bunnyear offset
                float scaleBunnyearX = 0.0F;
                float scaleBunnyearY = 0.0F;
                float scaleBunnyearZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_ears_type) == 2) {
                    scaleBunnyearX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Bunnyear_x) / 100;
                    scaleBunnyearY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Bunnyear_y) / 100;
                    scaleBunnyearZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Bunnyear_z) / 100;
                }
                //Flopear offset
                float scaleFlopearX = 0.0F;
                float scaleFlopearZ = 0.0F;
                float rotationFlopearZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_ears_type) == 3) {
                    scaleFlopearX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Flopear_x) / 100;
                    scaleFlopearZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Flopear_z) / 100;
                    rotationFlopearZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Flopear_z) / 10;
                }
                //Cowhorn offset
                float scaleCowhornX = 0.0F;
                float scaleCowhornY = 0.0F;
                float scaleCowhornZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_horn_type) == 1) {
                    scaleCowhornX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Cowhorn_x) / 100;
                    scaleCowhornY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Cowhorn_y) / 100;
                    scaleCowhornZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Cowhorn_z) / 100;
                }
                //Coldhorn offset
                float scaleColdhornX = 0.0F;
                float scaleColdhornY = 0.0F;
                float scaleColdhornZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_horn_type) == 2) {
                    scaleColdhornX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Coldhorn_x) / 100;
                    scaleColdhornY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Coldhorn_y) / 100;
                    scaleColdhornZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Coldhorn_z) / 100;
                }
                //Warmhorn offset
                float scaleWarmhornX = 0.0F;
                float scaleWarmhornY = 0.0F;
                float scaleWarmhornZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_horn_type) == 3) {
                    scaleWarmhornX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Warmhorn_x) / 100;
                    scaleWarmhornY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Warmhorn_y) / 100;
                    scaleWarmhornZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Warmhorn_z) / 100;
                }
                //Neck offset
                float scaleNeckX = 0.0F;
                float scaleNeckY = 0.0F;
                float scaleNeckZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_neck_type) != 0) {
                    scaleNeckX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Neck_x) / 100;
                    scaleNeckY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Neck_y) / 100;
                    scaleNeckZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Neck_z) / 100;
                }
                //Arm offset
                float positionArmX = 0.0F;
                float scaleArmX = 0.0F;
                float scaleArmY = 0.0F;
                float scaleArmZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_arm_type) == 1) {
                    positionArmX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Arm_x) / 100;
                    scaleArmX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Arm_x) / 100;
                    scaleArmY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Arm_y) / 100;
                    scaleArmZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Arm_z) / 100;
                }
                //Frontleg offset
                float positionFrontlegY = 0.0F;
                float positionFrontlegZ = 0.0F;
                float scaleFrontlegX = 0.0F;
                float scaleFrontlegY = 0.0F;
                float scaleFrontlegZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_arm_type) == 2) {
                    positionFrontlegY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Frontleg_y) / 100;
                    positionFrontlegZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Frontleg_z) / 100;
                    scaleFrontlegX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_x) / 100;
                    scaleFrontlegY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_y) / 100;
                    scaleFrontlegZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_z) / 100;
                }
                //Leg offset
                float scaleLegX = 0.0F;
                float scaleLegY = 0.0F;
                float scaleLegZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_leg_type) == 1) {
                    scaleLegX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_x) / 100;
                    scaleLegY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_y) / 100;
                    scaleLegZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_z) / 100;
                }
                //CLeg offset
                float scaleCLegX = 0.0F;
                float scaleCLegY = 0.0F;
                float scaleCLegZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_leg_type) == 2) {
                    scaleCLegX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_x) / 100;
                    scaleCLegY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_y) / 100;
                    scaleCLegZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_z) / 100;
                }
                //Tail offset
                float scaleTailX = 0.0F;
                float scaleTailY = 0.0F;
                float scaleTailZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_tail_type) == 1) {
                    scaleTailX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Tail_x) / 100;
                    scaleTailY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Tail_y) / 100;
                    scaleTailZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Tail_z) / 100;
                }
                //Dolphintail offset
                float scaleDolphintailX = 0.0F;
                float scaleDolphintailY = 0.0F;
                float scaleDolphintailZ = 0.0F;
                if (entity.getEntityData().get(PritchanimalEntity.DATA_tail_type) == 2) {
                    scaleDolphintailX = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Dolphintail_x) / 100;
                    scaleDolphintailY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Dolphintail_y) / 100;
                    scaleDolphintailZ = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Dolphintail_z) / 100;
                }
                AnimationDefinition armslegstest = AnimationDefinition.Builder.withLength(0.0F).looping()
                        .addAnimation("neck",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec((float) entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Neck_x)/10, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("body",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec((float) entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_flopear",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, rotationFlopearZ), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_flopear",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -rotationFlopearZ), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("snout",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(rotationSnoutX, 0.0F, 0.0F),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_arm",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec((float) entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Arm_x)/10, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_arm",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec((float) entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Arm_x)/10, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_frontleg",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec((float) entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_frontleg",
                                new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                        new Keyframe(0.0F, KeyframeAnimations.degreeVec((float) entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("body",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec((float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Body_x) / 100, (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Body_y) / 100,
                                                        (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Body_z) / 100),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("tail",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleTailX, scaleTailY, scaleTailZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("dolphintail",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleDolphintailX, scaleDolphintailY, scaleDolphintailZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("fishtail",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(0.0F, (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Fishtail_y) / 100, (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Fishtail_z) / 100),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("head_offset",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleHeadX, scaleHeadY, scaleHeadZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("neck",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleNeckX, scaleNeckY, scaleNeckZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("nose",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleNoseX, scaleNoseY, scaleNoseZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("snout", new AnimationChannel(AnimationChannel.Targets.SCALE,
                                new Keyframe(0.0F,
                                        KeyframeAnimations.scaleVec(scaleSnoutX, 1.0F, scaleSnoutZ),

                                        AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("beak",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleBeakX, scaleBeakY, scaleBeakZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_ear",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleEarX, scaleEarY, scaleEarZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_ear",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleEarX, scaleEarY, scaleEarZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_cowhorn",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleCowhornX, scaleCowhornY, scaleCowhornZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_cowhorn",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleCowhornX, scaleCowhornY, scaleCowhornZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_warmhorn",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleWarmhornX, scaleWarmhornY, scaleWarmhornZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_warmhorn",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleWarmhornX, scaleWarmhornY, scaleWarmhornZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_coldhorn",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleColdhornX, scaleColdhornY, scaleColdhornZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_coldhorn",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleColdhornX, scaleColdhornY, scaleColdhornZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_flopear",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleFlopearX, 1.0F, scaleFlopearZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_flopear",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleFlopearX, 1.0F, scaleFlopearZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_bunnyear",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleBunnyearX, scaleBunnyearY, scaleBunnyearZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_bunnyear",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleBunnyearX, scaleBunnyearY, scaleBunnyearZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_arm_offset",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleArmX, scaleArmY, scaleArmZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_arm_offset",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleArmX, scaleArmY, scaleArmZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_frontleg_offset",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleFrontlegX, scaleFrontlegY, scaleFrontlegZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_frontleg_offset",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleFrontlegX, scaleFrontlegY, scaleFrontlegZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_leg",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleLegX, scaleLegY, scaleLegZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_leg",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleLegX, scaleLegY, scaleLegZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_cleg1",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleCLegX, scaleCLegY, scaleCLegZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_cleg1",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleCLegX, scaleCLegY, scaleCLegZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_cleg2",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleCLegX, scaleCLegY, scaleCLegZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_cleg2",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec(scaleCLegX, scaleCLegY, scaleCLegZ),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("root_bone",
                                new AnimationChannel(AnimationChannel.Targets.SCALE,
                                        new Keyframe(0.0F,
                                                KeyframeAnimations.scaleVec((float) entity.getEntityData().get(PritchanimalEntity.DATA_size) / 100, (float) entity.getEntityData().get(PritchanimalEntity.DATA_size) / 100,
                                                        (float) entity.getEntityData().get(PritchanimalEntity.DATA_size) / 100),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("root_bone",
                                new AnimationChannel(AnimationChannel.Targets.POSITION,
                                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Root_y)/100, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("head",
                                new AnimationChannel(AnimationChannel.Targets.POSITION,
                                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Head_y)/100, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Head_z)/100),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("head_offset", new AnimationChannel(AnimationChannel.Targets.POSITION,
                                new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_HeadOffset_y)/100, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_HeadOffset_z)/100),
                                        AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_ear",
                                new AnimationChannel(AnimationChannel.Targets.POSITION,
                                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, positionEarY, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_ear",
                                new AnimationChannel(AnimationChannel.Targets.POSITION,
                                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, positionEarY, 0.0F), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_arm",
                                new AnimationChannel(AnimationChannel.Targets.POSITION,
                                        new Keyframe(0.0F, KeyframeAnimations.posVec(-positionArmX, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Arm_y)/100, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Arm_z)/100),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_arm",
                                new AnimationChannel(AnimationChannel.Targets.POSITION,
                                        new Keyframe(0.0F, KeyframeAnimations.posVec(positionArmX, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Arm_y)/100, (float) entity.getEntityData().get(PritchanimalEntity.DATA_POSITION_Arm_z)/100),
                                                AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("left_frontleg",
                                new AnimationChannel(AnimationChannel.Targets.POSITION,
                                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, positionFrontlegY, positionFrontlegZ), AnimationChannel.Interpolations.LINEAR)))
                        .addAnimation("right_frontleg",
                                new AnimationChannel(AnimationChannel.Targets.POSITION,
                                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, positionFrontlegY, positionFrontlegZ), AnimationChannel.Interpolations.LINEAR)))

                        .build();
                this.animate(entity.animationState0, armslegstest, ageInTicks, 1f);
            }
        };

        public AnimatedModel(ModelPart root) {
            super(root);
            this.root = root;
        }

        @Override
        public void setupAnim(PritchanimalEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        }
    }
}
