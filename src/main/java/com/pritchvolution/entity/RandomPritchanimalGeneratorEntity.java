package com.pritchvolution.entity;

import com.pritchvolution.init.PritchvolutionEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import oshi.jna.platform.mac.SystemB;

import javax.annotation.Nullable;
import java.util.Random;

public class RandomPritchanimalGeneratorEntity extends Monster {
    public RandomPritchanimalGeneratorEntity(EntityType<RandomPritchanimalGeneratorEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(true);
    }

    @Override
    protected void registerGoals() {
        /*
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected boolean canPerformAttack(LivingEntity entity) {
                return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
            }
        });
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new FloatGoal(this));
        */
    }

    @Override
    public Vec3 getPassengerRidingPosition(Entity entity) {
        return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
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
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        return retval;
    }

    public static void setRandomInRange(EntityDataAccessor<Integer> entityDataAccessor, PritchanimalEntity pritchanimal, int lowerBound, int upperBound) {
        pritchanimal.getEntityData().set(entityDataAccessor, Mth.nextInt(RandomSource.create(), lowerBound, upperBound));
    }

    public static void randomEntitySetup(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        Entity entity1 = null;
        entity1 = world instanceof ServerLevel _level0 ? PritchvolutionEntities.PRITCHANIMAL.get().spawn(_level0, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED) : null;

        if (entity1 instanceof PritchanimalEntity pritchanimal) {
            if (pritchanimal.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                pritchanimal.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.2, 0.3)));
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Arm_x, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Arm_y, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Arm_z, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Leg_x, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Leg_y, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Leg_z, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_ROTATION_Body_x, pritchanimal, 0, 900);
            setRandomInRange(PritchanimalEntity.DATA_ROTATION_Neck_x, pritchanimal, 0, 900);
            setRandomInRange(PritchanimalEntity.DATA_ROTATION_Arm_x, pritchanimal, -900, 0);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Body_x, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Body_y, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Body_z, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Head_x, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Head_y, pritchanimal, 50, 150);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Head_z, pritchanimal, 50, 150);

            setRandomInRange(PritchanimalEntity.DATA_SCALE_Neck_x, pritchanimal, (int) Math.floor(pritchanimal.getEntityData().get(PritchanimalEntity.DATA_SCALE_Body_x) * 0.5), pritchanimal.getEntityData().get(PritchanimalEntity.DATA_SCALE_Body_x));
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Neck_y, pritchanimal, 50, 200);
            setRandomInRange(PritchanimalEntity.DATA_SCALE_Neck_z, pritchanimal, (int) Math.floor(pritchanimal.getEntityData().get(PritchanimalEntity.DATA_SCALE_Body_z) * 0.25), (int) Math.floor(pritchanimal.getEntityData().get(PritchanimalEntity.DATA_SCALE_Body_x) * 0.5));

            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_roamType, Mth.nextInt(RandomSource.create(), 0, 3));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_hue, Mth.nextInt(RandomSource.create(), 0, 255));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_saturation, Mth.nextInt(RandomSource.create(), 0, 255));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_brightness, Mth.nextInt(RandomSource.create(), 125, 255));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_arm_type, Mth.nextInt(RandomSource.create(), 0, 2));
            double legRand = Math.random();
            if (legRand < 0.1) {
                pritchanimal.getEntityData().set(PritchanimalEntity.DATA_leg_type, 0);//no legs
            } else if (legRand > 0.9) {
                pritchanimal.getEntityData().set(PritchanimalEntity.DATA_leg_type, 2);//creeper legs
            }
            if (Math.random() > 0.5) {
                pritchanimal.getEntityData().set(PritchanimalEntity.DATA_neck_type, 1);
            }
            if (Math.random() > 0.1) {
                pritchanimal.getEntityData().set(PritchanimalEntity.DATA_head_type, 1);
            }

            double RandomSkin = 0;
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_nose_type, Mth.nextInt(RandomSource.create(), 0, 3));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Nose_x, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Nose_y, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Nose_z, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Snout_x, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Snout_z, (int) Mth.nextDouble(RandomSource.create(), 100, 300));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_ROTATION_Snout_x, (int) Mth.nextDouble(RandomSource.create(), 0, 300));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Beak_x, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Beak_y, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Beak_z, (int) Mth.nextDouble(RandomSource.create(), 50, 300));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_ears_type, Mth.nextInt(RandomSource.create(), 0, 3));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Ear_x, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Ear_y, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Ear_z, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_POSITION_Ear_y, Mth.nextInt(RandomSource.create(), -500, 0));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Bunnyear_x, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Bunnyear_y, (int) Mth.nextDouble(RandomSource.create(), 25, 100));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Bunnyear_z, (int) Mth.nextDouble(RandomSource.create(), 100, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Flopear_x, (int) Mth.nextDouble(RandomSource.create(), 25, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Flopear_z, (int) Mth.nextDouble(RandomSource.create(), 25, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_ROTATION_Flopear_z, (int) Mth.nextDouble(RandomSource.create(), -900, 900));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_horn_type, Mth.nextInt(RandomSource.create(), 0, 3));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Cowhorn_x, (int) Mth.nextDouble(RandomSource.create(), 100, 200));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Cowhorn_y, (int) Mth.nextDouble(RandomSource.create(), 50, 200));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Cowhorn_z, (int) Mth.nextDouble(RandomSource.create(), 100, 200));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Warmhorn_x, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Warmhorn_y, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Warmhorn_z, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Coldhorn_x, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Coldhorn_y, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Coldhorn_z, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_tail_type, Mth.nextInt(RandomSource.create(), 0, 2));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Tail_x, (int) Mth.nextDouble(RandomSource.create(), 75, 200));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Tail_y, (int) Mth.nextDouble(RandomSource.create(), 75, 200));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Tail_z, (int) Mth.nextDouble(RandomSource.create(), 50, 200));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Dolphintail_x, (int) Mth.nextDouble(RandomSource.create(), 50, 150));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Dolphintail_y, (int) Mth.nextDouble(RandomSource.create(), 50, 100));
            pritchanimal.getEntityData().set(PritchanimalEntity.DATA_SCALE_Dolphintail_z, (int) Mth.nextDouble(RandomSource.create(), 50, 200));
            if (pritchanimal.getAttributes().hasAttribute(Attributes.SCALE)) {
                Random random = new Random();
                double desiredMean = 1.0;
                double desiredStdDev = 0.25;
                pritchanimal.getAttribute(Attributes.SCALE).setBaseValue(random.nextGaussian() * desiredStdDev + desiredMean);
            }

            RandomSkin = Math.random();
            if (RandomSkin > 0.8) {
                pritchanimal.getEntityData().set(PritchanimalEntity.DATA_skin, "cow");
            } else if (RandomSkin > 0.6) {
                pritchanimal.getEntityData().set(PritchanimalEntity.DATA_skin, "chicken");
            } else if (RandomSkin > 0.4) {
                pritchanimal.getEntityData().set(PritchanimalEntity.DATA_skin, "sheep");
            } else if (RandomSkin > 0.2) {
                pritchanimal.getEntityData().set(PritchanimalEntity.DATA_skin, "creeper");
            }
        }




        if (!world.isClientSide())
            entity.discard();
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(PritchvolutionEntities.RANDOM_PRITCHANIMAL_GENERATOR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)),
                RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    public void baseTick() {
        randomEntitySetup(this.level(), this.getX(), this.getY(), this.getZ(), this);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 10);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder;
    }
}
