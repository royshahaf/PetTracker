package distribution;

import static org.junit.Assert.*;

import org.junit.Test;

import distribution.IReceiver;
import distribution.ISender;
import distribution.base.BaseCallback;
import distribution.base.BaseReceiver;
import distribution.base.BaseSender;
import distribution.base.BaseTopic;

public class TestBaseDistribution {

	@Test
	public void testSendAndReceive() {
		ITopic topic = new BaseTopic();
		ISender sender = new BaseSender(topic);
		IReceiver receiver = new BaseReceiver(topic);
		sender.send("Hello World");
		assertEquals("Hello World", receiver.receive());
	}

	@Test
	public void testSendAndCallback() throws InterruptedException {
		ITopic topic = new BaseTopic();
		ISender sender = new BaseSender(topic);
		ICallback callback = new BaseCallback();
		topic.register(callback);
		Thread thread = new Thread(() -> ((BaseCallback) callback).getLock());
		thread.start();
		sender.send("Hello World");
		thread.join();
		assertTrue(((BaseCallback) callback).getCounter() > 0);
	}

}
