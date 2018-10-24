package entities;

import java.io.Serializable;

public class Service implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8344893687724705025L;
	public final String name;
	public final int id;
	public final String kind;
	public final Location location;
	
	public Service(String name, int id, String kind, Location location) {
		super();
		this.name = name;
		this.id = id;
		this.kind = kind;
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Service other = (Service) obj;
		if (id != other.id)
			return false;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Service [name=" + name + ", id=" + id + ", kind=" + kind + ", location=" + location + "]";
	}

}
