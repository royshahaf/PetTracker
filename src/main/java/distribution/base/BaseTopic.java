package distribution.base;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import distribution.ICallback;
import distribution.ITopic;

public class BaseTopic implements ITopic {
	LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>();
	Logger logger = Logger.getLogger(getClass().getName());
	Set<ICallback> callbacks = new HashSet<>();

	@Override
	public void write(Object object) {
		objects.add(object);
		callbacks.forEach(callback -> callback.onDataArrival(object));
	}

	@Override
	public Object read() {
		try {
			return objects.take();
		} catch (InterruptedException e) {
			logger.info("InterruptedException while reading: " + e);
			Thread.currentThread().interrupt();
			return null;
		}
	}

	@Override
	public void register(ICallback callback) {
		callbacks.add(callback);
	}
}
