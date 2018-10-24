package simulator;

import entities.Service;
import entities.Sighting;

public interface ISightingGenerator {

	public Sighting getSighting(long time, Service service);

}
