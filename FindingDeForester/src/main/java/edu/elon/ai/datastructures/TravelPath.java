package edu.elon.ai.datastructures;

import java.util.ArrayList;
import java.util.Collections;

//this'll be a lot like the tour class that the website you showed me talked about
//http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
//as I'm sure you saw, the tour manager is pretty unnecessary since it just creates unique method names for functionality 
//already built into arraylist
public class TravelPath {
	
	// holds the travel path
	private ArrayList tp = new ArrayList<Location3D>();
	
	private double fitness = 0;
	private int distance = 0;
	
	public TravelPath() {
		for (int i = 0; i<TREES_IN_RANGE; i++) {
			tp.add(null);
		}
	}
	
	public TravelPath(ArrayList tp) {
		this.tp = tp;
	}
	
	// create a random individual
	public void generateIndividual() {
		for (int i=0; i<tp.size(); i++) {
			setLocation(i,TREE_ID);
		}
		Collections.shuffle(tp);
	}
	
	// get a location from the arraylist
	public Location3D getLocation(int pos) {
		return (Location3D)tp.get(pos);
	}
	
	// set a location at a specific place in the arraylist
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
	
	// check if a location is already in the path
	public boolean hasLoc(Location3D loc) {
		return tp.contains(loc);
	}
}
