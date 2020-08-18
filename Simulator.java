import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import aircraft.AircraftFactory;
import flyable.Flyable;

class Simulator {
	private static	AircraftFactory aircraftFactory = new AircraftFactory();

	private String	args[];
	private File	inputFile;
	private int		number_of_iterations;

	private String	parameters[];
	private int		height;
	private int		latitude;
	private int		longitude;

	public Simulator(String args[]) {
		this.args = args;
	}

	public void validate_arguments() {
		if (this.args.length != 1)
		{
			System.out.println("Error : Exactly one argument is required. use -help for more info");
			System.exit(1);
		}
	}

	public void parse_arguments() {
		String	option;
		
		option = this.args[0];
		if (option.equals("-help"))
		{
			System.out.println("Display help text");
			System.exit(1);
		}
	}

	public void open_file() {
		this.inputFile = new File(args[0]);
		if (!(this.inputFile.exists())) {
			System.out.println("Error : File does not exist");
			System.exit(1);
		}
		if (!(this.inputFile.isFile())) {
			System.out.println("Error : path does not conclude with a valid file");
			System.exit(1);
		}
	}

	public void read_file() {
		String	line;
		int		line_number;

		try {
			Scanner inputScanner = new Scanner(this.inputFile);

			this.validate_first_line(inputScanner.hasNextLine());
			this.get_number_of_iterations(inputScanner.nextLine());

			line_number = 2;
			while (inputScanner.hasNextLine()) {
				line = inputScanner.nextLine();
				this.validate_line(line, line_number);
				this.new_aircraft();
				line_number++;
				System.out.println(line);
			}
			inputScanner.close();
		} catch (IOException error) {
			System.out.println("Error :");
			error.printStackTrace();
			System.exit(1);
		}
	}

	private void validate_first_line(boolean has_next_line) {
		if (!has_next_line) {
			System.out.println("Error : File is empty");
			System.exit(1);
		}
	}

	private void get_number_of_iterations(String first_line) {
		try {
			this.number_of_iterations = Integer.parseInt(first_line);
		} catch (NumberFormatException nfe) {
			System.out.println("Error : First line is not in a valid integer format");
			System.exit(1);
		}
	}

	private void validate_line(String line, int line_number) {

		//Check that the line has the format <String> <String> <int> <int> <int>
		this.parameters = line.split(" ");
		if (this.parameters.length != 5) {
			System.out.println("Error : Line " + String.valueOf(line_number) + " in scenario file.");
			System.out.println("      : An Aircraft needs 5 space separated parameters.");
			System.out.println("      : Use -help for more info.");
			System.exit(1);
		}

		try {
			this.height = Integer.parseInt(this.parameters[4]);
			this.latitude = Integer.parseInt(this.parameters[3]);
			this.longitude = Integer.parseInt(this.parameters[2]);
		} catch (NumberFormatException nfe) {
			System.out.println("Error : Line " + String.valueOf(line_number) + " in scenario file.");
			System.out.println("      : Parameters 3, 4 and 5 need to be in a valid integer format.");
			System.out.println("      : Use -help for more info.");
			System.exit(1);
		}
		System.out.println(line);
	}

	private void new_aircraft() {
		Flyable	flyable;

		flyable = this.AircraftFactory.new_aircraft(this.parameters[0], this.parameters[1], this.height, this.latitude, this.longitude);
	}

	public static void main(String args[]) {
		Simulator simulator = new Simulator(args);

		simulator.validate_arguments();
		simulator.parse_arguments();
		simulator.open_file();
		simulator.read_file();
		//Run the simulation
	}
}