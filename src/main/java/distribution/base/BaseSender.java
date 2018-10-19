package distribution.base;

import distribution.ISender;
import distribution.ITopic;

public class BaseSender implements ISender {
	
	ITopic topic;
	
	public BaseSender(ITopic topic) {
		this.topic = topic;
	}
	
	public void send(Object object) {
		topic.write(object);
	}

}
