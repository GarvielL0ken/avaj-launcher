package aircraft;

import coordinates.Coordinates;
import flyable.Flyable;
import towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public updateConditions() {
		System.out.println("UPDATE CONDITIONS");
	}

	public registerTower(WeatherTower weatherTower) {
		System.out.println("REGISTER TOWER");
	}
}