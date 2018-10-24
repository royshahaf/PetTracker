package tracking;

import distribution.ITopic;
import entities.Sighting;

public interface ITracker {
	public void fuse(Sighting sighting);
	public void register(ITopic topic);
}
