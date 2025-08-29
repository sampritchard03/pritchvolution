package com.pritchvolution.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Modelpritchanimal<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("pritchvolution", "modelpritchanimal"), "main");
    public final ModelPart root_bone;
    public final ModelPart right_arm;
    public final ModelPart right_arm_offset;
    public final ModelPart left_arm;
    public final ModelPart left_arm_offset;
    public final ModelPart head;
    public final ModelPart head_offset;
    public final ModelPart left_coldhorn;
    public final ModelPart right_coldhorn;
    public final ModelPart left_warmhorn;
    public final ModelPart right_warmhorn;
    public final ModelPart left_cowhorn;
    public final ModelPart right_cowhorn;
    public final ModelPart left_ear;
    public final ModelPart right_ear;
    public final ModelPart left_bunnyear;
    public final ModelPart right_bunnyear;
    public final ModelPart snout;
    public final ModelPart nose;
    public final ModelPart beak;
    public final ModelPart left_flopear;
    public final ModelPart right_flopear;
    public final ModelPart neck;
    public final ModelPart body;
    public final ModelPart left_frontleg;
    public final ModelPart left_frontleg_offset;
    public final ModelPart right_frontleg;
    public final ModelPart right_frontleg_offset;
    public final ModelPart left_leg;
    public final ModelPart right_leg;
    public final ModelPart left_cleg1;
    public final ModelPart right_cleg1;
    public final ModelPart left_cleg2;
    public final ModelPart right_cleg2;
    public final ModelPart tail;
    public final ModelPart dolphintail;

    public Modelpritchanimal(ModelPart root) {
        this.root_bone = root.getChild("root_bone");
        this.right_arm = this.root_bone.getChild("right_arm");
        this.right_arm_offset = this.right_arm.getChild("right_arm_offset");
        this.left_arm = this.root_bone.getChild("left_arm");
        this.left_arm_offset = this.left_arm.getChild("left_arm_offset");
        this.head = this.root_bone.getChild("head");
        this.head_offset = this.head.getChild("head_offset");
        this.left_coldhorn = this.head_offset.getChild("left_coldhorn");
        this.right_coldhorn = this.head_offset.getChild("right_coldhorn");
        this.left_warmhorn = this.head_offset.getChild("left_warmhorn");
        this.right_warmhorn = this.head_offset.getChild("right_warmhorn");
        this.left_cowhorn = this.head_offset.getChild("left_cowhorn");
        this.right_cowhorn = this.head_offset.getChild("right_cowhorn");
        this.left_ear = this.head_offset.getChild("left_ear");
        this.right_ear = this.head_offset.getChild("right_ear");
        this.left_bunnyear = this.head_offset.getChild("left_bunnyear");
        this.right_bunnyear = this.head_offset.getChild("right_bunnyear");
        this.snout = this.head_offset.getChild("snout");
        this.nose = this.head_offset.getChild("nose");
        this.beak = this.nose.getChild("beak");
        this.left_flopear = this.head_offset.getChild("left_flopear");
        this.right_flopear = this.head_offset.getChild("right_flopear");
        this.neck = this.head.getChild("neck");
        this.body = this.root_bone.getChild("body");
        this.left_frontleg = this.root_bone.getChild("left_frontleg");
        this.left_frontleg_offset = this.left_frontleg.getChild("left_frontleg_offset");
        this.right_frontleg = this.root_bone.getChild("right_frontleg");
        this.right_frontleg_offset = this.right_frontleg.getChild("right_frontleg_offset");
        this.left_leg = this.root_bone.getChild("left_leg");
        this.right_leg = this.root_bone.getChild("right_leg");
        this.left_cleg1 = this.root_bone.getChild("left_cleg1");
        this.right_cleg1 = this.root_bone.getChild("right_cleg1");
        this.left_cleg2 = this.root_bone.getChild("left_cleg2");
        this.right_cleg2 = this.root_bone.getChild("right_cleg2");
        this.tail = this.root_bone.getChild("tail");
        this.dolphintail = this.root_bone.getChild("dolphintail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root_bone = partdefinition.addOrReplaceChild("root_bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition right_arm = root_bone.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, -22.0F, 0.0F));
        PartDefinition right_arm_offset = right_arm.addOrReplaceChild("right_arm_offset", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition left_arm = root_bone.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, -22.0F, 0.0F));
        PartDefinition left_arm_offset = left_arm.addOrReplaceChild("left_arm_offset", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head = root_bone.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));
        PartDefinition head_offset = head.addOrReplaceChild("head_offset", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition left_coldhorn = head_offset.addOrReplaceChild("left_coldhorn", CubeListBuilder.create(), PartPose.offset(4.0F, -7.0F, -3.0F));
        PartDefinition head_r1 = left_coldhorn.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(25, 0).addBox(-1.0F, -1.0F, 0.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        PartDefinition right_coldhorn = head_offset.addOrReplaceChild("right_coldhorn", CubeListBuilder.create(), PartPose.offset(-4.0F, -7.0F, -3.0F));
        PartDefinition head_r2 = right_coldhorn.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(25, 0).addBox(0.0F, -4.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, 3.0F, 1.0F, 0.0F, 1.5708F, 0.0F));
        PartDefinition left_warmhorn = head_offset.addOrReplaceChild("left_warmhorn",
                CubeListBuilder.create().texOffs(29, 0).addBox(0.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 0).addBox(2.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0F, -7.0F, -2.0F));
        PartDefinition right_warmhorn = head_offset.addOrReplaceChild("right_warmhorn", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(-4.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(32, 0).mirror()
                .addBox(-4.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -7.0F, -2.0F));
        PartDefinition left_cowhorn = head_offset.addOrReplaceChild("left_cowhorn", CubeListBuilder.create().texOffs(41, 0).addBox(0.0F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -7.0F, -2.5F));
        PartDefinition right_cowhorn = head_offset.addOrReplaceChild("right_cowhorn", CubeListBuilder.create().texOffs(41, 0).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -7.0F, -2.5F));
        PartDefinition left_ear = head_offset.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(32, 8).addBox(-1.0F, -4.0F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -7.0F, 0.5F));
        PartDefinition right_ear = head_offset.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(32, 8).mirror().addBox(-4.0F, -4.0F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offsetAndRotation(-4.0F, -7.0F, 0.5F, 0.1309F, 0.0F, 0.0F));
        PartDefinition left_bunnyear = head_offset.addOrReplaceChild("left_bunnyear", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -9.0F, -0.5F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -8.0F, 0.5F));
        PartDefinition right_bunnyear = head_offset.addOrReplaceChild("right_bunnyear", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-1.5F, -9.0F, -0.5F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offset(2.5F, -8.0F, 0.5F));
        PartDefinition snout = head_offset.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(45, 0).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, -4.0F));
        PartDefinition nose = head_offset.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(44, 5).mirror().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, -4.0F));
        PartDefinition beak = nose.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(32, 4).mirror().addBox(-4.0F, -2.0F, -1.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 1.0F, -0.5F));
        PartDefinition left_flopear = head_offset.addOrReplaceChild("left_flopear", CubeListBuilder.create().texOffs(32, 8).addBox(0.0F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0F, -7.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition right_flopear = head_offset.addOrReplaceChild("right_flopear", CubeListBuilder.create().texOffs(32, 8).mirror().addBox(-5.0F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offsetAndRotation(-4.0F, -7.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(32, 45).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body = root_bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));
        PartDefinition left_frontleg = root_bone.addOrReplaceChild("left_frontleg", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -22.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
        PartDefinition left_frontleg_offset = left_frontleg.addOrReplaceChild("left_frontleg_offset", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition right_frontleg = root_bone.addOrReplaceChild("right_frontleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -22.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
        PartDefinition right_frontleg_offset = right_frontleg.addOrReplaceChild("right_frontleg_offset", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition left_leg = root_bone.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));
        PartDefinition right_leg = root_bone.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));
        PartDefinition left_cleg1 = root_bone.addOrReplaceChild("left_cleg1", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, -2.0F));
        PartDefinition right_cleg1 = root_bone.addOrReplaceChild("right_cleg1", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, -2.0F));
        PartDefinition left_cleg2 = root_bone.addOrReplaceChild("left_cleg2", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 2.0F));
        PartDefinition right_cleg2 = root_bone.addOrReplaceChild("right_cleg2", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 2.0F));
        PartDefinition tail = root_bone.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 2.0F));
        PartDefinition left_leg_r1 = tail.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(8, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition dolphintail = root_bone.addOrReplaceChild("dolphintail", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));
        PartDefinition left_leg_r2 = dolphintail.addOrReplaceChild("left_leg_r2", CubeListBuilder.create().texOffs(6, 32).addBox(-2.0F, 3.0F, 0.0F, 1.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(1.5F, 5.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition left_leg_r3 = dolphintail.addOrReplaceChild("left_leg_r3", CubeListBuilder.create().texOffs(28, 32).addBox(-2.75F, -3.0F, -2.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5708F, 0.0F, -1.5708F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
        root_bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.right_arm_offset.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_cleg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_cleg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.tail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.dolphintail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.right_cleg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.right_cleg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.right_frontleg_offset.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm_offset.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.head_offset.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head_offset.xRot = headPitch / (180F / (float) Math.PI);
        this.left_frontleg_offset.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}
