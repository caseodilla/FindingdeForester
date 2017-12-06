package edu.elon.ai.datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class TravelPath {
	
	// holds the travel path
	private ArrayList<Location3D> tp = new ArrayList<Location3D>();
	
	private double fitness = 0;
	private double distance = 0;
	private Location3D startingLocation;
	
	// constructor to hold new paths
	public TravelPath(Location3D startingLocation, int size) {
		this.startingLocation = startingLocation;
		for (int i=0; i<size; i++) {
			tp.add(null);
		}
	}
	
	// initial constructor when all locations are initially being passed
	public TravelPath(Location3D startingLocation, ArrayList<Location3D> tp) {
		this.startingLocation = startingLocation;
		this.tp = tp;
	}
	
	// create a random individual
	public void generateIndividual() {
		for (int i=0; i<tp.size(); i++) {
			setLocation(i,tp.get(i));
		}
		Collections.shuffle(tp);
	}
	
	// get a location from the array list
	public Location3D getLocation(int i) {
		return (Location3D)tp.get(i);
	}
	
	// get array list of locations
	public ArrayList<Location3D> getLocations() {
		return tp;
	}
	
	// set a location at a specific position in the arraylist
	public void setLocation(int i, Location3D loc) {
		tp.set(i, loc);
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
	public double getDistance() {
		//makes sure the calculation isn't performed twice
		if (distance == 0) {
			double tpDist = startingLocation.distanceTo(getLocation(0));
			// loop through the coordinates of our path
			for (int i=0; i<tp.size()-1; i++) {
				Location3D fromLoc = getLocation(i);
				Location3D toLoc;
				toLoc = getLocation(i+1);

				// calc distance between locations
				tpDist += fromLoc.distanceTo(toLoc);
			}
			distance = tpDist;
		}
		return distance;
	}
	
	//get the starting location from travel path
	public Location3D getStartingLocation() {
		return startingLocation;
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
