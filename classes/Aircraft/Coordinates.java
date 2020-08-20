package aircraft;

public class Coordinates {
	private int	height;
	private int	latitude;
	private int	longitude;

	Coordinates(int height, int latitude, int longitude) {
		if (height < 0 || 100 < height || longitude < 0 || latitude < 0) {
			System.out.println("Error : Initial coordinates for Aircraft are out of bounds");
			System.out.println("      : Ranges : 0 < Height < 100");
			System.out.println("               : 0 < Latitude");
			System.out.println("               : 0 < Longitude");
			System.out.println("Run with -help for more info.");
			System.exit(1);
		}
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

	public void setCoordinates(int height, int latitude, int longitude) {
		int	flag_min;
		int	flag_max;

		flag_min = (height < 0) ? 1 : 0;
		flag_max = (100 < height) ? 1 : 0;

		//if (height < 0) {height = 0} else if (100 < height) {height = 100};
		this.height = height + ((0 - height) * flag_min) - ((height - 100) * flag_max); 

		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String toString() {
		String string;

		string = "(" + this.longitude + ", " + this.latitude + ", " + this.height + ")";
		return (string);
	}
}