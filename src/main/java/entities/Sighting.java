package entities;

import java.io.Serializable;
import java.util.UUID;

public class Sighting implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8305238027799584436L;
	public final UUID id;
	public final long time; 
	public final Service sightedBy;
	public final Location location;
	
	public Sighting(UUID id, long time, Service sightedBy, Location location) {
		super();
		this.id = id;
		this.time = time;
		this.sightedBy = sightedBy;
		this.location = location;
	}
	
	public Sighting(Service sightedBy, Location location) {
		 this(UUID.randomUUID(), System.currentTimeMillis(), sightedBy, location);
	}

	@Override
	public String toString() {
		return "Sighting [id=" + id + ", time=" + time + ", sightedBy=" + sightedBy + ", location=" + location + "]";
	}
}
