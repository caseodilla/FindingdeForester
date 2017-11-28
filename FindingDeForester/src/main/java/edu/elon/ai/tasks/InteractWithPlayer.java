package edu.elon.ai.tasks;

import edu.elon.ai.entities.EntityAIPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;

//much of this class is based on 
public class InteractWithPlayer extends EntityAIBase{

    private final EntityAIPlayer aiPlayer;

    public InteractWithPlayer(EntityAIPlayer aiPlayer)
    {
        this.aiPlayer = aiPlayer;
        this.setMutexBits(5);
    }
	
	@Override
	public boolean shouldExecute() {
		if (!this.aiPlayer.isEntityAlive())
        {
            return false;
        }
        else if (this.aiPlayer.isInWater())
        {
            return false;
        }
        else if (!this.aiPlayer.onGround)
        {
            return false;
        }
        else if (this.aiPlayer.velocityChanged)
        {
            return false;
        }
        else
        {
            EntityPlayer entityplayer = this.aiPlayer.getPlayer();

            if (entityplayer == null)
            {
                return false;
            }
            else if (this.aiPlayer.getDistanceSqToEntity(entityplayer) > 16.0D)
            {
                return false;
            }
            else
            {
                return entityplayer.openContainer != null;
            }
        }
	}
	
	/**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
    	System.out.println("Started Executing");
        this.aiPlayer.getNavigator().clearPathEntity();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.aiPlayer.setPlayer((EntityPlayer)null);
    }
    

}
