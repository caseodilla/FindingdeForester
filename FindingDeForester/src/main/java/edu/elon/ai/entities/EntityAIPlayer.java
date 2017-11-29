package edu.elon.ai.entities;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.jcraft.jorbis.Block;

import edu.elon.ai.AIMod;
import edu.elon.ai.datastructures.Location3D;
import edu.elon.ai.tasks.InteractWithPlayer;
import edu.elon.ai.tasks.MoveToPositionTask;
import edu.elon.ai.ui.ModGUIHandler;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIPlayer extends EntityCreature{
	
	ArrayList<Location3D> woodBlockTargets;
	EntityPlayer player;
	InteractWithPlayer tradeTask;
	
	public EntityAIPlayer(World worldIn) {
		super(worldIn);
		//set the home location and make the distance it can travel unbound
		this.setHomePosAndDistance(this.getPosition(), -1);
		woodBlockTargets = new ArrayList<Location3D>();
		//give the AIPlayer an axe
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
		this.setAIMoveSpeed(.5f);
		tradeTask = new InteractWithPlayer(this);
		this.setupAITasks();
	}
	
	private void setWoodBlockTargets(int scanRadiusLW, int scanRadiusHeight){
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
					//if is wood or air break
					String currentBlock = this.world.getBlockState(new BlockPos(x+xCord,y+yCord,z+zCord)).getBlock().getLocalizedName();
					if(currentBlock.equals("Wood")){
						//System.out.println("X: " + x + " Y: " + y + " Z: " + z);
						//System.out.println("X: " + xCord + " Y: " + yCord + " Z: " + zCord);
						System.out.println("Found Wood at X: " + (x + xCord) + " Y: " + (y + yCord) + " Z: " + (z+zCord));
						//add block position to arrayList
						woodBlockTargets.add(new Location3D(x+xCord,y+yCord,z+zCord));
						break;
					}
					//if there's an air block, there is no normally spawned tree
					if(currentBlock.equals("Air")) {
						break;
					}
				}
			}
		}
	}
	
	private void setupAITasks(){
		
        //this.tasks.addTask(1, tradeTask);
	}
	
	private void clearAITasks(){
		
	}
	
	public boolean isAIEnabled()
	{
	   return true;
	}
	
	private void addLumberjackTasks(ArrayList<Location3D> locations) {
		//test
		for(int i = 0; i < locations.size(); i++) {
			this.tasks.addTask(i+2, new MoveToPositionTask(this,locations.get(i)));
		}
	}
	
	
	//sets the player after interaction
    public void setPlayer(@Nullable EntityPlayer player)
    {
        this.player = player;
    }
	
    //gets the player from interaction, if there is one
	public EntityPlayer getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
	
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!world.isRemote)
        {
            this.setPlayer(player);
            setWoodBlockTargets(15,5);
            //player.openGui(AIMod.instance, ModGUIHandler.MOD_ENTITY_AI_PLAYER_GUI, world, (int) this.posX, (int) this.posY, (int) this.posZ);
            //tradeTask.resetTask();
            addLumberjackTasks(woodBlockTargets);
        }
        return true;
    }
	
	

}
