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
	public String toString() {
		return "Track [id=" + id + ", fused=" + fused + ", sightingIds=" + sightingIds + "]";
	}
}
