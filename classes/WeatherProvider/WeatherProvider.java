package weatherprovider;

import aircraft.Coordinates;

public class WeatherProvider {
	private static WeatherProvider	weatherProvider = new WeatherProvider();
	private static String			weather[] = {"FOG", "RAIN", "SNOW", "SUN"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int	seed;

		seed = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
		return (WeatherProvider.weather[seed % 4]);
	}
}