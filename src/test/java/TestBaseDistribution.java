import static org.junit.Assert.*;

import org.junit.Test;

public class TestBaseDistribution {

	@Test
	public void testSendAndReceive() {
		BaseTopic topic = new BaseTopic();
		ISender sender = new BaseSender(topic);
		IReceiver receiver = new BaseReceiver(topic);
		
		sender.send("Hello World");
		assertEquals("Hello World", receiver.receive());
	}

}
