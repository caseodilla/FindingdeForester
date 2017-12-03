package edu.elon.ai.problems;

import java.util.ArrayList;

import edu.elon.ai.datastructures.Location3D;
import edu.elon.ai.datastructures.TravelPath;

//This will be both GA and the population class from the website, you can make them separate if you want
//it may be easier to keep the functionality all in the same class tho
//http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
public class TravelingSalesman {

/*11/26 CH: Does this need to be here? It looks similar to the code in TravelPath 	
*	ArrayList<Location3D> locations;
*	public TravelingSalesman(ArrayList<Location3D> locations){
*		this.locations = locations;
*	}
*/	
	
	// holds the population of different generated paths
	TravelPath[] paths;
	
	// create a population
	public TravelingSalesman(ArrayList<Location3D> locations, boolean initialize) {
		paths = new TravelPath[locations.size()*2];
		// in case we need to init a population of paths
		if (initialize) {
			for (int i=0; i<populationSize(); i++) {
				TravelPath newPath = new TravelPath(locations);
				newPath.generateIndividual();
				savePath(i,newPath);
			}
		}
	}
	
	public TravelingSalesman(int popSize) {
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
		for (int i=1; i<populationSize(); i++) {
			if (fittest.getFitness() <= getPath(i).getFitness()) {
				fittest = getPath(i);
			}
		}
		return fittest;
	}
	
	public int populationSize() {
		return paths.length;
	}
}
