package towers;

import coordinates.Coordinates;
import weatherprovider.WeatherProvider;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	changeWeather() {
		this.conditionsChanged();
	}
}