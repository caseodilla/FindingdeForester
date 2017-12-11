package edu.elon.ai.items;

/**
 * @author James Greenwell & Casey Hayes
 * 
 * This class uses code from:
 * https://bedrockminer.jimdo.com/modding-tutorials/
 */

import java.util.HashSet;
import java.util.Set;

import edu.elon.ai.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
//This class is unnecessary now, but was initially going to be used for putting an item in game
@ObjectHolder(Reference.MOD_ID)
public final class ModItems {
	
	//public static final Item AI_EGG = new SpawnEggItem("LumberJack_Egg");
	
	//Register the items and store them
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		//store the items
		public static final Set<Item> ITEMS = new HashSet<>();
		
		//register the items
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			@SuppressWarnings("unused")
			final IForgeRegistry<Item> registry = event.getRegistry();
		}

	}
	
	//Initialize all of the items
	@SuppressWarnings("unused")
	private static void initializeItems(){

	}
}
