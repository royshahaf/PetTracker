package distribution.base;

import distribution.IReceiver;
import distribution.ITopic;

public class BaseReceiver implements IReceiver {
	private ITopic topic;

	public BaseReceiver(ITopic topic) {
		this.topic = topic;
	}

	@Override
	public Object receive() {
		return topic.read();
	}
}
