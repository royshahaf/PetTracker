package tracking;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import distribution.ISender;
import distribution.ITopic;
import distribution.base.BaseSender;
import distribution.base.BaseTopic;
import entities.Location;
import entities.Service;
import entities.Sighting;
import simulator.LineSightingGenerator;
import simulator.RandomTimePicker;
import simulator.ServiceSimulator;
import testUtils.CollectingCallback;

public class TestSimulator {

	@Test
	public void testSimulator() {
		ITopic topic = new BaseTopic();
		ISender sender = new BaseSender(topic);
		CollectingCallback callback = new CollectingCallback();
		topic.register(callback);
		int numberOfSightings = 1000;
		int minTime = 100;
		int maxTime = 200;
		ServiceSimulator.generateSightings(sender, new Service("test", 5, "silly", new Location(0, 0, 0)), numberOfSightings,
				new RandomTimePicker(minTime, maxTime),
				new LineSightingGenerator(new Location(0, 0, 0), new Location(1, 1, 1), new Location(1, 1, 1)));
		assertTrue(callback.objects.size() == numberOfSightings);
		callback.objects.forEach(object -> {
			assertTrue(object instanceof Sighting);
			Sighting sighting = (Sighting) object;
			assertTrue(sighting.time >= minTime);
			assertTrue(sighting.time < maxTime);
		});
	}

}
