package testUtils;


import distribution.ICallback;

public class PrintingCallback implements ICallback {

	private int counter = 0;
	@Override
	public void onDataArrival(Object object) {
		counter++;
		System.out.format("%04d: " + object + "\n", counter);;
	}

}
