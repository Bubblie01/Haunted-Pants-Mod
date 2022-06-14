package io.github.bubblie01.haunted_pants;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Example Mod");

	public void onInitialize(ModContainer mod) {
		HauntedPantsEntity.registerAttributes();
		BiomeModifications.addSpawn(BiomeSelectors.all(),SpawnGroup.MONSTER,HauntedPantsEntity.PANT_ENTITY_TYPE,100,3,5);

	}
}
