package towers;

//First Party Packages
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

//Third Party Packages

//Local Packages
import flyable.Flyable;

public class Tower {
	private List<Flyable> observers = new LinkedList<Flyable>();

	public FileWriter	fileWriter;

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		int	flag;
		int	size;
		int	i;
		
		size = observers.size();
		i = 0;
		while (i < size) {
			observers.get(i).updateConditions();

			//If size has changed i does not change
			flag = (size != observers.size()) ? 1 : 0;
			i += 1 - flag;

			size = observers.size();
		}
	}

	public void write(String line) {
		try {
			if (this.fileWriter == null)
				fileWriter = new FileWriter("simulation.txt");
			fileWriter.write(line + "\n");
		} catch (IOException error) {
			System.out.println("Error: ");
			error.printStackTrace();
		}
	}
}