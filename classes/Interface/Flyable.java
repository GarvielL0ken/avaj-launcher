package flyable;

import towers.WeatherTower;

public interface Flyable {
	void	updateConditions();
	void	registerTower(WeatherTower WeatherTower);
}