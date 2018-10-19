import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class BaseTopic implements ITopic {
	LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>();
	Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public void write(Object object) {
		objects.add(object);
	}

	@Override
	public Object read() {
		try {
			return objects.take();
		} catch (InterruptedException e) {
			logger.info("InterruptedException while reading: " + e);
			return null;
		}
	}

	@Override
	public void register(ICallback callback) {
		//
	}
}
