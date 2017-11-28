package edu.elon.ai.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.input.Keyboard;

import edu.elon.ai.entities.EntityAIPlayer;
import edu.elon.ai.ingame.Controller;

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
	
    @SubscribeEvent
    public void onAIPlayerClick(EntityInteract e)
    {
        if(e.getTarget() instanceof EntityAIPlayer){
        	EntityPlayer player = e.getEntityPlayer();
        	EntityAIPlayer p = (EntityAIPlayer) e.getTarget();
        	p.setPlayer(player);
        	
        }
    }
}
