package coordinates;

public class Coordinates {
	private int	height;
	private int	latitude;
	private int	longitude;

	Coordinates(int height, int latitude, int longitude) {
		this.height = height;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getHeight() {
		return (this.height);
	}

	public int getLatitude() {
		return (this.latitude);
	}

	public int getLongitude() {
		return (this.longitude);
	}
}