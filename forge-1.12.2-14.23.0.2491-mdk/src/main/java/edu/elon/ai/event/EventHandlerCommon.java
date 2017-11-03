package edu.elon.ai.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.input.Keyboard;

import edu.elon.ai.ingame.Controller;
import edu.elon.ai.items.ModItems;

public class EventHandlerCommon {
	
//	@SubscribeEvent
//	public void onEntityConstructing(EntityConstructing e) {
//	    if (e.getEntity() instanceof EntityPlayer) {
//	        Controller c = new Controller((EntityPlayer) e.getEntity());
//	    }
//	}
	//used to get player object upon the player joining the world
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent e) {
	    if (e.getEntity() instanceof EntityPlayer) {
	    	if(Keyboard.isKeyDown(Keyboard.KEY_J)){
	    		Runnable run = new Runnable(){
	    			public void run(){
	    				Controller c = new Controller((EntityPlayer) e.getEntity());
	    			}
	    		};
	    	}
	        
	    }
	}
}
