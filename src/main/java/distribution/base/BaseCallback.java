package distribution.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import distribution.ICallback;

public class BaseCallback implements ICallback {

	Lock lock = new ReentrantLock();
	
	public BaseCallback() {
		lock.lock();
	}
	
	@Override
	public void onDataArrival(Object object) {
		lock.unlock();
	}

	public void getLock() {
		lock.lock();
	}

}
