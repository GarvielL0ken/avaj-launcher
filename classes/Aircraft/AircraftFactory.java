package aircraftfactory;

import coordinates.Coordinates;
import flyable.Flyable;

public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int height, int latitude, int longitude) {
		Coordinates	coordinates;
		Flyable		flyable;

		coordinates = new Coordinates(height, latitude, longitude);
		flyable = null;
		if (type.equals('Baloon'))
			flyable = new Baloon(name, coordinates);
		else if (type.equals('Helicopter'))
			flyable = new Helicopter(name, coordinates);
		else if (type.equals('JetPlane'))
			flyable = new JetPlane(name, coordinates);
		return (flyable);
	}
}