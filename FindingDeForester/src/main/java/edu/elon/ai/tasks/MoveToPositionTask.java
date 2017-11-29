package edu.elon.ai.tasks;

import edu.elon.ai.datastructures.Location3D;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class MoveToPositionTask extends EntityAIBase{
	
	private final double MOVE_THRESHOLD = 3.0;
	private boolean completed;
	private EntityLiving e;
	private Location3D loc;
	public MoveToPositionTask(EntityLiving e, Location3D loc) {
		this.e = e;
		this.loc = loc;
		completed = false;
		this.setMutexBits(1);
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
		}
		else {
			e.getNavigator().clearPathEntity();
			completed = true;
		}
	}
}
