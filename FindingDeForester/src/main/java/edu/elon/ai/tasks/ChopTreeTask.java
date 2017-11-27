package edu.elon.ai.tasks;

import edu.elon.ai.entities.AIPlayer;
import net.minecraft.entity.ai.EntityAIBase;

public class ChopTreeTask extends EntityAIBase{
	
	private final AIPlayer entityAIPlayer;
	
	public ChopTreeTask(AIPlayer entityAIPlayer){
		this.entityAIPlayer = entityAIPlayer;
	}
    /**
     * Returns whether the EntityAIBase should begin execution.
     */
	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		return false;
	}
	
    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
	@Override
    public boolean shouldContinueExecuting()
    {
        return this.shouldExecute();
    }

    /**
     * Determine if this AI Task is interruptible by a higher (= lower value) priority task. All vanilla AITask have
     * this value set to true.
     */
	@Override
    public boolean isInterruptible()
    {
        return true;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
	@Override
    public void startExecuting()
    {
		
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
    	
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
    }

    /**
     * Sets the mutex bitflags, see getMutexBits. Flag 1 for motion, flag 2 for look/head movement, flag 4 for
     * swimming/misc. Flags can be OR'ed.
     */
    public void setMutexBits(int mutexBitsIn)
    {
        //this.mutexBits = mutexBitsIn;
    }

}
