package weatherprovider;

import coordinates.Coordinates;

public class WeatherProvider {
	private static WeatherProvider	weatherprovider;
	private static String			weather;

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {}

	public String getCurrentWeather(Coordinates coordinates) {}
}