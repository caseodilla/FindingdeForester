package edu.elon.ai.entities;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.jcraft.jorbis.Block;

import edu.elon.ai.AIMod;
import edu.elon.ai.algorithms.GeneticAlgorithm;
import edu.elon.ai.datastructures.Location3D;
import edu.elon.ai.datastructures.Population;
import edu.elon.ai.tasks.InteractWithPlayer;
import edu.elon.ai.tasks.SeekAndDestroyTrees;
import edu.elon.ai.ui.ModGUIHandler;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIPlayer extends EntityCreature{
	
	private ArrayList<Location3D> woodBlockTargets;
	private EntityPlayer player;
	
	//how far should the AI Player look for trees
	private final int SCAN_RADIUS_LW = 20;
	private final int SCAN_RADIUS_H = 5;
	
	//how many generations the algorithm should spawn
	private final int GENERATIONS = 1000;
	
	//InteractWithPlayer tradeTask;
	
	public EntityAIPlayer(World worldIn) {
		super(worldIn);
		//set the home location and make the distance it can travel unbound
		this.setHomePosAndDistance(this.getPosition(), -1);
		woodBlockTargets = new ArrayList<Location3D>();
		//give the AIPlayer an axe
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
		this.setAIMoveSpeed(.5f);
		System.out.println("Unmodded: " + this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue());
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Boost largest path distance", 10.0D, 1));
		System.out.println("Modded: " + this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue());
		
		//this.setEntityAttribute
		//tradeTask = new InteractWithPlayer(this);
		this.setupAITasks();
	}
	
	private void setWoodBlockTargets(int scanRadiusLW, int scanRadiusHeight){
		//clear the array each time a new search begins
		woodBlockTargets.clear();
		//get the players current coordinates (roughly - could be 1 off due to how doubles round)
		int xCord = (int) (this.posX);
		int yCord = (int) (this.posY);
		int zCord = (int) (this.posZ);
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
			Location3D currentLoc = locations.get(i);
			this.tasks.addTask(i+2, new SeekAndDestroyTrees(this,currentLoc));
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
            setWoodBlockTargets(SCAN_RADIUS_LW,SCAN_RADIUS_H);
            Location3D currentLoc = new Location3D(this.posX,this.posY,this.posZ);
            if(woodBlockTargets.size()>0) {
            		Population ts = new Population(currentLoc,woodBlockTargets);
            		for(int i = 0; i < GENERATIONS; i++) {
            			ts = GeneticAlgorithm.evolvePopulation(currentLoc,ts);
            	}
            	addLumberjackTasks(ts.getFittest().getLocations());
            }
        }
        return true;
    }
	
	

}
