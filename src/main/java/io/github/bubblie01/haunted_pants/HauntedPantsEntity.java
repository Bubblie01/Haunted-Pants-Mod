package io.github.bubblie01.haunted_pants;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class HauntedPantsEntity extends PathAwareEntity {

	public static final EntityType PANT_ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE, new Identifier("haunted_pants", "pant_entity"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HauntedPantsEntity::new).dimensions(EntityDimensions.changing(0.7F, 1.0F)).build());

	public HauntedPantsEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}

	protected void initGoals() {
		this.goalSelector.add(1, new WanderAroundFarGoal(this,0.7f));
		this.targetSelector.add(0, new TargetGoal(this, PlayerEntity.class, true));
		this.goalSelector.add(0,new MeleeAttackGoal(this,0.7f, false));
		super.initGoals();
	}

	@Override
	public boolean canSpawn(WorldView world) {
		int random = (int)(Math.random() * 10) + 0;
		if(random == 1) {
			return true;
		}
		return false;

	}

	@Nullable
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		this.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.CHAINMAIL_LEGGINGS));
		this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.CHAINMAIL_BOOTS));
		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	public static void registerAttributes() {
		FabricDefaultAttributeRegistry.register(PANT_ENTITY_TYPE, createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10f).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3f));
	}
}
