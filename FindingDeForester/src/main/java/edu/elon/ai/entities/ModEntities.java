package edu.elon.ai.entities;

import edu.elon.ai.AIMod;
import edu.elon.ai.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	public static void registerEntities() {
		registerEntity(AIPlayer.class,"AI_NPC",80,3,true,0x008B8B,0xDAA520);
	}
	
	private static int entityID = 0;
	
	/**
	 * Register an entity with the specified tracking values and spawn egg colours.
	 *
	 * @param entityClass          The entity's class
	 * @param entityName           The entity's unique name
	 * @param trackingRange        The range at which MC will send tracking updates
	 * @param updateFrequency      The frequency of tracking updates
	 * @param sendsVelocityUpdates Whether to send velocity information packets as well
	 * @param eggPrimary           The spawn egg's primary (background) colour
	 * @param eggSecondary         The spawn egg's secondary (foreground) colour
	 */
	private static void registerEntity(final Class<? extends Entity> entityClass, final String entityName, final int trackingRange, final int updateFrequency, final boolean sendsVelocityUpdates, final int eggPrimary, final int eggSecondary) {
		final ResourceLocation registryName = new ResourceLocation(Reference.MOD_ID, entityName);
		EntityRegistry.registerModEntity(registryName, entityClass, registryName.toString(), entityID++, AIMod.instance, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
	}
}
