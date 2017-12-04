package edu.elon.ai.datastructures;

import java.util.ArrayList;

public class Population {

	// holds the population of different generated paths
	TravelPath[] paths;
	
	// create a population
	public Population(ArrayList<Location3D> locations) {
		paths = new TravelPath[locations.size()];
		// in case we need to init a population of paths
		for (int i=0; i<pathSize(); i++) {
			TravelPath newPath = new TravelPath(locations);
			newPath.generateIndividual();
			savePath(i,newPath);
		}
	}
	
	// create an empty population, used for new generations that will inherit or mutate paths
	public Population(int popSize) {
		paths = new TravelPath[popSize];
	}
	
	// save the path
	public void savePath(int i, TravelPath path) {
		paths[i] = path;
	}
	
	// get the path from the population
	public TravelPath getPath(int i) {
		return paths[i];
	}
	
	// get the best path in the population
	public TravelPath getFittest() {
		TravelPath fittest = paths[0];
		// loop through all paths, find the fittest
		for (int i=1; i<pathSize(); i++) {
			if (fittest.getFitness() <= getPath(i).getFitness()) {
				fittest = getPath(i);
			}
		}
		return fittest;
	}
	
	public int pathSize() {
		return paths.length;
	}
}
