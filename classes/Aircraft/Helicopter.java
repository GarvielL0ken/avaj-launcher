package aircraft;

import coordinates.Coordinates;
import flyable.Flyable;
import towers.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public updateConditions() {
		String	weather;
		int		height;
		int		latitude;
		int		longitude;

		weather = this.weatherTower.getCurrentWeather(this.coordinates);
		height = this.coordinates.getHeight()
		latitude = this.coordinates.getLatitude()
		longitude = this.coordinates.getLongitude()

		longitude +=  1 * (weather.equals('FOG'));
		longitude +=  5 * (weather.equals('RAIN'));
		height -= 12 * (weather.equals('SNOW'));

		height -= 2 * (weather.equals('SUN'));
		longitude += 10 * (weather.equals('SUN'));

		this.coordinates.setCoordinates(height, latitude, longitude);
	}

	public registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}