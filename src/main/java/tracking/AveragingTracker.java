package tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import distribution.ICallback;
import distribution.ISender;
import distribution.ITopic;
import entities.Location;
import entities.Service;
import entities.Sighting;
import entities.Track;

public class AveragingTracker implements ITracker {

	private final Logger logger = Logger.getLogger(getClass().getName());

	public class TrackerCallback implements ICallback {

		@Override
		public void onDataArrival(Object object) {
			if (object instanceof Sighting) {
				fuse((Sighting) object);
			} else {
				logger.severe("Trying to handle unsupported message types in tracker callback");
			}
		}

	}

	private final Service identity;
	private final ISender sender;
	private final Map<Long, TimeInfo> locations = new HashMap<>();

	public AveragingTracker(Service identity, ISender sender) {
		this.identity = identity;
		this.sender = sender;
	}

	@Override
	public void fuse(Sighting sighting) {
		locations.putIfAbsent(sighting.time, new TimeInfo());
		locations.get(sighting.time).update(sighting);
		sender.send(generateTrack(locations.get(sighting.time), sighting.time));
	}

	private Object generateTrack(TimeInfo timeInfo, long time) {
		return new Track(1,
				new Sighting(UUID.randomUUID(), time, identity, new Location(timeInfo.averagedX, timeInfo.averagedY, timeInfo.averagedZ)),
				timeInfo.ids);
	}

	public static final class TimeInfo {
		private int counter = 0;
		private double averagedX = 0;
		private double averagedY = 0;
		private double averagedZ = 0;
		private List<UUID> ids = new LinkedList<>();

		public void update(Sighting sighting) {
			averagedX *= counter;
			averagedY *= counter;
			averagedZ *= counter;
			counter++;
			averagedX += sighting.location.x;
			averagedY += sighting.location.y;
			averagedZ += sighting.location.z;
			averagedX /= counter;
			averagedY /= counter;
			averagedZ /= counter;
			ids.add(sighting.id);
		}
	}

	@Override
	public void register(ITopic topic) {
		topic.register(new TrackerCallback());
	}

}
