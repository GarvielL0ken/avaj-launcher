package towers;

import coordinates.Coordinates;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		System.out.println("GET WEATHER");
		return (weather);
	}

	changeWeather() {
		System.out.println("CHANGE WEATHER");
	}
}