package aircraft;

import coordinates.Coordinates;
import flyable.Flyable;
import towers.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public updateConditions() {
		System.out.println("UPDATE CONDITIONS");
	}

	public registerTower(WeatherTower weatherTower) {
		System.out.println("REGISTER TOWER");
	}
}