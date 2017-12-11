package edu.elon.ai.datastructures;
//A 3D coordinate object
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
	
	//get the X coordinate
	public double getX(){
		return xCord;
	}
	
	//get the Y coordinate
	public double getY(){
		return yCord;
	}
	
	//get the Z coordinate
	public double getZ(){
		return zCord;
	}
	
	//get the distance between two points
	public double distanceTo(Location3D loc) {
		double xDist = Math.abs(this.getX() - loc.getX());
		double yDist = Math.abs(this.getY() - loc.getY());
		double zDist = Math.abs(this.getZ() - loc.getZ());
		
		return Math.sqrt((xDist*xDist)+(yDist*yDist)+(zDist*zDist));
	}
	
	// useful string output for testing and debugging; organizes locations into sets of coordinates
	@Override
	public String toString() {
		return (int)getX() + "," + (int)getY() + "," + (int)getZ();
	}
}
