package com.pritchvolution.entity;

import com.pritchvolution.client.renderer.RandomPritchanimalGeneratorRenderer;
import com.pritchvolution.init.PritchvolutionEntities;
import com.pritchvolution.init.PritchvolutionItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

public class PritchanimalEntity extends Animal {
    public static final EntityDataAccessor<Boolean> DATA_armslegstest = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Arm_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Arm_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Arm_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Leg_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Leg_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Leg_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_ROTATION_Arm_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_ROTATION_Body_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Body_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Body_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Body_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Head_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Head_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Head_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_Head_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_Head_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_Arm_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_Arm_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_nose_type = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_ears_type = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_tail_type = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Nose_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Nose_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Nose_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Snout_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Snout_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Ear_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Ear_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Ear_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Bunnyear_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Bunnyear_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Bunnyear_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_Root_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Beak_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Beak_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Beak_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Tail_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Tail_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Tail_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_size = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Flopear_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Flopear_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_ROTATION_Flopear_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_Ear_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_ROTATION_Snout_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Cowhorn_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Cowhorn_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Cowhorn_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Warmhorn_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Warmhorn_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Warmhorn_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Coldhorn_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Coldhorn_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Coldhorn_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Dolphintail_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Dolphintail_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Dolphintail_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_horn_type = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Fishtail_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Fishtail_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<String> DATA_skin = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Integer> DATA_POSITION_HeadOffset_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Neck_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Neck_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_SCALE_Neck_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_ROTATION_Neck_x = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_HeadOffset_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> DATA_isInitialized = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> DATA_fedTimer = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_roamType = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_hue = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_saturation = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_brightness = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_Frontleg_y = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_POSITION_Frontleg_z = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_arm_type = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_leg_type = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_neck_type = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_head_type = SynchedEntityData.defineId(PritchanimalEntity.class, EntityDataSerializers.INT);
    public final AnimationState animationState0 = new AnimationState();

    public PritchanimalEntity(EntityType<PritchanimalEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
        setPersistenceRequired();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_armslegstest, true);
        builder.define(DATA_SCALE_Arm_x, 100);
        builder.define(DATA_SCALE_Arm_y, 100);
        builder.define(DATA_SCALE_Arm_z, 100);
        builder.define(DATA_SCALE_Leg_x, 100);
        builder.define(DATA_SCALE_Leg_y, 100);
        builder.define(DATA_SCALE_Leg_z, 100);
        builder.define(DATA_ROTATION_Arm_x, 0);
        builder.define(DATA_ROTATION_Body_x, 0);
        builder.define(DATA_SCALE_Body_x, 100);
        builder.define(DATA_SCALE_Body_y, 100);
        builder.define(DATA_SCALE_Body_z, 100);
        builder.define(DATA_SCALE_Head_x, 100);
        builder.define(DATA_SCALE_Head_y, 100);
        builder.define(DATA_SCALE_Head_z, 100);
        builder.define(DATA_POSITION_Head_y, 0);
        builder.define(DATA_POSITION_Head_z, 0);
        builder.define(DATA_POSITION_Arm_y, 0);
        builder.define(DATA_POSITION_Arm_z, 0);
        builder.define(DATA_nose_type, 0);
        builder.define(DATA_ears_type, 0);
        builder.define(DATA_tail_type, 0);
        builder.define(DATA_SCALE_Nose_x, 0);
        builder.define(DATA_SCALE_Nose_y, 0);
        builder.define(DATA_SCALE_Nose_z, 0);
        builder.define(DATA_SCALE_Snout_x, 0);
        builder.define(DATA_SCALE_Snout_z, 0);
        builder.define(DATA_SCALE_Ear_x, 0);
        builder.define(DATA_SCALE_Ear_y, 0);
        builder.define(DATA_SCALE_Ear_z, 0);
        builder.define(DATA_SCALE_Bunnyear_x, 0);
        builder.define(DATA_SCALE_Bunnyear_y, 0);
        builder.define(DATA_SCALE_Bunnyear_z, 0);
        builder.define(DATA_POSITION_Root_y, 0);
        builder.define(DATA_SCALE_Beak_x, 0);
        builder.define(DATA_SCALE_Beak_y, 0);
        builder.define(DATA_SCALE_Beak_z, 0);
        builder.define(DATA_SCALE_Tail_x, 0);
        builder.define(DATA_SCALE_Tail_y, 0);
        builder.define(DATA_SCALE_Tail_z, 0);
        builder.define(DATA_size, 100);
        builder.define(DATA_SCALE_Flopear_x, 0);
        builder.define(DATA_SCALE_Flopear_z, 0);
        builder.define(DATA_ROTATION_Flopear_z, 0);
        builder.define(DATA_POSITION_Ear_y, 0);
        builder.define(DATA_ROTATION_Snout_x, 0);
        builder.define(DATA_SCALE_Cowhorn_x, 0);
        builder.define(DATA_SCALE_Cowhorn_y, 0);
        builder.define(DATA_SCALE_Cowhorn_z, 0);
        builder.define(DATA_SCALE_Warmhorn_x, 0);
        builder.define(DATA_SCALE_Warmhorn_y, 0);
        builder.define(DATA_SCALE_Warmhorn_z, 0);
        builder.define(DATA_SCALE_Coldhorn_x, 0);
        builder.define(DATA_SCALE_Coldhorn_y, 0);
        builder.define(DATA_SCALE_Coldhorn_z, 0);
        builder.define(DATA_SCALE_Dolphintail_x, 0);
        builder.define(DATA_SCALE_Dolphintail_y, 0);
        builder.define(DATA_SCALE_Dolphintail_z, 0);
        builder.define(DATA_horn_type, 0);
        builder.define(DATA_SCALE_Fishtail_y, 0);
        builder.define(DATA_SCALE_Fishtail_z, 0);
        builder.define(DATA_skin, "player");
        builder.define(DATA_POSITION_HeadOffset_y, 0);
        builder.define(DATA_SCALE_Neck_x, 0);
        builder.define(DATA_SCALE_Neck_y, 0);
        builder.define(DATA_SCALE_Neck_z, 0);
        builder.define(DATA_ROTATION_Neck_x, 0);
        builder.define(DATA_POSITION_HeadOffset_z, 0);
        builder.define(DATA_isInitialized, false);
        builder.define(DATA_fedTimer, -1);
        builder.define(DATA_roamType, 0);
        builder.define(DATA_hue, 0);
        builder.define(DATA_saturation, 0);
        builder.define(DATA_brightness, 255);
        builder.define(DATA_POSITION_Frontleg_y, 0);
        builder.define(DATA_POSITION_Frontleg_z, 0);
        builder.define(DATA_arm_type, 1);
        builder.define(DATA_leg_type, 1);
        builder.define(DATA_head_type, 1);
        builder.define(DATA_neck_type, 0);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected boolean canPerformAttack(LivingEntity entity) {
                return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
            }
        });
        this.goalSelector.addGoal(2, new TemptGoal(this, 1, Ingredient.of(Items.WHEAT), false));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new FloatGoal(this));
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Dataarmslegstest", this.entityData.get(DATA_armslegstest));
        compound.putInt("DataSCALE_Arm_x", this.entityData.get(DATA_SCALE_Arm_x));
        compound.putInt("DataSCALE_Arm_y", this.entityData.get(DATA_SCALE_Arm_y));
        compound.putInt("DataSCALE_Arm_z", this.entityData.get(DATA_SCALE_Arm_z));
        compound.putInt("DataSCALE_Leg_x", this.entityData.get(DATA_SCALE_Leg_x));
        compound.putInt("DataSCALE_Leg_y", this.entityData.get(DATA_SCALE_Leg_y));
        compound.putInt("DataSCALE_Leg_z", this.entityData.get(DATA_SCALE_Leg_z));
        compound.putInt("DataROTATION_Arm_x", this.entityData.get(DATA_ROTATION_Arm_x));
        compound.putInt("DataROTATION_Body_x", this.entityData.get(DATA_ROTATION_Body_x));
        compound.putInt("DataSCALE_Body_x", this.entityData.get(DATA_SCALE_Body_x));
        compound.putInt("DataSCALE_Body_y", this.entityData.get(DATA_SCALE_Body_y));
        compound.putInt("DataSCALE_Body_z", this.entityData.get(DATA_SCALE_Body_z));
        compound.putInt("DataSCALE_Head_x", this.entityData.get(DATA_SCALE_Head_x));
        compound.putInt("DataSCALE_Head_y", this.entityData.get(DATA_SCALE_Head_y));
        compound.putInt("DataSCALE_Head_z", this.entityData.get(DATA_SCALE_Head_z));
        compound.putInt("DataPOSITION_Head_y", this.entityData.get(DATA_POSITION_Head_y));
        compound.putInt("DataPOSITION_Head_z", this.entityData.get(DATA_POSITION_Head_z));
        compound.putInt("DataPOSITION_Arm_y", this.entityData.get(DATA_POSITION_Arm_y));
        compound.putInt("DataPOSITION_Arm_z", this.entityData.get(DATA_POSITION_Arm_z));
        compound.putInt("Datanose_type", this.entityData.get(DATA_nose_type));
        compound.putInt("Dataears_type", this.entityData.get(DATA_ears_type));
        compound.putInt("Datatail_type", this.entityData.get(DATA_tail_type));
        compound.putInt("DataSCALE_Nose_x", this.entityData.get(DATA_SCALE_Nose_x));
        compound.putInt("DataSCALE_Nose_y", this.entityData.get(DATA_SCALE_Nose_y));
        compound.putInt("DataSCALE_Nose_z", this.entityData.get(DATA_SCALE_Nose_z));
        compound.putInt("DataSCALE_Snout_x", this.entityData.get(DATA_SCALE_Snout_x));
        compound.putInt("DataSCALE_Snout_z", this.entityData.get(DATA_SCALE_Snout_z));
        compound.putInt("DataSCALE_Ear_x", this.entityData.get(DATA_SCALE_Ear_x));
        compound.putInt("DataSCALE_Ear_y", this.entityData.get(DATA_SCALE_Ear_y));
        compound.putInt("DataSCALE_Ear_z", this.entityData.get(DATA_SCALE_Ear_z));
        compound.putInt("DataSCALE_Bunnyear_x", this.entityData.get(DATA_SCALE_Bunnyear_x));
        compound.putInt("DataSCALE_Bunnyear_y", this.entityData.get(DATA_SCALE_Bunnyear_y));
        compound.putInt("DataSCALE_Bunnyear_z", this.entityData.get(DATA_SCALE_Bunnyear_z));
        compound.putInt("DataPOSITION_Root_y", this.entityData.get(DATA_POSITION_Root_y));
        compound.putInt("DataSCALE_Beak_x", this.entityData.get(DATA_SCALE_Beak_x));
        compound.putInt("DataSCALE_Beak_y", this.entityData.get(DATA_SCALE_Beak_y));
        compound.putInt("DataSCALE_Beak_z", this.entityData.get(DATA_SCALE_Beak_z));
        compound.putInt("DataSCALE_Tail_x", this.entityData.get(DATA_SCALE_Tail_x));
        compound.putInt("DataSCALE_Tail_y", this.entityData.get(DATA_SCALE_Tail_y));
        compound.putInt("DataSCALE_Tail_z", this.entityData.get(DATA_SCALE_Tail_z));
        compound.putInt("Datasize", this.entityData.get(DATA_size));
        compound.putInt("DataSCALE_Flopear_x", this.entityData.get(DATA_SCALE_Flopear_x));
        compound.putInt("DataSCALE_Flopear_z", this.entityData.get(DATA_SCALE_Flopear_z));
        compound.putInt("DataROTATION_Flopear_z", this.entityData.get(DATA_ROTATION_Flopear_z));
        compound.putInt("DataPOSITION_Ear_y", this.entityData.get(DATA_POSITION_Ear_y));
        compound.putInt("DataROTATION_Snout_x", this.entityData.get(DATA_ROTATION_Snout_x));
        compound.putInt("DataSCALE_Cowhorn_x", this.entityData.get(DATA_SCALE_Cowhorn_x));
        compound.putInt("DataSCALE_Cowhorn_y", this.entityData.get(DATA_SCALE_Cowhorn_y));
        compound.putInt("DataSCALE_Cowhorn_z", this.entityData.get(DATA_SCALE_Cowhorn_z));
        compound.putInt("DataSCALE_Warmhorn_x", this.entityData.get(DATA_SCALE_Warmhorn_x));
        compound.putInt("DataSCALE_Warmhorn_y", this.entityData.get(DATA_SCALE_Warmhorn_y));
        compound.putInt("DataSCALE_Warmhorn_z", this.entityData.get(DATA_SCALE_Warmhorn_z));
        compound.putInt("DataSCALE_Coldhorn_x", this.entityData.get(DATA_SCALE_Coldhorn_x));
        compound.putInt("DataSCALE_Coldhorn_y", this.entityData.get(DATA_SCALE_Coldhorn_y));
        compound.putInt("DataSCALE_Coldhorn_z", this.entityData.get(DATA_SCALE_Coldhorn_z));
        compound.putInt("DataSCALE_Dolphintail_x", this.entityData.get(DATA_SCALE_Dolphintail_x));
        compound.putInt("DataSCALE_Dolphintail_y", this.entityData.get(DATA_SCALE_Dolphintail_y));
        compound.putInt("DataSCALE_Dolphintail_z", this.entityData.get(DATA_SCALE_Dolphintail_z));
        compound.putInt("Datahorn_type", this.entityData.get(DATA_horn_type));
        compound.putInt("DataSCALE_Fishtail_y", this.entityData.get(DATA_SCALE_Fishtail_y));
        compound.putInt("DataSCALE_Fishtail_z", this.entityData.get(DATA_SCALE_Fishtail_z));
        compound.putString("Dataskin", this.entityData.get(DATA_skin));
        compound.putInt("DataPOSITION_HeadOffset_y", this.entityData.get(DATA_POSITION_HeadOffset_y));
        compound.putInt("DataSCALE_Neck_x", this.entityData.get(DATA_SCALE_Neck_x));
        compound.putInt("DataSCALE_Neck_y", this.entityData.get(DATA_SCALE_Neck_y));
        compound.putInt("DataSCALE_Neck_z", this.entityData.get(DATA_SCALE_Neck_z));
        compound.putInt("DataROTATION_Neck_x", this.entityData.get(DATA_ROTATION_Neck_x));
        compound.putInt("DataPOSITION_HeadOffset_z", this.entityData.get(DATA_POSITION_HeadOffset_z));
        compound.putBoolean("DataisInitialized", this.entityData.get(DATA_isInitialized));
        compound.putInt("DatafedTimer", this.entityData.get(DATA_fedTimer));
        compound.putInt("DataroamType", this.entityData.get(DATA_roamType));
        compound.putInt("Datahue", this.entityData.get(DATA_hue));
        compound.putInt("Datasaturation", this.entityData.get(DATA_saturation));
        compound.putInt("Databrightness", this.entityData.get(DATA_brightness));
        compound.putInt("DataPOSITION_Frontleg_y", this.entityData.get(DATA_POSITION_Frontleg_y));
        compound.putInt("DataPOSITION_Frontleg_z", this.entityData.get(DATA_POSITION_Frontleg_z));
        compound.putInt("Dataarm_type", this.entityData.get(DATA_arm_type));
        compound.putInt("Dataleg_type", this.entityData.get(DATA_leg_type));
        compound.putInt("Dataarm_type", this.entityData.get(DATA_head_type));
        compound.putInt("Dataleg_type", this.entityData.get(DATA_neck_type));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Dataarmslegstest"))
            this.entityData.set(DATA_armslegstest, compound.getBoolean("Dataarmslegstest"));
        if (compound.contains("DataSCALE_Arm_x"))
            this.entityData.set(DATA_SCALE_Arm_x, compound.getInt("DataSCALE_Arm_x"));
        if (compound.contains("DataSCALE_Arm_y"))
            this.entityData.set(DATA_SCALE_Arm_y, compound.getInt("DataSCALE_Arm_y"));
        if (compound.contains("DataSCALE_Arm_z"))
            this.entityData.set(DATA_SCALE_Arm_z, compound.getInt("DataSCALE_Arm_z"));
        if (compound.contains("DataSCALE_Leg_x"))
            this.entityData.set(DATA_SCALE_Leg_x, compound.getInt("DataSCALE_Leg_x"));
        if (compound.contains("DataSCALE_Leg_y"))
            this.entityData.set(DATA_SCALE_Leg_y, compound.getInt("DataSCALE_Leg_y"));
        if (compound.contains("DataSCALE_Leg_z"))
            this.entityData.set(DATA_SCALE_Leg_z, compound.getInt("DataSCALE_Leg_z"));
        if (compound.contains("DataROTATION_Arm_x"))
            this.entityData.set(DATA_ROTATION_Arm_x, compound.getInt("DataROTATION_Arm_x"));
        if (compound.contains("DataROTATION_Body_x"))
            this.entityData.set(DATA_ROTATION_Body_x, compound.getInt("DataROTATION_Body_x"));
        if (compound.contains("DataSCALE_Body_x"))
            this.entityData.set(DATA_SCALE_Body_x, compound.getInt("DataSCALE_Body_x"));
        if (compound.contains("DataSCALE_Body_y"))
            this.entityData.set(DATA_SCALE_Body_y, compound.getInt("DataSCALE_Body_y"));
        if (compound.contains("DataSCALE_Body_z"))
            this.entityData.set(DATA_SCALE_Body_z, compound.getInt("DataSCALE_Body_z"));
        if (compound.contains("DataSCALE_Head_x"))
            this.entityData.set(DATA_SCALE_Head_x, compound.getInt("DataSCALE_Head_x"));
        if (compound.contains("DataSCALE_Head_y"))
            this.entityData.set(DATA_SCALE_Head_y, compound.getInt("DataSCALE_Head_y"));
        if (compound.contains("DataSCALE_Head_z"))
            this.entityData.set(DATA_SCALE_Head_z, compound.getInt("DataSCALE_Head_z"));
        if (compound.contains("DataPOSITION_Head_y"))
            this.entityData.set(DATA_POSITION_Head_y, compound.getInt("DataPOSITION_Head_y"));
        if (compound.contains("DataPOSITION_Head_z"))
            this.entityData.set(DATA_POSITION_Head_z, compound.getInt("DataPOSITION_Head_z"));
        if (compound.contains("DataPOSITION_Arm_y"))
            this.entityData.set(DATA_POSITION_Arm_y, compound.getInt("DataPOSITION_Arm_y"));
        if (compound.contains("DataPOSITION_Arm_z"))
            this.entityData.set(DATA_POSITION_Arm_z, compound.getInt("DataPOSITION_Arm_z"));
        if (compound.contains("Datanose_type"))
            this.entityData.set(DATA_nose_type, compound.getInt("Datanose_type"));
        if (compound.contains("Dataears_type"))
            this.entityData.set(DATA_ears_type, compound.getInt("Dataears_type"));
        if (compound.contains("Datatail_type"))
            this.entityData.set(DATA_tail_type, compound.getInt("Datatail_type"));
        if (compound.contains("DataSCALE_Nose_x"))
            this.entityData.set(DATA_SCALE_Nose_x, compound.getInt("DataSCALE_Nose_x"));
        if (compound.contains("DataSCALE_Nose_y"))
            this.entityData.set(DATA_SCALE_Nose_y, compound.getInt("DataSCALE_Nose_y"));
        if (compound.contains("DataSCALE_Nose_z"))
            this.entityData.set(DATA_SCALE_Nose_z, compound.getInt("DataSCALE_Nose_z"));
        if (compound.contains("DataSCALE_Snout_x"))
            this.entityData.set(DATA_SCALE_Snout_x, compound.getInt("DataSCALE_Snout_x"));
        if (compound.contains("DataSCALE_Snout_z"))
            this.entityData.set(DATA_SCALE_Snout_z, compound.getInt("DataSCALE_Snout_z"));
        if (compound.contains("DataSCALE_Ear_x"))
            this.entityData.set(DATA_SCALE_Ear_x, compound.getInt("DataSCALE_Ear_x"));
        if (compound.contains("DataSCALE_Ear_y"))
            this.entityData.set(DATA_SCALE_Ear_y, compound.getInt("DataSCALE_Ear_y"));
        if (compound.contains("DataSCALE_Ear_z"))
            this.entityData.set(DATA_SCALE_Ear_z, compound.getInt("DataSCALE_Ear_z"));
        if (compound.contains("DataSCALE_Bunnyear_x"))
            this.entityData.set(DATA_SCALE_Bunnyear_x, compound.getInt("DataSCALE_Bunnyear_x"));
        if (compound.contains("DataSCALE_Bunnyear_y"))
            this.entityData.set(DATA_SCALE_Bunnyear_y, compound.getInt("DataSCALE_Bunnyear_y"));
        if (compound.contains("DataSCALE_Bunnyear_z"))
            this.entityData.set(DATA_SCALE_Bunnyear_z, compound.getInt("DataSCALE_Bunnyear_z"));
        if (compound.contains("DataPOSITION_Root_y"))
            this.entityData.set(DATA_POSITION_Root_y, compound.getInt("DataPOSITION_Root_y"));
        if (compound.contains("DataSCALE_Beak_x"))
            this.entityData.set(DATA_SCALE_Beak_x, compound.getInt("DataSCALE_Beak_x"));
        if (compound.contains("DataSCALE_Beak_y"))
            this.entityData.set(DATA_SCALE_Beak_y, compound.getInt("DataSCALE_Beak_y"));
        if (compound.contains("DataSCALE_Beak_z"))
            this.entityData.set(DATA_SCALE_Beak_z, compound.getInt("DataSCALE_Beak_z"));
        if (compound.contains("DataSCALE_Tail_x"))
            this.entityData.set(DATA_SCALE_Tail_x, compound.getInt("DataSCALE_Tail_x"));
        if (compound.contains("DataSCALE_Tail_y"))
            this.entityData.set(DATA_SCALE_Tail_y, compound.getInt("DataSCALE_Tail_y"));
        if (compound.contains("DataSCALE_Tail_z"))
            this.entityData.set(DATA_SCALE_Tail_z, compound.getInt("DataSCALE_Tail_z"));
        if (compound.contains("Datasize"))
            this.entityData.set(DATA_size, compound.getInt("Datasize"));
        if (compound.contains("DataSCALE_Flopear_x"))
            this.entityData.set(DATA_SCALE_Flopear_x, compound.getInt("DataSCALE_Flopear_x"));
        if (compound.contains("DataSCALE_Flopear_z"))
            this.entityData.set(DATA_SCALE_Flopear_z, compound.getInt("DataSCALE_Flopear_z"));
        if (compound.contains("DataROTATION_Flopear_z"))
            this.entityData.set(DATA_ROTATION_Flopear_z, compound.getInt("DataROTATION_Flopear_z"));
        if (compound.contains("DataPOSITION_Ear_y"))
            this.entityData.set(DATA_POSITION_Ear_y, compound.getInt("DataPOSITION_Ear_y"));
        if (compound.contains("DataROTATION_Snout_x"))
            this.entityData.set(DATA_ROTATION_Snout_x, compound.getInt("DataROTATION_Snout_x"));
        if (compound.contains("DataSCALE_Cowhorn_x"))
            this.entityData.set(DATA_SCALE_Cowhorn_x, compound.getInt("DataSCALE_Cowhorn_x"));
        if (compound.contains("DataSCALE_Cowhorn_y"))
            this.entityData.set(DATA_SCALE_Cowhorn_y, compound.getInt("DataSCALE_Cowhorn_y"));
        if (compound.contains("DataSCALE_Cowhorn_z"))
            this.entityData.set(DATA_SCALE_Cowhorn_z, compound.getInt("DataSCALE_Cowhorn_z"));
        if (compound.contains("DataSCALE_Warmhorn_x"))
            this.entityData.set(DATA_SCALE_Warmhorn_x, compound.getInt("DataSCALE_Warmhorn_x"));
        if (compound.contains("DataSCALE_Warmhorn_y"))
            this.entityData.set(DATA_SCALE_Warmhorn_y, compound.getInt("DataSCALE_Warmhorn_y"));
        if (compound.contains("DataSCALE_Warmhorn_z"))
            this.entityData.set(DATA_SCALE_Warmhorn_z, compound.getInt("DataSCALE_Warmhorn_z"));
        if (compound.contains("DataSCALE_Coldhorn_x"))
            this.entityData.set(DATA_SCALE_Coldhorn_x, compound.getInt("DataSCALE_Coldhorn_x"));
        if (compound.contains("DataSCALE_Coldhorn_y"))
            this.entityData.set(DATA_SCALE_Coldhorn_y, compound.getInt("DataSCALE_Coldhorn_y"));
        if (compound.contains("DataSCALE_Coldhorn_z"))
            this.entityData.set(DATA_SCALE_Coldhorn_z, compound.getInt("DataSCALE_Coldhorn_z"));
        if (compound.contains("DataSCALE_Dolphintail_x"))
            this.entityData.set(DATA_SCALE_Dolphintail_x, compound.getInt("DataSCALE_Dolphintail_x"));
        if (compound.contains("DataSCALE_Dolphintail_y"))
            this.entityData.set(DATA_SCALE_Dolphintail_y, compound.getInt("DataSCALE_Dolphintail_y"));
        if (compound.contains("DataSCALE_Dolphintail_z"))
            this.entityData.set(DATA_SCALE_Dolphintail_z, compound.getInt("DataSCALE_Dolphintail_z"));
        if (compound.contains("Datahorn_type"))
            this.entityData.set(DATA_horn_type, compound.getInt("Datahorn_type"));
        if (compound.contains("DataSCALE_Fishtail_y"))
            this.entityData.set(DATA_SCALE_Fishtail_y, compound.getInt("DataSCALE_Fishtail_y"));
        if (compound.contains("DataSCALE_Fishtail_z"))
            this.entityData.set(DATA_SCALE_Fishtail_z, compound.getInt("DataSCALE_Fishtail_z"));
        if (compound.contains("Dataskin"))
            this.entityData.set(DATA_skin, compound.getString("Dataskin"));
        if (compound.contains("DataPOSITION_HeadOffset_y"))
            this.entityData.set(DATA_POSITION_HeadOffset_y, compound.getInt("DataPOSITION_HeadOffset_y"));
        if (compound.contains("DataSCALE_Neck_x"))
            this.entityData.set(DATA_SCALE_Neck_x, compound.getInt("DataSCALE_Neck_x"));
        if (compound.contains("DataSCALE_Neck_y"))
            this.entityData.set(DATA_SCALE_Neck_y, compound.getInt("DataSCALE_Neck_y"));
        if (compound.contains("DataSCALE_Neck_z"))
            this.entityData.set(DATA_SCALE_Neck_z, compound.getInt("DataSCALE_Neck_z"));
        if (compound.contains("DataROTATION_Neck_x"))
            this.entityData.set(DATA_ROTATION_Neck_x, compound.getInt("DataROTATION_Neck_x"));
        if (compound.contains("DataPOSITION_HeadOffset_z"))
            this.entityData.set(DATA_POSITION_HeadOffset_z, compound.getInt("DataPOSITION_HeadOffset_z"));
        if (compound.contains("DataisInitialized"))
            this.entityData.set(DATA_isInitialized, compound.getBoolean("DataisInitialized"));
        if (compound.contains("DatafedTimer"))
            this.entityData.set(DATA_fedTimer, compound.getInt("DatafedTimer"));
        if (compound.contains("DataroamType"))
            this.entityData.set(DATA_roamType, compound.getInt("DataroamType"));
        if (compound.contains("Datahue"))
            this.entityData.set(DATA_hue, compound.getInt("Datahue"));
        if (compound.contains("Datasaturation"))
            this.entityData.set(DATA_saturation, compound.getInt("Datasaturation"));
        if (compound.contains("Databrightness"))
            this.entityData.set(DATA_brightness, compound.getInt("Databrightness"));
        if (compound.contains("DataPOSITION_Frontleg_y"))
            this.entityData.set(DATA_POSITION_Frontleg_y, compound.getInt("DataPOSITION_Frontleg_y"));
        if (compound.contains("DataPOSITION_Frontleg_z"))
            this.entityData.set(DATA_POSITION_Frontleg_z, compound.getInt("DataPOSITION_Frontleg_z"));
        if (compound.contains("Dataarm_type"))
            this.entityData.set(DATA_arm_type, compound.getInt("Dataarm_type"));
        if (compound.contains("Dataleg_type"))
            this.entityData.set(DATA_leg_type, compound.getInt("Dataleg_type"));
        if (compound.contains("Datahead_type"))
            this.entityData.set(DATA_arm_type, compound.getInt("Datahead_type"));
        if (compound.contains("Dataneck_type"))
            this.entityData.set(DATA_leg_type, compound.getInt("Dataneck_type"));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.animationState0.animateWhen(true, this.tickCount);
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        initialize(this.level(), this.getX(), this.getY(), this.getZ(), this);
        fedTimer(this.level(), this.getX(), this.getY(), this.getZ(), this);
    }

    public static void initialize(LevelAccessor world, double x, double y, double z, PritchanimalEntity entity) {
        if (entity == null)
            return;
        double ScaleBodyY = 0;
        double ScaleNeckY = 0;
        if (!entity.getEntityData().get(PritchanimalEntity.DATA_isInitialized)) {
            entity.getEntityData().set(PritchanimalEntity.DATA_isInitialized, true);
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_Root_y, (int) ((-6) * (1 - (float) (entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Leg_y) / 100))) * 100);
            ScaleNeckY = 0;
            if (entity.getEntityData().get(PritchanimalEntity.DATA_neck_type) != 0) {
                ScaleNeckY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Neck_y) / 100;
            }
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_HeadOffset_y, (int) (8 * ScaleNeckY * Math.cos(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Neck_x)/10))) * 100);
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_HeadOffset_z, (int) ((-10) * ScaleNeckY * Math.sin(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Neck_x)/10))) * 100);
            ScaleBodyY = (float) entity.getEntityData().get(PritchanimalEntity.DATA_SCALE_Body_y) / 100;
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_Head_y, (int) (12 * (ScaleBodyY - 1) - 12 * ScaleBodyY * Math.sin(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10))) * 100);
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_Head_z, (int) ((-16) * ScaleBodyY * Math.sin(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10))) * 100);
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_Arm_y, (int) (10 * (ScaleBodyY - 1) - 10 * ScaleBodyY * Math.sin(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10))) * 100);
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_Arm_z, (int) ((-10) * ScaleBodyY * Math.sin(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10))) * 100);
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_Frontleg_y, (int) (12 * (ScaleBodyY - 1) * Math.cos(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10) - 10 * Math.sin(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10)))) * 100);
            entity.getEntityData().set(PritchanimalEntity.DATA_POSITION_Frontleg_z, (int) ((-1) * (10 + 12 * (ScaleBodyY - 1)) * Math.sin(Math.toRadians((float)entity.getEntityData().get(PritchanimalEntity.DATA_ROTATION_Body_x)/10))) * 100);
        }
    }

    public static void fedTimer(LevelAccessor world, double x, double y, double z, PritchanimalEntity entity) {
        if (entity == null)
            return;

        if (Math.random() < 0.0001) {
            entity.getEntityData().set(PritchanimalEntity.DATA_fedTimer, 200);
        }

        PritchanimalEntity baby = null;
        entity.getEntityData().set(PritchanimalEntity.DATA_fedTimer, entity.getEntityData().get(PritchanimalEntity.DATA_fedTimer) - 1);
        if (entity.getEntityData().get(PritchanimalEntity.DATA_fedTimer)> 0) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.HEART, x, y, z, 1, 1, 1, 1, 1);
            for (Entity entityIterator : world.getEntities(entity, new AABB((x + 10), (y + 10), (z + 10), (x - 10), (y - 10), (z - 10)))) {
                if ((entityIterator instanceof PritchanimalEntity _datEntI ? _datEntI.getEntityData().get(PritchanimalEntity.DATA_fedTimer) : 0) > 0) {
                    entity.getNavigation().moveTo((entityIterator.getX()), (entityIterator.getY()), (entityIterator.getZ()), 1);
                }
            }
            for (Entity entityIterator : world.getEntities(entity, new AABB((x + 1), (y + 1), (z + 1), (x - 1), (y - 1), (z - 1)))) {
                if ((entityIterator instanceof PritchanimalEntity pritchanimal && pritchanimal.getEntityData().get(PritchanimalEntity.DATA_fedTimer) > 0)) {
                    entity.getEntityData().set(PritchanimalEntity.DATA_fedTimer, -1);
                    pritchanimal.getEntityData().set(PritchanimalEntity.DATA_fedTimer, -1);
                    baby = world instanceof ServerLevel _level13 ? PritchvolutionEntities.PRITCHANIMAL.get().spawn(_level13, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED) : null;
                    setupBaby(baby, entity, pritchanimal);
                }
            }
        }
    }

    public static void setBabyData(EntityDataAccessor<Integer> entityDataAccessor, PritchanimalEntity baby, PritchanimalEntity mother, PritchanimalEntity father) {
        baby.getEntityData().set(entityDataAccessor,
                (int) (Math.random()
                        * ((mother.getEntityData().get(entityDataAccessor)
                        - (father.getEntityData().get(entityDataAccessor))
                        + (father.getEntityData().get(entityDataAccessor))))));
    }

    public static void setBabyHas(EntityDataAccessor entityDataAccessor, double maternalChance, PritchanimalEntity baby, PritchanimalEntity mother, PritchanimalEntity father) {
        if (Math.random() > maternalChance) {
            baby.getEntityData().set(entityDataAccessor, (mother.getEntityData().get(entityDataAccessor)));
        } else {
            baby.getEntityData().set(entityDataAccessor, (father.getEntityData().get(entityDataAccessor)));
        }
    }

    public static void setupBaby(PritchanimalEntity baby, PritchanimalEntity mother, PritchanimalEntity father) {
        if (baby == null || mother == null || father == null)
            return;
        if (baby.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)) {
            baby.getAttribute(Attributes.MOVEMENT_SPEED)
                    .setBaseValue(Math.random()
                            * ((mother.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? mother.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)
                            - (father.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? father.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0))
                            + (father.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? father.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0));
        }
        setBabyData(PritchanimalEntity.DATA_SCALE_Arm_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Arm_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Arm_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Leg_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Leg_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Leg_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_ROTATION_Snout_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_ROTATION_Body_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_ROTATION_Neck_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_ROTATION_Arm_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Body_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Body_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Body_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Head_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Head_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Head_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Nose_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Nose_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Nose_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Snout_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Snout_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_ROTATION_Snout_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Beak_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Beak_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Beak_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Ear_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Ear_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Ear_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_POSITION_Ear_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Bunnyear_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Bunnyear_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Bunnyear_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Flopear_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Flopear_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_ROTATION_Flopear_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Cowhorn_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Cowhorn_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Cowhorn_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Coldhorn_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Coldhorn_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Coldhorn_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Warmhorn_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Warmhorn_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Warmhorn_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Tail_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Tail_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Tail_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Dolphintail_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Dolphintail_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Dolphintail_z, baby, mother, father);

        setBabyData(PritchanimalEntity.DATA_SCALE_Neck_x, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Neck_y, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_SCALE_Neck_z, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_hue, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_saturation, baby, mother, father);
        setBabyData(PritchanimalEntity.DATA_brightness, baby, mother, father);

        setBabyHas(PritchanimalEntity.DATA_head_type, 0.5, baby, mother, father);
        setBabyHas(PritchanimalEntity.DATA_nose_type, 0.5, baby, mother, father);
        setBabyHas(PritchanimalEntity.DATA_ears_type, 0.5, baby, mother, father);
        setBabyHas(PritchanimalEntity.DATA_horn_type, 0.5, baby, mother, father);
        setBabyHas(PritchanimalEntity.DATA_neck_type, 0.5, baby, mother, father);
        setBabyHas(PritchanimalEntity.DATA_arm_type, 0.5, baby, mother, father);
        setBabyHas(PritchanimalEntity.DATA_leg_type, 0.5, baby, mother, father);
        setBabyHas(PritchanimalEntity.DATA_tail_type, 0.5, baby, mother, father);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        PritchanimalEntity retval = PritchvolutionEntities.PRITCHANIMAL.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return Ingredient.of(new ItemStack(PritchvolutionItems.PRITCHANIMAL_SPAWN_EGG.get())).test(stack);
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(PritchvolutionEntities.PRITCHANIMAL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)),
                RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
        builder = builder.add(Attributes.MAX_HEALTH, 10);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder;
    }
}
