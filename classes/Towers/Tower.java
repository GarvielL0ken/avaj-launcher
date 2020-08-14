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
		for (Iterator observer = observers.iterator(); observer.hasNext();) {
			observer.updateConditions();
		}
		System.out.println("CONDITONS CHANGED");
	}
}