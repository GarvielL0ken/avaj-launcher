package aircraft;

import coordinates.Coordinates;

public class Aircraft {
	private static long		idCounter = 0;

	protected Coordinates	coordinates;
	protected String		name;
	protected long			id;
	
	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.nextId();
	}

	private long nextId() {
		Aircraft.idCounter++;
		return (Aircraft.idCounter);
	}
}