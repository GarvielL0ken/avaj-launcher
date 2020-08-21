package aircraft;

import flyable.Flyable;
import towers.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;
	private static String			weather[] = {"FOG  : ",
													"RAIN : ",
													"SNOW : ",
													"SUN  : "};
	private static String			changes[] = {" + (0, 0, -3) => ", 
													" + (0, 0, -5) => ",
													" + (0, 0, -15) => ",
													" + (2, 0, 4) => "};

	Baloon(String name, Coordinates coordinates) {
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
		height -=  3 * flag;
		index = 0;
		
		flag = (weather.equals("RAIN")) ? 1 : 0;
		height -= 5 * flag;
		index += 1 * flag;
		
		flag = (weather.equals("SNOW")) ? 1 : 0;
		height -= 15 * flag;
		index += 2 * flag;
		
		flag = (weather.equals("SUN")) ? 1 : 0;
		height += 4 * flag;
		longitude += 2 * flag;
		index += 3 * flag;

		this.coordinates.setCoordinates(height, latitude, longitude);
		//System.out.println("Ballon#" + this.name + "(" + this.id + ")     : " + this.weather[index] +
		//					"(Old Coordinates) => (new Coordinates)");
		weather = "Ballon#" + this.name + "(" + this.id + ")     : ";
		weather += this.weather[index];
		weather += originalCoordinates;
		weather += this.changes[index];
		weather += this.coordinates.toString();

		this.weatherTower.write(weather);
		if (this.coordinates.getHeight() == 0) {
			this.weatherTower.unregister(this);
			this.weatherTower.write("Tower says: " + this.toString() + " landed, unregistered from tower");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		String	line;

		this.weatherTower = weatherTower;
		weatherTower.register(this);

		line = "Tower says : " + this.toString() + "registered to weather tower";
		this.weatherTower.write(line);
	}

	public String toString() {
		return ("Baloon#" + this.name + "(" + this.id + ")");
	}
}