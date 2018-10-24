package distribution.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import distribution.ICallback;

public class BaseCallback implements ICallback {

	private final Lock lock = new ReentrantLock();
	private int counter = 0;
	
	public int getCounter() {
		return counter;
	}

	public BaseCallback() {
		lock.lock();
	}
	
	@Override
	public void onDataArrival(Object object) {
		counter++;
		lock.unlock();
	}

	public void getLock() {
		lock.lock();
	}

}
