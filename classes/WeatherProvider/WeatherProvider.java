package weatherprovider;

import coordinates.Coordinates;

public class WeatherProvider {
	private static WeatherProvider	weatherprovider = new WeatherProvider();
	private static String			weather[] = {"FOG", "RAIN", "SNOW", "SUN"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		return WeatherProvider.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int	seed;

		seed = coordinates.getHeight() * (coordinates.getLatitude() + coordinates.getLongitude());
		return (WeatherProvider.weather[seed % 4]);
	}
}