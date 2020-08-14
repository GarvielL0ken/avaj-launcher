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
		String	weather;
		int		height;
		int		latitude;
		int		longitude;

		weather = this.weatherTower.getCurrentWeather(this.coordinates);
		height = this.coordinates.getHeight()
		latitude = this.coordinates.getLatitude()
		longitude = this.coordinates.getLongitude()

		height -=  3 * (weather.equals('FOG'));
		height -=  5 * (weather.equals('RAIN'));
		height -= 15 * (weather.equals('SNOW'));

		height +=  4 * (weather.equals('SUN'));
		longitude += 2 * (weather.equals('SUN'));

		this.coordinates.setCoordinates(height, latitude, longitude);
	}

	public registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}