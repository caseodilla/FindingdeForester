package edu.elon.ai.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class EntityAI extends EntityCreature{
	
	public EntityAI(World worldIn) {
		super(worldIn);
		this.setEntityInvulnerable(true);
	}

}
