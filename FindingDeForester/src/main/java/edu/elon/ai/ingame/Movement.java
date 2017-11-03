package edu.elon.ai.ingame;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class Movement{
	EntityPlayer player;
	Robot robot;
	double posX;
	double posY;
	double posZ;
	float cameraYaw;
	float cameraPitch;
	public Movement(EntityPlayer player){
		this.player = player;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get initial position values
		updatePosition();
		//get initial camera values
		updateCamera();
		
	}
	
	private void updatePosition(){
		posX = player.posX;
		posY = player.posY;
		posZ = player.posZ;
	}
	
	private void updateCamera(){
		cameraYaw = player.cameraYaw;
		cameraPitch = player.cameraPitch;
	}
	
	public void moveToPoint(double destPosX, double destPosZ){
		while(this.posX != destPosX && this.posZ != destPosZ){
			moveForward();
			changeDirection(0,0);
			updatePosition();
		}
		

		System.out.println("Position X: "+ player.posX + " Position Z: "+ player.posZ);
	}
	
	//
	public void changeDirection(float yaw,float pitch){
		//changeYaw(yaw);
		Point mousePos = MouseInfo.getPointerInfo().getLocation();
		robot.mouseMove(mousePos.x+5, mousePos.y);
		//changePitch(pitch);
	}
	
	//turn right
	private void turnRight(float yaw){
		
	}
	
	//turn left
	private void changeYaw(float yaw){
		while(cameraYaw != yaw){
			Point mousePos = MouseInfo.getPointerInfo().getLocation();
			if(cameraYaw > yaw){
				robot.mouseMove((int)mousePos.getX()-1,(int)mousePos.getY());
			}
			else{
				robot.mouseMove((int)mousePos.getX()+1, (int)mousePos.getY());
			}
			System.out.print(cameraYaw);
			updateCamera();
		}
	}
	
	//look up
	private void changePitch(float pitch){
		//player.cameraPitch = pitch;
	}
	
	//look down
	private void turnLeft(float pitch){
		
	}
	
	//move the player forward
	private void moveForward(){
		robot.keyPress(KeyEvent.VK_W);
	}
	
	//move the player backward
	private void moveBack(){
		robot.keyPress(KeyEvent.VK_S);
	}
	
	//move the player right
	private void moveRight(){
		robot.keyPress(KeyEvent.VK_D);
	}
	
	//move the player left
	private void moveLeft(){
		robot.keyPress(KeyEvent.VK_A);
	}
	

}
