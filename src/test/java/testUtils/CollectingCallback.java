package testUtils;

import java.util.LinkedList;
import java.util.List;

import distribution.ICallback;

public class CollectingCallback implements ICallback {
	
	public final List<Object> objects = new LinkedList<>();
	
	@Override
	public void onDataArrival(Object object) {
		objects.add(object);
	}

}
