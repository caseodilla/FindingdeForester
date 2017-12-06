package edu.elon.ai.tester;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import edu.elon.ai.algorithms.GeneticAlgorithm;
import edu.elon.ai.datastructures.Location3D;
import edu.elon.ai.datastructures.Population;

import org.junit.Test;

public class TravelingSalesmanTest {

	@Test
	public void test() {
		ArrayList<Location3D> locations = new ArrayList<Location3D>();
		Location3D playerLocation = new Location3D(0,0,0);
		//locations.add(playerLocation);
		locations.add(new Location3D(1,1,0));
		locations.add(new Location3D(2,0,0));
		locations.add(new Location3D(3,10,0));
		locations.add(new Location3D(0,7,0));
		locations.add(new Location3D(1,7,0));
		locations.add(new Location3D(5,7,0));
		locations.add(new Location3D(3,17,0));
		locations.add(new Location3D(10,3,0));
		locations.add(new Location3D(11,9,0));
		locations.add(new Location3D(10,1,0));
		locations.add(new Location3D(10,7,0));
		locations.add(new Location3D(18,2,0));
		locations.add(new Location3D(0,17,0));
		locations.add(new Location3D(8,6,0));
		Population population = new Population(playerLocation,locations);
		for (int i=0; i<10000; i++) {
			population = GeneticAlgorithm.evolvePopulation(playerLocation,population);
		}
		System.out.println("||Test Results||");
		System.out.println("Final distance: " + population.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(population.getFittest());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void alwaysImprovingTest() {
		ArrayList<Location3D> locations = new ArrayList<Location3D>();
		Location3D playerLocation = new Location3D(0,0,0);
		//locations.add(playerLocation);
		locations.add(new Location3D(28,0,0));
		locations.add(new Location3D(27,0,0));
		locations.add(new Location3D(26,0,0));
		locations.add(new Location3D(25,0,0));
		locations.add(new Location3D(24,0,0));
		locations.add(new Location3D(23,0,0));
		locations.add(new Location3D(22,0,0));
		locations.add(new Location3D(21,0,0));
		locations.add(new Location3D(20,0,0));
		locations.add(new Location3D(19,0,0));
		locations.add(new Location3D(18,0,0));
		locations.add(new Location3D(17,0,0));
		locations.add(new Location3D(16,0,0));
		locations.add(new Location3D(15,0,0));
		locations.add(new Location3D(14,0,0));
		locations.add(new Location3D(13,0,0));
		locations.add(new Location3D(12,0,0));
		locations.add(new Location3D(11,0,0));
		locations.add(new Location3D(10,0,0));
		locations.add(new Location3D(9,0,0));
		locations.add(new Location3D(8,0,0));
		locations.add(new Location3D(7,0,0));
		locations.add(new Location3D(6,0,0));
		locations.add(new Location3D(5,0,0));
		locations.add(new Location3D(4,0,0));
		locations.add(new Location3D(3,0,0));
		locations.add(new Location3D(2,0,0));
		locations.add(new Location3D(1,0,0));
		Population population = new Population(playerLocation, locations);
		//best distance
		double bestSoFar = population.getFittest().getDistance();
		for (int i=0; i<11000; i++) {
			//makes sure it's improving every 1000 generations
			if(i%100 == 0) {
				double current = population.getFittest().getDistance();
				System.out.println("Current Best Distance: " + current);
				if(bestSoFar < current) {
					fail("The path did not stay the same or improve");
				}
				else {
					bestSoFar = population.getFittest().getDistance();
				}
			}
			population = GeneticAlgorithm.evolvePopulation(playerLocation, population);
		}
		System.out.println("||Test Results||");
		System.out.println("Final distance: " + population.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(population.getFittest());
		
	}

}
