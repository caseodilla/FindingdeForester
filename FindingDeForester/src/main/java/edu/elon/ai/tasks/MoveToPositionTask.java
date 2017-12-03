package edu.elon.ai.tasks;

import java.util.HashSet;

import edu.elon.ai.datastructures.Location3D;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoveToPositionTask extends EntityAIBase{
	
	private final double MOVE_THRESHOLD = 2.0;
	private boolean completed;
	private EntityLiving e;
	private Location3D loc;
	private int locYOffset = 0;

	public MoveToPositionTask(EntityLiving e, Location3D loc) {
		this.e = e;
		this.loc = loc;
		completed = false;
		this.setMutexBits(3);
	}
	
	
	//always execute based given the priority is correct
	@Override
	public boolean shouldExecute() {
		return !completed;
	}
	
	public boolean shouldContinueExecuting() {
		return !completed;
	}
	
    public void startExecuting()
    {
        e.getNavigator().clearPathEntity();
    }
	
	public void updateTask() {
		Location3D currentLoc = new Location3D(e.posX,e.posY,e.posZ);
		if(loc.distanceTo(currentLoc)>MOVE_THRESHOLD) {
			e.getNavigator().tryMoveToXYZ(loc.getX(), loc.getY(), loc.getZ(), .5);
			e.getLookHelper().setLookPosition(loc.getX(), loc.getY(), loc.getZ(), 10.0F, (float)e.getVerticalFaceSpeed());
		}
		else {
			//destroy wood blocks, along with those above it, on every tick
			BlockPos currentBlock = new BlockPos((int)loc.getX(),(int)loc.getY()+locYOffset,(int)loc.getZ());
			if(e.world.getBlockState(currentBlock).getBlock().getLocalizedName().equals("Wood")) {
				locYOffset++;
				//destroy leaves
				Thread t = new Thread(new DestroyLeaves(currentBlock,e.world));
				t.start();
				//destroy wood block
				e.world.destroyBlock(currentBlock, true);
			}
			else if(e.world.getBlockState(currentBlock).getBlock().getLocalizedName().equals("Leaves")) {
				locYOffset++;
				//destroy leaves
				Thread t = new Thread(new DestroyLeaves(currentBlock,e.world));
				t.start();
				//destroy current block of leaves
				e.world.destroyBlock(currentBlock, false);
			}
			else {
				e.getNavigator().clearPathEntity();
				completed = true;
			}			
		}
	}
	
	
	//This is a destroy leaves task within the overall move and destroy trees task
	public class DestroyLeaves extends EntityAIBase implements Runnable{
		private BlockPos woodPos;
		private World world;
		private HashSet<BlockPos> set;
		public DestroyLeaves(BlockPos woodPos, World world) {
			set = new HashSet<BlockPos>();
			this.woodPos = woodPos;
			this.world = world;
		}
		@Override
		public void run() {
			//destroy leaves in 4 directions (must be done because the initial block is wood where as subsequent blocks are leaves)
			BlockPos n = new BlockPos(woodPos).north();
			BlockPos s = new BlockPos(woodPos).south();
			BlockPos e = new BlockPos(woodPos).east();
			BlockPos w = new BlockPos(woodPos).west();
			findAdjacent(n);
			findAdjacent(s);
			findAdjacent(e);
			findAdjacent(w);
		}
		
		public void findAdjacent(BlockPos p) {
			if(set.contains(p)) {
				return;
			}
			set.add(p);
			if(world.getBlockState(p).getBlock().getLocalizedName().equals("Leaves")) {
				world.destroyBlock(p, false);
				BlockPos n = new BlockPos(p).north();
				BlockPos s = new BlockPos(p).south();
				BlockPos e = new BlockPos(p).east();
				BlockPos w = new BlockPos(p).west();
				findAdjacent(n);
				findAdjacent(s);
				findAdjacent(e);
				findAdjacent(w);
			}

			
		}
		@Override
		public boolean shouldExecute() {
			// TODO Auto-generated method stub
			return false;
		}
	}
}
