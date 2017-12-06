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
	public void alwaysImprovingTestX() {
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
		for (int i=0; i<12000; i++) {
			//makes sure it's improving every 100 generations
			if(i%100 == 0) {
				double current = population.getFittest().getDistance();
				//System.out.println("Current Best Distance: " + current);
				if(bestSoFar < current) {
					fail("The path did not stay the same or improve");
				}
				else {
					bestSoFar = population.getFittest().getDistance();
				}
			}
			population = GeneticAlgorithm.evolvePopulation(playerLocation, population);
		}
		System.out.println("||Test Results - Always Improving Test X||");
		System.out.println("Final distance: " + population.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(population.getFittest());
	}
	
	@Test
	public void alwaysImprovingTestY() {
		ArrayList<Location3D> locations = new ArrayList<Location3D>();
		Location3D playerLocation = new Location3D(0,0,0);
		//locations.add(playerLocation);
		locations.add(new Location3D(0,28,0));
		locations.add(new Location3D(0,27,0));
		locations.add(new Location3D(0,26,0));
		locations.add(new Location3D(0,25,0));
		locations.add(new Location3D(0,24,0));
		locations.add(new Location3D(0,23,0));
		locations.add(new Location3D(0,22,0));
		locations.add(new Location3D(0,21,0));
		locations.add(new Location3D(0,20,0));
		locations.add(new Location3D(0,19,0));
		locations.add(new Location3D(0,18,0));
		locations.add(new Location3D(0,17,0));
		locations.add(new Location3D(0,16,0));
		locations.add(new Location3D(0,15,0));
		locations.add(new Location3D(0,14,0));
		locations.add(new Location3D(0,13,0));
		locations.add(new Location3D(0,12,0));
		locations.add(new Location3D(0,11,0));
		locations.add(new Location3D(0,10,0));
		locations.add(new Location3D(0,9,0));
		locations.add(new Location3D(0,8,0));
		locations.add(new Location3D(0,7,0));
		locations.add(new Location3D(0,6,0));
		locations.add(new Location3D(0,5,0));
		locations.add(new Location3D(0,4,0));
		locations.add(new Location3D(0,3,0));
		locations.add(new Location3D(0,2,0));
		locations.add(new Location3D(0,1,0));
		Population population = new Population(playerLocation, locations);
		//best distance
		double bestSoFar = population.getFittest().getDistance();
		for (int i=0; i<12000; i++) {
			//makes sure it's improving every 100 generations
			if(i%100 == 0) {
				double current = population.getFittest().getDistance();
				//System.out.println("Current Best Distance: " + current);
				if(bestSoFar < current) {
					fail("The path did not stay the same or improve");
				}
				else {
					bestSoFar = population.getFittest().getDistance();
				}
			}
			population = GeneticAlgorithm.evolvePopulation(playerLocation, population);
		}
		System.out.println("||Test Results - Always Improving Test Y||");
		System.out.println("Final distance: " + population.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(population.getFittest());
	}
	
	@Test
	public void alwaysImprovingTestZ() {
		ArrayList<Location3D> locations = new ArrayList<Location3D>();
		Location3D playerLocation = new Location3D(0,0,0);
		//locations.add(playerLocation);
		locations.add(new Location3D(0,0,28));
		locations.add(new Location3D(0,0,27));
		locations.add(new Location3D(0,0,26));
		locations.add(new Location3D(0,0,25));
		locations.add(new Location3D(0,0,24));
		locations.add(new Location3D(0,0,23));
		locations.add(new Location3D(0,0,22));
		locations.add(new Location3D(0,0,21));
		locations.add(new Location3D(0,0,20));
		locations.add(new Location3D(0,0,19));
		locations.add(new Location3D(0,0,18));
		locations.add(new Location3D(0,0,17));
		locations.add(new Location3D(0,0,16));
		locations.add(new Location3D(0,0,15));
		locations.add(new Location3D(0,0,14));
		locations.add(new Location3D(0,0,13));
		locations.add(new Location3D(0,0,12));
		locations.add(new Location3D(0,0,11));
		locations.add(new Location3D(0,0,10));
		locations.add(new Location3D(0,0,9));
		locations.add(new Location3D(0,0,8));
		locations.add(new Location3D(0,0,7));
		locations.add(new Location3D(0,0,6));
		locations.add(new Location3D(0,0,5));
		locations.add(new Location3D(0,0,4));
		locations.add(new Location3D(0,0,3));
		locations.add(new Location3D(0,0,2));
		locations.add(new Location3D(0,0,1));
		Population population = new Population(playerLocation, locations);
		//best distance
		double bestSoFar = population.getFittest().getDistance();
		for (int i=0; i<12000; i++) {
			//makes sure it's improving every 100 generations
			if(i%100 == 0) {
				double current = population.getFittest().getDistance();
				//System.out.println("Current Best Distance: " + current);
				if(bestSoFar < current) {
					fail("The path did not stay the same or improve");
				}
				else {
					bestSoFar = population.getFittest().getDistance();
				}
			}
			population = GeneticAlgorithm.evolvePopulation(playerLocation, population);
		}
		System.out.println("||Test Results - Always Improving Test Z||");
		System.out.println("Final distance: " + population.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(population.getFittest());
	}
	
	@Test
	public void effectivenessTest() {
		ArrayList<Location3D> locations = new ArrayList<Location3D>();
		Location3D playerLocation = new Location3D(0,0,0);
		//locations.add(playerLocation);
		locations.add(new Location3D(1,1,1));
		locations.add(new Location3D(2,2,2));
		locations.add(new Location3D(3,3,3));
		locations.add(new Location3D(4,4,4));
		Population population = new Population(playerLocation,locations);
		for (int i=0; i<10000; i++) {
			population = GeneticAlgorithm.evolvePopulation(playerLocation,population);
		}
		System.out.println("||Test Results - Effectiveness Test||");
		System.out.println("Final distance: " + population.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(population.getFittest());
		
		//fail("Not yet implemented");
	}
	
	
	
	
}
