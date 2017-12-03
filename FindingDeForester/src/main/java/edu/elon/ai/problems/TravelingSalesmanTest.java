package edu.elon.ai.problems;

import java.util.ArrayList;

import edu.elon.ai.algorithms.GeneticAlgorithm;
import edu.elon.ai.datastructures.Location3D;
import org.junit.Test;

public class TravelingSalesmanTest {

	//this is basically TSP_GA from the website
	//http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
	@Test
	public void test() {
		ArrayList<Location3D> locations = new ArrayList<Location3D>();
		Location3D playerLocation = new Location3D(0,0,0);
		locations.add(new Location3D(1,1,0));
		locations.add(new Location3D(2,0,0));
		locations.add(new Location3D(3,10,0));
		locations.add(new Location3D(0,7,0));
		TravelingSalesman testSalesman = new TravelingSalesman(playerLocation, locations, true);
		testSalesman = GeneticAlgorithm.evolveTravelingSalesman(testSalesman);
		
		System.out.println("||Test Results||");
		System.out.println("Final distance: " + testSalesman.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(testSalesman.getFittest());
		
		//fail("Not yet implemented");
	}

}
