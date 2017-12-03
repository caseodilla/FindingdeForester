package edu.elon.ai.datastructures;

import java.util.ArrayList;
import java.util.Collections;

//this'll be a lot like the tour class that the website you showed me talked about
//http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
//as I'm sure you saw, the tour manager is pretty unnecessary since it just creates unique method names for functionality 
//already built into arraylist
public class TravelPath {
	
	// holds the travel path
	private ArrayList<Location3D> tp = new ArrayList<Location3D>();
	
	private double fitness = 0;
	private int distance = 0;
	
	public TravelPath(int size) {
		for (int i=0; i<size; i++) {
			tp.add(null);
		}
	}
		
	public TravelPath(ArrayList<Location3D> tp) {
		this.tp = tp;
	}
	
	// create a random individual
	public void generateIndividual() {
		for (int i=0; i<tp.size(); i++) {
			setLocation(i,tp.get(i));
		}
		Collections.shuffle(tp);
	}
	
	// get a location from the arraylist
	public Location3D getLocation(int pos) {
		return (Location3D)tp.get(pos);
	}
	
	// get array list of locations
	public ArrayList<Location3D> getLocations() {
		return tp;
	}
	
	// set a location at a specific position in the arraylist
	public void setLocation(int pos, Location3D loc) {
		tp.set(pos, loc);
		fitness = 0;
		distance = 0;
	}
	
	// get the fitness
	public double getFitness() {
		if (fitness == 0) {
			fitness = 1/(double)getDistance();
		}
		return fitness;
	}
	
	// get the total distance of the path
	public int getDistance() {
		if (distance == 0) {
			int tpDist = 0;
			// loop through the coordinates of our path
			for (int i=0; i<tp.size(); i++) {
				Location3D fromLoc = getLocation(i);
				Location3D toLoc;
				// if we're at the last location, set the next destination to the starting position
				if (i+1 < tp.size()) {
					toLoc = getLocation(i+1);
				} else {
					toLoc = getLocation(0);
				}
				// calc distance between locations
				tpDist += fromLoc.distanceTo(toLoc);
			}
			distance = tpDist;
		}
		return distance;
	}
	
	// return number of locations on a path
	public int pathSize() {
		return tp.size();
	}
	
	// check if a location is already in the path
	public boolean hasLoc(Location3D loc) {
		return tp.contains(loc);
	}
	
	@Override
	public String toString() {
		String geneString = "";
		for (int i=0; i<pathSize(); i++) {
			geneString += "(" + getLocation(i) + ")";
			if (i+1<pathSize()) {
				geneString += ",";
			}
		}
		return geneString;
	}
}
