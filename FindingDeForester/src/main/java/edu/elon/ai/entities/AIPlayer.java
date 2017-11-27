package edu.elon.ai.entities;

import java.util.ArrayList;
import net.minecraft.entity.ai.EntityAITradePlayer;

import com.jcraft.jorbis.Block;

import edu.elon.ai.datastructures.Location3D;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AIPlayer extends EntityCreature{
	
	ArrayList<Location3D> woodBlockTargets;
	
	public AIPlayer(World worldIn) {
		super(worldIn);
		//set the home location and make the distance it can travel unbound
		this.setHomePosAndDistance(this.getPosition(), -1);
		woodBlockTargets = new ArrayList<Location3D>();
		setWoodBlockTargets(worldIn,15,5);
		//this.navigator.tryMoveToXYZ(x, y, z, speedIn);
		this.setupAITasks();
	}
	
	private void setWoodBlockTargets(World worldIn,int scanRadiusLW, int scanRadiusHeight){
		int xCord = (int) (this.posX);
		int yCord = (int) (this.posY);
		int zCord = (int) (this.posZ);
		System.out.println("Reached");
		//scan the x coordinates
		for(int x = -scanRadiusLW;x <= scanRadiusLW;x++){
			//scan the z coordinates
			for(int z = -scanRadiusLW;z < scanRadiusLW;z++){
				//scan the y coordinates (done last to limit locations to lowest block
				for(int y = -scanRadiusHeight;y < scanRadiusHeight;y++){
					//The wood first detected will be the lowest
					//if is wood break
					if(worldIn.getBlockState(new BlockPos(x+xCord,y+yCord,z+zCord)).getBlock().getLocalizedName().equals("Wood")){
						//System.out.println("X: " + x + " Y: " + y + " Z: " + z);
						//System.out.println("X: " + xCord + " Y: " + yCord + " Z: " + zCord);
						//System.out.println("Found Wood at X: " + (x + xCord) + " Y: " + (y + yCord) + " Z: " + (z+zCord));
						//add block position to arrayList
						woodBlockTargets.add(new Location3D(x+xCord,y+yCord,z+zCord));
						break;
					}
				}
			}
		}
	}
	
	private void setupAITasks(){
        //this.tasks.addTask(1, new EntityAITradePlayer(this));
	}
	
	private void clearAITasks(){
		
	}
	
	public boolean isAIEnabled()
	{
	   return true;
	}
	
	

}
