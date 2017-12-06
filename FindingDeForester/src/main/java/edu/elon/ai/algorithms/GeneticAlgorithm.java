package edu.elon.ai.algorithms;

import edu.elon.ai.datastructures.Location3D;
import edu.elon.ai.datastructures.Population;
import edu.elon.ai.datastructures.TravelPath;

public class GeneticAlgorithm {

	//  control the likelihood of mutation
    private static final double mutationRate = 0.05;

    // evolves a population over one generation
    public static Population evolvePopulation(Location3D startingLoc, Population initialPopulation) {
        Population newPopulation = new Population(initialPopulation.pathSize());

        // save the best path, store it at 0; the rest will begin at index 1
        newPopulation.savePath(0, initialPopulation.getFittest());

        // use a tournament to pick the parent paths to breed
        for (int i = 1; i < newPopulation.pathSize(); i++) {
        	TravelPath p1 = lottery(initialPopulation);
            TravelPath p2 = lottery(initialPopulation);
            // breed
            TravelPath child = breed(p1, p2);
            
            //save the new child to the new population
            newPopulation.savePath(i, child);
        }

        // add some randomness by mutating the population
        for (int i = 1; i < newPopulation.pathSize(); i++) {
            mutate(newPopulation.getPath(i));
        }

        // congratulations! it's a beautiful new population! you must be so proud.
        // you'll be receiving a bill from the hospital for $1.3mil
        return newPopulation;
    }

    // breed a child from two parent paths
    public static TravelPath breed(TravelPath p1, TravelPath p2) {
        TravelPath child = new TravelPath(p1.getStartingLocation(),p1.pathSize());

        // determine where the start and end of p1's path will be
        int startPos = (int) (Math.random() * p1.pathSize());
        int endPos = (int) (Math.random() * p1.pathSize());

        // loop and add the sub TravelPath from p1 to our child
        for (int i = 0; i < child.pathSize(); i++) {
            // if start < end
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setLocation(i, p1.getLocation(i));
            }
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setLocation(i, p1.getLocation(i));
                }
            }
        }

        // p2 has a hand in this process too, ya know!
        // loop through its path, add any missing paths
        for (int i = 0; i < p2.pathSize(); i++) {
            // if it's empty at i, take p2's path
            if (!child.hasLoc(p2.getLocation(i))) {
                // find a spare position
                for (int j = 0; j < child.pathSize(); j++) {
                    // set p2's location to the child's empty location
                    if (child.getLocation(j) == null) {
                        child.setLocation(j, p2.getLocation(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // add some randomness by mutating the path
    private static void mutate(TravelPath path) {
    	// iterate over the path
        for(int pos1=0; pos1 < path.pathSize(); pos1++){
            // the higher the mutation rate, the more probable the mutation will occur
        	// if it does occur,
            if(Math.random() < mutationRate){
                // then get a second random position in the TravelPath that's different than pos1
                int pos2 = pos1;
                while (pos1 == pos2) {
                	pos2 = (int) (path.pathSize() * Math.random());
                }
                
                // store the locations at each position
                Location3D loc1 = path.getLocation(pos1);
                Location3D loc2 = path.getLocation(pos2);

                // switch the paths at each location
                path.setLocation(pos2, loc1);
                path.setLocation(pos1, loc2);
            }
        }
    }

    // lottery to select the fittest of randomly selected paths for breeding
    private static TravelPath lottery(Population pop) {
    	// number of lotto winners equals 20% of the population size
    		int lotterySize = (int)(pop.pathSize()*0.2);
    		//for the case where the population isn't at least 5
    		if(lotterySize==0) {
    			lotterySize=1;
    		}
        Population lottoDrawing = new Population(lotterySize);
        // and tonight's lucky winners are...
        for (int i = 0; i < lotterySize; i++) {
            int rand = (int) (Math.random() * pop.pathSize());
            lottoDrawing.savePath(i, pop.getPath(rand));
        }
        // find the fittest path of the lottery winners
        TravelPath fittest = lottoDrawing.getFittest();
        return fittest;
    }
}