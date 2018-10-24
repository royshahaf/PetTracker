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
	public String toString() {
		return "Service [name=" + name + ", id=" + id + ", kind=" + kind + ", location=" + location + "]";
	}

}
