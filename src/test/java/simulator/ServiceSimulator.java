package simulator;

import distribution.ISender;
import entities.Service;

public class ServiceSimulator {
	public static void generateSightings(ISender sender, Service service, int numberOfSightings, ITimePicker timePicker, ISightingGenerator sightingGenerator) {
		for (int i = 0; i < numberOfSightings; i++) {
			sender.send(sightingGenerator.getSighting(timePicker.getTime(), service));
		}
	}
}
