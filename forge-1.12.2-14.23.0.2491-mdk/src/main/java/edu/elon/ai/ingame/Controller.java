package edu.elon.ai.ingame;

import net.minecraft.entity.player.EntityPlayer;

public class Controller {
	EntityPlayer player;
	public Controller(EntityPlayer player){
		this.player = player;
		System.out.println("Position X: "+ player.posX + " Position Z: "+ player.posZ);
		//Movement mover = new Movement(player);
		//mover.moveToPoint(0, 0);
	}
}
