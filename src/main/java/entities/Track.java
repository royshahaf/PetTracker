package entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Track implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 466704459508002602L;
	public final int id;
	public final Sighting fused;
	public final List<UUID> sightingIds;
	
	public Track(int id, Sighting fused, List<UUID> sightingIds) {
		super();
		this.id = id;
		this.fused = fused;
		this.sightingIds = sightingIds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fused == null) ? 0 : fused.hashCode());
		result = prime * result + id;
		result = prime * result + ((sightingIds == null) ? 0 : sightingIds.hashCode());
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
		Track other = (Track) obj;
		if (fused == null) {
			if (other.fused != null)
				return false;
		} else if (!fused.equals(other.fused))
			return false;
		if (id != other.id)
			return false;
		if (sightingIds == null) {
			if (other.sightingIds != null)
				return false;
		} else if (!sightingIds.equals(other.sightingIds))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", fused=" + fused + ", sightingIds=" + sightingIds + "]";
	}
}
