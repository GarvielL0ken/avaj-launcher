package aircraft;

import coordinates.Coordinates;
import flyable.Flyable;
import towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String	weather;
		int		height;
		int		latitude;
		int		longitude;
		int		flag;

		weather = this.weatherTower.getCurrentWeather(this.coordinates);
		height = this.coordinates.getHeight();
		latitude = this.coordinates.getLatitude();
		longitude = this.coordinates.getLongitude();

		flag = (weather.equals("FOG")) ? 1 : 0;
		latitude +=  1 * flag;
		flag = (weather.equals("RAIN")) ? 1 : 0;
		latitude +=  5 * flag;
		flag = (weather.equals("SNOW")) ? 1 : 0;
		height -= 7 * flag;

		flag = (weather.equals("SUN")) ? 1 : 0;
		height += 2 * flag;
		latitude += 10 * flag;

		this.coordinates.setCoordinates(height, latitude, longitude);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}