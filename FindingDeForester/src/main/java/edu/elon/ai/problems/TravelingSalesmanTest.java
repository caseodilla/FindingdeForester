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
		TravelingSalesman testSalesman = new TravelingSalesman(locations, true);
		for (int i=0; i<100; i++) {
			testSalesman = GeneticAlgorithm.evolveTravelingSalesman(testSalesman);
		}
		System.out.println("||Test Results||");
		System.out.println("Final distance: " + testSalesman.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(testSalesman.getFittest());
		
		//fail("Not yet implemented");
	}

}
