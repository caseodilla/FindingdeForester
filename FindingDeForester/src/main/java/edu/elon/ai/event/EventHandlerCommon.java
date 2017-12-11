package edu.elon.ai.event;

/**
 * @author James Greenwell & Casey Hayes
 * 
 * This class uses code from:
 * https://bedrockminer.jimdo.com/modding-tutorials/
 */

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import edu.elon.ai.entities.EntityAIPlayer;

//used to subscribe to events, and perform actions when those events occure
public class EventHandlerCommon {
	
	//used to get player object upon the player joining the world
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent e) {
	    
	}
	
	//called when the player clicks on an entity, and calls methods 
	//in the EntityAIPlayer if the entity is an EntityAIPlayer
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
