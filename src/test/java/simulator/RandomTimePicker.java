package simulator;

import java.security.SecureRandom;

public class RandomTimePicker implements ITimePicker {

	private final SecureRandom random = new SecureRandom();
	private final long min;
	private final long max;
	
	public RandomTimePicker(long min, long max) {
		if (min < max) {
			this.min = min;
			this.max = max;
		} else {
			this.max = min;
			this.min = max;
		}
	}
	
	@Override
	public long getTime() {
		return min + (long) (random.nextDouble() * (max - min));
	}
	
}
