package edu.elon.ai.datastructures;

public class Location3D {
	//this makes the variables thread safe
	private final double xCord;
	private final double yCord;
	private final double zCord;
	public Location3D(double x, double y, double z){
		xCord = x;
		yCord = y;
		zCord = z;
	}
	
	public double getX(){
		return xCord;
	}
	
	public double getY(){
		return yCord;
	}
	
	public double getZ(){
		return zCord;
	}
	
	public double distanceTo(Location3D loc) {
		double xDist = Math.abs(this.getX() - loc.getX());
		double yDist = Math.abs(this.getY() - loc.getY());
		double zDist = Math.abs(this.getZ() - loc.getZ());
		
		return Math.sqrt((xDist*xDist)+(yDist*yDist)+(zDist*zDist));
	}
	
	@Override
	public String toString() {
		return getX() + ", " + getY() + ", " + getZ();
	}
}
