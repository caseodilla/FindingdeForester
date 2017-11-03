package edu.elon.ai.items;

import java.util.HashSet;
import java.util.Set;

import edu.elon.ai.Reference;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Reference.MOD_ID)
public final class ModItems {
	
	public static final Item AI_EGG = new SpawnEggItem("LumberJack_Egg");
	
	//Register the items and store them
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		//store the items
		public static final Set<Item> ITEMS = new HashSet<>();
		
		//register the items
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final IForgeRegistry<Item> registry = event.getRegistry();
			//name the item
			AI_EGG.setRegistryName(Reference.MOD_ID,Reference.AI_EGG_REGISTRY_NAME);
			//register the item
			registry.register(AI_EGG);
			ITEMS.add(AI_EGG);
		}

	}
	
	//Initialize all of the items
	private static void initializeItems(){

	}
}
