package towers;

import flyable.Flyable;

public class Tower {
	private List<Object>	observers;

	observers = new LinkedList<Object>();

	public register(Flyable flyable) {
		observers.add(flyable);
	}

	public unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected conditionsChanged() {
		System.out.println("CONDITONS CHANGED");
	}
}