package edu.elon.ai.algorithms;

import edu.elon.ai.datastructures.Location3D;
import edu.elon.ai.datastructures.TravelPath;
import edu.elon.ai.problems.TravelingSalesman;

public class GeneticAlgorithm {
    /* GA parameters */
    private static final double mutationRate = 0.015;
    private static final int TravelPathnamentSize = 5;
    private static final boolean elitism = true;

    // Evolves a TravelingSalesman over one generation
    public static TravelingSalesman evolveTravelingSalesman(TravelingSalesman pop) {
        TravelingSalesman newTravelingSalesman = new TravelingSalesman(pop.populationSize(), false);

        // Keep our best individual if elitism is enabled
        int elitismOffset = 0;
        if (elitism) {
            newTravelingSalesman.savePath(0, pop.getFittest());
            elitismOffset = 1;
        }

        // Crossover TravelingSalesman
        // Loop over the new TravelingSalesman's size and create individuals from
        // Current TravelingSalesman
        for (int i = elitismOffset; i < newTravelingSalesman.populationSize(); i++) {
            // Select parents
            TravelPath parent1 = TravelPathnamentSelection(pop);
            TravelPath parent2 = TravelPathnamentSelection(pop);
            // Crossover parents
            TravelPath child = crossover(parent1, parent2);
            // Add child to new TravelingSalesman
            newTravelingSalesman.savePath(i, child);
        }

        // Mutate the new TravelingSalesman a bit to add some new genetic material
        for (int i = elitismOffset; i < newTravelingSalesman.populationSize(); i++) {
            mutate(newTravelingSalesman.getPath(i));
        }

        return newTravelingSalesman;
    }

    // Applies crossover to a set of parents and creates offspring
    public static TravelPath crossover(TravelPath parent1, TravelPath parent2) {
        // Create new child TravelPath
        TravelPath child = new TravelPath();

        // Get start and end sub TravelPath positions for parent1's TravelPath
        int startPos = (int) (Math.random() * parent1.pathSize());
        int endPos = (int) (Math.random() * parent1.pathSize());

        // Loop and add the sub TravelPath from parent1 to our child
        for (int i = 0; i < child.pathSize(); i++) {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setLocation(i, parent1.getLocation(i));
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setLocation(i, parent1.getLocation(i));
                }
            }
        }

        // Loop through parent2's city TravelPath
        for (int i = 0; i < parent2.pathSize(); i++) {
            // If child doesn't have the city add it
            if (!child.hasLoc(parent2.getLocation(i))) {
                // Loop to find a spare position in the child's TravelPath
                for (int ii = 0; ii < child.pathSize(); ii++) {
                    // Spare position found, add city
                    if (child.getLocation(ii) == null) {
                        child.setLocation(ii, parent2.getLocation(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a TravelPath using swap mutation
    private static void mutate(TravelPath TravelPath) {
        // Loop through TravelPath cities
        for(int TravelPathPos1=0; TravelPathPos1 < TravelPath.pathSize(); TravelPathPos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the TravelPath
                int TravelPathPos2 = (int) (TravelPath.pathSize() * Math.random());

                // Get the cities at target position in TravelPath
                Location3D loc1 = TravelPath.getLocation(TravelPathPos1);
                Location3D loc2 = TravelPath.getLocation(TravelPathPos2);

                // Swap them around
                TravelPath.setLocation(TravelPathPos2, loc1);
                TravelPath.setLocation(TravelPathPos1, loc2);
            }
        }
    }

    // Selects candidate TravelPath for crossover
    private static TravelPath TravelPathnamentSelection(TravelingSalesman pop) {
        // Create a TravelPathnament TravelingSalesman
        TravelingSalesman TravelPathnament = new TravelingSalesman(TravelPathnamentSize, false);
        // For each place in the TravelPathnament get a random candidate TravelPath and
        // add it
        for (int i = 0; i < TravelPathnamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            TravelPathnament.savePath(i, pop.getPath(randomId));
        }
        // Get the fittest TravelPath
        TravelPath fittest = TravelPathnament.getFittest();
        return fittest;
    }
}