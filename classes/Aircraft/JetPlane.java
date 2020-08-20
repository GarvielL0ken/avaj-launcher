package aircraft;

import flyable.Flyable;
import towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;
	private static String			weather[] = {"FOG  : ",
													"RAIN : ",
													"SNOW : ",
													"SUN  : "};
	private static String			changes[] = {" + (0, 1, 0) => ", 
													" + (0, 5, 0) => ",
													" + (0, 0, -7) => ",
													" + (0, 10, 2) => "};

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String	weather;
		String	originalCoordinates;
		int		height;
		int		latitude;
		int		longitude;
		int		flag;
		int		index;

		weather = this.weatherTower.getWeather(this.coordinates);
		originalCoordinates = this.coordinates.toString();
		height = this.coordinates.getHeight();
		latitude = this.coordinates.getLatitude();
		longitude = this.coordinates.getLongitude();

		flag = (weather.equals("FOG")) ? 1 : 0;
		latitude +=  1 * flag;
		index = 0;

		flag = (weather.equals("RAIN")) ? 1 : 0;
		latitude += 5 * flag;
		index += 1 * flag;

		flag = (weather.equals("SNOW")) ? 1 : 0;
		height -= 7 * flag;
		index += 2 * flag;

		flag = (weather.equals("SUN")) ? 1 : 0;
		height += 2 * flag;
		latitude += 10 * flag;
		index += 3 * flag;

		this.coordinates.setCoordinates(height, latitude, longitude);
		weather = "JetPlane#" + this.name + "(" + this.id + ")   : ";
		weather += this.weather[index];
		weather += originalCoordinates;
		weather += this.changes[index];
		weather += this.coordinates.toString();
		System.out.println(weather);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);

		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}