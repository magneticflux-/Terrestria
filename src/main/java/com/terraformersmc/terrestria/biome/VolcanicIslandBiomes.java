package com.terraformersmc.terrestria.biome;

import com.terraformersmc.terrestria.init.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import static com.terraformersmc.terrestria.init.TerrestriaBiomes.addBasicFeatures;

public class VolcanicIslandBiomes {
	public static void register() {
		final Biome.Builder template = new Biome.Builder()
				//.configureSurfaceBuilder(TerrestriaSurfaces.BASALT_CLIFF, TerrestriaSurfaces.BASALT_CONFIG)
				.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.BEACH)
				.temperature(0.9F)
				.downfall(0.9F)
				.effects(TerrestriaBiomes.createDefaultBiomeEffects()
					.waterColor(0x54d3c0)
					.waterFogColor(0x24a0b0)
					.build()
				);

		TerrestriaBiomes.VOLCANIC_ISLAND = TerrestriaBiomes.register("volcanic_island", template
				.generationSettings(volcanicIslandGenerationSettings().build())
				.spawnSettings(defaultSpawnSettings().build())
				.category(Biome.Category.EXTREME_HILLS)
				//.depth(0.1F)
				//.scale(0.2F)
				//.addStructureFeature(TerrestriaStructures.VOLCANO)
				.build());

		TerrestriaBiomes.VOLCANIC_ISLAND_SHORE = TerrestriaBiomes.register("volcanic_island_shore", template
				.generationSettings(volcanicIslandShoreGenerationSettings().build())
				.spawnSettings(defaultSpawnSettings().build())
				//.depth(0.05F)
				//.scale(0.05F)
				//.addStructureFeature(TerrestriaStructures.SHORE_VOLCANO)
				.build());

		TerrestriaBiomes.VOLCANIC_ISLAND_BEACH = TerrestriaBiomes.register("volcanic_island_beach", template
				.generationSettings(volcanicIslandBeachGenerationSettings().build())
				.spawnSettings(defaultSpawnSettings().build())
				//.configureSurfaceBuilder(TerrestriaSurfaces.BASALT_BEACH, TerrestriaSurfaces.BASALT_CONFIG)
				//.depth(0F)
				//.scale(0.05F)
				//.addStructureFeature(TerrestriaStructures.SHORE_VOLCANO)
				.build());
	}

	private static GenerationSettings.Builder volcanicIslandGenerationSettings() {
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.DENSER_JUNGLE_PALM_TREES);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.PATCH_VOLCANIC_ISLAND_GRASS);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		return builder;
	}

	private static GenerationSettings.Builder volcanicIslandShoreGenerationSettings() {
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.JUNGLE_PALM_TREES);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.RARE_DUM_DUM_HEADS);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.PATCH_VOLCANIC_ISLAND_GRASS);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		return builder;
	}

	private static GenerationSettings.Builder volcanicIslandBeachGenerationSettings() {
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.JUNGLE_PALM_TREES);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.PATCH_VOLCANIC_ISLAND_GRASS);
		DefaultBiomeFeatures.addDefaultGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		return builder;
	}

	private static SpawnSettings.Builder defaultSpawnSettings() {
		SpawnSettings.Builder builder = TerrestriaBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.SQUID, 3, 1, 4));
		builder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 15, 3, 6));
		builder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.COD, 15, 1, 5));
		return builder;
	}
}
