package simulator;

import java.security.SecureRandom;
import java.util.UUID;

import entities.Location;
import entities.Service;
import entities.Sighting;

public class LineSightingGenerator implements ISightingGenerator {
	private final Location initialLocation;
	private final Location locationDelta;
	private final Location errorByAxis;
	private final SecureRandom random = new SecureRandom();
	
	public LineSightingGenerator(Location initialLocation, Location locationDelta, Location errorByAxis) {
		super();
		this.initialLocation = initialLocation;
		this.locationDelta = locationDelta;
		this.errorByAxis = errorByAxis;
	}

	@Override
	public Sighting getSighting(long time, Service service) {
		return new Sighting(UUID.randomUUID(), time, service, getLocation(time));
	}

	private Location getLocation(long time) {
		return new Location(getRandom(initialLocation.x, time * locationDelta.x, errorByAxis.x),
				getRandom(initialLocation.y, time * locationDelta.y, errorByAxis.y),
				getRandom(initialLocation.z, time * locationDelta.z, errorByAxis.z));
	}

	private double getRandom(double initial, double delta, double error) {
		return initial + delta + error * (0.5 - random.nextDouble());
	}
}
