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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((sightedBy == null) ? 0 : sightedBy.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sighting other = (Sighting) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (sightedBy == null) {
			if (other.sightedBy != null)
				return false;
		} else if (!sightedBy.equals(other.sightedBy))
			return false;
		if (time != other.time)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sighting [id=" + id + ", time=" + time + ", sightedBy=" + sightedBy + ", location=" + location + "]";
	}
}
