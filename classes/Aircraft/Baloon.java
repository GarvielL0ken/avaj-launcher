package aircraft;

import flyable.Flyable;
import towers.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower	weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String	weather;
		int		height;
		int		latitude;
		int		longitude;
		int		flag;

		weather = this.weatherTower.getWeather(this.coordinates);
		height = this.coordinates.getHeight();
		latitude = this.coordinates.getLatitude();
		longitude = this.coordinates.getLongitude();

		flag = (weather.equals("FOG")) ? 1 : 0;
		height -=  3 * flag;
		flag = (weather.equals("RAIN")) ? 1 : 0;
		height -=  5 * flag;
		flag = (weather.equals("SNOW")) ? 1 : 0;
		height -= 15 * flag;

		flag = (weather.equals("SUN")) ? 1 : 0;
		height +=  4 * flag;
		longitude += 2 * flag;

		this.coordinates.setCoordinates(height, latitude, longitude);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}