package entities;

import java.io.Serializable;

public class Location implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8864335556542246513L;
	public final double x;
	public final double y;
	public final double z;
	
	public Location(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
