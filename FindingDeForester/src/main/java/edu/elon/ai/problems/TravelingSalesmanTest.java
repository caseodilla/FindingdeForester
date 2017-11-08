package edu.elon.ai.problems;

import static org.junit.Assert.*;

import java.util.ArrayList;
import edu.elon.ai.datastructures.Location3D;
import org.junit.Test;

public class TravelingSalesmanTest {

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
