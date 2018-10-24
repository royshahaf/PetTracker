package tracking;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import distribution.ISender;
import distribution.ITopic;
import distribution.base.BaseSender;
import distribution.base.BaseTopic;
import entities.Location;
import entities.Service;
import entities.Track;
import simulator.LineSightingGenerator;
import simulator.RandomTimePicker;
import simulator.ServiceSimulator;
import testUtils.CollectingCallback;

public class TestAveragingTracker {

	public class TimeInfo {
		public int counter = 0;
		public Track lastUpdate;

		public TimeInfo(Track initialTrack) {
			lastUpdate = initialTrack;
		}

		public void update(Track newTrack) {
			counter++;
			lastUpdate = newTrack;
		}

		@Override
		public String toString() {
			return "TimeInfo [counter=" + counter + ", lastUpdate=" + lastUpdate + "]";
		}
	}

	@Test
	public void testTracker() {
		ITopic sightingTopic = new BaseTopic();
		ISender sightingSender = new BaseSender(sightingTopic);
		ITopic trackTopic = new BaseTopic();
		ISender trackSender = new BaseSender(trackTopic);
		ITracker tracker = new AveragingTracker(new Service("tracker", 1, "averaging", new Location(1, 1, 1)),
				trackSender);
		tracker.register(sightingTopic);
		CollectingCallback callback = new CollectingCallback();
		trackTopic.register(callback);
		int numberOfSightings = 1000;
		int minTime = 100;
		int maxTime = 200;
		sightingSender.send("Should not be received");
		ServiceSimulator.generateSightings(sightingSender, new Service("test", 5, "silly", new Location(0, 0, 0)),
				numberOfSightings, new RandomTimePicker(minTime, maxTime),
				new LineSightingGenerator(new Location(0, 0, 0), new Location(1, 1, 1), new Location(1, 1, 1)));
		assertTrue(callback.objects.size() <= numberOfSightings);
		Map<Long, TimeInfo> trackingInfo = new TreeMap<>();
		callback.objects.forEach(object -> {
			assertTrue(object instanceof Track);
			Track track = (Track) object;
			assertTrue(track.fused.time >= minTime);
			assertTrue(track.fused.time < maxTime);
			trackingInfo.putIfAbsent(track.fused.time, new TimeInfo(track));
			trackingInfo.get(track.fused.time).update(track);
			;
		});
		trackingInfo.entrySet().forEach(entry -> {
			System.out.format("%03d: " + entry.getValue() + "\n", entry.getKey());
		});
	}

}
