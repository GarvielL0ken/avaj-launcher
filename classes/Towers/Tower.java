package towers;

//First Party Packages
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

//Third Party Packages

//Local Packages
import flyable.Flyable;

public class Tower {
	private List<Flyable> observers = new LinkedList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		int	i;
		
		for (i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
		System.out.println("CONDITONS CHANGED");
	}
}