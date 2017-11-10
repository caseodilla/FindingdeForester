package edu.elon.ai.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class EntityAIPlayer extends EntityCreature{
	
	
	
	public EntityAIPlayer(World worldIn) {
		super(worldIn);
		//set the home location and make the distance it can travel unbound
		this.setHomePosAndDistance(this.getPosition(), -1);
		this.setupAITasks();
	}
	
	private void setupAITasks(){
		
	}
	
	private void clearAITasks(){
		
	}
	
	public boolean isAIEnabled()
	{
	   return true;
	}
	
	

}
