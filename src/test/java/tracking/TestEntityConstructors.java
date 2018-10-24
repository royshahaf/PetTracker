package tracking;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import entities.Location;
import entities.Service;
import entities.Sighting;

public class TestEntityConstructors {

	@Test
	public void testSightingConstructor() {
		Service sightedBy = new Service("test", 3, "test", new Location(1, 2, 3));
		Location location = new Location(3, 2, 1);
		Sighting sighting = new Sighting(sightedBy, location);
		assertEquals(sightedBy, sighting.sightedBy);
		assertEquals(location, sighting.location);
		assertTrue(sighting.id instanceof UUID);
	}

}
