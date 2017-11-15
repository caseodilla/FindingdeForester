package edu.elon.ai.problems;

import static org.junit.Assert.*;

import java.util.ArrayList;
import edu.elon.ai.datastructures.Location3D;
import org.junit.Test;

public class TravelingSalesmanTest {

	//this is basically TSP_GA from the website
	//http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
	@Test
	public void test() {
		ArrayList<Location3D> locations = new ArrayList<Location3D>();
		locations.add(new Location3D(0,0,0));
		locations.add(new Location3D(2,0,0));
		locations.add(new Location3D(3,3,0));
		locations.add(new Location3D(0,7,0));
		TravelingSalesman testSalesman = new TravelingSalesman(locations);
		
		System.out.println("||Test Results||");
		fail("Not yet implemented");
	}

}
